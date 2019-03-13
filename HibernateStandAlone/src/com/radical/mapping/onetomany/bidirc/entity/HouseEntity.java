package com.radical.mapping.onetomany.bidirc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "house")
public class HouseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long houseId;
	
	private String houseName;
	
	private String type;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="house")  
	private Set<FamilyMemberEntity> familyMembers;
	

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<FamilyMemberEntity> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Set<FamilyMemberEntity> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
	
}
