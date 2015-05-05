package code;
import hibernate.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	
	public static Connection con = null;
	public static ResultSet rs= null;
	
	public static Users login(Users user) throws SQLException, ClassNotFoundException{
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		System.out.println(username + password);
		
		return user;		
	}
}