package states;

import grafica.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import juego.Juego;

public class AyudaState extends State {

	public AyudaState(Juego juego) {
		super(juego);
	}

	public void update() {
	}

	public void render(Graphics g) {
		g.drawImage(Assets.mainMenu, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Controles: ", 550, 100);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("- Con las flechas del teclado se controla", 600, 150);
		g.drawString("  el movimiento del bomberman. ", 600, 170);
		g.drawString("- Con la barra espaciadora se colocan ", 600, 200);
		g.drawString("  las bombas. ", 600, 220);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 35)); 
		g.drawRect(690, 300, 240, 60);
		g.drawImage(Assets.volver, 700, 305, null);
	}

}
