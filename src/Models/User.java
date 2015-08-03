package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class User {
	private String server = "jdbc:mysql://localhost/finance", user = "root", password = "";
	
	public void createUser(String email, String username, String password, String accountType, Object companyId, String dob){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn;
		Statement stmt;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			if(accountType.equals("personal")){
				stmt.executeUpdate("INSERT INTO users (username, password, dob, contact_email) VALUES ('"+username+"', '"+password+"', '"+formatter.format(dob)+"', '"+email+"')");	
			} else {
				stmt.executeUpdate("INSERT INTO users (company_id, username, password, dob, contact_email) VALUES ('"+companyId+"', '"+username+"', '"+password+"', '"+formatter.format(dob)+"', '"+email+"')");
			}
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void updateUser(Object column, Object value, String query){
		
	}
	
	public void deleteUser(int user_id, String password){
		
	}
	
	/**
	 * @param column
	 * @param value
	 * @return ResultSet
	 */
	public ResultSet selectUser(Object column, Object value){
		ResultSet rs = null;
		Connection conn;
		Statement stmt;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users WHERE "+column+"='"+value+"'");
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * @param username
	 * @param password
	 * @param systemType
	 * @return boolean
	 */
	public boolean searchUser(String username, String password, Object companyId){
		ResultSet rs = null;
		Connection conn;
		Statement stmt;
		boolean result = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			if(companyId == null){
				rs = stmt.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'");				
			} else{
				rs = stmt.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"' AND company_id='"+companyId+"'");	 
			}
			if(rs.next()){
				result = true;
			}
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do DB: (Search) "+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * @return ResultSet
	 */
	public ResultSet listUsers(){
		ResultSet rs = null;
		Connection conn;
		Statement stmt;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(this.server, this.user, this.password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users");
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}
}
