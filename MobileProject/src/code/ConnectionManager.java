package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Prepare the connection to the DB */

public class ConnectionManager {
	
	public static Connection con;
	public static String url;
	
	public static Connection getConnection(){
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		
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