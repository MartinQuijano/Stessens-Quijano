package grafica;

import javax.swing.ImageIcon;

public class CeldaGrafico extends EntidadGrafica {

	public CeldaGrafico(int x, int y) {
		super(x, y);

		this.mImages[0] = new ImageIcon(this.getClass().getResource(
				"/res/Celda.png"));

	}
}