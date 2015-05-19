package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import code.BuyProduct;

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
	public static List<Object[]> getProductsListByCategory(String category){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			try{
				session.getTransaction().begin();
				List<Object[]> l = (List<Object[]>) session.createQuery("SELECT p, ps.price, s.company FROM Products p, Suppliers s JOIN p.sells ps JOIN s.sells JOIN p.department WHERE p.category='" + category +"'").list();
				//List<Products> l = (List<Products>) session.createQuery("WHERE p.category='" + category +"'").list();
				for(Object[] tuple: l){
					Products p = (Products) tuple[0];
					Double price = (Double) tuple[1];
					System.out.println(p.getID() + "\t" +
									   p.getName() + "\t" +
									   p.getMinimum() + "\t" +
									   p.getStored() + "\t" + 
									   price + "\t" +
									   p.getBatchAmount());	
				}
				session.getTransaction().commit();
				return l;
			}catch(Exception e){
				session.getTransaction().rollback();
				throw e;
			}
		}finally{
			HibernateUtil.closeConnection();
			}
		}
	
	//return all the categories of the products
	public static List<String> getCategories(String department){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			try{
				session.getTransaction().begin();
				String hql = "SELECT distinct p.category FROM Products p JOIN p.department d WHERE d.d_name='" + department + "'";
				Query query = session.createQuery(hql);
				List<String> productList = query.list();
				
				for(int i=0; i<productList.size(); i++){
					productList.get(i);
				}
				session.getTransaction().commit();
				return productList;
			}catch(Exception e){
				session.getTransaction().rollback();
				throw e;
			}
		}finally{
				HibernateUtil.closeConnection();
				}
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