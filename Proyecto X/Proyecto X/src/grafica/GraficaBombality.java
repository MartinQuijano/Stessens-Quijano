package grafica;

import java.awt.Graphics;

public class GraficaBombality extends EntidadGrafica {

	public GraficaBombality(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.bombality, x, y, null);
	}

	public void setCurrentAnimation(int n) {
	}

}
