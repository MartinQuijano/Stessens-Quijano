package entidades;

import java.util.LinkedList;

import niveles.Celda;
import niveles.Nivel;
import grafica.GraficaSirius;

/**
 * Sirius es un ex Bomberman que se paso al lado oscuro. No puede atravesar
 * paredes pero es tres veces más rapido que los Rugulos o Altair. Solo hay un
 * Sirius en el nivel y aparece en el rincón opuesto a donde aparece Bomberman.
 * Sirius es muy inteligente y siempre quiere ir hacia donde esta Bomberman.
 */
public class Sirius extends Enemigo {

	protected Nivel miNivel;

	/**
	 * @param int x representa la posición x dentro del arreglo de celdas.
	 * @param int y representa la posición y dentro del arreglo de celdas.
	 */
	public Sirius(int x, int y, Nivel miNivel) {
		super(x, y, 8);
		grafica = new GraficaSirius(x, y);
		this.miNivel = miNivel;
	}

	/**
	 * @return puntaje otorgado al matarlo.
	 */
	public int getPuntaje() {
		return 50;
	}

	public void mover(int dir) {
		Celda miCelda = miNivel.obtCelda(posX / 32, posY / 32);

		LinkedList<Celda> lci = new LinkedList<Celda>();
		LinkedList<Celda> lc = new LinkedList<Celda>();

		lci = miNivel.caminosPosiblesBFS(miCelda, lc);
	//	miNivel.imprimirCamino(lci);
		lc = miNivel.caminoFinal(lci);
	//	miNivel.imprimirCamino(lc);
		
		miNivel.desmarcarCeldas();
		for (Celda c : lc) {
			miCelda = miNivel.obtCelda(posX / 32, posY / 32);
			if (miCelda.obtY() < c.obtY()) {
				moverse(1);
			} else if (miCelda.obtY() > c.obtY()) {
				moverse(0);
			} else if (miCelda.obtX() > c.obtX()) {
				moverse(2);
			} else if (miCelda.obtX() < c.obtX()) {
				moverse(3);
			}
			
		}

	}

	private void moverse(int dir) {
		if (this.grafica != null) {
			try {

				switch (dir) {
				case 0: // Arriba
					for (int i = 0; i < 32; i += this.velocidad) {
						posY = posY - this.velocidad;
						grafica.setCurrentAnimation(0);
						grafica.update();
						grafica.setY(grafica.getY() - this.velocidad);
						Thread.sleep(80);
					}
					break;
				case 1: // Abajo.
					for (int i = 0; i < 32; i += this.velocidad) {
						posY = posY + this.velocidad;
						grafica.setCurrentAnimation(1);
						grafica.update();
						grafica.setY(grafica.getY() + this.velocidad);
						Thread.sleep(80);
					}
					break;
				case 2: // Izquierda
					for (int i = 0; i < 32; i += this.velocidad) {
						posX = posX - this.velocidad;
						grafica.setCurrentAnimation(3);
						grafica.update();
						grafica.setX(grafica.getX() - this.velocidad);
						Thread.sleep(80);
					}
					break;
				case 3: // Derecha
					for (int i = 0; i < 32; i += this.velocidad) {
						posX = posX + this.velocidad;
						grafica.setCurrentAnimation(2);
						grafica.update();
						grafica.setX(grafica.getX() + this.velocidad);
						Thread.sleep(80);
					}
					break;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}