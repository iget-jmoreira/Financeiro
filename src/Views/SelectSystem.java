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

import Controllers.BaseController;

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
	
	class SystemAction extends AbstractAction{
		/**
		 * Aqui ficam as ações do sistema
		 * Caso receba true irá redirecionar para login com a variável x = "personal"
		 * Caso receba false irá para login com a variável x = "coorporative"
		 */
		private static final long serialVersionUID = 1L;
		public boolean choice;
		public SystemAction(boolean choice){
			this.choice = choice;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			BaseController baseC = new BaseController();
			if(choice == true){
				baseC.goTo(SelectSystem.this, new Login("personal"));
			} else{
				baseC.goTo(SelectSystem.this, new Login("coorporative"));
			}
		}
		
	}
}
