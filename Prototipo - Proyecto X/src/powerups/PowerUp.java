package powerups;

import entidades.Bomberman;

public abstract class PowerUp {

	protected int posX;
	protected int posY;
	
	protected PowerUp(int x, int y){
		posX = x;
		posY = y;
	}
	
	public abstract void afectarBomberman(Bomberman b);
	
	public abstract int getPuntaje();
	
	public int obtX(){
		return posX;
	}
	
	public int obtY(){
		return posY;
	}
}
