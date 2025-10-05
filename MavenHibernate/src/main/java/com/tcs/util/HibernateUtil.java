package com.tcs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sf;
	
	static {
		try {
			Configuration cfg = new Configuration().configure("/com/tcs/config/hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
