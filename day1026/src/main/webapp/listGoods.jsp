<%@page import="com.sist.vo.GoodsVO"%>
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
<jsp:useBean id="dao" class = "com.sist.dao.GoodsDAO"/>
	<h2>상품목록</h2>
	<hr>
	<table border = "1">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<GoodsVO> list =  dao.listGoods();
				for(GoodsVO gv : list){
					%>
					<tr>
						<td><%=gv.getNo() %></td>
						<td><a href = "detailGoods.jsp?no=<%=gv.getNo() %>"><%=gv.getName()%></a></td>
					</tr>
					<%
				}
			%>
		</tbody>
	</table>
</body>
</html>