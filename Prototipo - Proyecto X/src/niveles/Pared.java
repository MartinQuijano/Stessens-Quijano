package niveles;

import javax.swing.JLabel;

import entidades.Bomberman;
import entidades.Enemigo;
import grafica.EntidadGrafica;

public abstract class Pared {
	
	protected int x;
	protected int y;
	
	protected EntidadGrafica grafico;
	
	protected Pared(int x, int y){
		this.x = x*32;
		this.y = y*32;
	}
	
	public abstract void avanzar(Bomberman b);
	
	public abstract void avanzarEnemigo(Enemigo e);
	
	public abstract int getPuntaje();
	
	public abstract void destruir();
	
	public JLabel getGrafico(){
		return grafico.getGrafico();
	} 
}
