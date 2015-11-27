package threads;

import juego.Juego;
import entidades.Enemigo;

public class EnemigoThread extends Thread {

	private Enemigo enemigoLogica;
	private Juego juego;

	private volatile boolean enemigoDetener;

	public EnemigoThread(Enemigo logica, Juego j) {
		enemigoLogica = logica;
		juego = j;
		enemigoDetener = false;
	}

	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!this.enemigoDetener) {
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(100);
				// Realizo el movimiento
				juego.mover(enemigoLogica);
			} catch (InterruptedException e) {
			}
		}
	}

	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt();

		// Seteamos el flag para detener su ejecución.
		this.enemigoDetener = true;
	}

	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();

		// Notificamos a la logica que este hilo se destruyo.
		this.enemigoLogica.destruir();
	}
}
