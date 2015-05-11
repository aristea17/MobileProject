package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductsManager {

	public static List<Products> getProcutsList(){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		List<Products> productsList = (List<Products>) session.createQuery("from Products").list();
		session.getTransaction().commit();
		
		System.out.println("p_name\tcategory\tbatch_amount\tminimum\tstored");
		for(int i=0; i<productsList.size(); i++){
			System.out.println(productsList.get(i).getName() + "\t" +
					productsList.get(i).getCategory() + "\t" +
					productsList.get(i).getBatchAmount() + "\t" +
					productsList.get(i).getMinimum() + "\t" +
					productsList.get(i).getStored());
		}
		
		return productsList;
	}
	
public static List<Products> getProcutsListByUser(){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		List<Products> productsList = (List<Products>) session.createQuery("from Products").list();
		session.getTransaction().commit();
		
		System.out.println("p_name\tcategory\tbatch_amount\tminimum\tstored");
		for(int i=0; i<productsList.size(); i++){
			System.out.println(productsList.get(i).getName() + "\t" +
					productsList.get(i).getCategory() + "\t" +
					productsList.get(i).getBatchAmount() + "\t" +
					productsList.get(i).getMinimum() + "\t" +
					productsList.get(i).getStored());
		}
		
		return productsList;
	}
	
}
