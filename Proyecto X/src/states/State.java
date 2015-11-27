package states;

import java.awt.Graphics;

import juego.Juego;

public abstract class State {

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	protected Juego juego;

	public State(Juego juego) {
		this.juego = juego;
	}

	public abstract void update();

	public abstract void render(Graphics g);
}
