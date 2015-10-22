package juego;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

import powerups.Bombality;
import powerups.PowerUp;
import powerups.SpeedUp;
import threads.BombaThread;
import threads.EnemigoThread;
import niveles.Nivel;
import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Rugulo;
import gui.GUI;

/**
 * 
 */
public class Juego {

	protected int puntaje;
	protected int tiempo;
	protected Nivel nivel;
	protected GUI gui;

	private EnemigoThread mMalos;
	private EnemigoThread mMalos2;
	private EnemigoThread mMalos3;

	protected LinkedList<Bomba> bombas;
	protected LinkedList<Enemigo> enemigos;
	protected LinkedList<PowerUp> powerUps;
	protected Bomberman bomberman;

	public Juego(GUI g) {
		gui = g;
		nivel = new Nivel(this);
		nivel.generarNivel();

		bombas = new LinkedList<Bomba>();
		enemigos = new LinkedList<Enemigo>();
		powerUps = new LinkedList<PowerUp>();

		bomberman = new Bomberman(32, 32);
		Enemigo enemigo = new Rugulo(32, 320);
		Enemigo enemigo2 = new Rugulo(416, 320);
		Enemigo enemigo3 = new Rugulo(704, 160);

		mMalos = new EnemigoThread(enemigo, this);
		mMalos2 = new EnemigoThread(enemigo2, this);
		mMalos3 = new EnemigoThread(enemigo3, this);

		enemigos.add(enemigo);
		enemigos.add(enemigo2);
		enemigos.add(enemigo3);

		PowerUp speed = new SpeedUp(96, 320);
		PowerUp bombality = new Bombality(192, 224);
		powerUps.add(speed);
		powerUps.add(bombality);

		gui.add(bomberman.getGrafico());
		gui.add(enemigo.getGrafico());
		gui.add(enemigo2.getGrafico());
		gui.add(enemigo3.getGrafico());
		gui.add(speed.getGrafico());
		gui.add(bombality.getGrafico());

		for (int i = 0; i < nivel.longitudX(); i++) {
			for (int j = 0; j < nivel.longitudY(); j++) {
				if (nivel.obtCelda(i, j).obtPared() != null) {
					gui.add(nivel.obtCelda(i, j).obtPared().getGrafico());
				}
				gui.add(nivel.obtCelda(i, j).getGrafico());
			}
		}

		mMalos.start();
		mMalos2.start();
		mMalos3.start();
	}

	/**
	 * Mueve el enemigo 'e' en una direccion aleatoria.
	 * @param e Enemigo el cual va a mover.
	 */
	public void mover(Enemigo e) {

		Random rnd = new Random();
		int dir = rnd.nextInt(4);

		switch (dir) {
		case 0:
			nivel.obtCelda(e.obtX() / 32, e.obtY() / 32 - 1).avanzarEnemigo(e);
			break;
		case 1:
			nivel.obtCelda(e.obtX() / 32, e.obtY() / 32 + 1).avanzarEnemigo(e);
			break;
		case 2:
			nivel.obtCelda(e.obtX() / 32 - 1, e.obtY() / 32).avanzarEnemigo(e);
			break;
		case 3:
			nivel.obtCelda(e.obtX() / 32 + 1, e.obtY() / 32).avanzarEnemigo(e);
			break;
		}
	}

	/**
	 * Mueve al Bomberman en la direccion pasada por parametro.
	 * @param dir direccion en la cual se va a mover el Bomberman.
	 */
	public void accionBomberman(int dir) {
		switch (dir) {
		case KeyEvent.VK_UP:
			nivel.obtCelda(bomberman.obtX() / 32, bomberman.obtY() / 32 - 1)
					.avanzar(bomberman);
			break;
		case KeyEvent.VK_DOWN:
			nivel.obtCelda(bomberman.obtX() / 32, bomberman.obtY() / 32 + 1)
					.avanzar(bomberman);
			break;
		case KeyEvent.VK_LEFT:
			nivel.obtCelda(bomberman.obtX() / 32 - 1, bomberman.obtY() / 32)
					.avanzar(bomberman);
			break;
		case KeyEvent.VK_RIGHT:
			nivel.obtCelda(bomberman.obtX() / 32 + 1, bomberman.obtY() / 32)
					.avanzar(bomberman);
			break;
		case KeyEvent.VK_SPACE:
			crearBomba();
			break;
		}
	}

	/**
     * Llama al bomberman para que cree una bomba y la coloca en su posicion.
     */
	public void crearBomba() {
		if (bomberman.tieneBombas()) {
			BombaThread hBomba;

			gui.remove(nivel.obtCelda(bomberman.obtX() / 32,
					bomberman.obtY() / 32).getGrafico());
			Bomba b = bomberman.crearBomba();
			bombas.add(b);

			gui.add(b.getGrafico());
			gui.add(nivel
					.obtCelda(bomberman.obtX() / 32, bomberman.obtY() / 32)
					.getGrafico());

			hBomba = new BombaThread(b);
			hBomba.start();
			bomberman.setBombasHabiles(-1);
		}

	}
	
	/**
	 * De acuerdo a los powerups dentro de la lista recibida por parametro, los elimina de la lista
	 * de powerups actual.
	 * @param p lista con los powerups a eliminar.
	 */
	public void clearPowerUp(LinkedList<PowerUp> p){
		for(PowerUp e : p){
			powerUps.remove(e);
			gui.remove(e.getGrafico());
		}
	}

	/**
     * Revisa si las bombas explotaron y las remueve del grafico.
     */
	public void controlarExplosiones() {
		LinkedList<Bomba> bombasExplotadas = new LinkedList<Bomba>();
		for (Bomba b : bombas) {
			if (b.yaExploto()) {
				gui.remove(b.getGrafico());
				bombasExplotadas.add(b);
			}
		}
		for (Bomba b : bombasExplotadas) {
			bombas.remove(b);
			bomberman.setBombasHabiles(1);
		}
	}

	/**
	 * @param b
	 */
	private void calcularEfectoBomba(Bomba b) {
		// TODO implement here
	}

	/**
     * 
     */
	public void moverEnemigos() {
		// TODO implement here
	}

	/**
	 * @param int i
	 */
	public void setPuntaje(int i) {
		// TODO implement here
	}

	/**
	 * @param int t
	 */
	private void setTiempo(int t) {
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

	public LinkedList<PowerUp> obtPowerUps() {
		return powerUps;
	}
}