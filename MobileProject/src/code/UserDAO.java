package code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
	
	static Connection currentCon = null;
	static ResultSet rs= null;
	
	/*public static UserBean login(UserBean bean){
		Statement s = null;
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		String query = "select * from users where username=" + username + "and password=" + password;
		
		//connection to the DB
		currentCon = ConnectionManager.getConnection();
		s = currentCon.createStatement();
		rs = s.executeQuery(query);
		boolean more = rs.next();
		
		if(!more){
			System.out.println("Register!");
			bean.setValid(false);
		}else{
			bean.setValid(true); 
		}
	}*/

}
