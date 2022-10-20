package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.RegisterBean;
import com.sist.vo.deptBean;

public class deptMGR {
	private final String JDBC_DRRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "c##madang";
	private final String PASS= "madang";
	
	public deptMGR() {
		try {
			Class.forName(JDBC_DRRIVER);
		}catch (Exception e) {
			System.out.println("JDBC DRIVER Exception" + e);
		}
	}
	
	public ArrayList<deptBean> getDeptList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<deptBean> list = new ArrayList<>();
		try {
			String sql = "select * from dept";
			conn = DriverManager.getConnection(JDBC_URL, USER,PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				deptBean db = new deptBean();
				db.setDno(rs.getInt(1));
				db.setDname(rs.getString(2));
				db.setDloc(rs.getString(3));
				list.add(db);
			}
		}catch (Exception e) {
			// TODO: handle exception
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
