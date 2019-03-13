package com.radical.dac;

import org.hibernate.Session;

import com.radical.utility.GenericInterface;
import com.radical.utility.HibernateUtil;

public abstract class GenericDAC<E> implements GenericInterface<E> {
	static Session session;

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session s) {
		session = s;
	}

	public static void createSession() {
		//session = HibernateUtil.getSessionFactory().getCurrentSession();
		if (session == null) {
			setSession(HibernateUtil.getSessionFactory().openSession());
		}

	}

	public void save(E o) {
		getSession().save(o);
	}

	public void update(E o) {
		getSession().update(o);
	}

	public void saveOrUpdate(E o) {
		getSession().saveOrUpdate(o);
	}
}
