package threads;

import entidades.Bomba;

public class BombaThread extends Thread {

	private Bomba bombaLogica;

	private volatile boolean bombaDetener;

	public BombaThread(Bomba bLogica) {
		bombaLogica = bLogica;
		bombaDetener = false;
	}

	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while (!this.bombaDetener) {
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(3500);
				// Realizo el movimiento
				bombaLogica.destruir();
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
		this.bombaDetener = true;
	}

	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();

		// Notificamos a la logica que este hilo se destruyo.
		this.bombaLogica.destruir();
	}
}
