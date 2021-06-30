package com.crudexample.crudExampleApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;  

import com.sun.istack.NotNull;

@Entity
@Table(name="employee_data")
public class Employee {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="employee_id")
private Integer employeeId;

@Column(name="name")
@NotBlank(message="name cannot be blank")
@Size(min=2,max=25,message="name should be between 2 to 25 characters")  
private String Name;

@NotBlank(message="email cannot be blank")
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
