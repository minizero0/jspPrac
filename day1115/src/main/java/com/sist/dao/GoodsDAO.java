package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.EmpVO;
import com.sist.vo.GoodsVO;

public class GoodsDAO {
private static GoodsDAO dao;
	
	public static GoodsDAO getInstance() {		//singleton 생성방식
		if(dao == null)
			dao = new GoodsDAO();
		return dao;
	}
	
	private GoodsDAO() {
		
	}
	
	public ArrayList<GoodsVO> findAll(){
		ArrayList<GoodsVO> list = new ArrayList<>();
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
				GoodsVO gv = new GoodsVO();
				gv.setNo(rs.getInt("no"));
				gv.setName(rs.getString("name"));
				gv.setPrice(rs.getInt("price"));
				gv.setQty(rs.getInt("qty"));
				gv.setFname(rs.getString("fname"));
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
