package Controllers;
import javax.swing.JFrame;

import Views.Home.*;

public class HomeController {
	private String systemType;
	public HomeController(String function, String systemType){
		this.systemType = systemType;
		switch(function){
		case "index":
			this.index();
			break;
		case "create":
			this.create();
			break;
		}
	}
	
	public void index () {
		Index page = new Index(this.systemType);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
	}
	
	public void create () {
		
	}
}
