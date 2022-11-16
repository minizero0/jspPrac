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
import com.sist.vo.EmpVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.SmemberVO;

public class SmemberDAO {
private static SmemberDAO dao;
	
	public static SmemberDAO getInstance() {		//singleton 생성방식
		if(dao == null)
			dao = new SmemberDAO();
		return dao;
	}
	
	private SmemberDAO() {
		
	}
	
	public int insertSmember(SmemberVO sv) {
		int re = -1;
		String sql = "insert into smember(no,name,age,addr) values(seq_smember.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds =(DataSource) context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sv.getName());
			pstmt.setInt(2, sv.getAge());
			pstmt.setString(3, sv.getAddr());
			re = pstmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {			
			if(pstmt != null) { try{pstmt.close();}catch(Exception e) {} }
			if(conn != null) { try{conn.close();}catch(Exception e) {} }
		}				
		return re;
	}
	
	
	public ArrayList<SmemberVO> findAll(){
		ArrayList<SmemberVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				SmemberVO sv = new SmemberVO();
				sv.setNo(rs.getInt("no"));
				sv.setName(rs.getString("name"));
				sv.setAge(rs.getInt("age"));
				sv.setAddr(rs.getString("addr"));
				list.add(sv);
				
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
