package niveles;

import entidades.Bomberman;
import entidades.Enemigo;

public abstract class Pared {

	public abstract void avanzar(Bomberman b);
	
	public abstract void avanzarEnemigo(Enemigo e);
	
	public abstract int getPuntaje();
	
	public abstract void destruir();
}
