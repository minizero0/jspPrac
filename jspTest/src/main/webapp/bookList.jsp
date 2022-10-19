
<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.blist();
%>

<table class="table">
	<thead>
      <tr>
        <th>bookid</th>
        <th>bookName</th>
        <th>publisher</th>
        <th>price</th>
      </tr>
    </thead>
	<tbody>
	<%
		for(BookVO d : list){
			%>
				<tr>
					<td><%=d.getBookid() %></td>
					<td><%=d.getBookname() %></td>
					<td><%=d.getPublisher() %></td>
					<td><%=d.getPrice() %></td>
				</tr>
			<%
		}
	%>
	</tbody>
</table>
</body>
</html>