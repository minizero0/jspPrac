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

import com.sist.vo.BoardVO;

public class BoardDAO {
		//한 화면에 보여줄 레코드의 수
		public static int pageSIZE = 10;
		
		//전체 레코드 수
		public static int totalRecord = 0;
		
		//전체 페이지 수 
		public static int totalPage = 0;
	
	public int countBoard(HashMap<String, String> map) {
		int re = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String searchColumn = map.get("searchColumn");
		String keyword = map.get("keyword");
		
		try {
			String sql = "select count(*) from board";
			if(keyword !=null) {
				sql += " where "+searchColumn+" like '%"+keyword+"%'";
			}
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/mydb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				re = rs.getInt(1);
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
		
		return re;
	}
	
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
				bv.setB_step(rs.getInt("b_step"));
				bv.setB_level(rs.getInt("b_level"));
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
	
	public ArrayList<BoardVO> listBoard(int pageNUM, HashMap<String, String> map){
		int cnt = countBoard(map);
		totalPage = (int)Math.ceil((double)cnt/pageSIZE);
		String searchColumn = map.get("searchColumn");
		String keyword = map.get("keyword");
		
		System.out.println(keyword);
		System.out.println(searchColumn);
		
		//현재페이지에 보여줘야 할 시작 레코드와 마지막 레코드를 계산하여 출력
		int start, end;
		
		start = (pageNUM-1)*pageSIZE + 1;
		end = start + pageSIZE - 1;
		
		if(end > cnt) {
			end = cnt;
		}
		
		ArrayList<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from(select rownum n, A.* "
					+ "from (select * from board ";
			
					if(keyword != null && !keyword.equals("")) {
						sql += "where "+searchColumn+" like '%"+keyword+"%'"; 
					}
																				
					sql += "order by b_ref desc, b_step) A) "
					+ "where n between "+start+" and "+end;
			
//					if(keyword != null) {
//						sql += " and "+searchColumn+" like '%"+keyword+"%'"; 
//					}
			
//			String sql = "select no, writer, pwd,title, content, regdate, hit, fname, b_ref, b_step, b_level "
//					+ "from (select rownum n, no, writer, pwd,title, content, regdate, hit, fname, b_ref, b_step, b_level "
//					+ "from (select * from board order by b_ref desc, b_step)) "
//					+ "where n between "+start+" and "+end+"";//b_ref, b_step
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
			pstmt.executeUpdate();
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
