package Employer;


import java.sql.*;

public class DBConnection {

	private static Connection dbConnection;
	
	private final static String host = "localhost";
	private final static String dbName = "employer";
	private final static String username = "root";
	private final static String password = "nihon123";
	
	