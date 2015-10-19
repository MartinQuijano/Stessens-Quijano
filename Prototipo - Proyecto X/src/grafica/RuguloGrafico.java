package grafica;

import javax.swing.ImageIcon;

public class RuguloGrafico extends EntidadGrafica{
	
	public RuguloGrafico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/BattleCity/up2.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/BattleCity/down2.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/BattleCity/left2.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/BattleCity/right2.png"));
	}
}