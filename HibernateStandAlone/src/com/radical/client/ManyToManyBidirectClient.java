package com.radical.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.radical.mapping.manytomany.bidirc.entity.ManagerEntity;
import com.radical.mapping.manytomany.bidirc.entity.projectEntity;
import com.radical.utility.HibernateUtil;

public class ManyToManyBidirectClient {
private void deleteManager(Session session, Long id){
	ManagerEntity manager = (ManagerEntity) session.get(ManagerEntity.class, id);
	session.delete(manager);
	
}
	public static void main(String[] args) {
		ManyToManyBidirectClient client = new ManyToManyBidirectClient();
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			Set<ManagerEntity> managers = client.createManager();
			
			Set<projectEntity> projects1 = client.createProjects(" project 1");
			Set<projectEntity> projects2 = client.createProjects(" project 2");
			int i = 1;
			for (ManagerEntity manager : managers) {
				if (i == 1) {
					manager.setProjects(projects1);
					for (projectEntity proj : projects1) {
						proj.addManager(manager);
					}
				} else {
					manager.setProjects(projects2);
					for (projectEntity proj : projects2) {
						proj.addManager(manager);
					}
				}
				
				session.save(manager);
				i++;
			}
			client.deleteManager(session, 21l);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}

	private Set<ManagerEntity> createManager() {
		Set<ManagerEntity> managers = new HashSet<ManagerEntity>();
		ManagerEntity manager1 = new ManagerEntity();
		manager1.setManagerName("Shailesh");

		ManagerEntity manager2 = new ManagerEntity();
		manager2.setManagerName("Uday");

		managers.add(manager1);
		managers.add(manager2);
		return managers;

	}

	private Set<projectEntity> createProjects(String vary) {

		Set<projectEntity> projects = new HashSet<projectEntity>();

		projectEntity project1 = new projectEntity();
		project1.setProjectName("BankCustomerManagement " + vary);

		projectEntity project2 = new projectEntity();
		project2.setProjectName("HospitalManagement " + vary);

		projects.add(project1);
		projects.add(project2);
		return projects;

	}
}
