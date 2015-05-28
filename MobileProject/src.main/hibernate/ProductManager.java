package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	
	
	public static ArrayList<productTuple> getProductsListByCategory(String category){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			try{
				session.getTransaction().begin();
				List<Products> listOfProducts = (List<Products>) session.createQuery("SELECT distinct p FROM Products p JOIN p.department WHERE p.category='" + category +"'").list();
				
				ArrayList<productTuple> output = new ArrayList<productTuple>();
				
				for(Products pr : listOfProducts){
					Set<Sells> sells = pr.getSells();
					for(Sells ss : sells){
						productTuple tuple = new productTuple(pr, ss.getSupplier(), ss.getPrice());
						
						output.add(tuple);
					}
				}
				session.getTransaction().commit();
				return output;
				
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
	public static void updateProductById(int id, int value){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		try{
			try{
				session.getTransaction().begin();
				Products prod = (Products) session.get(Products.class, id);
				prod.setStored(value);
				session.save(prod);
				session.getTransaction().commit();
			}catch(Exception e){
				session.getTransaction().rollback();
				throw e;
			}
		}finally{
				HibernateUtil.closeConnection();
		}
	}
}
	