package grafica;

import java.awt.Graphics;

public class GraficaSpeedUp extends EntidadGrafica{

	public GraficaSpeedUp(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.speedUp, x, y, null);
	}

	public void setCurrentAnimation(int n) {
	}

}
