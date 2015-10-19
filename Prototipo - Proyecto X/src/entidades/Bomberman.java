package entidades;

/**
 * 
 */
public class Bomberman extends Entidad {


    protected boolean estaVivo;
    protected int velocidad;
    protected int bombasHabiles;
    protected int alcanceBomba;
    protected int cantMaxBombas;
    protected boolean masacralityActivo;

    /**
     * @param int x 
     * @param int y
     */
    public Bomberman(int x, int y) {
        super(x, y);
    }

    /**
     * @return
     */
    public boolean sigueVivo() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void destruir() {
        // TODO implement here
    }

    /**
     * 
     */
    public void colocarBomba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void reponerBomba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void duplicarVelocidad() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setAlcanceBombas() {
        // TODO implement here
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