package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVO;


public class MemberDAO1 {
	
	public MemberVO findById(String id) {
		MemberVO b = null;
		try {
			String sql = "select * from member where id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return b;
	}
	
	
	public ArrayList<MemberVO> findAll(){
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "select * from member";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	public boolean isMember(String id, String pwd) {
		boolean re = false;
		String sql = "select * from member where id = ? and pwd = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("에러발생:"+e.getMessage());
		}
		return re;
	}
	
	
	
	//MemberVO를 매개변수로 전달받아 레코드 추가하는 메소드
	public int insertMember(MemberVO m) {
		int re = 0;
		try {
			String sql = "insert into member(id,pwd,name) values(?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
					"c##madang", "madang");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			
			re = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}
