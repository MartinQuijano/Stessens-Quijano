package niveles;

import java.awt.Graphics;
import java.util.LinkedList;

import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import grafica.GraficaParedIndestructible;

public class ParedIndestructible extends Pared {

	public ParedIndestructible(int x, int y, Celda c) {
		super(x, y, c);
		
		grafica = new GraficaParedIndestructible(x, y);
	}

	public void avanzar(Bomberman b) {
	}

	public void avanzarEnemigo(Enemigo e, LinkedList<Bomba> bombas) {
	}

	public int getPuntaje() {
		return 0;
	}

	public void destruir() {
	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);
	}
}
