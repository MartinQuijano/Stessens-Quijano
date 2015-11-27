package entidades;

public abstract class Enemigo extends Entidad {

	protected Enemigo(int x, int y, int vel) {
		super(x, y, vel);
	}

	/**
	 * @return puntaje otorgado al matarlo.
	 */
	public abstract int getPuntaje();

	/**
	 * Ejecuta el movimiento del enemigo.
	 */
	public void mover(int dir) {
	}

}
