package com.springboot.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.dao.EmployeeDao;
import com.springboot.springboot.exception.EmployeeNotFoundForThisUid;
import com.springboot.springboot.exception.ResourceNotFoundException;
import com.springboot.springboot.model.Employee;
import com.springboot.springboot.services.EmpService;

@RestController
public class MyController {
	
@Autowired
private EmpService empService;
@Autowired
private EmployeeDao employeeDao;

	@GetMapping("/Employees")
	public List<Employee> getEmployees(){
		return this.empService.getEmployees();
		
	}
	

	@PostMapping("/Employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.empService.addEmployee(employee);
		
	}
	
	@DeleteMapping("/Employees/{uid}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long uid){
		Employee existing=this.employeeDao.findById(uid)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with uid"+uid)); 
		this.employeeDao.delete(existing);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/Employees/{uid}")
	public Employee getEmployee(@PathVariable long uid) {

		return this.employeeDao.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with uid "+uid));
		
        
	}
	@PutMapping("/Employees/{uid}")
	public void updateEmployees(@RequestBody Employee employee,@PathVariable long uid) {
		Employee existing=employeeDao.findById(uid)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found with uid"+uid));
		existing.setEmail(employee.getEmail());
		existing.setFirstName(employee.getFirstName());
		existing.setLastName(employee.getLastName());
		existing.setMobileNo(employee.getMobileNo());
		existing.setSalary(employee.getSalary());
		employeeDao.save(existing);
		
		
		
		
		
		
//		Employee employe = empService.findEmployeeById(uid);
//		try {
//		if(employee!=null) 
//			 employeeDao.save(employee);
//		}catch(NullPointerException n) {
//			n.getMessage();
//		}
//		}else {
//			throw new RuntimeException("Employee not found for the id "+uid);
//		}
	}
	
//	@PostMapping("/Employees/{uid}")
//	public Employee updateEmployee(@RequestBody Employee employee) {
//		return this.empService.updateEmployee(employee);
//		
//	}
	
//	@PutMapping("/Employees")
//	public void updateEmployees(@RequestBody Employee employee) {
//		employeeDao.save(employee);
//		
//	}
	
	
	

}





