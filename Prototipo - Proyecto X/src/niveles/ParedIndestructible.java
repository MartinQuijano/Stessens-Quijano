package niveles;

import entidades.Bomberman;
import entidades.Enemigo;
import grafica.IndestructibleGrafico;

public class ParedIndestructible extends Pared {

	public ParedIndestructible(int x, int y) {
		super(x, y);
		grafico = new IndestructibleGrafico(x * 32, y * 32);
	}

	public void avanzar(Bomberman b) {
	}

	public void avanzarEnemigo(Enemigo e) {
	}

	public int getPuntaje() {
		return 0;
	}

	public void destruir() {
	}
}
