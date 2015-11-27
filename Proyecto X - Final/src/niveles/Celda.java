package niveles;

import java.awt.Graphics;
import java.util.LinkedList;

import powerups.PowerUp;
import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import grafica.GraficaCelda;

public class Celda {

	protected int posX;
	protected int posY;
	protected int value;

	protected Pared miPared;
	protected GraficaCelda grafica;
	protected PowerUp miPowerUp;

	public Celda(int x, int y) {
		posX = x * 32;
		posY = y * 32;

		grafica = new GraficaCelda(x, y, 0);
	}

	/**
	 * Si no tiene pared, de acuerdo a donde se encuentre la celda y el
	 * bomberman, lo mueve en su direccion. Si tiene pared, no hace nada.
	 * 
	 * @param b
	 *            Bomberman a mover
	 * @param bombas
	 */
	public void avanzar(Bomberman b, LinkedList<Bomba> bombas) {

		boolean hayBomba = false;
		for (Bomba bomb : bombas) {
			if (bomb.obtX() == posX && bomb.obtY() == posY)
				hayBomba = true;
		}
		if (miPared == null && !hayBomba) {
			if (b.obtX() < posX)
				b.mover(39);
			else if (b.obtX() > posX)
				b.mover(37);
			else if (b.obtY() < posY)
				b.mover(40);
			else if (b.obtY() > posY)
				b.mover(38);
		}
	}

	/**
	 * Si no tiene pared, de acuerdo a donde se encuentre la celda y el enemigo,
	 * lo mueve en su direccion. Si tiene pared, no hace nada.
	 * 
	 * @param e
	 *            Enemigo a mover
	 * @param bombas
	 */
	public void avanzarEnemigo(Enemigo e, LinkedList<Bomba> bombas) {
		boolean hayBomba = false;
		for (Bomba bomb : bombas) {
			if ((bomb.obtX() == posX && bomb.obtY() == posY) || e.esEtereo())
				hayBomba = true;
		}
		if (e.esEtereo() && miPared != null) {
				miPared.avanzarEnemigo(e, bombas);
		} else if ((miPared == null && !hayBomba) || e.esEtereo()) {
			if (e.obtY() > posY) {
				e.mover(0);
			} else if (e.obtY() < posY) {
				e.mover(1);
			} else if (e.obtX() > posX)
				e.mover(2);
			else if (e.obtX() < posX)
				e.mover(3);
		}
	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);
		if (miPowerUp != null)
			miPowerUp.dibujar(g);
	}

	public int getPuntaje() {
		if (miPared != null)
			return miPared.getPuntaje();
		return 0;
	}

	public int obtX() {
		return posX;
	}

	public int obtY() {
		return posY;
	}

	public void destruir() {
		if (miPared != null) {
			miPared.destruir();
		}
	}

	public Pared obtPared() {
		return miPared;
	}

	public void setPared(Pared p) {
		miPared = p;
	}

	public Pared getPared() {
		return miPared;
	}

	public void setValue(int v) {
		value = v;
		grafica.setType(v);
	}

	public int getValue() {
		return value;
	}

	public PowerUp getPowerUp() {
		return miPowerUp;
	}

	public void setPowerUp(PowerUp p) {
		miPowerUp = p;
	}

}
