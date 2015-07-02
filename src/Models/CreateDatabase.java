package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	public CreateDatabase(){
		Connection conn;
		Statement stmt;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS finance");
			stmt.close();
			conn.close();
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/finance", "root", "");
			// Cria Tabela Accounts
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS accounts ("
					+ "id INT NOT NULL AUTO_INCREMENT, "
					+ "type VARCHAR(255) NOT NULL,"
					+ "PRIMARY KEY (id)"
					+ ") ENGINE = InnoDB");
			stmt.close();
			
			// Cria Tabela Companies
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS companies ("
					+ "id INT NOT NULL AUTO_INCREMENT,"
					+ "name VARCHAR(255) NOT NULL,"
					+ "contact_phone VARCHAR(255),"
					+ "contact_email VARCHAR(255) NOT NULL,"
					+ "PRIMARY KEY (id)"
					+ ") ENGINE = InnoDB");
			stmt.close();
			
			// Cria Tabela Users
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users ("
					+ "id INT NOT NULL AUTO_INCREMENT,"
					+ "company_id INT,"
					+ "name VARCHAR(255) NOT NULL,"
					+ "contact_phone VARCHAR(255),"
					+ "contact_email VARCHAR(255) NOT NULL,"
					+ "FOREIGN KEY (company_id) REFERENCES companies(id),"
					+ "PRIMARY KEY (id)"
					+ ") ENGINE = InnoDB");
			stmt.close();
			
			// Cria Tabela Products
			
			// Cria Tabela Payments
			
			// Cria Tabela Receipts
			
			// Cria Tabela CashFlow
			
			
			System.out.println("ok!");
			
			
			
		} catch(ClassNotFoundException e){
			System.out.println("Erro no Driver "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("Erro do BD "+e.getMessage());
			e.printStackTrace();
		}
	}
}
