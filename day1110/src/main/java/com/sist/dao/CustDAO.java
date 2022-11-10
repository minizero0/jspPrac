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

import com.sist.vo.CustVO;

public class CustDAO {
private static CustDAO dao;
	
	public static CustDAO getInstance() {
		if(dao == null) 
			dao = new CustDAO();
		return dao;
	}
	
	
	private CustDAO() {
		
	}
	
	
	
	public int addCust(CustVO cv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into educust values(seq_id.nextval,?,?,?,?)";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cv.getName());
			pstmt.setString(2, cv.getGender());
			pstmt.setString(3, cv.getLoc());
			pstmt.setString(4, cv.getBlood());
			re = pstmt.executeUpdate();
			
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
		}
		
		
		return re;
	}
	
	
	public ArrayList<CustVO> listCust(){
		ArrayList<CustVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from educust";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				CustVO cv = new CustVO();
				cv.setId(rs.getInt("id"));
				cv.setName(rs.getString("name"));
				cv.setGender(rs.getString("gender"));
				cv.setLoc(rs.getString("loc"));
				cv.setBlood(rs.getString("blood"));
				list.add(cv);
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
