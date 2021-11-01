package com.java.eti.employee.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.eti.employee.model.Employee;
import com.java.eti.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    
  @PostMapping("/create")
  public ResponseEntity<Employee> save(@Validated Employee entity) throws Exception {
     Employee employee = null;
     employee = employeeService.save(entity);
	  
      return new ResponseEntity<Employee>(employee, HttpStatus.OK);
  }
  
  
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> employee() {
		List<Employee> emplist = null;
		
		emplist = employeeService.findall();
	    return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{ID}")
	public ResponseEntity<Optional<Employee>> employeeById(@PathVariable int id) {
		Optional<Employee> employee = null;
		
		employee = employeeService.findById(id);
	    return new ResponseEntity<Optional<Employee>>(employee, HttpStatus.OK);
	}
	
  @GetMapping("/employee/{id}/delete")
  public ResponseEntity<String> delete(@PathVariable int id) {
     String emplDelete =  employeeService.delete(id);
      
      return new ResponseEntity<String>(emplDelete, HttpStatus.OK);
  }
	  
  
	@GetMapping("/employee/{id}/edit")
	public ResponseEntity<Employee> edit(@PathVariable int id, @RequestBody Employee entity ) {
		Employee updatedEmp =  employeeService.update(id, entity);
	    return  new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
  
}