package com.radical.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.radical.entity.FarmarEntity;
import com.radical.utility.HibernateUtil;

public class HibernateFarmerClient {

	public static void main(String[] args) {
		HibernateFarmerClient client = new HibernateFarmerClient();
		client.process();

	}

	public void process() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		FarmarEntity farmar = createFarmar();
		session.save(farmar);
		tx.commit();
		session.clear();
		session.close();
		HibernateUtil.shutdown();
	}

	private FarmarEntity createFarmar() {
		FarmarEntity farmar = new FarmarEntity();
		farmar.setName("rahul");
		return farmar;
	}
}
