package Views;

import javax.swing.JFrame;

//oi

public class Index{
	public static void main(String[] args){
		//instacia elementos para serem visualizados
		Login page = new Login();
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
	}
}

