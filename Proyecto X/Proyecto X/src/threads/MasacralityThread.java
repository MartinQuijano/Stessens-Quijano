package threads;

import juego.Juego;
import entidades.Bomberman;
import entidades.Fuego;

public class MasacralityThread extends Thread {

	private Bomberman bombermanLogica;

	private volatile boolean masacralityDetener;

	public MasacralityThread(Bomberman logica) {
		bombermanLogica = logica;
		masacralityDetener = false;
	}

	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!this.masacralityDetener) {
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(5000);
				// Realizo el movimiento
				detener();
				destruir();
			} catch (InterruptedException e) {
			}
		}
	}

	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt();

		// Seteamos el flag para detener su ejecución.
		this.masacralityDetener = true;
	}

	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();

		// Notificamos a la logica que este hilo se destruyo.
		this.bombermanLogica.setMasacrality();
	}
}
