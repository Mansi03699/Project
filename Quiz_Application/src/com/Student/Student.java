package com.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Student {
	static int marks;
	int studentid;
	int id;
	static int mark;
	public static void main(String[] args) {
		Student s = new Student();
	
	Scanner sc = new Scanner (System.in);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/quizgame","root","mannu");
		java.sql.Statement smt = con.createStatement();
		System.out.println("For Marks enter your ID");
		int studentid = sc.nextInt();
        String sql = "Select marks,id from details"; 
        String sql2 = "Select * from grades";
		ResultSet rs = smt.executeQuery(sql);
		while (rs.next()) {
			
			marks = rs.getInt("marks");
			s.id = rs.getInt("id");
			if(s.id == studentid) { 
			System.out.println("Marks :" + marks );
			mark = marks;
			}
		}	
		Connection cone =DriverManager.getConnection("jdbc:mysql://localhost:3306/classes","root","mannu");
		PreparedStatement ps = cone.prepareStatement("select * from class");
		ResultSet rst = ps.executeQuery();
		while (rst.next()) {
			int getmark = rst.getInt("marks");
			 String str =rst.getString("grades");
			if(getmark==mark) { 
			System.out.println("Class : " + str );
			if(str.equals("D")) {
				System.out.println("Fail");
			}
			}
		}	 	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
			
		
		
		  
	}
		
	


		
		
	
	


