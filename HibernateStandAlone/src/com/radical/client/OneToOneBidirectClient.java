package com.radical.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.radical.mapping.onetoone.bidirc.entity.CollegeEntity;
import com.radical.mapping.onetoone.bidirc.entity.PrincipalEntity;
import com.radical.mappingOneToOne.Unidirc.entity.AddressEntity;
import com.radical.mappingOneToOne.Unidirc.entity.MedicalStoreEntity;
import com.radical.utility.HibernateUtil;

public class OneToOneBidirectClient {
	public static void main(String[] args) {
		 Session session = null;
		try{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        session = sessionFactory.openSession();  
        session.beginTransaction();  
          
        CollegeEntity college = new CollegeEntity();  
        college.setName("MIET");
        college.setLevel("private");
          
        PrincipalEntity principal = new PrincipalEntity();  
        principal.setAge(50);  
        principal.setName("Dr. Ashok");
       
        principal.setCollege(college);
        college.setPrincipal(principal); 
         
          
       session.persist(college);  
        
        session.getTransaction().commit();  

//        CollegeEntity collegeEntity = (CollegeEntity)session.get(CollegeEntity.class, 16l);
//        PrincipalEntity prin = collegeEntity.getPrincipal();
        
       
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.shutdown();
		}
        
	}
}
