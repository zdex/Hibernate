package com.radical.dac.impl;

import org.hibernate.Session;

import com.radical.dac.GenericDAC;
import com.radical.dac.MedicalStoreDAC;
import com.radical.mappingOneToOne.Unidirc.entity.MedicalStoreEntity;

public class MedicalStoreDACImpl extends GenericDAC<MedicalStoreEntity>
		implements MedicalStoreDAC<MedicalStoreEntity> {
	
	@Override
	public void saveMedicalStore(MedicalStoreEntity medicalStore) {
		createSession();
		Session session = getSession();
		session.beginTransaction();
		save(medicalStore);
		session.getTransaction().commit();
		session.clear();
		session.close();
		

	}

}
