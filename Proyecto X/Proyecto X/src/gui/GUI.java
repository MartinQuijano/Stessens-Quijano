package gui;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import juego.Juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {

	private JFrame frame;
	private Canvas canvas;

	private int width;
	private int height;

	private ContadorTiempo tiempo;
	private boolean lock = false;
	private int tecla = -1;

	/**
	 * Crea el frame.
	 */
	public GUI(Juego juego) {
		width = 992;
		height = 446;
		
		frame = new JFrame("Bomberman");
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});

		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();

		tiempo = new ContadorTiempo(juego, this);
		tiempo.start();
	}

	protected void mover(KeyEvent key) {
		if (!lock) {
			tecla = key.getKeyCode();
			this.lock = true;
		}
	}

	public boolean getLock() {
		return this.lock;
	}

	public void toggleLock() {
		this.lock = !this.lock;
	}

	public int getTecla() {
		return tecla;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

}
