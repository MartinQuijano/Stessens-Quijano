package niveles;

import java.util.LinkedList;

import powerups.PowerUp;
import entidades.Enemigo;
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

	/**
	 * Revisa si hubo colisiones entre el bomberman y los enemigos y powerups.
	 * Segun la colision, llama a los metodos correspondientes.
	 */
	public void revisarPosiciones() {
		LinkedList<Enemigo> enemigos = miJuego.obtEnemigos();
		for (Enemigo e : enemigos) {
			if (e.obtX() == miJuego.obtBomberman().obtX()) {
				if ((miJuego.obtBomberman().obtY() <= e.obtY() && miJuego
						.obtBomberman().obtY() + 31 >= e.obtY())
						|| miJuego.obtBomberman().obtY() >= e.obtY()
						&& miJuego.obtBomberman().obtY() <= e.obtY() + 31) {
					System.exit(1);
				}
			}
			if (e.obtY() == miJuego.obtBomberman().obtY()) {
				if ((miJuego.obtBomberman().obtX() <= e.obtX() && miJuego
						.obtBomberman().obtX() + 31 >= e.obtX())
						|| (miJuego.obtBomberman().obtX() >= e.obtX() && miJuego
								.obtBomberman().obtX() <= e.obtX() + 31)) {
					System.exit(1);
				}
			}
		}
		LinkedList<PowerUp> powerUps = miJuego.obtPowerUps();
		LinkedList<PowerUp> powerUpsAfectados = new LinkedList<PowerUp>();
		for (PowerUp p : powerUps) {
			if (p.obtX() == miJuego.obtBomberman().obtX()) {
				if ((miJuego.obtBomberman().obtY() <= p.obtY() && miJuego
						.obtBomberman().obtY() + 31 >= p.obtY())
						|| miJuego.obtBomberman().obtY() >= p.obtY()
						&& miJuego.obtBomberman().obtY() <= p.obtY() + 31) {
					p.afectarBomberman(miJuego.obtBomberman());
					powerUpsAfectados.add(p);

				}
			} else if (p.obtY() == miJuego.obtBomberman().obtY()) {
				if ((miJuego.obtBomberman().obtX() <= p.obtX() && miJuego
						.obtBomberman().obtX() + 31 >= p.obtX())
						|| (miJuego.obtBomberman().obtX() >= p.obtX() && miJuego
								.obtBomberman().obtX() <= p.obtX() + 31)) {
					p.afectarBomberman(miJuego.obtBomberman());
					powerUpsAfectados.add(p);
				}
			}
		}
		miJuego.clearPowerUp(powerUpsAfectados);

	}

	/**
	 * Genera el nivel de forma aleatoria, respetando ciertas reglas.
	 */
	public void generarNivel() {
		misCeldas = new Celda[31][13];
		for (int i = 0; i < misCeldas.length; i++) {
			for (int j = 0; j < misCeldas[0].length; j++) {
				misCeldas[i][j] = new Celda(i, j);
				if (i == 0)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j));
				else if (i == misCeldas.length - 1)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j));
				else if (j == 0)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j));
				else if (j == misCeldas[0].length - 1)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j));
				else if (i % 2 == 0 && j % 2 == 0)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j));

			}
		}
		misCeldas[5][1].setPared(new ParedDestruible(5, 1));
		misCeldas[5][2].setPared(new ParedDestruible(5, 2));
		misCeldas[2][7].setPared(new ParedDestruible(2, 7));
		misCeldas[4][3].setPared(new ParedDestruible(4, 3));
		misCeldas[3][3].setPared(new ParedDestruible(3, 3));

		misCeldas[2][1].setPared(new ParedDestruible(2, 1));
		misCeldas[2][3].setPared(new ParedDestruible(2, 3));
		misCeldas[2][7].setPared(new ParedDestruible(2, 7));
		misCeldas[2][9].setPared(new ParedDestruible(2, 9));
		misCeldas[2][11].setPared(new ParedDestruible(2, 11));

	}

	public int longitudX() {
		return misCeldas.length;
	}

	public int longitudY() {
		return misCeldas[0].length;
	}
}
