package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USER = "c##madang";
	final String PWD = "madang";
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BookDAO() {
		try {
		Class.forName(DRIVER_NAME);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public ArrayList<BookVO> listBook(){
		ArrayList<BookVO> list = new ArrayList<>();
		String sql = "select * from book";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BookVO bv = new BookVO();
				bv.setBookid(rs.getInt(1));
				bv.setBookname(rs.getString(2));
				bv.setPublisher(rs.getString(3));
				bv.setPrice(rs.getInt(4));
				list.add(bv);
			}
		}catch (Exception e) {
			System.out.println("예외:"+e.getMessage());
		}finally {
			if(rs!=null) {
				try {
				rs.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			if(pstmt!=null) {
				try {
				pstmt.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			if(conn!=null) {
				try {
				conn.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
		}
		
		return list;
	}
}
