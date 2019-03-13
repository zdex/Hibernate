package com.radical.mappingOneToOne.Unidirc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicalstore")
public class MedicalStoreEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2875867167229951812L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long medStrId;

	@Column 
	private String name;

	private String registrationNumber;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	public Long getMedStrId() {
		return medStrId;
	}

	public void setMedStrId(Long medStrId) {
		this.medStrId = medStrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((medStrId == null) ? 0 : medStrId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((registrationNumber == null) ? 0 : registrationNumber
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalStoreEntity other = (MedicalStoreEntity) obj;
		if (medStrId == null) {
			if (other.medStrId != null)
				return false;
		} else if (!medStrId.equals(other.medStrId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalStoreEntity [medId=" + medStrId + ", name=" + name
				+ ", registrationNumber=" + registrationNumber + "]";
	}

}
