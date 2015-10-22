package entidades;

import javax.swing.JLabel;

import grafica.BombaGrafico;
import grafica.EntidadGrafica;

/**
 * Bomberman es capaz de colocar bombas en su posicion. Pasado un tiempo estas
 * explotan afectando a las casillas contiguas.
 */
public class Bomba {

	protected int posX;
	protected int posY;
	protected boolean exploto;
	protected int alcance;

	protected EntidadGrafica grafico;

	public Bomba(int x, int y, int alc) {
		posX = x;
		posY = y;
		alcance = alc;

		grafico = new BombaGrafico(x, y);
	}

	/**
	 * @return true si la bomba ya exploto, false caso contrario.
	 */
	public boolean yaExploto() {
		return exploto;
	}

	/**
	 * @return entero que representa la posicion x dentro del arreglo de celdas.
	 */
	public int obtX() {
		return posX;
	}

	/**
	 * @return entero que representa la posicion y dentro del arreglo de celdas.
	 */
	public int obtY() {
		return posY;
	}

	public JLabel getGrafico() {
		return grafico.getGrafico();
	}

	/**
	 * Marca la bomba como destruida y marca el grafico de la misma para que
	 * desaparesca.
	 */
	public void destruir() {
		exploto = true;
		grafico.getGrafico().setBounds(posX, posY + 32, 32, 32);
	}
}
