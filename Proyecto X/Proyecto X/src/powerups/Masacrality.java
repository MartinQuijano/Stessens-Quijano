package powerups;


import entidades.Bomberman;
import grafica.GraficaMasacrality;

public class Masacrality extends PowerUp {

	public Masacrality(int x, int y) {
		super(x, y);

		grafica = new GraficaMasacrality(x, y);
	}

	public void afectarBomberman(Bomberman b) {

	}

	public int getPuntaje() {
		return 50;
	}
}
