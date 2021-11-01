package com.java.eti.employee.service;

import com.java.eti.employee.model.Departments;

public class DepartementServiceImpl implements DepartmentService{

	@Override
	public Departments findbyId(Number id) {
		Departments departments = null;
		try {
			departments = findbyId(id);
		} catch (Exception e) {
			departments = null;
		}
		return departments;
	}

}
