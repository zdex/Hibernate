package com.radical.mapping.onetoone.bidirc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class CollegeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cllgId;
	
	private String name;
	
	private String level;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy= "college")
	private PrincipalEntity principal;

	public Long getCllgId() {
		return cllgId;
	}

	public void setCllgId(Long cllgId) {
		this.cllgId = cllgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public PrincipalEntity getPrincipal() {
		return principal;
	}

	public void setPrincipal(PrincipalEntity principal) {
		this.principal = principal;
	}

}
