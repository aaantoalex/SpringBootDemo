
package com.psv.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Course")
public class Courses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CourseID;
	private String CourseName;
	public long getCourseID() {
		return CourseID;
	}
	public void setCourseID(long courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	

}
