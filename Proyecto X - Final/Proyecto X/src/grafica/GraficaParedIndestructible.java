package grafica;

import java.awt.Graphics;

public class GraficaParedIndestructible extends EntidadGrafica {

	public GraficaParedIndestructible(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.muroIndes, x * width, y * height, null);
	}

	public void setCurrentAnimation(int n) {
	}

}
