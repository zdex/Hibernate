package com.radical.mapping.manytomany.unidirc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "salt")
public class SaltEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saltId;
	
	private String name;
	
	private String chemicalName;
	
	private String color;

	public Long getSaltId() {
		return saltId;
	}

	public void setSaltId(Long saltId) {
		this.saltId = saltId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChemicalName() {
		return chemicalName;
	}

	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chemicalName == null) ? 0 : chemicalName.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((saltId == null) ? 0 : saltId.hashCode());
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
		SaltEntity other = (SaltEntity) obj;
		if (chemicalName == null) {
			if (other.chemicalName != null)
				return false;
		} else if (!chemicalName.equals(other.chemicalName))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (saltId == null) {
			if (other.saltId != null)
				return false;
		} else if (!saltId.equals(other.saltId))
			return false;
		return true;
	}
	
	
}
