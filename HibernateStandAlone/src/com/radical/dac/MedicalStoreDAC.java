package com.radical.dac;

import com.radical.mappingOneToOne.Unidirc.entity.MedicalStoreEntity;
import com.radical.utility.GenericInterface;

public interface MedicalStoreDAC<E> extends
		GenericInterface<MedicalStoreEntity> {

	void saveMedicalStore(MedicalStoreEntity medicalStore);

}
