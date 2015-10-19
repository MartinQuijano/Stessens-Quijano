package entidades;

import grafica.EntidadGrafica;

import javax.swing.JLabel;

import niveles.Celda;

public abstract class Entidad {

	protected EntidadGrafica grafico;
	protected boolean esEtereo;
	protected int posX;
	protected int posY;
	
	protected int velocidad;
	
	protected Entidad(int x, int y, int vel){
		posX = x;
		posY = y;
		velocidad = vel;
		
		grafico = null;
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
	
	protected void mover(int dir){
//		Celda next = this.pos.getVecina(dir);
//		
//		if(next != null){
//			this.pos = next;
//			this.grafico.mover(dir);
//		}
	}
	
	public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
	
	public int obtVelocidad(){
		return velocidad;
	}
}
