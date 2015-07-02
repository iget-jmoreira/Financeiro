package Views;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectSystem extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JLabel label;
	JButton choice;
	
	public SelectSystem(){
		// BASE CODE //
		new DefaultSettings(SelectSystem.this, panel);
		// BASE CODE //
		
		label = new JLabel("Bem vindo!");
		label.setBounds(280, 180, 100, 30);
		panel.add(label);
		
		label = new JLabel("Qual o seu sistema?");
		label.setBounds(280, 200, 400, 30);
		panel.add(label);
		
		
		Action personal = new SystemAction(true);
		Action coorporative = new SystemAction(false);
		
		choice = new JButton("Sistema Pessoal");
		choice.setBounds(300, 240, 300, 120);
		choice.addActionListener(personal);
		panel.add(choice);
		
		choice = new JButton("Sistema Empresarial");
		choice.setBounds(700, 240, 300, 120);
		choice.addActionListener(coorporative);
		panel.add(choice);
		
		// BASE CODE //
		Container c = getContentPane();
		c.add(panel);
		// BASE CODE //
	}
	
	class SystemAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public boolean choice;
		public SystemAction(boolean choice){
			this.choice = choice;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(choice == true){
				System.out.println("Go to Personal");
			} else{
				System.out.println("Go to Coorporative");
			}
		}
		
	}
}
