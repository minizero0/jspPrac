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

import com.sist.vo.CustomerVO;

public class CustomerDAO {
	
	public int updateCustomer(CustomerVO cv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update customer set name = ?, address = ?, phone = ? where custid = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cv.getName());
			pstmt.setString(2, cv.getAddress());
			pstmt.setString(3, cv.getPhone());
			pstmt.setInt(4, cv.getCustid());
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		}
		
		
		
		return re;
	}
	
	public int deleteCustomer(int custid) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete customer where custid = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		}
		return re;
				
	}
	
	
	public int insertCustomer(CustomerVO cv) {
		int i = 0;
		String sql = "insert into customer values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cv.getCustid());
			pstmt.setString(2, cv.getName());
			pstmt.setString(3, cv.getAddress());
			pstmt.setString(4, cv.getPhone());
			i = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		}
		
		
		return i;
		
	}
	
	public CustomerVO findByCustid(int custid){
		CustomerVO c= null;
		String sql = "select * from customer where custid = ?";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				c = new CustomerVO();
				c.setCustid(rs.getInt("custid"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs != null) {try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(stmt != null) {try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(pstmt != null) {try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		}
		return c;
	}
	
	public ArrayList<CustomerVO> findAll(){
		ArrayList<CustomerVO> list = new ArrayList<>();
		String sql = "select * from customer";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				CustomerVO cv = new CustomerVO();
				cv.setCustid(rs.getInt("custid"));
				cv.setName(rs.getString("name"));
				cv.setAddress(rs.getString("address"));
				cv.setPhone(rs.getString("phone"));
				list.add(cv);
			}
		}catch (Exception e) {
			System.out.println("예외발생" +e.getMessage());
		}finally {
			if(rs != null) {try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(stmt != null) {try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			if(conn != null) {try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
		}
		return list;
		
	}
}
