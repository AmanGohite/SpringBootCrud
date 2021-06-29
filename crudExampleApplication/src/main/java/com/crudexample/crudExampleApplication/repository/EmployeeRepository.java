package com.crudexample.crudExampleApplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crudexample.crudExampleApplication.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>  {

	List<Employee> findAllByEmail(String email);

}
