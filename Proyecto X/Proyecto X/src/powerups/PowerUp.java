package powerups;

import java.awt.Graphics;

import entidades.Bomberman;
import grafica.EntidadGrafica;

public abstract class PowerUp {

	protected int posX;
	protected int posY;
	protected boolean dibujar = false;

	EntidadGrafica grafica;
	
	protected PowerUp(int x, int y) {
		posX = x;
		posY = y;

	}

	public abstract void afectarBomberman(Bomberman b);

	public abstract int getPuntaje();
	
	public void dibujar(Graphics g){
		if(dibujar)
			grafica.dibujar(g);
	}

	public int obtX() {
		return posX;
	}

	public int obtY() {
		return posY;
	}

	public void setDibujar(boolean b) {
		dibujar = b;
	}
}
