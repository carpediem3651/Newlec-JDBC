package com.newlecture.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@db.newlecture.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "RLAND", "0530");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			
			if(age < 200) {
				System.out.printf("name:%s, age:%d\n", name, age);
			}
			
		}
				
		rs.close();
		st.close();
		con.close();
	}
}
