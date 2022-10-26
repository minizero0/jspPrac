<%@page import="com.sist.util.SistUtil"%>
<%@page import="com.sist.vo.GoodsVO"%>
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
<h2>상품 상세</h2>
<hr>
	<% 
	if(request.getParameter("no")!=null){
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsVO gv = dao.findByNo(no);
		String fname = gv.getFname();
		
		%>
			<h4>상품번호 : <%= gv.getNo() %></h4>
			<h4>상품이름 : <%= gv.getName() %></h4>
			<h4>상품개수 : <%= gv.getQty() %></h4>
			<h4>상품가격 : <%= gv.getPrice() %></h4>
		<%
		if(fname != null){
			if(SistUtil.isImg(fname)){
				%>
				<img alt="" src="data/<%=fname%>" width = "200" height = "200"><br>
				<%
			}else{
				%>
				<h4>첨부파일 : <a href = "data/<%=fname%>"><%=fname%></a></h4>
				<%
			}
		}
		%>
		<button type="button" onclick="location.href='updateGoods.jsp?no=<%=gv.getNo()%>'">수정</button>
		<button type="button" onclick="location.href='deleteGoodsOK.jsp?no=<%=gv.getNo()%>'">삭제</button>
		<%
	}
	%>
</body>
</html>