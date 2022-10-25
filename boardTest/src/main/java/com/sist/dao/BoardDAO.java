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

import com.sist.vo.BoardVO;

public class BoardDAO {
	
	public void plusHit(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update board set hit = hit+1 where no = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
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
	}
	
	public int deleteBoard(int no, String pwd) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete board where no = ? and pwd = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
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
	
	public int updateBoard(BoardVO bv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update board set title = ?, content = ? where no = ? and pwd = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getContent());
			pstmt.setInt(3, bv.getNo());
			pstmt.setString(4, bv.getPwd());
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
	
	
	public BoardVO findByNo(int no) {
		BoardVO bv = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from board where no = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bv = new BoardVO();
				bv.setNo(rs.getInt("no"));
				bv.setWriter(rs.getNString("writer"));
				bv.setPwd(rs.getString("pwd"));
				bv.setTitle(rs.getString("title"));
				bv.setContent(rs.getString("content"));
				bv.setRegdate(rs.getDate("regdate"));
				bv.setHit(rs.getInt("hit"));
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs!=null) {try {
				rs.close();
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
			if(conn!=null) {try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		return bv;
	}
	
	
	public int insertBoard(BoardVO bv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into board(no,writer,pwd,title,content,fname) values(seq_board.nextval,?,?,?,?,?)";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getWriter());
			pstmt.setString(2, bv.getPwd());
			pstmt.setString(3, bv.getTitle());
			pstmt.setString(4, bv.getContent());
			pstmt.setString(5, bv.getFname());
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(conn!=null){try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(pstmt!=null){try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
		return re;
	}
	
	public ArrayList<BoardVO> listBoard(){
		ArrayList<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from board";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setNo(rs.getInt("no"));
				bv.setWriter(rs.getString("writer"));
				bv.setPwd(rs.getString("pwd"));
				bv.setTitle(rs.getString("title"));
				bv.setContent(rs.getString("content"));
				bv.setRegdate(rs.getDate("regdate"));
				bv.setHit(rs.getInt("hit"));
				bv.setFname(rs.getString("fname"));
				list.add(bv);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null) {try {
				rs.close();
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
