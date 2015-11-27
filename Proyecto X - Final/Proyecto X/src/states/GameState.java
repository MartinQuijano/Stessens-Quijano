package states;

import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import entidades.Fuego;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import juego.Juego;

public class GameState extends State {

	private Bomberman bomberman;
	private LinkedList<Bomba> bombas;
	private LinkedList<Enemigo> enemigos;
	private LinkedList<Fuego> fuegos;
	private String puntaje;
	private String tiempo;

	public GameState(Juego juego, Bomberman b, LinkedList<Bomba> bombas,
			LinkedList<Enemigo> enemigos, LinkedList<Fuego> fuegos) {
		super(juego);
		this.bombas = bombas;
		bomberman = b;
		this.enemigos = enemigos;
		this.fuegos = fuegos;
	}

	public void update() {
		puntaje = "Puntaje = " + Integer.toString(juego.getPuntaje());
		tiempo = "Tiempo = " + Integer.toString(juego.obtTiempoH())+ ":" +  Integer.toString(juego.obtTiempoM()) + ":"
				+ Integer.toString(juego.obtTiempoS());
	}

	public void render(Graphics g) {

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 992, 446);
		g.setColor(Color.WHITE);
		g.drawString(puntaje, 200, 435);
		g.drawString(tiempo, 700, 435);
		juego.getNivel().generarNivelGrafico(g);
		bomberman.dibujar(g);
		for (Bomba b : bombas)
			b.dibujar(g);
		for (Enemigo e : enemigos)
			e.dibujar(g);
		for (Fuego f : fuegos)
			f.dibujar(g);

	}

}
