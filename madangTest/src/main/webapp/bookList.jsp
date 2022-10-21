<%@page import="com.sist.vo.BookVO"%>
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
	
	<jsp:useBean id="dao" class = "com.sist.dao.BookDAO" />
	<table border = "1">
		<thead>
			<tr>
				<th>bookid</th>
				<th>bookname</th>
				<th>publisher</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody>
			<%
			int count = 0;
				ArrayList<BookVO> list = dao.listBook();
				for(BookVO b : list){
					%>
						<tr>
							<td><%=b.getBookid() %></td>
							<td><%=b.getBookname() %></td>
							<td><%=b.getPublisher() %></td>
							<td><%=b.getPrice() %></td>
						</tr>
					<%
					count++;
				}
			%>
		</tbody>
	</table>
	<h2>총 레코드 : <%= count %></h2>

</body>
</html>