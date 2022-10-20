package com.sist.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sist.db.ConnectionProvider;

public class DriverTest {
	public static void main(String[] args) {
		Connection conn;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			conn = DriverManager.getConnection(url,usr,pwd);
			System.out.println("success");
		}catch (SQLException e) {
			System.out.println("SQL예외발생:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
