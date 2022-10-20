package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.RegisterBean;

public class RegisterMgr {
	private final String JDBC_DRRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "c##madang";
	private final String PASS= "madang";
	
	public RegisterMgr() {
		try {
			Class.forName(JDBC_DRRIVER);
		}catch (Exception e) {
			System.out.println("JDBC DRIVER Exception" + e);
		}
	}
	
	public ArrayList<RegisterBean> getRegisterList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<RegisterBean> list = new ArrayList<>();
		try {
			String sql = "select * from tblRegister";
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				RegisterBean bean = new RegisterBean();
				
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setNum1(rs.getString("num1"));
				bean.setNum2(rs.getString("num2"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setJob(rs.getString("job"));
				list.add(bean);
			}
			
			
		}catch (Exception e) {
			System.out.println("Exception" + e);
		}finally {
			try {
				if(stmt!=null) 
					stmt.close();
			}catch (Exception e2) {
				System.out.println("Exception" +e2);
			}
			try {
				if(rs!=null) 
					rs.close();
			}catch (Exception e2) {
				System.out.println("Exception" +e2);
			}
			try {
				if(conn!=null) 
					conn.close();
			}catch (Exception e2) {
				System.out.println("Exception" +e2);
			}
		} 
			
		
		
		
		return list;
	}
}
