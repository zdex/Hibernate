package com.radical.mapping.manytomany.unidirc.entity;

import java.io.Serializable;

import javax.persistence.JoinColumn;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medecine")
public class MedecineEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medecineId;

	private String medecineName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "medicine_salt_uni", joinColumns = @JoinColumn(name = "medecine_Id"), inverseJoinColumns = @JoinColumn(name = "salt_Id"))
	private Set<SaltEntity> salts;

	public Set<SaltEntity> getSalts() {
		return salts;
	}

	public void setSalts(Set<SaltEntity> salts) {
		this.salts = salts;
	}

	public Long getMedecineId() {
		return medecineId;
	}

	public void setMedecineId(Long medecineId) {
		this.medecineId = medecineId;
	}

	public String getMedecineName() {
		return medecineName;
	}

	public void setMedecineName(String medecineName) {
		this.medecineName = medecineName;
	}

}
