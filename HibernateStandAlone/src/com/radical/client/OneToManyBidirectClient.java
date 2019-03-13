package com.radical.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.radical.mapping.onetomany.bidirc.entity.FamilyMemberEntity;
import com.radical.mapping.onetomany.bidirc.entity.HouseEntity;
import com.radical.utility.HibernateUtil;

public class OneToManyBidirectClient {

	public static void main(String[] args) {
		OneToManyBidirectClient client = new OneToManyBidirectClient();
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			HouseEntity house = new HouseEntity();
			house.setHouseName("Maheshwari Pariwar");
			house.setType("happy family");
			
			Set<FamilyMemberEntity> members = client.createFamilyMembers();
			for(FamilyMemberEntity member : members){
				member.setHouse(house);
			}
			
			house.setFamilyMembers(members);
			session.save(house);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}

	private Set<FamilyMemberEntity> createFamilyMembers(){
		
		Set<FamilyMemberEntity> members = new HashSet<FamilyMemberEntity>();
		
		FamilyMemberEntity member1 = new FamilyMemberEntity();
		member1.setAge(2);
		member1.setName("pushthi");
		
		FamilyMemberEntity member2 = new FamilyMemberEntity();
		member2.setAge(50);
		member2.setName("gaurav");
		
		members.add(member1);
		members.add(member2);
		return members;
		
	}

}
