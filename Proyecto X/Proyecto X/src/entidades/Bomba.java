package entidades;

import grafica.EntidadGrafica;
import grafica.GraficaBomba;

import java.awt.Graphics;

/**
 * Bomberman es capaz de colocar bombas en su posicion. Pasado un tiempo estas
 * explotan afectando a las casillas contiguas.
 */
public class Bomba {

	protected int posX;
	protected int posY;
	protected boolean exploto;
	protected int alcance;

	protected EntidadGrafica grafica;
	
	public Bomba(int x, int y, int alc) {
		posX = x;
		posY = y;
		alcance = alc;

		grafica = new GraficaBomba(x, y);
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

	/**
	 * Marca la bomba como destruida y marca el grafico de la misma para que
	 * desaparesca.
	 */
	public void destruir() {
		exploto = true;
	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);
		
	}
	
	public int obtAlcance(){
		return alcance;
	}
}
