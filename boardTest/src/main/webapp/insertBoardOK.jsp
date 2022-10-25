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
		String path2 = request.getRealPath("/data/a.txt");
		out.println(path2);
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
	
		File uploadFile =  multi.getFile("uploadFile");
		b.setFname(uploadFile.getName());
		
		BoardDAO dao = new BoardDAO();		
		
		int re = dao.insertBoard(b);
		if(re > 0){
			out.print("성공");
			out.print(path);
		}else{
			out.print("실패");
		}
	%>
</body>
</html>