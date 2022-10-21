<%@page import="com.sist.vo.CustomerOrdersVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.BookDAO"/>
	<form action="orderList.jsp" method = "post">
		고객명 : <input type = "search" name = "name">
		<input type = "submit" value = "검색">
	</form>
	<%
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		if(method.equals("POST")){
			String name = request.getParameter("name");
			ArrayList<CustomerOrdersVO> list = dao.listOrders(name);
			%>
			<h2><%=name %>님의 주문목록</h2>
			<table border = "1">
				<tr>
					<th>도서명</th>
					<th>가격</th>
					<th>날짜</th>
				</tr>
				<%
				for(CustomerOrdersVO cv : list){
					%>
					<tr>
						<td><%=cv.getBookname() %></td>
						<td><%=cv.getPrice() %></td>
						<td><%=cv.getOrderDate() %></td>
					</tr>
					<%
				}
				%>
				
			</table>
			<%
		}
		%>
</body>
</html>