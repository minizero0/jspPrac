<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물상세</h2>
	<hr>
	
		<h4>글번호 : ${b.no }</h4>
		<h4>글제목 : ${b.title }</h4>
		<h4>작성자 : ${b.writer }</h4>
		<h4>글내용 :<br>
		<textarea rows="10" cols="60" readonly="readonly">${b.content }</textarea> </h4>
		<h4>조회수 : ${b.hit }</h4>
		<h4>등록일 : ${b.regdate }</h4>
		
		<hr>
		<h4><a href = "updateBoard.do?no=${b.no }">수정</a></h4>
		<h4><a href = "deleteBoard.do?no=${b.no }">삭제</a></h4>
		<h4><a href = "insertBoard.do?no=${b.no }">답글작성</a></h4>
	
			
</body>
</html>