<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#op{
		display: none;
	}
</style>
<script type="text/javascript" src = "https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#cate").change(function(){
			var col = $(this).val();
			if(col == "price" || col == "qty"){
				$("#op").css("display", "inline");
			}
			else{
				$("#op").css("display", "none");
			}
			
			
		})
	})
</script>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.GoodsDAO"/>
	<h2>상품목록</h2>
	<hr>
	<h3><a href = "insertGoods.jsp">상품등록</a></h3>
	<form action="listGoods.jsp" method = "post">
		<select name = "cate" id = "cate">
			<option value = "no">상품번호</option>
			<option value = "name">상품이름</option>
			<option value = "price">상품가격</option>
			<option value = "qty">상품수량</option>
		</select>
		<select name = "op" id = "op">
			<option value = ">=">&gt;=</option>
			<option value = "<=">&lt;=</option>
			<option value = "=">=</option>
			<option value = ">">&gt;</option>
			<option value = "<">&lt;</option>
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
				String searchName = "";
				String cate = "";
				String op = "";
				HashMap<String, String> map = new HashMap<>();
				if(session.getAttribute("map")!=null){
					map = (HashMap<String,String>)session.getAttribute("map");
					op = map.get("op");
					searchName = map.get("searchName");
					cate = map.get("cate");
				}
				
				if(request.getParameter("searchName")!=null){
					searchName = request.getParameter("searchName");
					cate = request.getParameter("cate");
					op = request.getParameter("op");
				}
				sortColumn = request.getParameter("sortColumn");
			%>
			
		</thead>
		<tbody>
			<%
			
			
			map.put("sortColumn", sortColumn);
			map.put("searchName", searchName);
			map.put("cate", cate);
			map.put("op", op);
			
			ArrayList<GoodsVO> list =  dao.listGoods(map);
			session.setAttribute("map", map);	
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