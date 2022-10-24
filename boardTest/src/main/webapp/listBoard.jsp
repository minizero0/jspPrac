<%@page import="com.sist.vo.BoardVO"%>
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
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dao" class = "com.sist.dao.BoardDAO"/>
	<jsp:useBean id="vo" class = "com.sist.vo.BoardVO"/>
	
	<% ArrayList<BoardVO> list = dao.listBoard(); %>
	<table border = "1">
	<thead>
		<tr>
			<th>NO</th>
			<th>Writer</th>
			<th>Title</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(BoardVO bv : list){
				%>
				<tr>
					<td><%=bv.getNo()%></td>
					<td><a href = "detailBoard.jsp?no=<%=bv.getNo()%>"><%=bv.getWriter()%></a></td>
					<td><%=bv.getTitle()%></td>
					
				</tr>
				<%
			}
		%>
	</tbody>
	</table>
	<hr>
	<h3><a href = "insertBoard.jsp">등록</a></h3>
</body>
</html>