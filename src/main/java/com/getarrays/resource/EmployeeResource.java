package com.getarrays.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getarrays.model.Employee;
import com.getarrays.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	private final EmployeeService empService;
	
	public EmployeeResource(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = empService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
		Employee empFound = empService.findEmployeeById(id);
		return new ResponseEntity<>(empFound, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee empAdded = empService.addEmployee(emp);
		return new ResponseEntity<>(empAdded, HttpStatus.CREATED);
	}
	
	@PutMapping ("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee empUpdated = empService.addEmployee(emp);
		return new ResponseEntity<>(empUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
		empService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}




















