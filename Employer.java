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
		
	public static boolean addEmployer(String position, String dept, int salary) {
		String query = "INSERT INTO Employers(position, dept, salary) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, position);
			preparedStatement.setString(2, dept);
			preparedStatement.setInt(3, salary);
			
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
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
	
	public static boolean updateEmployer(int id, String position, String dept, int salary) {
		String query = "UPDATE Employers SET position=?, dept=?, salary=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, position);
			preparedStatement.setString(2, dept);
			preparedStatement.setInt(3, salary);
			preparedStatement.setInt(4, id);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteEmployer(int id) {
		String query = "Delete from Employers where id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public static List<Employer> getEmployers() {
		List<Employer> EmployerList = new ArrayList();
		
		String query = "Select * from Employers";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Employer Employer = new Employer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
				EmployerList.add(Employer);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return EmployerList;
	}
}


	
	
