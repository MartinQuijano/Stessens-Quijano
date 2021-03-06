package gui;

import juego.Juego;

public class ContadorTiempo extends Thread {

	private Juego juego;
	private GUI gui;

	ContadorTiempo(Juego j, GUI gui) {
		this.juego = j;
		this.gui = gui;
	}

	/**
	 * Ejecuta el hilo principal.
	 */
	public void run() {
		while (true) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (juego.getState() == 1) {
				juego.controlarWin();
				juego.controlarExplosiones();
				juego.obtNivel().revisarPosiciones(juego.obtFuegos());
				juego.terminar();
				if (gui.getLock()) {
					juego.accionBomberman(gui.getTecla());
					gui.toggleLock();

				}
			}
		}
	}
}