<%@page import="com.sist.vo.DeptVO"%>
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
		/* DeptVO d = new DeptVO();
		d.setDno(10);
		d.setDname("총무팀");
		d.setDloc("서교동");
		out.print(d.getDno());
		out.print(d.getDname()); 
		out.print(d.getDloc()); */
		
	%>
	<jsp:useBean id="d" class = "com.sist.vo.DeptVO"/>		<!--DepvVO d = new DeptVO()와 같은 의미 -->
	<jsp:setProperty property="dno" name="d" value="10"/>     <!-- d.setDno와 같은 의미 -->
	<jsp:setProperty property="dname" name="d" value="총무팀"/>
	<jsp:setProperty property="dloc" name="d" value="서교동"/>
	
	<jsp:getProperty property="dno" name="d"/><br>			<!-- d.getDno()와 같은의미 -->
	<jsp:getProperty property="dname" name="d"/><br>
	<jsp:getProperty property="dloc" name="d"/><br>
</body>
</html>