package grafica;

import java.awt.Graphics;

public class GraficaFatality extends EntidadGrafica {

	public GraficaFatality(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.fatality, x, y, null);
	}

	public void setCurrentAnimation(int n) {
	}

}
