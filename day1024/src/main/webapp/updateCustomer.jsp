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
			int custid = Integer.parseInt(request.getParameter("custid"));
	 %>
	 <jsp:useBean id="vo" class = "com.sist.vo.CustomerVO"/>
	<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"/>
	<%
		vo = dao.findByCustid(custid);
	%>
	<form action="updateCustomerOK.jsp" method = "post">
		고객번호 : <%=custid %>
		<input type = "hidden" name = "custid" value = "<%=vo.getCustid()%>"><br>
		이름 : <input type = "text" name = "name" value = "<%=vo.getName()%>"><br>
		주소 : <input type = "text" name = "address" value = "<%=vo.getAddress()%>"><br>
		전화번호 : <input type = "text" name = "phone" value = "<%=vo.getPhone()%>"><br>
		<input type="submit" value = "수정">
		<input type = "reset" value = "취소"> 
	</form>
	
	
</body>
</html>