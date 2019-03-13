package com.radical.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.CollectionSubqueryFactory;

import com.radical.mapping.onetomany.unidirc.entity.Employee_oneToMany;
import com.radical.mapping.onetomany.unidirc.entity.Phone;
import com.radical.utility.HibernateUtil;

public class OneToManyUnidirectClient {

	public static void main(String[] args) {
		OneToManyUnidirectClient client = new OneToManyUnidirectClient();
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			Employee_oneToMany emp = new Employee_oneToMany();
			emp.setName("gautam");
			emp.setSalary(564125l);
			List<Phone> phones = client.createPhones();
			emp.setPhones(phones);

			// session.save(emp);

			session.getTransaction().commit();
			// Employee_oneToMany empl =
			// (Employee_oneToMany)session.get(Employee_oneToMany.class, 10);
/*			Criteria c = session.createCriteria(Employee_oneToMany.class);
			// c.add(Restrictions.eq("id", 10));
			// c.add(Restrictions.eq("age", 0));
			c.add(Restrictions.or(Restrictions.eq("id", 10),
					Restrictions.eq("age", 0)));
				
			List<Employee_oneToMany> emplist = c.list();
			for (Employee_oneToMany emp_1 : emplist) {
				List<Phone> phs = (List<Phone>) emp_1.getPhones();
				for (Phone phone : phs) {
					System.out.println("emp:" + emp_1.getId() + " phone is: "
							+ phone.getId());
				}
			}
*/			
			Criteria c1 = session.createCriteria(Employee_oneToMany.class);
			//c1.createAlias("emp_alias.phones", "phone");
			ProjectionList pl =  Projections.projectionList();
			pl.add(Projections.property("id")).add(Projections.property("age"));
			pl.add(Projections.sum("salary"));
			//pl.add(Projections.property("phone.id"));
						
			c1.setProjection(pl);
			
			c1.addOrder(Order.desc("id"));
			c1.addOrder(Order.desc("age"));

			List<Employee_oneToMany> emplist_1 = c1.list();
			for (Employee_oneToMany emp_1 : emplist_1) {
				List<Phone> phs = (List<Phone>) emp_1.getPhones();
				for (Phone phone : phs) {
					System.out.println("emp:" + emp_1.getId() + " phone is: "
							+ phone.getId());
					
				}
//				System.out.println(emp_1.get);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}

	private List<Phone> createPhones() {

		List<Phone> phones = new ArrayList<Phone>();

		Phone phone1 = new Phone();
		phone1.setNumber(93725506);
		phone1.setType("pager");

		Phone phone2 = new Phone();
		phone2.setNumber(987654);
		phone2.setType("smart");

		phones.add(phone1);
		phones.add(phone2);
		return phones;

	}

}
