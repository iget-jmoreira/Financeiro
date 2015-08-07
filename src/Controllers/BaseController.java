package Controllers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BaseController {
	public void goTo(JFrame actual, JFrame destination){
		actual.setVisible(false);
		actual.dispose();
		destination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		destination.setVisible(true);
	}
	
	public void close(JFrame actual){
		actual.setVisible(false);
		actual.dispose();
	}
	
	public void popUp(String title, String message){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
}
