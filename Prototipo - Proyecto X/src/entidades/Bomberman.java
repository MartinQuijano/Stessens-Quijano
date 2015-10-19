package entidades;

/**
 * Es el personaje principal del juego, quien puede desplazarse por el nivel en forma vertical y 
 * horizontal colocando bombas y destruyendo así paredes y enemigos. Bomberman tiene una sola vida
 * y cuando muere se termina el juego.
 */
public class Bomberman extends Entidad {

    protected boolean estaVivo;
    protected int bombasHabiles;
    protected int alcanceBomba;
    protected int cantMaxBombas;
    protected boolean masacralityActivo;

    /**
     * @param int x representa la posición x dentro del arreglo de celdas.
     * @param int y representa la posición y dentro del arreglo de celdas.
     */
    public Bomberman(int x, int y) {
        super(x, y, 5);
    }

    /**
     * @return true si Bomberman sigue vivo, falso caso contrario.
     */
    public boolean sigueVivo() {
        return estaVivo;
    }

    /**
     * Establece el valor del atributo estaVivo a true.
     */
    public void destruir() {
        estaVivo = false;
    }

    
	/**
	 * @return una bomba en la posición que se encuentra y con el alcance que tengan
	 *         las bombas actualmente.
	 */
    public Bomba crearBomba() {
    	Bomba b = new Bomba(posX, posY, alcanceBomba);
    	return b;
    }

    /**
     * Incrementa la cantidad de bombas habiles para usar en 1.
     */
    public void reponerBomba() {
        if(bombasHabiles < cantMaxBombas)
        	bombasHabiles++;
    }

    /**
     * Duplica la velocidad de movimiento.
     */
    public void duplicarVelocidad() {
        velocidad = velocidad*2;
    }

    /**
     * Incrementa el alcance de las bombas que crea.
     */
    public void setAlcanceBombas() {
        alcanceBomba++;
    }

    /**
     * @return 
     */
    public int obtAlcanceBombas() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public boolean tieneBombas() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void setCantMaxBombas() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setMasacrality() {
        // TODO implement here
    }

}