<%@page import="java.io.File"%>
<%@page import="com.sist.dao.BoardDAO"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(
										request,
										path,
										1024*1024*5,
										"utf-8",
										new DefaultFileRenamePolicy()
									);
		BoardVO b = new BoardVO();
		
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setTitle(multi.getParameter("title"));
		b.setContent(multi.getParameter("content"));
		
		String fname = "";
		File uploadFile =  multi.getFile("uploadFile");
		if(uploadFile != null){
			fname = uploadFile.getName();
		}
		b.setFname(fname);
		
		BoardDAO dao = new BoardDAO();		
		
		//일단 새글 이라고 본다.
		int no = dao.getNextNo();
		int b_ref = no;
		int b_step = 0;
		int b_level = 0;
		
		int pno = Integer.parseInt(multi.getParameter("no"));
		if(pno != 0){
			BoardVO p = dao.findByNo(pno);
			b_ref = p.getB_ref();
			b_step = p.getB_step();
			b_level = p.getB_level();
			
			dao.updateStep(b_ref,b_step);
			
			b_step++;
			b_level++;
		}
		
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_step(b_step);
		b.setB_level(b_level);
		
		int re = dao.insertBoard(b);
		if(re > 0){
			out.print("성공");
			out.print(path);
		}else{
			out.print("실패");
		}
	%>
	
	<a href = "listBoard.jsp">게시물 목록</a>
</body>
</html>