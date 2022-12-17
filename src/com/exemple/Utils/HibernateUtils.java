package com.exemple.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.crjj.ismo.entities.Brevet;
import com.crjj.ismo.entities.Domaine;
import com.crjj.ismo.entities.Entreprise;
import com.crjj.ismo.entities.Inventeur;
import com.crjj.ismo.entities.Invention;

public class HibernateUtils {
	
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		Configuration config = new Configuration();
		config.configure();
		
		config.addAnnotatedClass(Entreprise.class);
		config.addAnnotatedClass(Invention.class);
		config.addAnnotatedClass(Inventeur.class);
		config.addAnnotatedClass(Domaine.class);
		config.addAnnotatedClass(Brevet.class);
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
