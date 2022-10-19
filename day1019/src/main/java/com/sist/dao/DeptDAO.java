package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sist.db.ConnectionProvider;
import com.sist.vo.DeptVO;

public class DeptDAO {
	
	public int insertDept(DeptVO d) {
		int re = -1;
		String sql = "insert into dept(dno,dname,dloc) values(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}
