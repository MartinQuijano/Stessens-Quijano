package grafica;

import java.awt.Graphics;

public class GraficaFuego extends EntidadGrafica{
	
	public GraficaFuego(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.fuego, x, y, null);
	}

	public void setCurrentAnimation(int n) {
	}

}
