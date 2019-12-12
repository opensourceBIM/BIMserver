package org.bimserver.custom;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
		try {
			Properties properties = new Properties();
			// Create the SessionFactory from hibernate.cfg.xml
			properties = PropertiesUtil.propertyLoad();
			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml").addProperties(properties);
			configuration.addResource("CustomBim.hbm.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactory;
		}
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
   /* public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }*/

}
