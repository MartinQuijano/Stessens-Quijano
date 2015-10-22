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
	 * @return true si puede atravesar paredes, false caso contrario.
	 */
	public abstract boolean atraviesaParedes();

	public void mover(int dir) {
		super.mover(dir);
	}

	public void destruir() {
		// super.destruir();
	}

}
