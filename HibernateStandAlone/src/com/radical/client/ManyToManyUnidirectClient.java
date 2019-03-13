package com.radical.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.radical.mapping.manytomany.unidirc.entity.MedecineEntity;
import com.radical.mapping.manytomany.unidirc.entity.SaltEntity;
import com.radical.utility.HibernateUtil;

public class ManyToManyUnidirectClient {

	public static void main(String[] args) {
		ManyToManyUnidirectClient client = new ManyToManyUnidirectClient();
		Session session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			Set<MedecineEntity> medecines = client.createMedecines();
			int i = 1;
			for (MedecineEntity medecine : medecines){
				
				Set<SaltEntity> salts =  client.createSalts(" salt " + i);
				medecine.setSalts(salts);
				session.save(medecine);
				i++;
			}
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}



	private Set<MedecineEntity> createMedecines(){
		Set<MedecineEntity> medecines = new HashSet<MedecineEntity>();
		MedecineEntity medecine1 = new MedecineEntity();
		medecine1.setMedecineName("disprine");
		
		MedecineEntity medecine2 = new MedecineEntity();
		medecine2.setMedecineName("citrazine");
		
		medecines.add(medecine1);
		medecines.add(medecine2);
		return medecines;
		
	}
	
	private Set<SaltEntity> createSalts(String vary){
		
		Set<SaltEntity> salts = new HashSet<SaltEntity>();
		
		SaltEntity salt1 = new SaltEntity();
		salt1.setChemicalName("hclo2" + vary);
		salt1.setName("hydrocloric acid" + vary);
		salt1.setColor("white" + vary);
		
		SaltEntity salt2 = new SaltEntity();
		salt2.setChemicalName("cl" + vary);
		salt2.setName("chlorine" + vary);
		salt2.setColor("white" + vary);
		
		salts.add(salt1);
		salts.add(salt2);
		return salts;
		
	}
}
