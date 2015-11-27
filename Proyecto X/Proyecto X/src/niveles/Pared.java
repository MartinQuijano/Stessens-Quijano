package niveles;

import java.awt.Graphics;
import java.util.LinkedList;

import powerups.PowerUp;
import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import grafica.EntidadGrafica;

public abstract class Pared {

	protected int x;
	protected int y;
	protected Celda miCelda;
	protected EntidadGrafica grafica;
	protected PowerUp miPowerUp;

	protected Pared(int x, int y, Celda c) {
		this.x = x * 32;
		this.y = y * 32;
		miCelda = c;
	}

	public abstract void avanzar(Bomberman b);

	public abstract void avanzarEnemigo(Enemigo e);

	public abstract int getPuntaje();

	public abstract void destruir();

	public abstract void dibujar(Graphics g);

	public PowerUp getPowerUp() {
		return miPowerUp;
	}

	public void setPowerUp(PowerUp p) {
		miPowerUp = p;
	}
}
