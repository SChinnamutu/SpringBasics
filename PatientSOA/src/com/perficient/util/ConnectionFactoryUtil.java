package com.perficient.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConnectionFactoryUtil {

	private static SessionFactory sessionFactory;

	public static Session createSession(){
		Session session = null;
		try {
			if(sessionFactory == null ){
				session =  sessionFactory.openSession();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	
}
