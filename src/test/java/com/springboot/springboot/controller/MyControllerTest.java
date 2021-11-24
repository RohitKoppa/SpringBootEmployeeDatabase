package com.springboot.springboot.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.springboot.springboot.dao.EmployeeDao;
import com.springboot.springboot.model.Employee;
import com.springboot.springboot.services.EmpService;
import com.springboot.springboot.services.EmpServiceImpl;
//@WebAppConfiguration
//@SpringBootTest(classes=MyController.class)
@RunWith(SpringJUnit4ClassRunner.class)

@WebMvcTest(MyController.class)
public class MyControllerTest {

	@Autowired
	private transient MockMvc mockMvc;//It encapsulates all web application beans 
	//and makes them available for testing
	
	@MockBean
	private EmployeeDao employeeDao;
	@InjectMocks
	private transient MyController myController;

	@MockBean
	private transient EmpService empService;


	private transient Employee employList;



	//ObjectMapper obj=new ObjectMapper();

	@BeforeEach
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		long mobileNo = 1144512;
		double salary = 114451.2;
		String email ="rohit@123";
		String firstName="rohit";
		String lastName="koppa";
		//long id = 123;
		this.employList = new Employee(email, firstName, lastName, salary, mobileNo );
	}


	@org.junit.jupiter.api.Test
	public void getEmployees() throws Exception {
		List<Employee> employee = new ArrayList<Employee>();
		employee.add(employList);
		when(empService.getEmployees()).thenReturn(employee);
		MvcResult result = mockMvc.perform(get(
				"/Employees")
				.accept(
						MediaType.APPLICATION_JSON)
				.header("Content-type",MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String empData = result.getResponse().getContentAsString();
		DocumentContext context = JsonPath.parse(empData);
		int length = context.read("$.length()");
		assertEquals(length ,employee.size());
	}


	@org.junit.jupiter.api.Test
	public void addEmployee() throws Exception{
		Employee emp=new Employee("rohit@123", "rohit", "koppa", 45564544, 3456778 );
		when(empService.addEmployee(emp)).thenReturn(employList);
		Employee addedEmp = empService.addEmployee(emp);

		assertNotNull(addedEmp);

		//    	List<Employee> employee = new ArrayList<Employee>();
		//        employee.add(employList);
		//    	when(empService.addEmployee(employList)).thenReturn(employList);
		//    	MvcResult result = mockMvc.perform(post(
		//                "/Employees").accept(
		//                MediaType.APPLICATION_JSON)
		//    			.header("Content-type",MediaType.APPLICATION_JSON))
		//                .andExpect(status().isOk()).andReturn();
		//        String empData = result.getResponse().getContentAsString();
		//        DocumentContext context = JsonPath.parse(empData);
		//        int length = context.read("$.length()");
		//        assertEquals(length , employee.size());
	}




























	//    private String jsonToString(final Object obj1) throws JsonProcessingException {
	//        String result;
	//        try {
	//          final ObjectMapper mapper = new ObjectMapper();
	//          final String message = mapper.writeValueAsString(obj1);
	//          result = message;
	//        } catch (JsonProcessingException e) {
	//          result = "Json processing error";
	//        }
	//
	//        return result;
	//      }
	//    
	//    @Before
	//    public void setupMock1() {
	//      MockitoAnnotations.initMocks(this);
	//      this.employList = new Employee("rohit@123", "poovi", "poovalagan", 23456.6,456789456);
	//      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	//      try {
	//  		String json = ow.writeValueAsString(this.employList);
	//  	} catch (JsonProcessingException e) {
	//  		// TODO Auto-generated catch block
	//  		e.printStackTrace();
	//  	}
	//    }


	//    @org.junit.jupiter.api.Test
	//    public void addEmployee() throws Exception{
	//      when(empServiceImpl.addEmployee(employList)).thenReturn(employList);
	//      mockMvc.perform(post("/Employees").contentType(MediaType.APPLICATION_JSON)
	//        .accept(MediaType.APPLICATION_JSON)
	//        .content(jsonToString(employList)))
	//        .andExpect(status().isCreated())
	//        .andDo(print());
	//
	//      verify(empServiceImpl, times(1)).addEmployee(Mockito.any(Employee.class));
	//      verifyNoMoreInteractions(empServiceImpl);
	//    }

	//	@org.junit.jupiter.api.Test
	//	public void addEmployee() throws Exception {
	//		Employee employee=new Employee();
	//		employee.setEmail("rohit@123");
	//		employee.setFirstName("rohit");
	//		employee.setLastName("koppa");
	//		employee.setMobileNo(991432545);
	//		employee.setSalary(553544.6);
	//
	//		String JsonRequest=obj.writeValueAsString(employee);
	//		MvcResult result= mockMvc.perform(post("/Employee").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
	//				.andExpect(status().isOk()).andReturn();
	//		String resultContext=result.getResponse().getContentAsString();
	//		Employee  response = obj.readValue(resultContext, Employee.class);
	//		Assert.assertTrue(response.getEmail().isEmpty()==Boolean.FALSE);
	//	}

	//		@org.junit.jupiter.api.Test
	//		public void testAddEmployees() throws Exception {
	//			mockMvc.perform(
	//				MockMvcRequestBuilders.post("/Employees"))
	//				.andExpect(MockMvcResultMatchers.status().isOk());
	//		}


}
