<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class = "com.sist.dao.GoodsDAO"/>
	<% 
	request.setCharacterEncoding("utf-8"); 
	String path = request.getRealPath("data");		
	MultipartRequest multi = new MultipartRequest(request,path,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
	
	GoodsVO gv = new GoodsVO();
	gv.setName(multi.getParameter("name"));
	gv.setQty(Integer.parseInt(multi.getParameter("qty")));
	gv.setPrice(Integer.parseInt(multi.getParameter("price")));
	
	
	String fname = "";
	File uploadFile = multi.getFile("uploadFile");
	if(uploadFile != null){
		fname = uploadFile.getName();
	}
	gv.setFname(fname);
		
	int re = dao.insertGoods(gv);
	if (re > 0){
		response.sendRedirect("listGoods.jsp");
	}else
		out.print("Fail");
	%>
	
</body>
</html>