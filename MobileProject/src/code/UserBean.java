package code;

//this is the JavaBean for the User, with its properties and the getters and setters
public class UserBean {
	
	private String username;
	private String password;
	private boolean valid;
	
	public void setUsername(String newUsername){
		username = newUsername;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setPassword(String newPassword){
		password = newPassword;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setValid(boolean newValid){
		valid = newValid;
	}
	
	public boolean getValid(){
		return valid;
	}

}
