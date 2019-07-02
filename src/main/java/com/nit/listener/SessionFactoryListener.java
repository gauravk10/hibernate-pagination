package com.nit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nit.utility.HibernateUtils;

public class SessionFactoryListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// close SessionFactory object
		HibernateUtils.closeSessionFactory();
	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("com.nit.utility.HibernateUtils");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	}

}
