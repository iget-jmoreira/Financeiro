package Controllers;

import javax.swing.JFrame;

public class BaseController {
	public void goTo(JFrame actual, JFrame destination){
		actual.setVisible(false);
		actual.dispose();
		destination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		destination.setVisible(true);
	}
}
