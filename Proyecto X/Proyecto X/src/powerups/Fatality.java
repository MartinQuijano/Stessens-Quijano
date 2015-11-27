package powerups;

import entidades.Bomberman;
import grafica.GraficaFatality;

public class Fatality extends PowerUp {

	public Fatality(int x, int y) {
		super(x, y);

		grafica = new GraficaFatality(x, y);
	}

	public void afectarBomberman(Bomberman b) {
		b.setAlcanceBombas(b.obtAlcanceBombas() * 2);
	}

	public int getPuntaje() {
		return 35;
	}
}
