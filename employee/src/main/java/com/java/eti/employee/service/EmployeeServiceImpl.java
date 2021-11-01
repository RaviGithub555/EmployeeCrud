package com.java.eti.employee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.eti.employee.model.Departments;
import com.java.eti.employee.model.Employee;
import com.java.eti.employee.repository.DepartmentRepository;
import com.java.eti.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    DepartmentRepository departmentRepository;
    

    
    @Override
	public List<Employee> findall() {
    	 return employeeRepository.findAll();
	}
    
    @Override
	public Optional<Employee> findById(int id) {
		Optional<Employee> emp = null;
		emp = employeeRepository.findById(id);
		return emp;
	}

    
//
//    @Override
//    public List<Employee> search(String empName) {
//        return employeeRepository.findByNameContaining(empName);
//    }
//
//    @Override
//    public Optional<Employee> findOne(int id) {
//        return employeeRepository.findById(id);
//    }

    @Override
    public Employee save(Employee emp) throws Exception {
    	//validate phone_number
    	Employee employee = null;
    	String phoneNumber = emp.getPhoneNumber();
    	if(!phoneNumber.matches("[0-9]+") && !(phoneNumber.length()>10) && !(phoneNumber.length() <14)) {
    		throw new Exception();
    	}
    	Number salary = emp.getSalary();
    	String salaryInString = salary.toString();
    	if(!(Integer.parseUnsignedInt(salaryInString)>0)) {
    		throw new Exception();
    	}
    	Optional<Departments> departments = departmentRepository.findById(emp.getDepartment_Id().intValue());
    	if(departments!=null) {
    		employee = 	employeeRepository.save(emp);
    	}else {
    		throw new Exception();
    	}
		return employee;
    }

	@Override
	public String delete(int id) {
		String deleteMsg  = null;
		try {
			employeeRepository.deleteById(id);
			deleteMsg = "employee deleted successfully";
		} catch (Exception e) {
			deleteMsg = "employee not deleted";
		}
		return deleteMsg;
	}


	@Override
	public Employee update(int id, Employee entity) {
		
	Optional<Employee> emp = 	employeeRepository.findById(id);
		
	 Employee updateEmployee = emp.get();
	 updateEmployee.setFirstName(entity.getFirstName());
	 updateEmployee.setLastName(entity.getLastName());
	 updateEmployee.setEmail(entity.getEmail());
	 updateEmployee.setHireDate(entity.getHireDate());
	 updateEmployee.setMangare_Id(entity.getMangare_Id());
	 updateEmployee.setPhoneNumber(entity.getPhoneNumber());
	 updateEmployee.setSalary(entity.getSalary());
	 if(updateEmployee!=null) {
		 employeeRepository.save(updateEmployee);
	 }
		return updateEmployee;
	}

//    @Override
//    public void delete(int id) {
//        employeeRepository.deleteById(id);
//    }
}