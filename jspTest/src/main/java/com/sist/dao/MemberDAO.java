package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MemberDAO {
	
	public static void insertAdmin() {
		String sql = "insert into member values('admin','admin1234','관리자')";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			Connection conn = DriverManager.getConnection(url,usr,pwd);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteAdmin() {
		String sql = "delete member where id = 'admin'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			Connection conn = DriverManager.getConnection(url,usr,pwd);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
