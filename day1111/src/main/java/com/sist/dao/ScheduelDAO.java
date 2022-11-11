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

import com.sist.vo.ChatMessageVO;
import com.sist.vo.ScheduelVO;

public class ScheduelDAO {
private static ScheduelDAO dao;

	public static ScheduelDAO getInstance() {
		if(dao == null) 
			dao = new ScheduelDAO();
		return dao;
	}
	
	private ScheduelDAO() {
		
	}
	
	public int addCust(ScheduelVO cv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into scheduel values(seq_scheduel.nextval,?,?)";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cv.getName());
			pstmt.setString(2, cv.getDay());
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
	
	public ArrayList<ScheduelVO> findAll(){
		ArrayList<ScheduelVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from scheduel";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ScheduelVO gv = new ScheduelVO();
				gv.setNo(rs.getInt("no"));
				gv.setName(rs.getString("name"));
				gv.setDay(rs.getString("day"));
				list.add(gv);
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
