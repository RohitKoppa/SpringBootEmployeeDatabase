package com.springboot.springboot.dao;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springboot.model.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
Optional<Employee> findByEmail(String email);




}






//List<Employee> findAll();

	//Employee getById(String email);