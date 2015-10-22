package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Juego miJuego;

	private ContadorTiempo tiempo;
	private boolean lock = false;
	private int tecla = -1;

	/**
	 * Comienza la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 */
	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 1008, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		miJuego = new Juego(this);

		tiempo = new ContadorTiempo(miJuego, this);
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

}
