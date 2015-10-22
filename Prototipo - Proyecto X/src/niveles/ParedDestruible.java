package niveles;

import entidades.Bomberman;
import entidades.Enemigo;
import grafica.DestruibleGrafico;
import grafica.IndestructibleGrafico;

public class ParedDestruible extends Pared{

	public ParedDestruible(int x, int y){
		super(x, y);
		grafico = new DestruibleGrafico(x*32, y*32);
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
