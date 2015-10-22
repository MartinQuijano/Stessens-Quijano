package entidades;

/**
 * Los altair son seres del inframundo. Pueden atravesar las paredes destruibles (pero no las indestructibles).
 * Son tan veloces como los Rugulos e igual de inteligentes. En el nivel tiene que aparecer 2 de ellos.
 */
public class Altair extends Enemigo {

	/**
     * @param int x representa la posición x dentro del arreglo de celdas.
     * @param int y representa la posición y dentro del arreglo de celdas.
     */
    public Altair(int x, int y) {
    	super(x, y, 2);
    	esEtereo = true;
    }

    /**
     * @return puntaje otorgado al matarlo.
     */
    public int getPuntaje() {
        return 20;
    }

    /**
     * @return true si puede atravesar paredes, false caso contrario.
     */
    public boolean atraviesaParedes() {
        return esEtereo;
    }

	public void mover() {
		
	}

	public void destruir() {
		
	}

	@Override
	public void mover(int dir) {
		// TODO Auto-generated method stub
		
	}

}