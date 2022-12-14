<%@page import="com.sist.util.SistUtil"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class = "com.sist.dao.BoardDAO"/>
	<%
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO bv = dao.findByNo(no);
		String oldFname = bv.getFname();
	%>
	<h2>게시물 수정</h2>
	<hr>
	<form action="updateBoardOK.jsp" method="post" enctype="multipart/form-data">
		글번호 : <%=bv.getNo()%>
		<input type = "hidden" name = "no" value = "<%=bv.getNo()%>" required="required"><br>
		<input type = "hidden" name = "oldFname" value = "<%=oldFname%>" required="required">
		작성자 : <input type = "text" name = "writer" value = "<%=bv.getWriter()%>" required="required"><br> 
		글암호 : <input type = "password" name = "pwd" value = "<%=bv.getPwd()%>" required="required"><br>
		글제목 : <input type = "text" name = "title" value = "<%=bv.getTitle()%>" required="required"><br>
		글내용 : 
		<textarea rows="10" cols="60" name = "content" required="required"><%=bv.getContent()%></textarea><br>
		<%
		if(oldFname!=null){
			if(SistUtil.isImg(oldFname)){
				%>
				<img alt="" src="data/<%=oldFname%>" width = "50" height = "50">
				<%
			}else{
				out.print("첨부파일명:" +oldFname+"<br>");
			}
		}
		%>
		
		<input type = "file" name = "uploadFile"><br>
		<input type = "submit" value = "수정">
		<input type = "reset" value = "취소">
	</form>
</body>
</html>