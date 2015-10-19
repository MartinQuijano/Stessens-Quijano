package entidades;

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
	
	public boolean yaExploto(){
		return exploto;
	}
	
	public int obtX(){
		return posX;
	}
	
	public int obtY(){
		return posY;
	}
	
	public void aumentarAlcance(){
		alcance++;
	}
}
