package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	static Connection con;
	static String url;
	
	public static Connection getConnection(){
		
		String url = "jdbc:postgresql://localhost:5432/Mobile";
		String user = "postgres";
		String password = "aristea17";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	

}
