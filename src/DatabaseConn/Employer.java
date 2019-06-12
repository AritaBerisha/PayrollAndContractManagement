package DatabaseConn;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employer {

	private int id;
	private String position;
	private String dept;
	private int salary;
	private String BeginDate; 
	private String EndDate;
	
	
	public Employer(int id, String position, String dept, int salary,String BeginDate, String EndDate) {
		this.id = id;
		this.position = position;
		this.dept = dept;
		this.salary = salary;
		this.BeginDate=BeginDate;
		this.EndDate=EndDate;
		
	}
	
	public int getId() {
		return id;
	}
	
//	public void setId(int id) {
//		this.id = id;
//	}
	
	public String getBeginDate() {
		return BeginDate;
	}
	
//	public void setBeginDate(String beginDate) {
//		this.BeginDate = beginDate;
//	}
	public String getEndDate() {
		return EndDate;
	}
	
//	public void setEndDate(String endDate) {
//		this.EndDate = endDate;
//	}
	
	public String getPosition() {
		return position;
	}
	
//	public void setPosition(String position) {
//		this.position = position;
//	}
	
	public String getDept() {
		return dept;
	}
	public static boolean addEmployer(int id,String position, String dept, int salary,String BeginDate, String EndDate) {
		//String query = "INSERT INTO contracts(position, dept, salary) VALUES(?,?,?)";
		String query ="Insert into contracts(Contract_date_begin,Contract_date_due, job_title, department,EmpId,empSalary )"+
		         "values ('"+BeginDate+"','"+EndDate+"','"+position+"','"+dept+"','"+id+"','"+salary+"')";
		try {
			PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
			
			preparedStatement.executeUpdate();
			
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
	
	public int getSalary() {
		return salary;
	}
	
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
	
	public static boolean updateEmployer(int id, String position, String dept, int salary,String BeginDate, String EndDate) {
		String query ="Update contracts set Contract_date_begin='"+BeginDate+"', Contract_date_due='"+EndDate+"', job_title='"+position+"', department='"+dept+"',empSalary='"+salary+"' where EmpId='"+id+"'";                                 
		
		try {
			PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
			
			preparedStatement.executeUpdate();
			
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteEmployer(int id) {
		String query = "Delete from contracts where EmpId='"+id+"'";
		
		try {
			PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
			preparedStatement.executeUpdate();
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public static List<Employer> getEmployers() {
		List<Employer> EmployerList = new ArrayList();
		
		String query = "Select * from contracts";
		
		try {
			PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Employer Employer = new Employer(resultSet.getInt(5), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(6),  resultSet.getString(1),  resultSet.getString(2));
				EmployerList.add(Employer);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return EmployerList;
	}
}


	
	
