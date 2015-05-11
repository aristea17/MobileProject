package hibernate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserManager {

	public static void saveUsers(Users user){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}
	
	public static Users getUser(String username){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		Users user = (Users) session.get(Users.class, username);
		session.getTransaction().commit();
		
		return user;
		
	}

	
	public static boolean verifyUser(String username, String password){
		
		String encrypPsw = simpleEncrypt(password);
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.openSession();
		Transaction t = null;
		
		t= session.beginTransaction();
		List<Users> users = (List<Users>) session.createQuery("from Users").list();
		t.commit();
		session.close();
		if(users.isEmpty()){
			return false;
		}else{
			for(int i=0; i<users.size(); i++)
			if(users.get(i).getUsername().equals(username) &&
					users.get(i).getPassword().equals(encrypPsw)){
				return true;
			}
		}
		return false;
	}
	
	private static String simpleEncrypt(String s){
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
	
	public static void saveDepartment(Department dept){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		session.save(dept);
		session.getTransaction().commit();
	}
	
	public static Department getDepartment(int id){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		Department dept = (Department) session.get(Department.class, id);
		session.getTransaction().commit();
		
		return dept;
		
	}
}
