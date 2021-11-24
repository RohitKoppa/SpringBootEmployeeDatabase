package com.springboot.springboot.services;

import java.util.List;
import java.util.Optional;

import com.springboot.springboot.exception.EmployeeNotFoundForThisUid;
import com.springboot.springboot.model.Employee;

public interface EmpService {

	public List<Employee> getEmployees();
	public Employee addEmployee(Employee employee);


	//public Employee findEmployeeById(long uid) ;//g
	public void deleteEmployeeById(long uid);//g

	

	//public void updateEmployee(Employee employee);
	

	//void deleteEmployee(String email);
	//Optional<Employee> getEmployee(String email);






}







//public Optional<Employee> getEmployee(String email);
//public Employee updateEmployee(Employee employee);



//void deleteEmployee(String email);

//public void deleteEmployee(String email);

