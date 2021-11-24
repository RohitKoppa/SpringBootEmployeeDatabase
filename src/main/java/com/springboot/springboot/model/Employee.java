package com.springboot.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long uid;
	

	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull
	@Column(name = "salary")
	private double salary;
	
	@NotNull
	@Column(name = "mobileNo")
	private long mobileNo;

	
	
	public Employee(String email, String firstName, String lastName, double salary, long mobileNo) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.mobileNo = mobileNo;
	}
	
	
	public Employee() {
		
	}
	
	public long getUid() {
		return uid;
	}


	public void setUid(long uid) {
		this.uid = uid;
	}
//	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	

}
