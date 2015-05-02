package code;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* This is the JavaBean for the User, with its properties and the getters and setters */
public class UserBean {
	
	private String username;
	private String password;
	private boolean valid;
	
	public void setUsername(String newUsername){
		this.username = newUsername;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setPassword(String newPassword){
		this.password = simpleEncrypt(newPassword);
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setValid(boolean newValid){
		this.valid = newValid;
	}
	
	public boolean isValid(){
		return valid;
	}
	
	private String simpleEncrypt(String s){
		String encryptedPsw = null;
		
		try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(s.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            encryptedPsw = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
		
		return encryptedPsw;
	}
}