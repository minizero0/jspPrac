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
	
	public int deleteBook(int bookid) {
		int re = 0;
		String sql = "delete book where bookid = ?";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			re = pstmt.executeUpdate();
			
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
		
		return re;
	}
	
	public int updateBook(BookVO bv) {
		int re = 0;
		String sql = "update book set bookname = ?,publisher = ?,price=? where bookid = ?";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBookname());
			pstmt.setString(2, bv.getPublisher());
			pstmt.setInt(3, bv.getPrice());
			pstmt.setInt(4, bv.getBookid());
			re = pstmt.executeUpdate();
			
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
		
		return re;
		
	}
	
	
	public int insertBook(BookVO bv) {
		int re = 0;
		String sql = "insert into book values(?,?,?,?)";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bv.getBookid());
			pstmt.setString(2, bv.getBookname());
			pstmt.setString(3, bv.getPublisher());
			pstmt.setInt(4, bv.getPrice());
			re = pstmt.executeUpdate();
			
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
		
		return re;
	}
	
	
	public BookVO findById(int bookid) {
		BookVO bv = null;
		String sql = "select * from book where bookid = ?";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bv = new BookVO();
				bv.setBookid(rs.getInt(1));
				bv.setBookname(rs.getString(2));
				bv.setPublisher(rs.getString(3));
				bv.setPrice(rs.getInt(4));
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
		return bv;
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
