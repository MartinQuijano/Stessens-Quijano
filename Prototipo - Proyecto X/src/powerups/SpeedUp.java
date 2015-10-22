package powerups;

import entidades.Bomberman;
import grafica.SpeedUpGrafico;

public class SpeedUp extends PowerUp {

	public SpeedUp(int x, int y) {
		super(x, y);

		grafico = new SpeedUpGrafico(x , y );
	}

	/**
	 * Duplica la velocidad de movimiento del bomberman pasado por parametro.
	 */
	public void afectarBomberman(Bomberman b) {
		b.duplicarVelocidad();
	}

	public int getPuntaje() {
		return 0;
	}
}
