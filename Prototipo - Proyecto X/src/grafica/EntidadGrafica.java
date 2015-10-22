package grafica;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {

	protected JLabel mGrafico;
	protected Icon mImages[];

	protected final int mWidth = 32;
	protected final int mHeight = 32;

	protected int mVelocidad;

	protected int posX;
	protected int posY;

	protected EntidadGrafica(int x, int y) {
		posX = x;
		posY = y;

		mVelocidad = 0;
		this.mImages = new Icon[4];
	}

	protected EntidadGrafica(int velocidad, int x, int y) {
		posX = x;
		posY = y;
		this.mVelocidad = velocidad;
		this.mImages = new Icon[4];
	}

	public int getVelocidad() {
		return this.mVelocidad;
	}

	public int getPosicionX() {
		return posX;
	}

	public int getPosicionY() {
		return posY;
	}

	public void setPosX(int x) {
		posX = x;
	}

	public void setPosY(int y) {
		posY = y;
	}

	/**
	 * Mueve la entidad en la direccion pasa por parametro.
	 * 
	 * @param dir
	 *            direccion a la cual mover la entidad.
	 */
	public void mover(int dir) {
		if (this.mGrafico != null) {
			this.mGrafico.setIcon(this.mImages[0]);
			this.mGrafico.setBounds(posX, posY, this.mWidth, this.mHeight);
		}
	}

	/**
	 * Retorna el JLabel asociado a la entidad.
	 * 
	 * @return JLabel (imagen) asociado a la entidad.
	 */
	public JLabel getGrafico() {
		if (this.mGrafico == null) {
			this.mGrafico = new JLabel(this.mImages[0]);
			this.mGrafico.setBounds(posX, posY, this.mWidth, this.mHeight);
		}
		return this.mGrafico;
	}

}