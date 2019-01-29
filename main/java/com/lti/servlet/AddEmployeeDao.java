package com.lti.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.lti.dto.Employee5;

public class AddEmployeeDao {

	//public void insert(int empno,String name,double salary)
	public void insert(Employee5 emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;//precompiled sql statements
		try	{
			//why not FileInputStream is = new FileInputStream("dev-db.properties")
			
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			
			Properties dbProps = new Properties();
			dbProps.load(is);
			String driverClassName = dbProps.getProperty("driverClassName");
			String url = dbProps.getProperty("url");
			String username =dbProps.getProperty("username");
			String password = dbProps.getProperty("password");			
			
			
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
			pstmt = conn.prepareStatement("insert into emp1 values(?,?,?)");
			pstmt.setInt(1, emp.getEmpno());
		    pstmt.setString(2, emp.getName());
		    pstmt.setDouble(3, emp.getSalary());
		    pstmt.executeUpdate();
		
		}
		   catch(ClassNotFoundException | SQLException | IOException e1 ) {
	       e1.printStackTrace();
		}
		finally
		{
			try {pstmt.close();}catch(Exception e1) { } 
			try {conn.close();}catch(Exception e1) {}
		}
	}
}