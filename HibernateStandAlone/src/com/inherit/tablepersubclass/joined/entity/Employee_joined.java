package com.inherit.tablepersubclass.joined.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_PERSUBCLASS_JOINED")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Employee_joined extends Person_Joined implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "joining_date")
	private Date joiningDate;

	@Column(name = "department_name")
	private String departmentName;

	public Employee_joined() {
	}

	public Employee_joined(String firstname, String lastname,
			String departmentName, Date joiningDate) {

		super(firstname, lastname);

		this.departmentName = departmentName;
		this.joiningDate = joiningDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
