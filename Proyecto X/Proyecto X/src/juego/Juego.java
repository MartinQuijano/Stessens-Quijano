package juego;

import input.MouseInput;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Random;

import powerups.PowerUp;
import states.AyudaState;
import states.GameState;
import states.MenuState;
import states.State;
import threads.BombaThread;
import threads.EnemigoThread;
import threads.FuegoThread;
import niveles.Celda;
import niveles.Nivel;
import entidades.Altair;
import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Fuego;
import entidades.Rugulo;
import entidades.Sirius;
import grafica.Assets;
import gui.GUI;

/**
 * 
 */
public class Juego extends Canvas implements Runnable {

	protected int puntaje;
	protected int tiempoS;
	protected int tiempoM;
	protected int tiempoH;
	protected int tiempoAux;
	protected Nivel nivel;

	protected GUI gui;

	private BufferStrategy bs;
	private Graphics g;

	private Thread thread;
	private boolean running = false;

	private int width;
	private int height;

	protected LinkedList<Bomba> bombas;
	protected LinkedList<Enemigo> enemigos;
	protected LinkedList<Fuego> fuegos;
	protected Bomberman bomberman;

	// States
	private State gameState;
	private State menuState;
	private State ayudaState;
	private int state;

	public Juego(int w, int h) {
		Assets.init();
		width = w;
		height = h;
		nivel = new Nivel(this);
		nivel.generarNivel();

		bombas = new LinkedList<Bomba>();
		enemigos = new LinkedList<Enemigo>();
		fuegos = new LinkedList<Fuego>();

		state = 0;
		
		bomberman = new Bomberman(32, 32);

	}

	private void init() {

		gui = new GUI(this);
		gameState = new GameState(this, bomberman, bombas, enemigos, fuegos);
		menuState = new MenuState(this);
		ayudaState = new AyudaState(this);
		State.setState(menuState);
	}

	private void update() {
		if (state == 0) {
			State.setState(menuState);
		} else if (state == 1) {
			State.setState(gameState);
		} else if (state == 2) {
			State.setState(ayudaState);
		}

		if (State.getState() != null)
			State.getState().update();
		tiempoAux++;
		if (tiempoAux == 60) {
			tiempoS++;
			tiempoAux = 0;
		}
		if (tiempoS == 60) {
			tiempoM++;
			tiempoS = 0;
		}
		if (tiempoM == 60) {
			tiempoH++;
			tiempoS = 0;
		}

	}

	private void render() {
		bs = gui.getCanvas().getBufferStrategy();
		if (bs == null) {
			gui.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Limpiar pantalla
		g.clearRect(0, 0, width, height);
		// Dibujar

		if (State.getState() != null)
			State.getState().render(g);

		// Fin dibujo
		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				delta--;
			}
		}
		stop();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mueve el enemigo 'e' en una direccion aleatoria.
	 * 
	 * @param e
	 *            Enemigo el cual va a mover.
	 */
	public void mover(Enemigo e) {
		Random rnd = new Random();
		int dir = rnd.nextInt(4);
		switch (dir) {
		case 0:
			nivel.obtCelda(e.obtX() / 32, e.obtY() / 32 - 1).avanzarEnemigo(e,
					bombas);
			break;
		case 1:
			nivel.obtCelda(e.obtX() / 32, e.obtY() / 32 + 1).avanzarEnemigo(e,
					bombas);
			break;
		case 2:
			nivel.obtCelda(e.obtX() / 32 - 1, e.obtY() / 32).avanzarEnemigo(e,
					bombas);
			break;
		case 3:
			nivel.obtCelda(e.obtX() / 32 + 1, e.obtY() / 32).avanzarEnemigo(e,
					bombas);
			break;
		}
	}

