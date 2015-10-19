package niveles;

import entidades.Bomberman;
import entidades.Enemigo;

public class Celda {

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
