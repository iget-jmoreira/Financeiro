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

public class SignUp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JLabel description, username, email, day, month, year, password, question, answer;
	JTextField username_tf, email_tf, day_tf, month_tf, year_tf, question_tf, answer_tf;
	JPasswordField password1_pf, password2_pf;
	JButton save, login, cancel;
	BaseController baseC = new BaseController();
	public SignUp(String systemType){
		// BASE CODE //
		new DefaultSettings(SignUp.this, panel);
		// BASE CODE //
		
		Action saveAct = new SaveAction();
		Action cancelAct = new CancelAction();
		Action loginAct = new LoginAction(systemType);
		
		description = new JLabel("Creating a new user", SwingConstants.CENTER);
		description.setBounds(0, 80, getWidth(), 30);
		panel.add(description);
		
		username = new JLabel("Username");
		username.setBounds(240, 130, 180, 30);
		panel.add(username);
		username_tf = new JTextField();
		username_tf.setBounds(245, 155, getWidth()/2, 30);
		panel.add(username_tf);
		
		password = new JLabel("Password");
		password.setBounds(240, 190, 180, 30);
		panel.add(password);
		password1_pf = new JPasswordField();
		password1_pf.setBounds(245, 215, 350, 30);
		panel.add(password1_pf);
		
		password = new JLabel("Password *");
		password.setBounds(620, 190, 180, 30);
		panel.add(password);
		password2_pf = new JPasswordField();
		password2_pf.setBounds(625, 215, 350, 30);
		panel.add(password2_pf);

		email = new JLabel("E-mail");
		email.setBounds(240, 250, 180, 30);
		panel.add(email);
		email_tf = new JTextField();
		email_tf.setBounds(245, 275, getWidth()/2, 30);
		panel.add(email_tf);
		
		description = new JLabel("Date of Birth");
		description.setBounds(240, 310, 280, 30);
		panel.add(description);
		day = new JLabel("Day");
		day.setBounds(245, 325, 100, 30);
		panel.add(day);
		day_tf = new JTextField();
		day_tf.setBounds(245, 350, 40, 30);
		panel.add(day_tf);
		month = new JLabel("Month");
		month.setBounds(300, 325, 100, 30);
		panel.add(month);
		month_tf = new JTextField();
		month_tf.setBounds(300, 350, 40, 30);
		panel.add(month_tf);
		year = new JLabel("Year");
		year.setBounds(355, 325, 100, 30);
		panel.add(year);
		year_tf = new JTextField();
		year_tf.setBounds(355, 350, 60, 30);
		panel.add(year_tf);
		
		question = new JLabel("Secret Question");
		question.setBounds(425, 310, 150, 30);
		panel.add(question);
		question_tf = new JTextField();
		question_tf.setBounds(425, 335, 250, 30);
		panel.add(question_tf);
		
		answer = new JLabel("Secret Answer");
		answer.setBounds(680, 310, 150, 30);
		panel.add(answer);
		answer_tf = new JTextField();
		answer_tf.setBounds(680, 335, 250, 30);
		panel.add(answer_tf);
		
		save = new JButton("Save");
		save.setBounds(245, 400, 130, 40);
		save.addActionListener(saveAct);
		panel.add(save);
		
		cancel = new JButton("Clear");
		cancel.setBounds(385, 400, 130, 40);
		cancel.addActionListener(cancelAct);
		panel.add(cancel);
		
		description = new JLabel("or");
		description.setBounds(530, 400, 30, 30);
		panel.add(description);
		
		login = new JButton("Login");
		login.setBounds(560, 400, 130, 40);
		login.addActionListener(loginAct);
		panel.add(login);
		
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

	public class SaveAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			User user = new User();
			String email = SignUp.this.email_tf.getText();
			String username = SignUp.this.username_tf.getText();
			String password = String.valueOf(SignUp.this.password1_pf.getPassword());
			String passwordVerify = String.valueOf(SignUp.this.password2_pf.getPassword());
			String accountType = "personal";
			String day = SignUp.this.day_tf.getText();
			String month = SignUp.this.month_tf.getText();
			String year = SignUp.this.year_tf.getText();
			String dob = day+"/"+month+"/"+year;
			if(password.equals(passwordVerify)){
				user.createUser(email, username, password, accountType, null, dob);
				boolean result = user.searchUser(username, password, accountType);
				if(result){
					baseC.goTo(SignUp.this, new Home(accountType));
				} else{
					baseC.popUp("Login Fail", "Username or Password are not!");
					baseC.goTo(SignUp.this, new Login(accountType));
				}
			} else{
				baseC.popUp("Sign-up Fail", "Incorrect Passwords!");
				SignUp.this.username_tf.setText("");
				SignUp.this.password1_pf.setText("");
				SignUp.this.password2_pf.setText("");
				SignUp.this.email_tf.setText("");
				SignUp.this.day_tf.setText("");
				SignUp.this.month_tf.setText("");
				SignUp.this.year_tf.setText("");
			}
		}
		
	}
	
	public class CancelAction extends AbstractAction{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SignUp.this.username_tf.setText("");
			SignUp.this.password1_pf.setText("");
			SignUp.this.password2_pf.setText("");
			SignUp.this.email_tf.setText("");
			SignUp.this.day_tf.setText("");
			SignUp.this.month_tf.setText("");
			SignUp.this.year_tf.setText("");
		}
	}
	
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
			SignUp.this.baseC.goTo(SignUp.this, new Login(this.systemType));
		}
		
	}
}
