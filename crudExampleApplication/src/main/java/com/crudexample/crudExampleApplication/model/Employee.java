package com.crudexample.crudExampleApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_data")
public class Employee {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="employee_id")
private Integer employeeId;

@Column(name="name")
private String Name;

@Column(name="email")
private String email;



public Integer getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(Integer employeeId) {
	this.employeeId = employeeId;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



}
