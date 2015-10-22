package entidades;

import grafica.RuguloGrafico;

/**
 * Los rugulos son personajes muy tontos y lentos. Se desplazan por los lugares
 * donde no hay paredes y deciden hacia dodne ir en forma aleatoria. En el nivel
 * tienen que aparecer 3 de ellos.
 */
public class Rugulo extends Enemigo {

	/**
	 * @param int x representa la posición x dentro del arreglo de celdas.
	 * @param int y representa la posición y dentro del arreglo de celdas.
	 */
	public Rugulo(int x, int y) {
		super(x, y, 4);
		grafico = new RuguloGrafico(2, x, y);
	}

	/**
	 * @return puntaje otorgado al matarlo.
	 */
	public int getPuntaje() {
		return 15;
	}

	/**
	 * @return true si puede atravesar paredes, false caso contrario.
	 */
	public boolean atraviesaParedes() {
		return esEtereo;
	}

	public void destruir() {
	}

	public void mover(int dir) {
		if (this.grafico != null) {
			// this.changeIcon(dir);

			try {
				switch (dir) {
				case 0:
					for (int i = 0; i < 32; i += this.velocidad) {
						grafico.getGrafico().setBounds(posX,
								posY -= this.velocidad, 32, 32);
						Thread.sleep(80);
					}
					break;
				case 1:
					for (int i = 0; i < 32; i += this.velocidad) {
						grafico.getGrafico().setBounds(posX,
								posY += this.velocidad, 32, 32);
						Thread.sleep(80);
					}
					break;
				case 3:
					for (int i = 0; i < 32; i += this.velocidad) {
						grafico.getGrafico().setBounds(posX += this.velocidad,
								posY, 32, 32);
						Thread.sleep(80);
					}
					break;
				case 2:
					for (int i = 0; i < 32; i += this.velocidad) {
						grafico.getGrafico().setBounds(posX -= this.velocidad,
								posY, 32, 32);
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