package gui;

import juego.Juego;

public class ContadorTiempo extends Thread {

	private Juego juego;
	private GUI miGUI;

	public ContadorTiempo(Juego j, GUI gui) {
		this.juego = j;
		this.miGUI = gui;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
			if(miGUI.getLock()){
				juego.mover(miGUI.getDirection());
				miGUI.toggleLock();
			}
		}
	}
}