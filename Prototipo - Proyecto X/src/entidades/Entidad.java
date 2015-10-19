package entidades;

public abstract class Entidad {

	protected boolean esEtereo;
	protected int posX;
	protected int posY;
	
	protected Entidad(int x, int y){
		posX = x;
		posY = y;		
	}
	
	public int obtX(){
		return posX;	
	}
	
	public int obtY(){
		return posY;
	}
	
	public void setX(int x){
		posX = x;
	}
	
	public void setY(int y){
		posY = y;
	}
	
	public boolean esEtereo(){
		return esEtereo;
	}
}
