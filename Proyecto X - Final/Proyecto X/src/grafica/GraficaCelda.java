package grafica;

import java.awt.Graphics;

public class GraficaCelda extends EntidadGrafica {

	protected int type;

	public GraficaCelda(int x, int y, int type) {
		super(x, y);
		this.type = type;
	}

	public void dibujar(Graphics g) {
		if (type == 0)
			g.drawImage(Assets.sueloRoca1, x * width, y * height, null);
		else
			g.drawImage(Assets.sueloRoca2, x * width, y * height, null);
	}
	
	public void setType(int t){
		this.type = t;
	}

	public void setCurrentAnimation(int n) {
	}

}
