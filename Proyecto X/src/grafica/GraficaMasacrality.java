package grafica;

import java.awt.Graphics;

public class GraficaMasacrality extends EntidadGrafica {

	public GraficaMasacrality(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.masacrality, x, y, null);
	}

	public void setCurrentAnimation(int n) {
	}
}
