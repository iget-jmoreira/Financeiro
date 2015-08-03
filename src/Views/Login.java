package Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

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

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BaseController baseC = new BaseController();
	JPanel panel = new JPanel();
	JLabel description, username, password;
	JTextField username_tf;
	JPasswordField password_pf;
	JButton signin, signup, recovery;
	public Login(String systemType){
		// BASE CODE //
		new DefaultSettings(Login.this, panel);
		// BASE CODE //
		
		Action signIn = new LoginAction(systemType);
		Action signUp = new SignupAction(systemType);
		Action recoveryPass = new RecoveryAction(systemType);
		
		description = new JLabel("Put your username and password to login.", SwingConstants.CENTER);
		description.setBounds(0, 80, getWidth(), 30);
		panel.add(description);
		
		username = new JLabel("Username");
		username.setBounds(240, 170, 180, 30);
		panel.add(username);
		username_tf = new JTextField();
		username_tf.setBounds(245, 200, getWidth()/2, 30);
		panel.add(username_tf);
		
		password = new JLabel("Password");
		password.setBounds(240, 250, 180, 30);
		panel.add(password);
		password_pf = new JPasswordField();
		password_pf.setBounds(245, 280, 350, 30);
		panel.add(password_pf);
		
		signin = new JButton("Login");
		signin.setBounds(240, 350, 150, 40);
		signin.addActionListener(signIn);
		panel.add(signin);
		
		signup = new JButton("Sign-up");
		signup.setBounds(410, 350, 150, 40);
		signup.addActionListener(signUp);
		panel.add(signup);
		
		description = new JLabel("Click in 'sign-up' to create an new account!");
		description.setBounds(580, 350, 400, 30);
		panel.add(description);
		
		description = new JLabel("Forgot you password?");
		description.setBounds(240, 410, 300, 30);
		panel.add(description);
		
		recovery = new JButton("Recovery Pass");
		recovery.setBounds(420, 410, 150, 30);
		recovery.addActionListener(recoveryPass);
		panel.add(recovery);
		
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
	
	public class LoginAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String systemType;
		public LoginAction(String systemType){
			this.systemType = systemType;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			User user = new User();
			boolean result = user.searchUser(Login.this.username_tf.getText(), String.valueOf(Login.this.password_pf.getPassword()), this.systemType);
			if(result){
				baseC.goTo(Login.this, new Home(this.systemType));
			} else{
				baseC.popUp("Login Fail", "Username or Password not exists!");
				Login.this.username_tf.setText("");
				Login.this.password_pf.setText("");
			}
		}
	}
	
	public class SignupAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String systemType;
		public SignupAction(String systemType){
			this.systemType = systemType;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Login.this.baseC.goTo(Login.this, new SignUp(this.systemType));
		}
	}
	
	public class RecoveryAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String systemType;
		public RecoveryAction(String systemType){
			this.systemType = systemType;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Login.this.baseC.goTo(Login.this, new RecoveryCheckEmail(this.systemType));
		}
		
	}
	
}
