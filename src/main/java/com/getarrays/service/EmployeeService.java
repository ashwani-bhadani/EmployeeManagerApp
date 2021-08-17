package com.getarrays.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getarrays.exception.UserNotFoundException;
import com.getarrays.model.Employee;
import com.getarrays.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee emp) {
		emp.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(emp);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public Employee findEmployeeById(Long id) {
		//using Java8 feature, made method optional return type in repository intef.
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User with id: "+id+"with us. Check data again!" ));
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	
}
