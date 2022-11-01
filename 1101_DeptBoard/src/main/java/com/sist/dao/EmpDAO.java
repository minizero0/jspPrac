package com.sist.dao;

import java.sql.Connection;
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
