package com.psv.students.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psv.students.model.Departments;

public interface DepartmentRepository extends JpaRepository<Departments, Long> {

}
