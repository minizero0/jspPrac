package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.MemberVO;

public class MemberDAO1 {
	//MemberVO를 매개변수로 전달받아 레코드 추가하는 메소드
	int re = 0;
	public int insertMember(MemberVO m) {
		
		
		try {
			String sql = "insert into member(id,pwd,name) values(?,?.?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url,usr,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			re = pstmt.executeUpdate();
			
			if(pstmt != null)
				pstmt.close();
			
			if(conn != null)
				conn.close();
			
			
		}catch (Exception e) {
			System.out.println("오류발생" +e.getMessage());
		}
		return re;
	}
}
