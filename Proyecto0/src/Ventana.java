import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Ventana extends javax.swing.JFrame {
	private JLabel imagen;
	private JTextField tFrase;
	private JButton bFrase;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ventana inst = new Ventana();
				inst.setTitle("Monty");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Ventana() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				imagen = new JLabel();
				getContentPane().add(imagen, "Center");
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/burnzDolar.jpg")));
				imagen.setBounds(116, 36, 297, 216);
			}
			{
				bFrase = new JButton();
				
				 
				getContentPane().add(bFrase);
				bFrase.setText("¡Un dólar por la felicidad eterna!");
				bFrase.setBounds(104, 258, 297, 23);
				bFrase.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bFrase.actionPerformed, event="+evt);
						tFrase.setText("¿Un dólar a cambio de la felicidad eterna? mmm... prefiero el dólar.");
					}
				});
			}
			{
				tFrase = new JTextField();
				getContentPane().add(tFrase);
				tFrase.setBounds(63, 303, 380, 23);
				tFrase.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			pack();
			this.setSize(525, 418);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
