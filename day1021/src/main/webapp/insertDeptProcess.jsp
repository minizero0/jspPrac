<%@page import="com.sist.vo.deptVO"%>
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
		
		/* int dno = Integer.parseInt(request.getParameter("dno"));
		String dname = request.getParameter("dname");
		String dloc = request.getParameter("dloc");
		
		deptVO dv = new deptVO(dno,dname,dloc);
		*/
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dao" class= "com.sist.dao.deptDAO"/>
	<jsp:useBean id="d" class = "com.sist.vo.deptVO" />
	<jsp:setProperty property="*" name="d"/>
	<%
	int re = dao.insertDept(d);
	if (re > 0){
		response.sendRedirect("deptList.jsp");
	}else
		response.sendRedirect("insertDeptProcess.jsp");
	%>
	
</body>
</html>