package grafica;

import java.awt.Graphics;

public class GraficaBomberman extends EntidadGrafica {

	public GraficaBomberman(int x, int y) {
		super(x, y);

		animaciones = new Animation[4];

		animaciones[0] = new Animation(200, Assets.player_up);
		animaciones[1] = new Animation(200, Assets.player_down);
		animaciones[2] = new Animation(200, Assets.player_right);
		animaciones[3] = new Animation(200, Assets.player_left);

		currentAnim = animaciones[1];
	}

	public void dibujar(Graphics g) {
		g.drawImage(currentAnim.getCurrentFrame(), x, y, null);
	}

	public void setCurrentAnimation(int n) {
		currentAnim = animaciones[n];
	}

}
