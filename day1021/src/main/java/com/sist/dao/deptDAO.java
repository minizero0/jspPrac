package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.deptVO;

public class deptDAO {
	final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USER = "c##madang";
	final String PWD = "madang";
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public deptDAO() {
		try {
			Class.forName(DRIVER_NAME);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	public int updateDept(deptVO dv, int dno1) {
		String sql = "update dept set dno = ?, dname = ?, dloc = ? where dno = ?";
		int re = 0;
		try {
		conn = DriverManager.getConnection(URL,USER,PWD);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dv.getDno());
		pstmt.setString(2, dv.getDname());
		pstmt.setString(3, dv.getDloc());
		pstmt.setInt(4, dno1);
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
	
	
	public int insertDept(deptVO dv) {
		String sql = "insert into dept(dno,dname,dloc) values(?,?,?)";
		int re = 0;
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dv.getDno());
			pstmt.setString(2, dv.getDname());
			pstmt.setString(3, dv.getDloc());
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
	
	
	public deptVO findByNo(int dno){
		deptVO d = null;
		String sql = "select * from dept where dno = ?";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				d = new deptVO();
				d.setDno(rs.getInt("dno"));
				d.setDname(rs.getString("dname"));
				d.setDloc(rs.getString("dloc"));
			}
			
		}catch (Exception e) {
			System.out.println("Exceoption" );
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
		return d;
	}
	
	public ArrayList<deptVO> findAll(){
		ArrayList<deptVO> list = new ArrayList<>();
		String sql = "select * from dept";
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				deptVO dv = new deptVO();
				dv.setDno(rs.getInt(1));
				dv.setDname(rs.getString(2));
				dv.setDloc(rs.getString(3));
				list.add(dv);
			}
			
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
			if(stmt!=null) {
				try {
				rs.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			if(conn!=null) {
				try {
				rs.close();
				}
			catch (Exception e) {
				System.out.println("Exception"+e.getMessage());
				}
			}
			
		}
		
		
		
		return list;
	}
}
