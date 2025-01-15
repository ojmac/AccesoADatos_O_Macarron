package ORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hibernate.entity.*;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	/**
	 * Crea la factoria de sesiones
	 */
	public static void buildSessionFactory() {

		Configuration configuration = new Configuration();
		// La llamada al método configure() carga los parámetros del fichero
		// hibernate.cfg.xml
		configuration.configure();

		// Se registran las clases que hay que mapear con cada tabla de la base de datos
		configuration.addAnnotatedClass(Coche.class);
		// configuration.addAnnotatedClass(Clase2.class);
		// configuration.addAnnotatedClass(Clase3.class);

		// Se crea una SessionFactory a partir del objeto Configuration
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/**
	 * Abre una nueva sesión
	 */
	public static Session openSession() {
		if(sessionFactory == null) {
			buildSessionFactory();
		}
		session = sessionFactory.openSession();
		return session;
	}

	/**
	 * Devuelve la sesión actual
	 * 
	 * @return
	 */
	
		
	public static Session getCurrentSession() {

		if ((session == null) || (!session.isOpen()))
			openSession();

		return session;
	}

	/**
	 * Cierra Hibernate
	 */
	public static void closeSessionFactory() {

		try {
			if (session != null)
				session.close();

			if (sessionFactory != null)
				sessionFactory.close();

		} catch (Exception ex) {
			System.out.println("Se ha producido un error al cerrar la conexión: \n" + ex.getStackTrace());
		}

	}
}