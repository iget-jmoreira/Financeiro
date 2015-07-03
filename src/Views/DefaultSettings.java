package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DefaultSettings{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public double width = screenSize.getWidth() - 100;
	public double height = screenSize.getHeight() - 180;
	public DefaultSettings(JFrame frame, JPanel panel){
		double x = (screenSize.getWidth() / 2) - ((screenSize.getWidth() - 100) / 2);
		frame.setBounds((int)x, 80,(int) width,(int) height);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		JLabel top = new JLabel("<html><p style='font-size:24px;'>Financial System</p></html>");
		top.setBounds(80, 20, 344, 45);
		panel.add(top);
	}
}
