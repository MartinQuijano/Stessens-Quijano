package niveles;

import juego.Juego;

public class Nivel {

	protected Juego miJuego;
	protected Celda misCeldas[][];

	public Nivel(Juego j) {
		miJuego = j;
	}

	public Celda obtCelda(int x, int y) {
		return misCeldas[x][y];
	}

	public void revisarPosiciones() {

	}

	/**
	 * Genera el nivel de forma aleatoria, respetando ciertas reglas.
	 */
	public void generarNivel() {
		for (int i = 0; i < misCeldas.length; i++) {
			for (int j = 0; j < misCeldas[0].length; j++) {
				misCeldas[i][j] = new Celda(i, j);
			}
		}
	}
}