	/**
	 * Acciona al Bomberman de acuerdo a la tecla pasada por parametro.
	 * 
	 * @param key
	 *            tecla presionada
	 */
	public void accionBomberman(int key) {
		switch (key) {
		case KeyEvent.VK_UP:
			nivel.obtCelda(bomberman.obtX() / 32, bomberman.obtY() / 32 - 1)
					.avanzar(bomberman, bombas);
			break;
		case KeyEvent.VK_DOWN:
			nivel.obtCelda(bomberman.obtX() / 32, bomberman.obtY() / 32 + 1)
					.avanzar(bomberman, bombas);
			break;
		case KeyEvent.VK_LEFT:
			nivel.obtCelda(bomberman.obtX() / 32 - 1, bomberman.obtY() / 32)
					.avanzar(bomberman, bombas);
			break;
		case KeyEvent.VK_RIGHT:
			nivel.obtCelda(bomberman.obtX() / 32 + 1, bomberman.obtY() / 32)
					.avanzar(bomberman, bombas);
			break;
		case KeyEvent.VK_SPACE:
			colocarBomba();
			break;
		}
	}

	/**
	 * Llama al bomberman para que cree una bomba y la coloca en su posicion.
	 */
	public void colocarBomba() {
		if (bomberman.tieneBombas()) {
			BombaThread hBomba;
			Bomba b = bomberman.crearBomba();
			bombas.add(b);
			hBomba = new BombaThread(b);
			hBomba.start();
		}
	}

	/**
	 * Revisa si las bombas explotaron y las remueve del grafico.
	 */
	public void controlarExplosiones() {
		LinkedList<Bomba> bombasExplotadas = new LinkedList<Bomba>();
		LinkedList<Fuego> fuegosConsumidos = new LinkedList<Fuego>();

		for (Bomba b : bombas) {
			if (b.yaExploto()) {
				bombasExplotadas.add(b);
				calcularEfectoBomba(b);
			}
		}
		for (Bomba b : bombasExplotadas) {
			bombas.remove(b);
			bomberman.reponerBomba();
		}

		for (Fuego f : fuegos) {
			if (f.seConsumio())
				fuegosConsumidos.add(f);
		}
		for (Fuego fc : fuegosConsumidos) {
			fuegos.remove(fc);
		}
	}

	/**
	 * De acuerdo a la bomba pasada por parametro, afecta a todas las celdas
	 * contiguas.
	 * 
	 * @param b
	 *            bomba que exploto
	 */
	private void calcularEfectoBomba(Bomba b) {
		int rangoBomba = b.obtAlcance();

		if (nivel.obtCelda(b.obtX() / 32, b.obtY() / 32).obtPared() == null) {
			Fuego fuego0 = new Fuego(b.obtX(), b.obtY(), 0);
			FuegoThread hiloFuego0 = new FuegoThread(fuego0, this);
			hiloFuego0.start();
			fuegos.add(fuego0);
		}

		boolean seguirDerecha = true;
		boolean seguirIzquierda = true;
		boolean seguirArriba = true;
		boolean seguirAbajo = true;

		for (int i = 0; i < rangoBomba; i++) {
			if (seguirArriba)
				if (nivel.obtCelda(b.obtX() / 32, b.obtY() / 32 - (i + 1))
						.obtPared() == null) {
					Fuego fuego1 = new Fuego(b.obtX(), b.obtY() - 32 * (i + 1),
							0);
					FuegoThread hiloFuego1 = new FuegoThread(fuego1, this);
					hiloFuego1.start();
					fuegos.add(fuego1);
				} else {
					seguirArriba = false;
					puntaje = puntaje
							+ nivel.obtCelda(b.obtX() / 32,
									b.obtY() / 32 - (i + 1)).getPuntaje();
					nivel.obtCelda(b.obtX() / 32, b.obtY() / 32 - (i + 1))
							.destruir();
				}

			if (seguirAbajo)
				if (nivel.obtCelda(b.obtX() / 32, b.obtY() / 32 + (i + 1))
						.obtPared() == null) {
					Fuego fuego2 = new Fuego(b.obtX(), b.obtY() + 32 * (i + 1),
							0);
					FuegoThread hiloFuego2 = new FuegoThread(fuego2, this);
					hiloFuego2.start();
					fuegos.add(fuego2);

				} else {
					seguirAbajo = false;
					puntaje = puntaje
							+ nivel.obtCelda(b.obtX() / 32,
									b.obtY() / 32 + (i + 1)).getPuntaje();
					nivel.obtCelda(b.obtX() / 32, b.obtY() / 32 + (i + 1))
							.destruir();
				}

			if (seguirDerecha)
				if (nivel.obtCelda(b.obtX() / 32 + (i + 1), b.obtY() / 32)
						.obtPared() == null) {
					Fuego fuego3 = new Fuego(b.obtX() + 32 * (i + 1), b.obtY(),
							0);
					FuegoThread hiloFuego3 = new FuegoThread(fuego3, this);
					hiloFuego3.start();
					fuegos.add(fuego3);
				} else {
					seguirDerecha = false;
					puntaje = puntaje
							+ nivel.obtCelda(b.obtX() / 32 + (i + 1),
									b.obtY() / 32).getPuntaje();
					nivel.obtCelda(b.obtX() / 32 + (i + 1), b.obtY() / 32)
							.destruir();
				}

			if (seguirIzquierda)
				if (nivel.obtCelda(b.obtX() / 32 - (i + 1), b.obtY() / 32)
						.obtPared() == null) {
					Fuego fuego4 = new Fuego(b.obtX() - 32 * (i + 1), b.obtY(),
							0);
					FuegoThread hiloFuego4 = new FuegoThread(fuego4, this);
					hiloFuego4.start();
					fuegos.add(fuego4);
				} else {
					seguirIzquierda = false;
					puntaje = puntaje
							+ nivel.obtCelda(b.obtX() / 32 - (i + 1),
									b.obtY() / 32).getPuntaje();
					nivel.obtCelda(b.obtX() / 32 - (i + 1), b.obtY() / 32)
							.destruir();
				}

		}
	}

