package grafica;

import javax.swing.ImageIcon;

public class SpeedUpGrafico extends EntidadGrafica {

	public SpeedUpGrafico(int x, int y) {
		super(x, y);

		this.mImages[0] = new ImageIcon(this.getClass().getResource(
				"/res/SpeedUp.png"));
	}
}
