package com.inherit.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inherit.tablepersubclass.joined.entity.Employee_joined;
import com.inherit.tablepersubclass.joined.entity.Owner_joined;
import com.inherit.tablepersubclass.joined.entity.Person_Joined;
import com.radical.utility.HibernateUtil;

public class TablePerSubClassJoinedClient {

	public static void main(String[] args) {
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Person_Joined person = new Person_Joined("rahul", "rahul");
			//session.save(person);

			Employee_joined employee = new Employee_joined("James2", "Gosling2",
					"Marketing2", new Date());
			//session.save(employee);

			Owner_joined owner = new Owner_joined("Bill", "Gates", 300L, 20L);
			//session.save(owner);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}

}
