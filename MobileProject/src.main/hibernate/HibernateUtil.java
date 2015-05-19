package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionAnnotationFactory;
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
	
	private static SessionFactory buildSessionAnnotationFactory(){
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		}
		catch (Throwable ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}		
	}
	
	public static SessionFactory getSessionFactory(){
		Session session = threadLocal.get();
		if(sessionAnnotationFactory==null) sessionAnnotationFactory = buildSessionAnnotationFactory();
		threadLocal.set(session);
		return sessionAnnotationFactory;
	}
	
	public static void closeConnection(){
			Session session = (Session) threadLocal.get();
			threadLocal.set(null);
			if(session!=null){
				session.close();
			}
	}
}