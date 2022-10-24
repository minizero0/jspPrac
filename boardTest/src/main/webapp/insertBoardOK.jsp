<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dao" class = "com.sist.dao.BoardDAO"/>
	<jsp:useBean id="vo" class = "com.sist.vo.BoardVO"/>
	<jsp:setProperty property="*" name="vo"/>
	
	<%
	int re = dao.insertBoard(vo);
	if (re > 0){
		%>
		<script type="text/javascript">
			alert("등록 성공");
			location.href = "listBoard.jsp";
		</script>
		 <%
	}else{
		%>
		<script type="text/javascript">
			alert("등록 실패");
			location.href = "listBoard.jsp";
		</script>
		 <%
	}
	%>
</body>
</html>