package grafica;

import java.awt.Graphics;

public class GraficaBomba extends EntidadGrafica{

	public GraficaBomba(int x, int y) {
		super(x, y);
	}

	public void dibujar(Graphics g) {
		g.drawImage(Assets.bomba, x , y , null);
	}

	public void setCurrentAnimation(int n) {
	}
}
