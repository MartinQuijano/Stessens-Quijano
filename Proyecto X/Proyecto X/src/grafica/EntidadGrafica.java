package grafica;

import java.awt.Graphics;

public abstract class EntidadGrafica {

	protected int x;
	protected int y;
	protected int width = 32;
	protected int height = 32;

	Animation animaciones[];
	Animation currentAnim;

	protected EntidadGrafica(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		currentAnim.update();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void dibujar(Graphics g);

	public abstract void setCurrentAnimation(int n);

	public Animation getCurrentAnim() {
		return currentAnim;
	}
}
