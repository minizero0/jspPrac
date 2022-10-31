<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>게시물 상세</h2>

		<c:forEach items ="${bv}" var="bv">
			<h4>글번호 : ${bv.no }</h4>
			<h4>글제목 : ${bv.title }</h4>
			<h4>작성자 : ${bv.writer }</h4>
			<h4>글내용 :<br>
			<textarea rows="10" cols="60" readonly="readonly">${bv.content }</textarea> </h4>
			<h4>조회수 : ${bv.hit }</h4>
			<h4>등록일 : ${bv.regdate }</h4>
		</c:forEach>
</body>
</html>