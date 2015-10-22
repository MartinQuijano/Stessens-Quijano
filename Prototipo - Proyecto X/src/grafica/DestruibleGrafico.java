package grafica;

import javax.swing.ImageIcon;

public class DestruibleGrafico extends EntidadGrafica {

	public DestruibleGrafico(int x, int y) {
		super(x, y);
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/res/Destruible.png"));
	}
}
