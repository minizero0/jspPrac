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
			String sql = "update board set title = ?, content = ?,fname=? where no = ? and pwd = ?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getContent());
			pstmt.setString(3, bv.getFname());
			pstmt.setInt(4, bv.getNo());
			pstmt.setString(5, bv.getPwd());
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
				bv.setFname(rs.getString("fname"));
				bv.setB_ref(rs.getInt("b_ref"));
				bv.setB_ref(rs.getInt("b_step"));
				bv.setB_ref(rs.getInt("b_level"));
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
	
	//새로운 글번호 발행하는 메소드
	public int getNextNo() {
		int no = 0;
		String sql = "select nvl(max(no),0)+1 from board";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				no = rs.getInt(1);
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
		return no;
	}
	
	public int insertBoard(BoardVO bv) {
		int re = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into board(no,writer,pwd,title,content,fname,b_ref,b_step,b_level)"
					+ " values(?,?,?,?,?,?,?,?,?)";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bv.getNo());
			pstmt.setString(2, bv.getWriter());
			pstmt.setString(3, bv.getPwd());
			pstmt.setString(4, bv.getTitle());
			pstmt.setString(5, bv.getContent());
			pstmt.setString(6, bv.getFname());
			pstmt.setInt(7, bv.getB_ref());
			pstmt.setInt(8, bv.getB_step());
			pstmt.setInt(9, bv.getB_level());
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
			String sql = "select * from oredr by b_ref, b_step";
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
				bv.setB_ref(rs.getInt("b_ref"));
				bv.setB_ref(rs.getInt("b_step"));
				bv.setB_ref(rs.getInt("b_level"));
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
	
	public void updateStep(int b_ref, int b_step) {
		String sql = "update board set b_step = b_step + 1 where b_ref = ? and b_step > ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
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
		}
	}

}
