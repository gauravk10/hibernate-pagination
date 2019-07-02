package com.nit.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;

	static {
		try {
			// bootstrap configuration
			Configuration cfg = new Configuration();
			cfg.configure("com/nit/cfgs/hibernate.cfg.xml");
			// create session factory object
			factory = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		Session session = null;
		if (factory != null)
			session = factory.getCurrentSession();
		return session;
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
