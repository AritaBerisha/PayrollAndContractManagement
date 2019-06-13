package DatabaseConn;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employer {

	private int EmpId;
	private String job_title;
	private String department;
	private int empSalary;
	private String Contract_date_begin; 
	private String Contract_date_due;
	
	
	public Employer(int EmpId, String job_title, String department, int empSalary,String Contract_date_begin, String Contract_date_due) {
		this.EmpId = EmpId;
		this.job_title = job_title;
		this.department = department;
		this.empSalary = empSalary;
		this.Contract_date_begin=Contract_date_begin;
		this.Contract_date_due=Contract_date_due;
		
	}
	
	public int getEmpId() {
		return EmpId;
	}
	
	public void setEmpId(int EmpId) {
		this.EmpId = EmpId;
	}
	
	public String getContract_date_begin() {
		return Contract_date_begin;
	}
	
	public void setContract_date_begin(String Contract_date_begin) {
		this.Contract_date_begin = Contract_date_begin;
	}
	public String getContract_date_due() {
		return Contract_date_due;
	}
	
	public void setContract_date_due(String Contract_date_due) {
		this.Contract_date_due = Contract_date_due;
	}
	
	public String getJob_title() {
		return job_title;
	}
	
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	
	public String getDepartment() {
		return department;
	}

	
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getEmpSalary() {
		return empSalary;
	}
	
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
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


	
	
