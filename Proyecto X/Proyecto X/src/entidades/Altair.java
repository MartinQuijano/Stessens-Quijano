package entidades;

import grafica.GraficaAltair;

import java.awt.Graphics;

/**
 * Los altair son seres del inframundo. Pueden atravesar las paredes destruibles
 * (pero no las indestructibles). Son tan veloces como los Rugulos e igual de
 * inteligentes. En el nivel tiene que aparecer 2 de ellos.
 */
public class Altair extends Enemigo {

	/**
	 * @param int x representa la posición x dentro del arreglo de celdas.
	 * @param int y representa la posición y dentro del arreglo de celdas.
	 */
	public Altair(int x, int y) {
		super(x, y, 4);
		esEtereo = true;

		grafica = new GraficaAltair(x, y);
	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);
	}

	/**
	 * @return puntaje otorgado al matarlo.
	 */
	public int getPuntaje() {
		return 20;
	}

	/**
	 * @return true si puede atravesar paredes, false caso contrario.
	 */
	public boolean atraviesaParedes() {
		return esEtereo;
	}

	public void destruir() {

	}

	public void mover(int dir) {
		if (this.grafica != null) {
			// this.changeIcon(dir);
			try {
				switch (dir) {
				case 0: // Arriba
					for (int i = 0; i < 32; i += this.velocidad) {
						posY = posY - this.velocidad;
						grafica.setCurrentAnimation(0);
						grafica.update();
						grafica.setY(grafica.getY() - this.velocidad);
						Thread.sleep(80);
					}
					break;
				case 1: // Abajo.
					for (int i = 0; i < 32; i += this.velocidad) {
						posY = posY + this.velocidad;
						grafica.setCurrentAnimation(1);
						grafica.update();
						grafica.setY(grafica.getY() + this.velocidad);
						Thread.sleep(80);
					}
					break;
				case 2: // Izquierda
					for (int i = 0; i < 32; i += this.velocidad) {
						posX = posX - this.velocidad;
						grafica.setCurrentAnimation(3);
						grafica.update();
						grafica.setX(grafica.getX() - this.velocidad);
						Thread.sleep(80);
					}
					break;
				case 3: // Derecha
					for (int i = 0; i < 32; i += this.velocidad) {
						posX = posX + this.velocidad;
						grafica.setCurrentAnimation(2);
						grafica.update();
						grafica.setX(grafica.getX() + this.velocidad);
						Thread.sleep(80);
					}
					break;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}