package com.psv.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long StudentId;
	private String StudentName;
	private String Email;
	private long MobileNo;
	private int DepartmentId;
	private int CourseId;
	
	public long getStudentId() {
		return StudentId;
	}
	public void setStudentId(long studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public int getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	
	
	

}
