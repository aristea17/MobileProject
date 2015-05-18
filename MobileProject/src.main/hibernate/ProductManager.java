package hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductManager {
	
	public static List<Products> getProductList(){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		String hql = "from Products";
		Query query = session.createQuery(hql);
		List<Products> productList = query.list();
		session.getTransaction().commit();
		
		for(int i=0; i<productList.size(); i++){
			System.out.println(productList.get(i).getID() + "\t" +
					productList.get(i).getName() + "\t" +
					productList.get(i).getMinimum() + "\t" +
					productList.get(i).getStored() + "\t" +
					productList.get(i).getCategory() + "\t" +
					productList.get(i).getBatchAmount());
		}
		return productList;		
	}
	
	public static List<Products> getProductsListByUser(String user){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		String hql = "SELECT p FROM Products p JOIN p.department d WHERE d.d_name='" + user +"'";
		Query query = session.createQuery(hql);
		List<Products> productList = query.list();
		session.getTransaction().commit();
		
		for(int i=0; i<productList.size(); i++){
			System.out.println(productList.get(i).getID() + "\t" +
					productList.get(i).getName() + "\t" +
					productList.get(i).getMinimum() + "\t" +
					productList.get(i).getStored() + "\t" +
					productList.get(i).getCategory() + "\t" +
					productList.get(i).getBatchAmount());
		}
		return productList;
	}
	
	//add the category in the method parameter, now it's done manually
	public static List<Products> getProductsListByCategory(String category){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		String hql = "SELECT p FROM Products p JOIN p.department d WHERE p.category='" + category + "'";
		Query query = session.createQuery(hql);
		List<Products> productList = query.list();
		session.getTransaction().commit();
		
		for(int i=0; i<productList.size(); i++){
			System.out.println(productList.get(i).getID() + "\t" +
					productList.get(i).getName() + "\t" +
					productList.get(i).getMinimum() + "\t" +
					productList.get(i).getStored() + "\t" +
					productList.get(i).getCategory() + "\t" +
					productList.get(i).getBatchAmount());
			//productList.get(i);
		}
		return productList;
	}
	
	//return all the categories of the products
	public static List<String> getCategories(String department){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		String hql = "SELECT distinct p.category FROM Products p JOIN p.department d WHERE d.d_name='" + department + "'";
		Query query = session.createQuery(hql);
		List<String> productList = query.list();
		session.getTransaction().commit();
		
		for(int i=0; i<productList.size(); i++){
			productList.get(i);
		}
		return productList;
	}
	
	//update the amount of products
	public static void addProducts(){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		String hql = "UPDATE Products p SET p.stored=25 WHERE p.p_id=2";
		Query query = session.createQuery(hql);
		
		int result = query.executeUpdate();	
	}
}