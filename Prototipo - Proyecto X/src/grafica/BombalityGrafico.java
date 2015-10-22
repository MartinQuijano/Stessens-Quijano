package grafica;

import javax.swing.ImageIcon;

public class BombalityGrafico extends EntidadGrafica {

	public BombalityGrafico(int x, int y) {
		super(x, y);

		this.mImages[0] = new ImageIcon(this.getClass().getResource(
				"/res/Bombality.png"));
	}
}