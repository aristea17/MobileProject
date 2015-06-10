package service;
 
import java.util.List;

import model.Suppliers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtil;

/* Handle access to DB when working with Suppliers */
public class SuppliersManager {

	/* List of all suppliers for a specific user/department */
	public static List<Suppliers> getSuppliersList(String user){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		/* Query to DB */
		session.beginTransaction();
		String hql = "SELECT s FROM Suppliers s JOIN s.department d WHERE d.d_name='" + user + "'";
		Query query = session.createQuery(hql);
		List<Suppliers> supplierList = query.list();
		
		return supplierList;

	}
}