package Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	public Login(String systemType){
		// BASE CODE //
		new DefaultSettings(Login.this, panel);
		// BASE CODE //
		
		
		
		
		// BASE CODE //
		Container c = getContentPane();
		c.add(panel);
		// BASE CODE //
	}
	// BASE CODE //
	public void paint(Graphics g){
		/**
		 * Função para desenhar uma linha embaixo do titulo
		 */
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawLine(60, 90, getWidth() - 60, 90);
	}
	// BASE CODE //
}
