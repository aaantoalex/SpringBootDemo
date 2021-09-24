package com.psv.students.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psv.students.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
