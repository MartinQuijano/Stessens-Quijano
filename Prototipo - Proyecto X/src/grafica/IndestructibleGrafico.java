package grafica;

import javax.swing.ImageIcon;

public class IndestructibleGrafico extends EntidadGrafica {

	public IndestructibleGrafico(int x, int y) {
		super(x, y);
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/res/Indestructible.png"));
	}

}
