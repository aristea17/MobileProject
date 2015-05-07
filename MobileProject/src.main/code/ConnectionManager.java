package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Prepare the connection to the DB */

public class ConnectionManager {
	
	private static Connection con = null;
	private static String url = "jdbc:postgresql://localhost:5432/Mobile";
	private static String driver = "org.postgresql.Driver";
	private static String user = "postgres";
	private static String password = "aristea17";
	
	public static Connection startConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	/**
	 * 
	 * @throws SQLException when there is a problem with closing the connection
	 */
	public static void closeConnection() throws SQLException{
		if(con != null){
			con.close();
		}
	}
}