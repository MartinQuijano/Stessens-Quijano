package powerups;

import entidades.Bomberman;
import grafica.GraficaSpeedUp;

public class SpeedUp extends PowerUp {

	public SpeedUp(int x, int y) {
		super(x, y);
		
		grafica = new GraficaSpeedUp(x, y);

	}

	/**
	 * Duplica la velocidad de movimiento del bomberman pasado por parametro.
	 */
	public void afectarBomberman(Bomberman b) {
		b.duplicarVelocidad();
	}

	public int getPuntaje() {
		return 30;
	}
}
