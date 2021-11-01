package com.java.eti.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Departments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	    @Id
	    @Column(name = "department_id", nullable = false)
	    private int department_Id;

	    @Column(name = "department_name", nullable = false)
	    private String department_name;

	    @Column(name = "manager_id", nullable = false)
	    private Number manager_Id;

		public int getDepartment_Id() {
			return department_Id;
		}

		public void setDepartment_Id(int department_Id) {
			this.department_Id = department_Id;
		}

		public String getDepartment_name() {
			return department_name;
		}

		public void setDepartment_name(String department_name) {
			this.department_name = department_name;
		}

		public Number getManager_Id() {
			return manager_Id;
		}

		public void setManager_Id(Number manager_Id) {
			this.manager_Id = manager_Id;
		}

		@Override
		public String toString() {
			return "Departments [department_Id=" + department_Id + ", department_name=" + department_name
					+ ", manager_Id=" + manager_Id + "]";
		}
	    
}
