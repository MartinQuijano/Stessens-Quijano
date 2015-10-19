package entidades;

/**
 * Los rugulos son personajes muy tontos y lentos. Se desplazan por los lugares donde no hay paredes
 * y deciden hacia dodne ir en forma aleatoria. En el nivel tienen que aparecer 3 de ellos.
 */
public class Rugulo extends Enemigo {

    /**
     * @param int x representa la posición x dentro del arreglo de celdas.
     * @param int y representa la posición y dentro del arreglo de celdas.
     */
    public Rugulo(int x, int y) {
        super(x, y, 2);
    }

    /**
     * @return puntaje otorgado al matarlo.
     */
    public int getPuntaje() {
        return 15;
    }

    /**
     * @return true si puede atravesar paredes, false caso contrario.
     */
    public boolean atraviesaParedes() {
        return false;
    }

}