package threads;

import entidades.Fuego;

public class FuegoThread extends Thread{

	private Fuego fuegoLogica;

	private volatile boolean fuegoDetener;

	public FuegoThread(Fuego logica) {
		fuegoLogica = logica;
		fuegoDetener = false;
	}

	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!this.fuegoDetener) {
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(1500);
				// Realizo el movimiento
				fuegoLogica.destruir();
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
		this.fuegoDetener = true;
	}

	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();
	}
}


