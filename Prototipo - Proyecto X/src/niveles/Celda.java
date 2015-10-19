package niveles;

import java.awt.event.KeyEvent;

import entidades.Bomberman;
import entidades.Enemigo;

public class Celda {

	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	
	protected int posX;
	protected int posY;
	protected Pared miPared;
	
	public Celda(int x, int y){
		posX = x;
		posY = y;
	}
	
	public void avanzar(Bomberman b){
		
	}
	
	public void avanzarEnemigo(Enemigo e){
		
	}
	
	public int getPuntaje(){
		return miPared.getPuntaje();
	}
	
	public int obtX(){
		return posX;
	}
	
	public int obtY(){
		return posY;
	}
	
	public void destruir(){
		
	}
	
	public Pared obtPared(){
		return miPared;
	}
	
	public void setPared(Pared p){
		miPared = p;
	}

}
