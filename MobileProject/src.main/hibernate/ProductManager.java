package hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* Handles access to DB when working with Products */
public class ProductManager {
	
	/* List of ALL products in DB */
	public static List<Products> getProductList(){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			/* Query to DB */
			session.beginTransaction();
			String hql = "from Products";
			Query query = session.createQuery(hql);
			List<Products> productList = query.list();
			session.getTransaction().commit();
			
			return productList;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.closeConnection();
		}
	}
	
	/* List of all products for a specific user/department */
	public static List<Products> getProductsListByUser(String user){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			/* Query to DB */
			session.beginTransaction();
			String hql = "SELECT p FROM Products p JOIN p.department d WHERE d.d_name='" + user +"'";
			Query query = session.createQuery(hql);
			List<Products> productList = query.list();
			session.getTransaction().commit();
			
			return productList;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.closeConnection();
		}
	}
	
	/* List of all products (in form of ProductTuple, obj to be displayed in a table) for a category */
	public static ArrayList<ProductTuple> getProductsListByCategory(String department, String category){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			/* Query to DB */
			session.getTransaction().begin();
			List<Products> listOfProducts = (List<Products>) session.createQuery("SELECT distinct p FROM Products p JOIN p.department pd WHERE p.category='" + category +"' and pd.d_name='" + department + "'").list();
			
			ArrayList<ProductTuple> output = new ArrayList<ProductTuple>();
			
			/* For each Products obj we create its "sibling" ProductTuple obj */
			for(Products pr : listOfProducts){
				Set<Sells> sells = pr.getSells();
				for(Sells ss : sells){
					ProductTuple tuple = new ProductTuple(pr, ss.getSupplier(), ss.getPrice());
					
					output.add(tuple);
				}
			}
			
			/* Close connection and return */
			session.getTransaction().commit();
			return output;

		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.closeConnection();
		}
	}
	
	/* List of all product-categories based on department parameter */
	public static List<String> getCategories(String department){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();

		try{
			/* Query to DB */
			session.getTransaction().begin();
			String hql = "SELECT distinct p.category FROM Products p JOIN p.department d WHERE d.d_name='" + department + "'";
			Query query = session.createQuery(hql);
			List<String> productList = query.list();			
			session.getTransaction().commit();
			return productList;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.closeConnection();
		}
	}
		
	/* Update in DB the stored-amount of a given product (based on id) */
	public static void updateProductById(int id, int value){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			/* Query to DB to get product and update quantity. Then we save to DB the obj */
			session.getTransaction().begin();
			Products prod = (Products) session.get(Products.class, id);
			prod.setStored(value);
			session.saveOrUpdate(prod);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			HibernateUtil.closeConnection();
		}
	}
}
	