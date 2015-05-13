package hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SuppliersManager {

	public static List<Suppliers> getSuppliersList(String user){
		
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		String hql = "SELECT s FROM Suppliers s JOIN s.department d WHERE d.d_name='" + user +"'";
		Query query = session.createQuery(hql);
		List<Suppliers> supplierList = query.list();
		session.getTransaction().commit();
		
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
