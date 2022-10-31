<%@page import="java.io.File"%>
<%@page import="com.sist.dao.BoardDAO"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test = "${re == 1 }">
		게시물 등록 성공.
	</c:if>
	<c:if test = "${re != 1 }">
		게시물 등록 실패.
	</c:if>
	<hr>
	<a href = "listBoard.do">게시물 목록</a>
</body>
</html>