package powerups;


import threads.MasacralityThread;
import entidades.Bomberman;
import grafica.GraficaMasacrality;

public class Masacrality extends PowerUp {

	public Masacrality(int x, int y) {
		super(x, y);

		grafica = new GraficaMasacrality(x, y);
	}

	public void afectarBomberman(Bomberman b) {
		b.setMasacrality();
		MasacralityThread mscThread = new MasacralityThread(b);
		mscThread.start();
	}

	public int getPuntaje() {
		return 50;
	}
}
