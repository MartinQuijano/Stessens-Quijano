package niveles;

import javax.swing.JLabel;

import entidades.Bomberman;
import entidades.Enemigo;
import grafica.CeldaGrafico;
import grafica.EntidadGrafica;

public class Celda {

	protected int posX;
	protected int posY;

	protected EntidadGrafica grafico;

	protected Pared miPared;

	public Celda(int x, int y) {
		posX = x * 32;
		posY = y * 32;

		grafico = new CeldaGrafico(x * 32, y * 32);
	}

	/**
	 * Si no tiene pared, de acuerdo a donde se encuentre la celda y el
	 * bomberman, lo mueve en su direccion. Si tiene pared, no hace nada.
	 * 
	 * @param b
	 *            Bomberman a mover
	 */
	public void avanzar(Bomberman b) {
		if (miPared == null) {
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
	 */
	public void avanzarEnemigo(Enemigo e) {
		if (miPared == null) {
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

	public int getPuntaje() {
		return miPared.getPuntaje();
	}

	public int obtX() {
		return posX;
	}

	public int obtY() {
		return posY;
	}

	public void destruir() {

	}

	public Pared obtPared() {
		return miPared;
	}

	public void setPared(Pared p) {
		miPared = p;
	}

	public JLabel getGrafico() {
		return grafico.getGrafico();
	}

}
