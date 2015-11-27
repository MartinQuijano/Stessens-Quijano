package gui;

import juego.Juego;

public class Launcher {

	public static void main(String[] args){
		Juego juego = new Juego(992, 416);
		juego.start();
	}
}
