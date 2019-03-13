package com.radical.mapping.manytomany.bidirc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class ManagerEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long managerId;

	private String managerName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "manager_project_bi", joinColumns = @JoinColumn(name = "manager_Id"), inverseJoinColumns = @JoinColumn(name = "project_Id"))
	private Set<projectEntity> projects = new HashSet<projectEntity>();

	public void addProject(projectEntity project){
		this.getProjects().add(project);
	}
	public Set<projectEntity> getProjects() {
		return projects;
	}

	public void setProjects(Set<projectEntity> projects) {
		this.projects = projects;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result
				+ ((managerName == null) ? 0 : managerName.hashCode());
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
		ManagerEntity other = (ManagerEntity) obj;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		return true;
	}

	

}
