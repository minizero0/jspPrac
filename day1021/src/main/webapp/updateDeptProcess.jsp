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
	%>
	<jsp:useBean id="dao" class ="com.sist.dao.deptDAO"/>
	<jsp:useBean id="dv" class = "com.sist.vo.deptVO"/>
	<jsp:setProperty property="*" name="dv"/>
	<%
		int dno1 = Integer.parseInt(request.getParameter("dno1"));
		
		int re = dao.updateDept(dv, dno1);
		if(re >0){
			response.sendRedirect("deptList.jsp");
		}else{
			response.sendRedirect("updateDept.jsp");
		}
		
		
	%>
</body>
</html>