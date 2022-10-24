<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"/>
<jsp:useBean id="vo" class = "com.sist.vo.CustomerVO"/>
<%	
	int custid = 0;
	if(request.getParameter("custid")!=null){
		custid = Integer.parseInt(request.getParameter("custid"));
		vo = dao.findByCustid(custid);
	}
%>

<h2>이름 : <%=vo.getName() %></h2>
<h2>주소 : <%=vo.getAddress() %></h2>
<h2>번호 : <%=vo.getPhone() %></h2>


</body>
</html>