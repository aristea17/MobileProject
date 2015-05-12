package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductManager {
	
	public static List<Products> getProductList(){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		List<Products> productList = (List<Products>) session.createQuery("from Products").list();
		session.getTransaction().commit();
		
		System.out.println("ID\tName\tMinimum\tStored\tBatch");
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

}
