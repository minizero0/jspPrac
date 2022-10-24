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
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"  />
	<table border = "1">
		<thead>
			<tr>
				<th>custid</th>
				<th>name</th>
				<th>address</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<CustomerVO> list = dao.findAll();
				for(CustomerVO cv : list){
					%>
						<tr>
							<td><%=cv.getCustid() %></td>
							<td><%=cv.getName() %></td>
							<td><%=cv.getAddress() %></td>
							<td><%=cv.getPhone() %></td>
						</tr>
					<%
				}
			%>
		</tbody>
	</table>
</body>
</html>