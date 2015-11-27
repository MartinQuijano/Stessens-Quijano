package niveles;

import java.awt.Graphics;
import java.util.LinkedList;

import powerups.PowerUp;
import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import grafica.GraficaParedDestruible;

public class ParedDestruible extends Pared {

	public ParedDestruible(int x, int y, Celda c) {
		super(x, y, c);

		grafica = new GraficaParedDestruible(x, y);
	}

	public void avanzar(Bomberman b) {
	}

	public void avanzarEnemigo(Enemigo e, LinkedList<Bomba> bombas) {
		if (e.obtY() > y) {
			e.mover(0);
		} else if (e.obtY() < y) {
			e.mover(1);
		} else if (e.obtX() > x)
			e.mover(2);
		else if (e.obtX() < x)
			e.mover(3);
	}

	public int getPuntaje() {
		return 10;
	}

	public void destruir() {
		miCelda.setPared(null);
		if (miPowerUp != null) {
			miPowerUp.setDibujar(true);
			miCelda.setPowerUp(miPowerUp);
		}
	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);

	}

}
