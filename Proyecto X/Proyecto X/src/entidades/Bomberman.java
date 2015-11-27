package entidades;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import grafica.Animation;
import grafica.Assets;
import grafica.GraficaBomberman;

/**
 * Es el personaje principal del juego, quien puede desplazarse por el nivel en
 * forma vertical y horizontal colocando bombas y destruyendo así paredes y
 * enemigos. Bomberman tiene una sola vida y cuando muere se termina el juego.
 */
public class Bomberman extends Entidad {

	protected boolean estaVivo;
	protected int bombasHabiles;
	protected int alcanceBomba;
	protected int cantMaxBombas;
	protected boolean masacralityActivo;

	/**
	 * @param int x representa la posición x dentro del arreglo de celdas.
	 * @param int y representa la posición y dentro del arreglo de celdas.
	 */
	public Bomberman(int x, int y) {
		super(x, y, 2);
		bombasHabiles = 1;
		cantMaxBombas = 1;
		alcanceBomba = 1;

		grafica = new GraficaBomberman(x, y);

	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);
	}

	/**
	 * @return true si Bomberman sigue vivo, falso caso contrario.
	 */
	public boolean sigueVivo() {
		return estaVivo;
	}

	/**
	 * Establece el valor del atributo estaVivo a true.
	 */
	public void destruir() {
		estaVivo = false;
	}

	/**
	 * @return una bomba en la posición que se encuentra y con el alcance que
	 *         tengan las bombas actualmente.
	 */
	public Bomba crearBomba() {
		Bomba b = new Bomba(posX, posY, alcanceBomba);
		bombasHabiles--;
		return b;
	}

	/**
	 * Incrementa la cantidad de bombas habiles para usar en 1.
	 */
	public void reponerBomba() {
		if (bombasHabiles < cantMaxBombas) {
			bombasHabiles++;
		}
	}

	/**
	 * Duplica la velocidad de movimiento.
	 */
	public void duplicarVelocidad() {
		velocidad = velocidad * 2;
	}

	/**
	 * Incrementa el alcance de las bombas que crea.
	 */
	public void setAlcanceBombas(int alc) {
		alcanceBomba = alc;
	}

	/**
	 * @return entero que representa el alcance de las bombas.
	 */
	public int obtAlcanceBombas() {
		return alcanceBomba;
	}

	/**
	 * @return true si tiene bombas para poner, false caso contrario.
	 */
	public boolean tieneBombas() {
		return (bombasHabiles > 0);
	}

	/**
	 * Incrementa la cantidad maxima de bombas que puede colocar.
	 */
	public void setCantMaxBombas(int cmb) {
		cantMaxBombas = cmb;
	}

	/**
	 * Activa/Desactiva masacrality.
	 */
	public void setMasacrality() {
		if (masacralityActivo) {
			masacralityActivo = false;
			esEtereo = false;
		} else {
			masacralityActivo = true;
			esEtereo = true;
		}
	}

	public void mover(int dir) {
		if (this.grafica != null) {
			// this.changeIcon(dir);
			try {
				switch (dir) {
				case KeyEvent.VK_UP: // Arriba
					for (int i = 0; i < 32; i += this.velocidad) {
						posY = posY - this.velocidad;
						grafica.setCurrentAnimation(0);
						grafica.update();
						grafica.setY(grafica.getY() - this.velocidad);
						Thread.sleep(40);
					}
					break;
				case KeyEvent.VK_DOWN: // Abajo.
					for (int i = 0; i < 32; i += this.velocidad) {
						posY = posY + this.velocidad;
						grafica.setCurrentAnimation(1);
						grafica.update();
						grafica.setY(grafica.getY() + this.velocidad);
						Thread.sleep(40);
					}
					break;
				case KeyEvent.VK_RIGHT: // Derecha
					for (int i = 0; i < 32; i += this.velocidad) {
						posX = posX + this.velocidad;
						grafica.setCurrentAnimation(2);
						grafica.update();
						grafica.setX(grafica.getX() + this.velocidad);
						Thread.sleep(40);
					}
					break;
				case KeyEvent.VK_LEFT: // Izquierda
					for (int i = 0; i < 32; i += this.velocidad) {
						posX = posX - this.velocidad;
						grafica.setCurrentAnimation(3);
						grafica.update();
						grafica.setX(grafica.getX() - this.velocidad);
						Thread.sleep(40);
					}
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setBombasHabiles(int bh) {
		bombasHabiles = bh;
	}

	public int obtBombasHabiles() {
		return bombasHabiles;
	}

	public int obtCantMaxBombas() {
		return cantMaxBombas;
	}

}