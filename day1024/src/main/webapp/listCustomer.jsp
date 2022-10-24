<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h2>고객목록</h2>
<hr>

	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"  />
	<ul>
			<%
				ArrayList<CustomerVO> list = dao.findAll();
				for(CustomerVO cv : list){
					%>
						<li><a href = "detailCustomer.jsp?custid=<%=cv.getCustid()%>"><%=cv.getName() %></a></li>
						<%-- <li><%=cv.getAddress() %></li>
						<li><%=cv.getPhone() %></li>
						<li><%=cv.getCustid() %></li> --%>
					<%
				}
			%>
	</ul>
	<h3><a href = "insertCustomer.jsp">고객등록</a></h3>
</body>
</html>