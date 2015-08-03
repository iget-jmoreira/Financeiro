package Views;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		//estancia elementos para serem visualizados		
		SelectSystem page = new SelectSystem();
//		Login page = new Login("personal");
//		SignUp page = new SignUp("personal");
//		RecoveryCheckEmail page = new RecoveryCheckEmail("personal");
//		RecoveryChangePass page = new RecoveryChangePass("email@email.com", "Who was my fisrt teacher?", "personal");
		
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
		
//		Deixe o codigo acima comentado e a linha de baixo descomentada
//		para criar os bancos de dados do sistema.
		
//		new Models.CreateDatabase();
		
	}
}
