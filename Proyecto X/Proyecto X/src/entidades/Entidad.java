package entidades;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import grafica.EntidadGrafica;

public abstract class Entidad {

	protected boolean esEtereo;
	protected int posX;
	protected int posY;

	protected int velocidad;
	protected EntidadGrafica grafica;

	protected Entidad(int x, int y, int vel) {
		posX = x;
		posY = y;
		velocidad = vel;
		esEtereo = false;
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
//		if (this.grafica != null) {
//			
//			// this.changeIcon(dir);
//			try {
//				switch (dir) {
//				case KeyEvent.VK_UP: // Arriba
//					for (int i = 0; i < 32; i += this.velocidad) {
//						posY = posY - this.velocidad;
//						grafica.setY(grafica.getY() - this.velocidad);
//						Thread.sleep(40);
//					}
//					break;
//				case KeyEvent.VK_DOWN: // Abajo.				
//					for (int i = 0; i < 32; i += this.velocidad) {
//						posY = posY + this.velocidad;
//						grafica.setY(grafica.getY() + this.velocidad);
//						Thread.sleep(40);
//					}
//					break;
//				case KeyEvent.VK_RIGHT: // Derecha
//					for (int i = 0; i < 32; i += this.velocidad) {
//						posX = posX + this.velocidad;
//						grafica.setX(grafica.getX() + this.velocidad);
//						Thread.sleep(40);
//					}
//					break;
//				case KeyEvent.VK_LEFT: // Izquierda
//					for (int i = 0; i < 32; i += this.velocidad) {
//						posX = posX - this.velocidad;
//						grafica.setX(grafica.getX() - this.velocidad);
//						Thread.sleep(40);
//					}
//					break;
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}	
	}

	public int obtVelocidad() {
		return velocidad;
	}
	
	public abstract void dibujar(Graphics g);
}
