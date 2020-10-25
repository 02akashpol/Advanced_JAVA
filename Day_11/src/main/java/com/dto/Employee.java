package com.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int empId;
	private String empName;
	private float basicSalary;
	private String dept;
	private Date joinDate;
	
	public Employee() {
	
		super();
	}

	public Employee(int empId, String empName, float basicSalary, String dept, Date joinDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.basicSalary = basicSalary;
		this.dept = dept;
		this.joinDate = joinDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getDate() {
		return joinDate;
	}

	public void setDate(Date date) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return empId + " " + empName + " " + basicSalary + " " + dept + " " + joinDate;
	}
	
}
