package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import juego.Juego;

public class MouseInput implements MouseListener {

	private Juego juego;

	public MouseInput(Juego juego) {
		this.juego = juego;
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	/**
	 * Cuando se presiona el boton izquierdo del mouse, de acuerdo a la
	 * ubicacion en pantalla, se presionan los botones.
	 */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (juego.getState() == 0) {
			// Boton nuevo juego
			if (mx >= 620 && mx <= 870)
				if (my >= 100 && my <= 160) {
					juego.inicializar();
					juego.setState(1);
				}

			// Boton ayuda
			if (mx >= 620 && mx <= 870)
				if (my >= 200 && my <= 260)
					juego.setState(2);
		}
		if (juego.getState() == 2) {
			// Boton volver
			if (mx >= 690 && mx <= 930)
				if (my >= 300 && my <= 360)
					juego.setState(0);
		}
	}

	public void mouseReleased(MouseEvent arg0) {
	}

}
