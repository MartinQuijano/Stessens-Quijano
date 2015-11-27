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
		g.drawString(" - Nuevo Juego", 620, 140);
		g.drawRect(620, 200, 250, 60);
		g.drawString(" - Ayuda", 620, 240);
	}

}
