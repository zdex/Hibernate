package com.radical.client;

import org.hibernate.Session;

import com.radical.entity.EmployeeEntity;
import com.radical.utility.HibernateUtil;

public class HibernateClient {
	public static void main(String[] args) {
		Session session = null;
		try {
			System.out.println("Maven + Hibernate + MySQL");
			session = HibernateUtil.getSessionFactory().openSession();
			HibernateClient client = new HibernateClient();
			// client.saveEmployee(session);

			/*EmployeeEntity emp = client.getEmployeeRecord(session, 36l);
			System.out.println("name: " + emp.getfName());
			session.clear();
			session.persist(emp);
			emp.setfName("rahul1");
			session.getTransaction().commit();*/
			
			client.testObjectStates(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
			HibernateUtil.shutdown();
		}
	}

	public void testObjectStates(Session session) {
		EmployeeEntity emp = createEntity();
		updateEmployee(session, emp);
		System.out.println("updated first name: " + emp.getfName());
	}

	public void updateEmployee(Session session, EmployeeEntity emp) {
		session.beginTransaction();
		EmployeeEntity employee = (EmployeeEntity) session.merge(emp);
		//session.save(emp);
		employee.setfName("saurav100");
		session.getTransaction().commit();

	}

	public EmployeeEntity getEmployeeRecord(Session session, Long id) {
		session.beginTransaction();
		EmployeeEntity emp = null;
		try {
			emp = (EmployeeEntity) session.get(EmployeeEntity.class, id);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return emp;
	}

	private static EmployeeEntity createEntity() {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmpId(50l);
		emp.setName("pushthi1");
		emp.setfName("pushthi1");
		emp.setAge(3);
		emp.setCity("pune mh100");
		return emp;
	}

	public void saveEmployee(Session session) {
		session.beginTransaction();
		EmployeeEntity emp = new EmployeeEntity(); // transient

		emp.setName("gaurav");
		emp.setAge(25);
		emp.setCity("pune");

		session.save(emp);

		emp.setName("rahul");
		session.getTransaction().commit();

	}

}
