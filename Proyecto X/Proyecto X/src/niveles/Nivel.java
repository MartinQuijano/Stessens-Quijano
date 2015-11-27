package niveles;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import powerups.Bombality;
import powerups.Fatality;
import powerups.Masacrality;
import powerups.PowerUp;
import powerups.SpeedUp;
import entidades.Enemigo;
import entidades.Fuego;
import juego.Juego;

public class Nivel {

	protected Juego miJuego;
	protected Celda misCeldas[][];
	protected int cantCeldas = 246;
	protected double porcOcupadas = 0.5;
	protected int cantidadSpeedUp = 4;
	protected int cantidadFatality = 3;
	protected int cantidadBombality = 3;
	protected int cantidadMasacrality = 1;

	public Nivel(Juego j) {
		miJuego = j;
	}

	public Celda obtCelda(int x, int y) {
		return misCeldas[x][y];
	}

	/**
	 * Revisa si hubo colisiones entre el bomberman y los enemigos y powerups.
	 * Segun la colision, llama a los metodos correspondientes.
	 * 
	 * @param fuegos
	 */
	public void revisarPosiciones(LinkedList<Fuego> fuegos) {
		int posXbomberman = miJuego.obtBomberman().obtX();
		int posYbomberman = miJuego.obtBomberman().obtY();
		Celda celdBomberman = obtCelda(posXbomberman / 32, posYbomberman / 32);
		LinkedList<Enemigo> enemigos = miJuego.obtEnemigos();
		if (!miJuego.obtBomberman().estaActivoMasacrality()) {
			for (Enemigo e : enemigos) {
				Celda c = obtCelda(e.obtX() / 32, e.obtY() / 32);
				if (c.equals(obtCelda(posXbomberman / 32, posYbomberman / 32)))
					System.exit(1);
			}
		}

		PowerUp powerUp;
		if (misCeldas[posXbomberman / 32][posYbomberman / 32].getPowerUp() != null) {
			powerUp = misCeldas[posXbomberman / 32][posYbomberman / 32]
					.getPowerUp();
			miJuego.setPuntaje(miJuego.obtPuntaje() + powerUp.getPuntaje());
			powerUp.afectarBomberman(miJuego.obtBomberman());
			misCeldas[posXbomberman / 32][posYbomberman / 32].setPowerUp(null);
		}

		LinkedList<Enemigo> destruidos = new LinkedList<Enemigo>();
		for (Fuego f : fuegos) {
			Celda celd = obtCelda(f.obtX() / 32, f.obtY() / 32);
			if (!miJuego.obtBomberman().estaActivoMasacrality())
				if (celd.equals(celdBomberman))
					System.exit(1);
			for (Enemigo e : enemigos) {
				if (celd.equals(obtCelda(e.obtX() / 32, e.obtY() / 32))) {
					miJuego.setPuntaje(miJuego.getPuntaje() + e.getPuntaje());
					destruidos.add(e);
				}
			}
		}
		miJuego.limpiarEnemigos(destruidos);
	}

	/**
	 * Genera el nivel de forma aleatoria, respetando ciertas reglas.
	 */
	public void generarNivel() {
		int totalPowerUps = cantidadSpeedUp + cantidadBombality
				+ cantidadFatality + cantidadMasacrality;
		misCeldas = new Celda[31][13];
		double ocupadas = cantCeldas * porcOcupadas;
		Random r = new Random();
		int random;

		for (int i = 0; i < misCeldas.length; i++) {
			for (int j = 0; j < misCeldas[0].length; j++) {
				misCeldas[i][j] = new Celda(i, j);
				random = r.nextInt(2);
				misCeldas[i][j].setValue(random);
				if (i == 0)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j,
							misCeldas[i][j]));
				else if (i == misCeldas.length - 1)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j,
							misCeldas[i][j]));
				else if (j == 0)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j,
							misCeldas[i][j]));
				else if (j == misCeldas[0].length - 1)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j,
							misCeldas[i][j]));
				else if (i % 2 == 0 && j % 2 == 0)
					misCeldas[i][j].setPared(new ParedIndestructible(i, j,
							misCeldas[i][j]));
			}
		}
		while (ocupadas > 0) {
			for (int i = 1; i < misCeldas.length - 1; i++)
				for (int j = 1; j < misCeldas[0].length - 1; j++) {
					if (ocupadas > 0) {
						random = r.nextInt(2);
						if ((i != 1 || j != 1) && (i != 2 || j != 1)
								&& (i != 1 || j != 2))
							if (i % 2 != 0 || j % 2 != 0)
								if (random == 0) {
									misCeldas[i][j]
											.setPared(new ParedDestruible(i, j,
													misCeldas[i][j]));
									ocupadas--;
								}
					}
				}

		}
		while (totalPowerUps > 0) {
			for (int i = 1; i < misCeldas.length - 1; i++)
				for (int j = 1; j < misCeldas[0].length - 1; j++) {
					if (totalPowerUps > 0)
						if (misCeldas[i][j].getPared() != null) {
							if (misCeldas[i][j].getPared().getPowerUp() == null) {
								if (cantidadSpeedUp > 0) {
									random = r.nextInt(20);
									if (random == 0) {
										misCeldas[i][j].getPared().setPowerUp(
												new SpeedUp(i * 32, j * 32));
										totalPowerUps--;
										cantidadSpeedUp--;
									}
								}
							}

							if (misCeldas[i][j].getPared().getPowerUp() == null) {
								if (cantidadBombality > 0) {
									random = r.nextInt(20);
									if (random == 0) {
										misCeldas[i][j].getPared().setPowerUp(
												new Bombality(i * 32, j * 32));
										totalPowerUps--;
										cantidadBombality--;
									}
								}
							}

							if (misCeldas[i][j].getPared().getPowerUp() == null) {
								if (cantidadFatality > 0) {
									random = r.nextInt(20);
									if (random == 0) {
										misCeldas[i][j].getPared().setPowerUp(
												new Fatality(i * 32, j * 32));
										totalPowerUps--;
										cantidadFatality--;
									}
								}
							}

							if (misCeldas[i][j].getPared().getPowerUp() == null) {
								if (cantidadMasacrality > 0) {
									random = r.nextInt(20);
									if (random == 0) {
										misCeldas[i][j].getPared()
												.setPowerUp(
														new Masacrality(i * 32,
																j * 32));
										totalPowerUps--;
										cantidadMasacrality--;
									}
								}
							}
						}
				}
		}
	}

	public void generarNivelGrafico(Graphics g) {

		for (int i = 0; i < misCeldas.length; i++) {
			for (int j = 0; j < misCeldas[0].length; j++) {
				misCeldas[i][j].dibujar(g);
				if (misCeldas[i][j].getPared() != null)
					misCeldas[i][j].getPared().dibujar(g);
			}
		}
	}

	public int obtLongitudX() {
		return misCeldas.length;
	}

	public int obtLongitudY() {
		return misCeldas[0].length;
	}

	public void controlarWinCond() {
		boolean win = true;
		for (int i = 1; i < misCeldas.length - 1; i++) {
			for (int j = 1; j < misCeldas[0].length - 1; j++) {
				if (i % 2 != 0 && j % 2 != 0) {
					if (misCeldas[i][j].getPared() != null) {
						win = false;
					}
				}
			}
		}
		if (win) {
			System.exit(1);
		}
	}

}
