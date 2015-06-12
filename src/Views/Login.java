package Views;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	public Login(){
		// BASE CODE //
		new DefaultSettings(Login.this, panel);
		// BASE CODE //
		
		
		
		
		
		
		// BASE CODE //
		Container c = getContentPane();
		c.add(panel);
		// BASE CODE //
	}
}
