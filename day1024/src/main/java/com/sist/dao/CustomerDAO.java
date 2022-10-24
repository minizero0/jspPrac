package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.CustomerVO;

public class CustomerDAO {
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
