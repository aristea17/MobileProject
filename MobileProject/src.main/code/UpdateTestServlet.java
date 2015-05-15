package code;

import java.io.IOException;
import java.util.List;

import hibernate.HibernateUtil;
import hibernate.ProductManager;
import hibernate.Products;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("serial")
public class UpdateTestServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		List<Products> list = ProductManager.getProductList();
		Products product1 = list.get(1);
		Products product2 = list.get(2);
		Products product3 = list.get(3);
		product1.setStored(155);
		product2.setStored(0);
		product3.setStored(6);
		/*ProductManager.*/updateProductTest(product1);
		/*ProductManager.*/updateProductTest(product2);
		/*ProductManager.*/updateProductTest(product3);
		
		
	}
	
	//To put in ProductManager and to web.xml + add a method get product by name or smth similar
	private static void updateProductTest(Products product){
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session session = sessFac.getCurrentSession();
		
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}

}
