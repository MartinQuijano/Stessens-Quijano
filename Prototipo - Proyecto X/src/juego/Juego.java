package juego;

import java.util.LinkedList;

import niveles.Nivel;
import entidades.Bomba;
import entidades.Bomberman;
import entidades.Enemigo;
import gui.GUI;


/**
 * 
 */
public class Juego {

	protected GUI miGUI;
    protected int puntaje;
    protected int tiempo;
    protected Nivel nivel;

    protected LinkedList<Bomba> bombas;
    protected LinkedList<Enemigo> enemigos;
    protected Bomberman bomberman;
    
    /**
     * 
     */
    public Juego(GUI gui) {
        miGUI = gui;
    }

    /**
     * 
     */
    public void mover(){
    	
    }
    
    /**
     * 
     */
    public void mover(int dir){
    	
    }
    
    /**
     * 
     */
    public void crearBomba() {
    	bombas.add(bomberman.crearBomba());
    }

    /**
     * 
     */
    public void controlarExplosiones() {
        // TODO implement here
    }

    /**
     * @param b
     */
    private void calcularEfectoBomba(Bomba b) {
        // TODO implement here
    }

    /**
     * 
     */
    public void moverEnemigos() {
        // TODO implement here
    }

    /**
     * @param int i
     */
    public void setPuntaje(int i) {
        // TODO implement here
    }

    /**
     * @param int t
     */
    private void setTiempo(int t) {
        // TODO implement here
    }

}