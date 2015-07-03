package Views;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		//instacia elementos para serem visualizados		
		SelectSystem page = new SelectSystem();
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
		
//		Deixe o codigo acima comentado e a linha de baixo descomentada
//		para criar os bancos de dados do sistema.
		
//		new CreateDatabase();
		
	}
}
