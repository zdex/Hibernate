package com.inherit.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inherit.tableperhirarchy.singletable.entity.EmployeeSingleTable;
import com.inherit.tableperhirarchy.singletable.entity.Person;
import com.radical.utility.HibernateUtil;

public class PerhirarchySingleTableClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			Person person = new Person();
			person.setFirstname("Steve");
			person.setLastname("Balmer");
			session.save(person);

			EmployeeSingleTable employee = new EmployeeSingleTable();
			employee.setFirstname("James");
			employee.setDepartmentName("Marketing");
			employee.setJoiningDate(new Date());
			employee.setLastname("Gosling");
			session.save(employee);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}

}
