package entidades;

import grafica.GraficaFuego;

import java.awt.Graphics;

public class Fuego extends Entidad {

	protected boolean seConsumio = false;
	
	public Fuego(int x, int y, int vel) {
		super(x, y, vel);

		grafica = new GraficaFuego(x, y);
	}

	public void dibujar(Graphics g) {
		grafica.dibujar(g);
	}
	
	public void destruir(){
		seConsumio = true;
	}
	
	public boolean seConsumio(){
		return seConsumio;
	}

}
