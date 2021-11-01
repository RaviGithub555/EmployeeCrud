package com.java.eti.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.eti.employee.model.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Integer>{

}
