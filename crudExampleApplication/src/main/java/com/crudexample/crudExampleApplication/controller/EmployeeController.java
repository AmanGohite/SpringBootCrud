package com.crudexample.crudExampleApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crudexample.crudExampleApplication.model.Employee;
import com.crudexample.crudExampleApplication.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController{
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping(value="/")
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployee();
		
	}
	

	
	@GetMapping(value="/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Integer employeeId) {
		return empService.getEmployee(employeeId);
	}
	
	
	@PostMapping(value="/")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp, UriComponentsBuilder builder) {
		boolean flag = empService.addEmployee(emp);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/article/{id}").buildAndExpand(emp.getEmployeeId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	@PutMapping(value="/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		empService.updateArticle(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping(value="employee/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Integer id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
