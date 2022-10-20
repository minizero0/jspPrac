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
	String serverInfo = application.getServerInfo();
	String mimeType = application.getMimeType("main.jsp");
	String realPath = application.getRealPath("/");
	application.log("application 내부 객체 로그 테스트");
	String path = application.getRealPath("/data");
	String path2 = request.getRealPath("/data");
%>

<h1>Application Example1</h1>
서블릿 컨테이너의 이름과 버전 : <%= serverInfo %><br>
main.jsp의 MIME Type : <%= mimeType  %><br>
로컬 파일 시스템 결과 : <%= realPath %><br>
data의 실제 경로 : <%= path %><br>
data의 실제 경로 : <%= path2 %><br>

</body>
</html>