	/**
	 * @param int i
	 */
	public void setPuntaje(int i) {
		puntaje = i;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public int obtTiempoS() {
		return tiempoS;
	}

	public int obtTiempoM() {
		return tiempoM;
	}

	public LinkedList<Enemigo> obtEnemigos() {
		return enemigos;
	}

	public Bomberman obtBomberman() {
		return bomberman;
	}

	public Nivel obtNivel() {
		return nivel;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public int obtPuntaje() {
		return puntaje;
	}

	public LinkedList<Fuego> obtFuegos() {
		return fuegos;
	}

	public void limpiarEnemigos(LinkedList<Enemigo> destruidos) {
		for (Enemigo e : destruidos)
			enemigos.remove(e);
	}

	public int obtTiempoH() {
		return tiempoH;
	}

	public void controlarWin() {
		nivel.controlarWinCond();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void inicializar() {
		EnemigoThread mMalos;
		EnemigoThread mMalos2;
		EnemigoThread mMalos3;
		EnemigoThread mMalos4;
		EnemigoThread mMalos5;
		EnemigoThread mMalos6;

		Enemigo enemigo = new Rugulo(32, 352);
		nivel.obtCelda(32 / 32, 352 / 32).setPared(null);
		Enemigo enemigo2 = new Rugulo(416, 320);
		nivel.obtCelda(416 / 32, 320 / 32).setPared(null);
		Enemigo enemigo3 = new Rugulo(704, 160);
		nivel.obtCelda(704 / 32, 160 / 32).setPared(null);
		Enemigo enemigo4 = new Altair(640, 224);
		nivel.obtCelda(640 / 32, 224 / 32).setPared(null);
		Enemigo enemigo5 = new Altair(736, 128);
		nivel.obtCelda(736 / 32, 128 / 32).setPared(null);
		Enemigo enemigo6 = new Sirius(928, 352);
		nivel.obtCelda(928 / 32, 352 / 32).setPared(null);

		mMalos = new EnemigoThread(enemigo, this);
		mMalos2 = new EnemigoThread(enemigo2, this);
		mMalos3 = new EnemigoThread(enemigo3, this);
		mMalos4 = new EnemigoThread(enemigo4, this);
		mMalos5 = new EnemigoThread(enemigo5, this);
		mMalos6 = new EnemigoThread(enemigo6, this);

		enemigos.add(enemigo);
		enemigos.add(enemigo2);
		enemigos.add(enemigo3);
		enemigos.add(enemigo4);
		enemigos.add(enemigo5);
		enemigos.add(enemigo6);

		mMalos.start();
		mMalos2.start();
		mMalos3.start();
		mMalos4.start();
		mMalos5.start();
		mMalos6.start();
		
		tiempoS = 0;
		tiempoM = 0;
		tiempoH = 0;

	}
}