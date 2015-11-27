package entidades;

import grafica.GraficaFuego;

public class Fuego extends Entidad {

	protected boolean seConsumio = false;
	
	public Fuego(int x, int y, int vel) {
		super(x, y, vel);

		grafica = new GraficaFuego(x, y);
	}
	
	/**
	 * Establece al fuego como consumido.
	 */
	public void destruir(){
		seConsumio = true;
	}
	
	public boolean seConsumio(){
		return seConsumio;
	}

}
