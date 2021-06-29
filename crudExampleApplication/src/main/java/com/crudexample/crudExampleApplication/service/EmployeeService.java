package com.crudexample.crudExampleApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crudexample.crudExampleApplication.model.Employee;
import com.crudexample.crudExampleApplication.repository.EmployeeRepository;

import ch.qos.logback.classic.Logger;


@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository empRepository;
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());



	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		try {
			empRepository.findAll().forEach(e -> list.add(e));
			return list;
		} catch (Exception e) {
			logger.error("error occured while retreiving employees");
		}
		return list;
	}

	public Employee getEmployeeById(Integer employeeId) {
		Employee emp = new Employee();
		try {
		 emp = empRepository.findById(employeeId).get();
		return emp;
		} catch (Exception e) {
			logger.error("error occured while retreiving user by id {}",employeeId);
		}
		return emp;
	}	
	
	public ResponseEntity<Employee> getEmployee(Integer employeeId) {
		Employee emp = empRepository.findById(employeeId).get();
		if (emp != null){
			return new ResponseEntity<Employee>(emp,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}

	public synchronized boolean addEmployee(Employee emp){
		try {
        List<Employee> list = empRepository.findAllByEmail(emp.getEmail()); 	
            if (list.size() > 0) {
	           return false;
            } else {
	        empRepository.save(emp);
	        return true;
            }
		} catch (Exception e) {
			logger.error("error occured while saving employee {}",emp.getEmail()+" "+emp.getName());
		}
		return false;
	}

	public void updateEmployee(Employee emp) {
		try {
		empRepository.save(emp);
		}
		catch (Exception e) {
			logger.error("error occured while updating data {}",emp.getEmail()+" "+emp.getEmployeeId());
		}
	}
	
	public void deleteEmployee(Integer employeeId) {
		try
		{
			empRepository.delete(getEmployeeById(employeeId));
		} catch (Exception e) {
			logger.error("error occured while deleting employee {}",employeeId);
		}
	}
	

	
	
	
	
}
