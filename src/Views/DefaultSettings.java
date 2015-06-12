package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DefaultSettings {
	public DefaultSettings(JFrame frame, JPanel panel){
		frame.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double x = (screenSize.getWidth() / 2) - ((screenSize.getWidth() - 100) / 2);
		double width = screenSize.getWidth() - 100;
		double height = screenSize.getHeight() - 180;
		frame.setBounds((int)x, 80,(int) width,(int) height);
		panel.setBackground(Color.WHITE);
		JLabel top = new JLabel("Financial System");
		top.setBounds(0, 0, 150, 140);
		panel.add(top);
		
	}
	

}
