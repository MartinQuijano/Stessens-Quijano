package grafica;

import java.awt.Graphics;

public class GraficaAltair extends EntidadGrafica {

	public GraficaAltair(int x, int y) {
		super(x, y);

		animaciones = new Animation[4];

		animaciones[0] = new Animation(200, Assets.altair_up);
		animaciones[1] = new Animation(200, Assets.altair_down);
		animaciones[2] = new Animation(200, Assets.altair_right);
		animaciones[3] = new Animation(200, Assets.altair_left);

		currentAnim = animaciones[1];
	}

	public void dibujar(Graphics g) {
		g.drawImage(currentAnim.getCurrentFrame(), x, y, null);
	}

	public void setCurrentAnimation(int n) {
		currentAnim = animaciones[n];
	}

}
