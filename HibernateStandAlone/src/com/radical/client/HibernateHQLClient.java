package com.radical.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.radical.mapping.onetomany.bidirc.entity.HouseEntity;
import com.radical.mapping.onetomany.unidirc.entity.Employee_oneToMany;
import com.radical.mapping.onetomany.unidirc.entity.Phone;
import com.radical.utility.HibernateUtil;

public class HibernateHQLClient {

	public static void main(String[] args) {

		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			int emp_id = 10;
			session.beginTransaction();
			String querystr = "select e from Employee_oneToMany e where e.id = :emp_id";
			Query query = session.createQuery(querystr);
			query.setParameter("emp_id", emp_id);

			List<Employee_oneToMany> emps = (ArrayList<Employee_oneToMany>) query.list();
			System.out.println(emps.isEmpty());
			Employee_oneToMany empl = emps.get(0);
			if (empl.getPhones() != null) {
				for (Phone phone : empl.getPhones()) {
					System.out.println(phone.getNumber());
				}
			}
			
			//retrieveHouseMembers(5l, session);
			
			//	retrieveHouseMembersUsingCriteria(5l, session);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}

	}

	private static void retrieveHouseMembersUsingCriteria(long id,
			Session session) {
		Criteria criteria = session.createCriteria(HouseEntity.class);
		criteria.add(Restrictions.eq("houseId", id)); 
		criteria.add(Restrictions.or(Restrictions.eq("houseId", id), 
				Restrictions.eq("type", "single")));
		
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.property("houseId"));
		proj.add(Projections.property("houseName"));
		criteria.setProjection(proj);
		criteria.addOrder(Order.asc("houseName"));
		List<HouseEntity> house = criteria.list();
		System.out.println("house.size() usig criteria: " + house.size());
		
	}

	private static void retrieveHouseMembers(long houseid, Session session) {
		String querystr = "select count(h.houseId) from HouseEntity h  "
				+ " join h.familyMembers f "
				+ "where h.houseId = :hid and f.name = :fname";
		Query query = session.createQuery(querystr);
		query.setParameter("hid", houseid);
		query.setParameter("fname", "gaurav");
		//List<HouseEntity> house = query.list();
		//System.out.println(house.size());
		List<Long> values = query.list();
		Long count = values.get(0);
		System.out.println(count);
	}

}
