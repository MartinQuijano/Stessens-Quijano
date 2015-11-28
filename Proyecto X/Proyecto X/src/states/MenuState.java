package states;

import grafica.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import juego.Juego;

public class MenuState extends State{

	public MenuState(Juego juego){
		super(juego);
	}
	
	public void update() {
	}

	public void render(Graphics g) {
		g.drawImage(Assets.mainMenu, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
		g.drawRect(620, 100, 250, 60);
		g.drawImage(Assets.jugar, 640, 105, null);
		g.drawRect(620, 200, 250, 60);
		g.drawImage(Assets.ayuda, 640, 205, null);
	}

}
