package niveles;

import juego.Juego;

public class Nivel {
	
	protected Juego miJuego;
	protected Celda misCeldas[][];
	
	public Nivel(Juego j){
		miJuego = j;
	}
	
	public Celda obtCelda(int x, int y){
		return misCeldas[x][y];
	}
	
	public void revisarPosiciones(){
		
	}
}
