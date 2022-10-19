package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.DeptVO;

public class DeptDAO {
	//모든 부서 목록을 검색하여 ArrayList로 반환
	
	public ArrayList<DeptVO> list() {
		ArrayList<DeptVO> list = new ArrayList<>();
		String sql = "select * from dept";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url,usr,pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("오류발생:" + e.getMessage());
		}
		return list;
	}
}
