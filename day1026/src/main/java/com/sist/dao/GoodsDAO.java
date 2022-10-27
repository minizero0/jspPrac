package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	
	
	public int deleteGoods(int no) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete goods where no = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) {try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
		return re;
	}
	
	public int updateGoods(GoodsVO gv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update goods set name = ?, qty = ?, price = ?, fname = ? where no = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gv.getName());
			pstmt.setInt(2, gv.getQty());
			pstmt.setInt(3, gv.getPrice());
			pstmt.setString(4, gv.getFname());
			pstmt.setInt(5, gv.getNo());
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) {try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
		return re;
	}
	
	
	public GoodsVO findByNo(int no) {
		GoodsVO gv = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from goods where no = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gv = new GoodsVO();
				gv.setNo(rs.getInt("no"));
				gv.setName(rs.getString("name"));
				gv.setQty(rs.getInt("qty"));
				gv.setPrice(rs.getInt("price"));
				gv.setFname(rs.getString("fname"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
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
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
		return gv;
	}
	
	public int insertGoods(GoodsVO gv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql  = "insert into goods values(seq_goods.nextval,?,?,?,?)";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gv.getName());
			pstmt.setInt(2, gv.getQty());
			pstmt.setInt(3, gv.getPrice());
			pstmt.setString(4, gv.getFname());
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pstmt!=null) {try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return re;
	}
	
	public ArrayList<GoodsVO> listGoods(HashMap<String, String> map){
		String searchName = map.get("searchName");
		String sortcolumn = map.get("sortColumn");
		String cate = map.get("cate");		
		String op = map.get("op");
		
		ArrayList<GoodsVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods";
		
		if(searchName!=null && !searchName.equals("")) {
			switch (cate) {
			case "no": sql += " where no = "+searchName;break;
			case "name":sql += " where name like '%"+searchName+"%'";break;
			default: sql += " where "+cate+" "+op+" "+searchName;
			}
			
//			if(cate.equals("price") || cate.equals("qty")) {
//				sql += " where "+cate+" > "+searchName+"";
//			}else {
//				sql += " where "+cate+" like '%"+searchName+"%'";
//			}
			
		}
		if(sortcolumn!=null && !sortcolumn.equals("")) {
			sql += " order by "+sortcolumn;
		}
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
				gv.setQty(rs.getInt("qty"));
				gv.setPrice(rs.getInt("price"));
				gv.setFname(rs.getString("fname"));
				list.add(gv);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
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
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return list;
	}
	
}
