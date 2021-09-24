package com.psv.students.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psv.students.model.Students;

public interface StudentRepository extends JpaRepository<Students,Long >{

}
