package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SuppliersManager {

	public static List<Suppliers> getSuppliersList(){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		//new
		List<Suppliers> supplierList = (List<Suppliers>) session.createQuery("SELECT s FROM Suppliers s JOIN s.department d WHERE d.d_name='clean'").list();
		//List<Suppliers> supplierList = (List<Suppliers>) session.createQuery("Select ").list();
		session.getTransaction().commit();
		
		System.out.println("Company\temail\tname\taddress\tphone");
		for(int i=0; i<supplierList.size(); i++){
			System.out.println(supplierList.get(i).getCompany() + "\t" +
					supplierList.get(i).getEmail() + "\t" +
					supplierList.get(i).getRepresentative() + "\t" +
					supplierList.get(i).getAddress() + "\t" +
					supplierList.get(i).getTelephone());
		}
		
		return supplierList;
	}
	
}
