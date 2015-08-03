package Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controllers.BaseController;
import Models.User;

public class RecoveryCheckEmail extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel = new JPanel();
	public JLabel description, email;
	public JTextField email_tf;
	public JButton check, cancel;
	BaseController baseC = new BaseController();
	private String systemType;
	public RecoveryCheckEmail(String systemType){
		// BASE CODE //
		new DefaultSettings(RecoveryCheckEmail.this, panel);
		// BASE CODE //
		
		this.systemType = systemType;
		
		Action checkAct = new CheckAction();
		Action cancelAct = new CancelAction(systemType);
		
		description = new JLabel("Put your e-mail to get your Secret Question", SwingConstants.CENTER);
		description.setBounds(0, 80, getWidth(), 30);
		panel.add(description);

		email = new JLabel("E-mail");
		email.setBounds(240, 170, 150, 30);
		panel.add(email);
		email_tf = new JTextField();
		email_tf.setBounds(245, 195, getWidth()/2, 30);
		panel.add(email_tf);
		
		check = new JButton("Check");
		check.setBounds(245, 240, 150, 40);
		check.addActionListener(checkAct);
		panel.add(check);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(400, 240, 150, 40);
		cancel.addActionListener(cancelAct);
		panel.add(cancel);
		
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
	
	public class CheckAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			User user = new User();
			ResultSet rs = user.selectUser("email", RecoveryCheckEmail.this.email_tf.getText());
			try {
				if((rs.next()) && (rs.getString("email").equals(RecoveryCheckEmail.this.email_tf.getText()))){
					RecoveryCheckEmail.this.baseC.goTo(RecoveryCheckEmail.this, new RecoveryChangePass(rs.getString("email"), rs.getString("question"), RecoveryCheckEmail.this.systemType));
				} else{
					baseC.popUp("Login Fail", "Email not exist!");
					RecoveryCheckEmail.this.email_tf.setText("");
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public class CancelAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String systemType;
		public CancelAction(String systemType) {
			// TODO Auto-generated constructor stub
			this.systemType = systemType;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			baseC.goTo(RecoveryCheckEmail.this, new Login(this.systemType));
		}
		
	}
}
