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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double x = (screenSize.getWidth() / 2) - ((screenSize.getWidth() - 100) / 2);
		double width = screenSize.getWidth() - 100;
		double height = screenSize.getHeight() - 180;
		frame.setBounds((int)x, 80,(int) width,(int) height);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		JLabel top = new JLabel("<html><p style='font-size:28px;'>Financial System</p></html>");
		top.setBounds((int)((screenSize.getWidth() / 2) - 202), 20, 344, 45);
		panel.add(top);
		
	}
	

}
