package utils;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionAnnotationFactory;
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
	
	/* Singleton build of session factory, called only if it doesn't exist already */
	private static SessionFactory buildSessionAnnotationFactory(){		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		}
		catch (Throwable ex){
			System.err.println("Initial SessionFactory creation failed...\n" + ex);
            throw new ExceptionInInitializerError(ex);
		}		
	}
	
	/* getSessionFactory */
	public static SessionFactory getSessionFactory(){
		Session session = threadLocal.get();
		if(sessionAnnotationFactory==null) sessionAnnotationFactory = buildSessionAnnotationFactory();
		threadLocal.set(session);
		return sessionAnnotationFactory;
	}
	
	/* Close current session */
	public static void closeConnection(){
			Session session = (Session) threadLocal.get();
			threadLocal.set(null);
			if(session!=null){
				session.close();
			}
	}
}