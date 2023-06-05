package com.rapportsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
	
	public static boolean checkUser(String email, String pass) throws ClassNotFoundException, SQLException
	{
		boolean st = false;
		
		try { 
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_login","root","root");
		
		PreparedStatement pst = con.prepareStatement("SELECT * FROM student WHERE email=? AND password=?");
		pst.setString(1,email);
		pst.setString(2, pass);
		
		ResultSet rs = pst.executeQuery();
		
		st = rs.next();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return st;

	}
}
