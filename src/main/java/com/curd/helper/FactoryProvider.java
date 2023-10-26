package com.curd.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	
	private static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure("/hibernate.conf.xml").buildSessionFactory();
		}		
		return factory;
	}
	
	public static void closeFactory() {
		factory.close();
	}

}
