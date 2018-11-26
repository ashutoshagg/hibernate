package com.ashutosh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_url="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("connecting to databse: " + jdbc_url);
			Connection conn = DriverManager.getConnection(jdbc_url, user, password);
			System.out.println("connection successful");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
