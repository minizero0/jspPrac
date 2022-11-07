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

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public class EmpDAO {
	private static EmpDAO dao;
	
	public static EmpDAO getInstance() {
		if (dao == null)
			dao = new EmpDAO();
		return dao;
	}
	
	private EmpDAO() {
		
	}
	
	//사원번호로 사원찾기
		public ArrayList<EmpVO> findByDno(int dno) {
			ArrayList<EmpVO> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from emp where dno = ?";
			try {
				Context context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dno);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					EmpVO ev = new EmpVO();
					ev.setEno(rs.getInt("eno"));
					ev.setEname(rs.getString("ename"));
					ev.setDno(rs.getInt("dno"));
					ev.setSalary(rs.getInt("salary"));
					ev.setPhone(rs.getString("phone"));
					ev.setEmail(rs.getString("email"));
					list.add(ev);
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
			
			return list;
		}
	
	//사원번호로 사원찾기
	public EmpVO findByEno(int eno) {
		EmpVO ev = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp where eno = ?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ev = new EmpVO();
				ev.setEno(rs.getInt("eno"));
				ev.setEname(rs.getString("ename"));
				ev.setDno(rs.getInt("dno"));
				ev.setSalary(rs.getInt("salary"));
				ev.setPhone(rs.getString("phone"));
				ev.setEmail(rs.getString("email"));
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
		
		return ev;
	}
	
	public ArrayList<EmpVO> findAll(){
		ArrayList<EmpVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				EmpVO ev = new EmpVO();
				ev.setEno(rs.getInt("eno"));
				ev.setEname(rs.getString("ename"));
				ev.setDno(rs.getInt("dno"));
				ev.setSalary(rs.getInt("salary"));
				list.add(ev);
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
