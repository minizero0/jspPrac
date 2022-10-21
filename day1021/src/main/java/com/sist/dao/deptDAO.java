package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.deptVO;

public class deptDAO {
	final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USER = "c##madang";
	final String PWD = "madang";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public deptDAO() {
		try {
			Class.forName(DRIVER_NAME);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	
	
	public ArrayList<deptVO> findAll(){
		ArrayList<deptVO> list = new ArrayList<>();
		String sql = "select * from dept";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				deptVO dv = new deptVO();
				dv.setDno(rs.getInt(1));
				dv.setDname(rs.getString(2));
				dv.setDloc(rs.getString(3));
				list.add(dv);
			}
			
		}catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}finally {
			if(rs!=null) {
				try {
				rs.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			if(stmt!=null) {
				try {
				rs.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			if(conn!=null) {
				try {
				rs.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			
		}
		
		
		
		return list;
	}
}
