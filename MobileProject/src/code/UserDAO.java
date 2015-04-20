package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	
	static Connection currentCon = null;
	static ResultSet rs= null;
	
	public static UserBean login(UserBean bean) throws SQLException{
		Statement s = null;
		
		String username = bean.getUsername();
		String password = bean.getPassword();
		
		System.out.println(username + password);
		
		String query = "Select * From public.\"User\" where username='" + username + "' and password='" + password + "'";
		
		//connection to the DB
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				rs=null;
			}
			
			if(s!=null){
				try {
					s.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				s = null;
			}
			
			if(currentCon!=null){
				try {
					currentCon.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				currentCon = null;
			}
		}
		
		return bean;		
	}
}