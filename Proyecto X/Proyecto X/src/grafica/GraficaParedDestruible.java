package grafica;

import java.awt.Graphics;

public class GraficaParedDestruible extends EntidadGrafica {

	public GraficaParedDestruible(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.muroDest, x * width, y * height, null);
	}

	public void setCurrentAnimation(int n) {
	}

}
