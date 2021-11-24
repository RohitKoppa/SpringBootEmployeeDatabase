package com.springboot.springboot.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.EmployeeDao;
import com.springboot.springboot.exception.EmployeeNotFoundForThisUid;
import com.springboot.springboot.model.Employee;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeDao employeeDao;


	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}


	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		return employee;
	}
	@Override
	public void deleteEmployeeById(long uid) {
		employeeDao.deleteById(uid);
		
	}

//	@Override
//	public void deleteEmployee(String email) {
//		Employee entity=employeeDao.getOne(email);
//		employeeDao.delete(entity);
//		// TODO Auto-generated method stub
//
//	}
//
//
//
//	@Override
//	public Optional<Employee> getEmployee(String email) {
//		//return employeeDao.getOne(email);
//		return employeeDao.findById(email);
//	}


//	@Override
//	public void updateEmployee(Employee employee) {
//		employeeDao.save(employee);
//	
//	
//	}


//@Override
//public Employee findEmployeeById(long uid)  {
//	Employee e= employeeDao.findById(uid).orElseGet(null);
//	
//	if(e!=null){
//		System.out.println("hibro+++++++++");
//		return e;
//	}
//	else {
//		System.out.println("byebro____________");
//		//throw new EmployeeNotFoundForThisUid("No Employee is available for this"+uid);
//	}
//	return e;
//}





}




