package entidades;

import grafica.EntidadGrafica;
import javax.swing.JLabel;

public abstract class Entidad {

	protected EntidadGrafica grafico;
	protected boolean esEtereo;
	protected int posX;
	protected int posY;

	protected int velocidad;

	protected Entidad(int x, int y, int vel) {
		posX = x;
		posY = y;
		velocidad = vel;
		esEtereo = false;

		grafico = null;
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

	/**
	 * @param x
	 *            representa la posición x dentro del arreglo de celdas. Setea
	 *            la posicion dentro de las celdas en x.
	 */
	public void setX(int x) {
		posX = x;
	}

	/**
	 * @param y
	 *            representa la posición y dentro del arreglo de celdas. Setea
	 *            la posicion dentro de las celdas en y.
	 */
	public void setY(int y) {
		posY = y;
	}

	/**
	 * @return true si es etereo, false caso contrario.
	 */
	public boolean esEtereo() {
		return esEtereo;
	}

	protected void mover(int dir) {
		grafico.mover(dir);
	}

	public JLabel getGrafico() {
		return grafico.getGrafico();
	}

	public int obtVelocidad() {
		return velocidad;
	}
}
