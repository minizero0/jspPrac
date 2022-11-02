package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.BookVO;
import com.sist.vo.DeptVO;

public class BookDAO {
	private static BookDAO dao;
	
	public static BookDAO getInstance() {
		if(dao == null) 
			dao = new BookDAO();
		return dao;
	}
	
	
	private BookDAO() {
		
	}
	
	public BookVO findByBookid(int bookid) {
		BookVO bv = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from book where bookid = ?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bv = new BookVO();
				bv.setBookid(rs.getInt("bookid"));
				bv.setBookname(rs.getString("bookname"));
				bv.setPublisher(rs.getString("publisher"));
				bv.setPrice(rs.getInt("price"));
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(pstmt!=null) {try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
		return dv;
	}
	
	
	public ArrayList<BookVO> findAll(){
		ArrayList<BookVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from book";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BookVO bv = new BookVO();
				bv.setBookid(rs.getInt("bookid"));
				bv.setBookname(rs.getString("bookname"));
				bv.setPublisher(rs.getString("publisher"));
				bv.setPrice(rs.getInt("price"));
				list.add(bv);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(stmt!=null) {try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(rs!=null) {try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return list;
	}
	
}
