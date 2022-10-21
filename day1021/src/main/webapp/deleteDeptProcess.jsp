<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.deptDAO"/>
	<%
	int dno = Integer.parseInt(request.getParameter("dno"));
	int re = dao.deleteDept(dno);
	if (re > 0){
		response.sendRedirect("deptList.jsp");
	}
	else{
		out.print("fail");
	}
	%>
</body>
</html>