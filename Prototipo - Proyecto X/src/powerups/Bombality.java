package powerups;

import entidades.Bomberman;
import grafica.BombalityGrafico;

public class Bombality extends PowerUp {

	public Bombality(int x, int y) {
		super(x, y);

		grafico = new BombalityGrafico(x, y);
	}

	/**
	 * Incrementa la cantidad maxima de bombas que tiene el bomberman pasado por
	 * parametro en 1.
	 */
	public void afectarBomberman(Bomberman b) {
		b.setCantMaxBombas(1);
		b.setBombasHabiles(1);
	}

	public int getPuntaje() {
		return 0;
	}

}
