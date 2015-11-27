package powerups;

import entidades.Bomberman;
import grafica.GraficaBombality;

public class Bombality extends PowerUp {

	public Bombality(int x, int y) {
		super(x, y);

		grafica = new GraficaBombality(x, y);

	}

	/**
	 * Incrementa la cantidad maxima de bombas que tiene el bomberman pasado por
	 * parametro en 1.
	 */
	public void afectarBomberman(Bomberman b) {
		b.setCantMaxBombas(b.obtCantMaxBombas() + 1);
		b.setBombasHabiles(b.obtBombasHabiles() + 1);
	}

	public int getPuntaje() {
		return 35;
	}

}
