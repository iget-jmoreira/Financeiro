package Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controllers.BaseController;
import Models.User;

public class RecoveryChangePass extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JLabel description, question, answer, password;
	JTextField answer_tf;
	JPasswordField password1_pf, password2_pf;
	JButton check, cancel;
	BaseController baseC = new BaseController();
	private String email, systemType;
	
	public RecoveryChangePass(String email, String quest, String systemType){
		// BASE CODE //
		new DefaultSettings(RecoveryChangePass.this, panel);
		// BASE CODE //
		
		this.email = email;
		this.systemType = systemType;
		
		Action checkAct = new CheckAction();
		Action cancelAct = new CancelAction();
		
		description = new JLabel("Put your secret answer and reset your password", SwingConstants.CENTER);
		description.setBounds(0, 80, getWidth(), 30);
		panel.add(description);
		
		question = new JLabel("Question");
		question.setBounds(240, 170, 150, 30);
		panel.add(question);
		question = new JLabel("<html><font style='font-size:12px;' color='#990000'><b>"+quest+"</b></font></html>");
		question.setBounds(245, 195, getWidth()-245, 30);
		panel.add(question);
		
		answer = new JLabel("Answer");
		answer.setBounds(240, 240, 150, 30);
		panel.add(answer);
		answer_tf = new JTextField();
		answer_tf.setBounds(245, 265, getWidth()/2, 30);
		panel.add(answer_tf);
		
		password = new JLabel("Password");
		password.setBounds(240, 320, 180, 30);
		panel.add(password);
		password1_pf = new JPasswordField();
		password1_pf.setBounds(245, 350, 350, 30);
		panel.add(password1_pf);
		
		password = new JLabel("Password *");
		password.setBounds(620, 320, 180, 30);
		panel.add(password);
		password2_pf = new JPasswordField();
		password2_pf.setBounds(625, 350, 350, 30);
		panel.add(password2_pf);
		
		check = new JButton("Check");
		check.setBounds(245, 405, 150, 40);
		check.addActionListener(checkAct);
		panel.add(check);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(400, 405, 150, 40);
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
	
	public class CheckAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String pass1 = String.valueOf(RecoveryChangePass.this.password1_pf.getPassword());
			String pass2 = String.valueOf(RecoveryChangePass.this.password2_pf.getPassword());
			User user = new User();
			ResultSet rs;
			rs = user.selectUser("email", RecoveryChangePass.this.email);
			boolean result = false;
			try {
				if(rs.next() && rs.getString("email").equals(RecoveryChangePass.this.email)){
					if(rs.getString("answer").equals(RecoveryChangePass.this.answer_tf.getText())){
						//answer correta
						if(pass1.equals(pass2)){
							// passwords corretos
							result = true;
						}else{
							// passwords diferentes
							baseC.popUp("Error!", "Passwords are differents!");
						}
					} else{
						// answer errada
						baseC.popUp("Error!", "The answer is not correct!");
					}
				}
				rs.close();
				if(result){
					user.updateUser("email", RecoveryChangePass.this.email, "password='"+pass1+"'");
					RecoveryChangePass.this.baseC.goTo(RecoveryChangePass.this, new Login(RecoveryChangePass.this.systemType));
				}
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
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			baseC.goTo(RecoveryChangePass.this, new Login(RecoveryChangePass.this.systemType));
		}
		
	}
}
