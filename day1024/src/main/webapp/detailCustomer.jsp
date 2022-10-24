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
<h2>고객상세</h2>
<hr>
<h3>고객번호 : <%=vo.getCustid() %></h3>
<h3>이름 : <%=vo.getName() %></h3>
<h3>주소 : <%=vo.getAddress() %></h3>
<h3>번호 : <%=vo.getPhone() %></h3>
<hr>

</body>
</html>