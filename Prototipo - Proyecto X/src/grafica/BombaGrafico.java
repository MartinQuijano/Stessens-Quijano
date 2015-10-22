package grafica;

import javax.swing.ImageIcon;

public class BombaGrafico extends EntidadGrafica {

	public BombaGrafico(int x, int y) {
		super(x, y);

		this.mImages[0] = new ImageIcon(this.getClass().getResource(
				"/res/Bomba.png"));

	}
}
