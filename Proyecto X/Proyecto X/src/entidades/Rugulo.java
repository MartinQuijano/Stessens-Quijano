package entidades;

import grafica.GraficaRugulo;

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
		
		grafica = new GraficaRugulo(x, y);
	}

	/**
	 * @return puntaje otorgado al matarlo.
	 */
	public int getPuntaje() {
		return 15;
	}

	public void mover(int dir) {
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