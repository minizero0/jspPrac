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
	<h3><a href = "insertBook.jsp">등록</a></h3>
	<jsp:useBean id="dao" class = "com.sist.dao.BookDAO" />
	<table border = "1">
		<thead>
			<tr>
				<th>bookid</th>
				<th>bookname</th>
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
							<td><a href = "detailBook.jsp?bookid=<%=b.getBookid() %>"><%=b.getBookname() %></a></td>
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