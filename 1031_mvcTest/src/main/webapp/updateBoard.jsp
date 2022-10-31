<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 수정</h2>
	<hr>
	<form action="updateBoardOK.do" method="post" enctype="multipart/form-data">
		<input type = "hidden" name = "no" value = "${b.no }">
		작성자 : <input type = "text" name = "writer" required="required" value = "${b.writer}"><br> 
		글암호 : <input type = "password" name = "pwd" required="required" value = "${b.pwd }"><br>
		글제목 : <input type = "text" name = "title" required="required" value = "${b.title }"><br>
		글내용 : 
		<textarea rows="10" cols="60" name = "content" required="required">${b.content }</textarea><br>
		첨부파일 : <input type = "file" name = "uploadFile" value = "${b.fname }"><br>
		<input type = "submit" value = "등록">
		<input type = "reset" value = "취소">
	</form>

</body>
</html>