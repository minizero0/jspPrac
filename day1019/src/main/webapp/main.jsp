<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String name = "홍길동";
		
	%>
	이름 : <%=name %><br>
	<jsp:include page="age.jsp"/>		<!-- 다른 파일을 포함시키는 액션태그 include -->
	<%
		String addr = "서울시 마포구 서교동";		
	%>
	<hr>
	주소 : <%=addr %>
</body>
</html>