package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;
import com.sist.vo.DeptVO;

public class BookDAO {
	
	public ArrayList<BookVO> blist(){
		String sql = "select * from book";
		ArrayList<BookVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url,usr,pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
				System.out.println("ok");
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
