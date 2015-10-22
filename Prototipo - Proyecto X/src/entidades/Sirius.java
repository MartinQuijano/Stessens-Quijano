package entidades;

/**
 * Sirius es un ex Bomberman que se paso al lado oscuro. No puede atravesar paredes pero es tres
 * veces más rapido que los Rugulos o Altair. Solo hay un Sirius en el nivel y aparece en el
 * rincón opuesto a donde aparece Bomberman. Sirius es muy inteligente y siempre quiere ir
 * hacia donde esta Bomberman.
 */
public class Sirius extends Enemigo {

    /**
     * @param int x representa la posición x dentro del arreglo de celdas.
     * @param int y representa la posición y dentro del arreglo de celdas.
     */
    public  Sirius(int x, int y) {
        super(x, y, 6);
    }

    /**
     * @return puntaje otorgado al matarlo.
     */
    public int getPuntaje() {
        return 50;
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