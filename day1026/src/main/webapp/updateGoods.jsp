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
<jsp:useBean id="d" class = "w"/>
	<h2>상품 수정</h2>
	<hr>
	<%
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsVO gv = dao.findByNo(no);
	String oldFname = gv.getFname();
	%>
	<form action="updateGoodsOK.jsp" method = "post" enctype="multipart/form-data">
		상품번호 : <%= no %>
		<input type="hidden" name = "no" value = "<%=no%>">
		<input type = "hidden" name = "oldFname" value = "<%=oldFname%>" required="required">
		상품이름 : <input type="text" name = "name" value = "<%=gv.getName()%>"><br>
		상품개수 : <input type="number" name = "qty" value = "<%=gv.getQty()%>"><br>
		상품가격 : <input type="number" name = "price" value = "<%=gv.getPrice()%>"><br>
		<%
		if(oldFname!=null){
			if(SistUtil.isImg(oldFname)){
				%>
				<img alt="" src="data/<%=oldFname%>" width = "200" height = "200"><br>
				<%
			}else{
				out.print("첨부파일명:" +oldFname+"<br>");
			}
		}
		%>
		<input type = "file" name = "uploadFile"><br>
		<input type="submit" value = "상품수정">
		<input type="reset" value = "수정취소">
	</form>
</body>
</html>