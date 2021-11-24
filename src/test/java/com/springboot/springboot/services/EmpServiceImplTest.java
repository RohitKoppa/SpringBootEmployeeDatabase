package com.springboot.springboot.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.springboot.springboot.controller.MyController;
import com.springboot.springboot.dao.EmployeeDao;
import com.springboot.springboot.model.Employee;


@SpringBootTest
public class EmpServiceImplTest {
	@Autowired
	private EmpServiceImpl empserviceImpl;

	@MockBean
	private EmployeeDao employeeDao;
	@InjectMocks
	private transient MyController myController;

	@Test
	public void getEmployeesTest() {
		when(employeeDao.findAll()).
		thenReturn(Stream.of(new Employee("jaguar@321","abc","cba", 3.5454567E7,467543433))
				.collect(Collectors.toList()));
		assertEquals(1, empserviceImpl.getEmployees().size());

	}

	@Test

	public void addEmployeeTest(){
		Employee employee =new Employee("Audi@321","abc","cba", 35.4567E7,467543433);
		when(employeeDao.save(employee)).thenReturn(employee);
		assertEquals(employee,empserviceImpl.addEmployee(employee) );
	}
	@Test
	public void deleteEmployee(){
		Employee emp= new Employee("Audi@321","abc","cba", 35.4567E7,467543433);
		employeeDao.save(emp);
		//List<Employee> emp2=employeeDao.findAll();
		//int size=empserviceImpl.getEmployees().size();
		//System.out.println(size);
		employeeDao.deleteById(1L);
		Employee emp1=null;
		Optional<Employee> optionalEmployee =employeeDao.findByEmail("Audi@321");
		System.out.println(optionalEmployee.isEmpty());

		if(optionalEmployee.isPresent()) {
			emp1=optionalEmployee.get();
		}
		Assertions.assertThat(emp1).isNull();
	}
	@Test
	public void addEmployee() {
		Employee emp= new Employee("VishweshwarayyaTechnology@32","ranga","banglore", 35.4567E7,467543433);
		String s=emp.getEmail();
		System.out.println(s.length());
		if(s.length()<=20) {
		employeeDao.save(emp);
		}else {
			emp=null;
		}
		Assertions.assertThat(emp).isNull();
		
	}
	@Test
	public void update() {
		Employee emp= new Employee("Audi@321","abc","cba", 35.4567E7,467543433);
		employeeDao.save(emp);
	
		emp.setEmail("karthik@gmail.com");
		emp.setFirstName("karthik");
		employeeDao.save(emp);
//		Optional<Employee> optionalEmployee =employeeDao.findByEmail("Audi@321");
//		System.out.println("djgkdfkdkkflf");
//		System.out.println(optionalEmployee.isPresent());
		//optionalEmployee.("WWW@12");
		//Employee empupdate=employeeDao.save(optionalEmployee);
		Assertions.assertThat(emp.getEmail()).isEqualTo("karthik@gmail.com");
	}
	
	
	
	
	
	
	
	
	//private transient Employee employList;

//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//		long mobileNo = 1144512;
//		double salary = 114451.2;
//		String email ="rohit@123";
//		String firstName="rohit";
//		String lastName="koppa";
//		long id = 123;
//		this.employList = new Employee(id,email, firstName, lastName, salary, mobileNo );
//	}
	
	//@Test
	//public void getEmployee() {
//		List<Employee> employee = new ArrayList<Employee>();
//		employee.add(employList);
		//employeeDao.save(employList);
		//when(employeeDao.findById(123l)).thenReturn(employee);
//		Employee emp= new Employee("Rajarammohan@321","abc","cba", 35.4567E7,467543433);
//		employeeDao.save(emp);
//		emp.setUid(9000L);
//		employeeDao.save(emp);
//		 //long x=emp.getUid();
//		System.out.println(emp.getUid());
//		System.out.println(emp.getEmail());
		//Employee optionalEmployee =employeeDao.findById(123L).get();
		//System.out.println(optionalEmployee.getFirstName());
	
//		if(optionalEmployee.) {
//			emp1=optionalEmployee.get();
//		}
		//Assertions.assertThat(optionalEmployee).isNotNull();
//		Employee employee =new Employee("Audi@321","abc","cba", 35.4567E7,467543433);
//		when(employeeDao.save(employee)).t;
//		assertEquals(employee,empserviceImpl.addEmployee(employee) );			
	}
//	

	
	




