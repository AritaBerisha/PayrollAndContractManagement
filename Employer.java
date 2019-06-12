package Employer;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employer {

	private int id;
	private String position;
	private String dept;
	private int salary;
	
	
	public Employer(int id, String position, String dept, int salary) {
		this.id = id;
		this.position = position;
		this.dept = dept;
		this.salary = salary;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	