package com.radical.client;

import com.radical.dac.MedicalStoreDAC;
import com.radical.dac.impl.MedicalStoreDACImpl;
import com.radical.mappingOneToOne.Unidirc.entity.AddressEntity;
import com.radical.mappingOneToOne.Unidirc.entity.MedicalStoreEntity;
import com.radical.utility.HibernateUtil;

public class MedicalStoreClient {
	private static MedicalStoreDAC<MedicalStoreEntity> medicalStoreDac;

	public static void main(String[] args) {
		medicalStoreDac = new MedicalStoreDACImpl();
		MedicalStoreClient client = new MedicalStoreClient();
		client.saveMedicalStore();
		HibernateUtil.shutdown();
	}

	private void saveMedicalStore() {
		MedicalStoreEntity medicalStore = createMedicalStore("Rohan Medicals",
				"Reg_011");
		AddressEntity address = createAddress("101", "balewadi1", "bvp",
				"balewadi", "pune", "MH", "India", 411045);
		medicalStore.setAddress(address);
		medicalStoreDac.saveMedicalStore(medicalStore);
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
