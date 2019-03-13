package com.radical.client;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.radical.mappingOneToOne.Unidirc.entity.AddressEntity;
import com.radical.mappingOneToOne.Unidirc.entity.MedicalStoreEntity;
import com.radical.utility.HibernateUtil;

public class MedicalStoreClientSample {

	public static void main(String[] args) {
		Session session = null;
		MedicalStoreClientSample client = new MedicalStoreClientSample();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			client.saveMedicalStore(session);
			client.test(session);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
			HibernateUtil.shutdown();
		}
	}

	private void test(Session session) {
		session.beginTransaction();
		MedicalStoreEntity entity = (MedicalStoreEntity)session.get(MedicalStoreEntity.class , 3l);
		System.out.println(entity.getAddress().getArea());
	}

	private void saveMedicalStore(Session session) {
		session.beginTransaction();
		MedicalStoreEntity medicalStore = createMedicalStore("Rahul Medicals",
				"Reg_102");
		AddressEntity address = createAddress("102", "balewadi102", "bvp",
				"balewadi102", "pune102", "MH", "India", 411045);
		medicalStore.setAddress(address);
		session.save(medicalStore);
		session.getTransaction().commit();
	}

	private MedicalStoreEntity createMedicalStore(String name, String regName) {
		MedicalStoreEntity entity = new MedicalStoreEntity();
		entity.setName(name);
		entity.setRegistrationNumber(regName);
		return entity;
	}

	private AddressEntity createAddress(String shopNumber, String streetName,
			String nearby, String area, String city, String state,
			String country, int pincode) {
		AddressEntity entity = new AddressEntity();
		entity.setArea(area);
		entity.setCity(city);
		entity.setCountry(country);
		entity.setNearby(nearby);
		entity.setPincode(pincode);
		entity.setShopNumber(shopNumber);
		entity.setState(state);
		entity.setStreetName(streetName);
		return entity;
	}
}
