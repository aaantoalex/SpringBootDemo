package com.psv.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Department")
public class Departments {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long DepartmentID;
	private String DepartmentName;
	public long getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(long departmentID) {
		DepartmentID = departmentID;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	
	
}
