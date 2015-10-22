package powerups;

import javax.swing.JLabel;
import entidades.Bomberman;
import grafica.EntidadGrafica;

public abstract class PowerUp {

	protected int posX;
	protected int posY;

	protected EntidadGrafica grafico;

	protected PowerUp(int x, int y) {
		posX = x;
		posY = y;

		grafico = null;
	}

	public abstract void afectarBomberman(Bomberman b);

	public abstract int getPuntaje();

	public int obtX() {
		return posX;
	}

	public int obtY() {
		return posY;
	}

	public JLabel getGrafico() {
		return grafico.getGrafico();
	}
}
