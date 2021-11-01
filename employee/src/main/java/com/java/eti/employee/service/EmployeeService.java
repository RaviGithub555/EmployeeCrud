package com.java.eti.employee.service;
import java.util.List;
import java.util.Optional;

import com.java.eti.employee.model.Departments;
import com.java.eti.employee.model.Employee;

public interface EmployeeService {
//    Iterable<Employee> findAll();
//
//    List<Employee> search(String q);
//
//    Optional<Employee> findOne(int id);

    Employee save(Employee contact) throws Exception;

	List<Employee> findall();

	Optional<Employee> findById(int id);

	String delete(int id);


	Employee update(int id, Employee entity);

  //  void delete(int id);
    
}