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
	<h3><a href = "insertGoods.jsp">상품등록</a></h3>
	<form action="listGoods.jsp" method = "post">
		<select name = "cate">
			<option value = "*">전체</option>
			<option value = "no">상품번호</option>
			<option value = "name">상품이름</option>
			<option value = "price">상품가격</option>
			<option value = "qty">상품수량</option>
		</select>
		<input type = "search" name = "searchName">
		<input type = "submit" value = "검색">
	</form>
	<br>
	<table border = "1">
		<thead>
			<tr>
				<th><a href ="listGoods.jsp?sortColumn=no">상품번호</a></th>
				<th><a href ="listGoods.jsp?sortColumn=name">상품이름</a></th>
				<th><a href ="listGoods.jsp?sortColumn=price">상품가격</a></th>
				<th><a href ="listGoods.jsp?sortColumn=qty">상품수량</a></th>
			</tr>
			<%
				request.setCharacterEncoding("utf-8");
				String sortColumn = "";
				sortColumn = request.getParameter("sortColumn");
				
				String searchName = "";
				searchName = request.getParameter("searchName");
				
				String cate = "";
				cate = request.getParameter("cate");
				
			%>
		</thead>
		<tbody>
			<%
			ArrayList<GoodsVO> list =  dao.listGoods(sortColumn,searchName,cate);
				for(GoodsVO gv : list){
					%>
					<tr>
						<td><%=gv.getNo() %></td>
						<td><a href = "detailGoods.jsp?no=<%=gv.getNo() %>"><%=gv.getName()%></a></td>
						<td><%=gv.getPrice() %></td>
						<td><%=gv.getQty() %></td>
					</tr>
					<%
				}
			%>
		</tbody>
	</table>
	
</body>
</html>