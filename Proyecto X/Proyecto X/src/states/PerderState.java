package states;

import grafica.Assets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import juego.Juego;

public class PerderState extends State {

	private String puntaje;
	private String tiempo;
	private boolean seteado = false;

	public PerderState(Juego juego) {
		super(juego);
	}

	public void update() {
		
	}
	
	public void setValoresFin(){
		puntaje = "Puntaje = " + Integer.toString(juego.getPuntaje());
		tiempo = "Tiempo = " + Integer.toString(juego.obtTiempoH()) + ":"
				+ Integer.toString(juego.obtTiempoM()) + ":"
				+ Integer.toString(juego.obtTiempoS());
		seteado = true;
	}

	public void render(Graphics g) {
		if (!seteado )
			setValoresFin();
		g.drawImage(Assets.mainMenu, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
		g.drawString("Perdiste! ", 650, 150);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(puntaje, 650, 200);
		g.drawString(tiempo, 650, 250);
	}
}