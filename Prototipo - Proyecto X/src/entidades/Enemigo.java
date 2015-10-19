package entidades;

public abstract class Enemigo extends Entidad{

	protected Enemigo(int x, int y){
		super(x,y);
	}
	
	public abstract int getPuntaje();
	
	public abstract boolean atraviesaParedes();
	
}
