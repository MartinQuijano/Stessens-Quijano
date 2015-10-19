package entidades;

/**
 * Bomberman es capaz de colocar bombas en su posicion. Pasado un tiempo estas explotan afectando a las casillas
 * contiguas.
 */
public class Bomba {
	
	protected int posX;
	protected int posY;
	protected boolean exploto;
	protected int alcance;
	
	public Bomba(int x, int y, int alc){
		posX = x;
		posY = y;
		alcance = alc;
	}
	
	/**
	 * @return true si la bomba ya exploto, false caso contrario.
	 */
	public boolean yaExploto(){
		return exploto;
	}
	
	/**
	 * @return entero que representa la posicion x dentro del arreglo de celdas.
	 */
	public int obtX(){
		return posX;
	}
	
	/**
	 * @return entero que representa la posicion y dentro del arreglo de celdas.
	 */
	public int obtY(){
		return posY;
	}
	
	/**
	 * Incrementa el alcance que tienen las bombas en 1 celda mas en cada direccion.
	 */
	public void aumentarAlcance(){
		alcance++;
	}
}
