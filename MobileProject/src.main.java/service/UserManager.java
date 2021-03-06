package service;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.Department;
import model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class UserManager {

	/* Will be needed eventually in case we let the super user to add another 'user' */
	public static void saveUsers(Users user){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	/* Return the searched users */
	public static Users getUser(String username){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
				
		/* Query to DB */
		session.beginTransaction();
		Users user = (Users) session.get(Users.class, username);
		session.getTransaction().commit();
		
		return user;
	}
	
	/* Authenticate the user by checking the inserted username & password */
	public static boolean authenticate(String username, String password){
		
		String encrypPsw = simpleEncrypt(password);
		Users user = getUserByStringId(username);
		
		if(user != null){
			if(user.getUsername().equals(username) &&
				user.getPassword().equals(encrypPsw)) return true;
		}
		return false;
	}
	
	/* Get the users by their username */
	private static Users getUserByStringId(String username){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
				
		/* Query to DB */
		session.beginTransaction();
		String query = "from Users where username='" + username + "'";
		Users user = (Users) session.createQuery(query).uniqueResult();
		session.getTransaction().commit();
		return user;
		
	}
	
	/* Method to encrypt the inserted password from the user */
	private static String simpleEncrypt(String s){
		String encryptedPsw = null;
		
		try {
            /* Create MessageDigest instance for MD5 */
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            /* Add password bytes to digest*/
            md.update(s.getBytes());
            
            /* Get the hash's bytes */
            byte[] bytes = md.digest();
            
            /* This bytes[] has bytes in decimal format;
               Convert it to hexadecimal format */
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            /* Get complete hashed password in hex format */
            encryptedPsw = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
		
		return encryptedPsw;
	}
	
	/* Get the department by ID */
	public static Department getDepartment(int id){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		/* Query to DB */
		session.beginTransaction();
		Department dept = (Department) session.get(Department.class, id);
		session.getTransaction().commit();
		
		return dept;
	}
} 