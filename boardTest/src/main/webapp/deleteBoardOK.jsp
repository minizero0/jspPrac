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
		if(request.getParameter("no")!=null){
			int no = Integer.parseInt(request.getParameter("no"));
			String pwd = request.getParameter("pwd");
			int re = dao.deleteBoard(no,pwd);
			if(re > 0){
				%>
				<script type="text/javascript">
					alert("삭제완료");
					location.href = "listBoard.jsp";
				</script>
				<%
			}else{
				%>
				<script type="text/javascript">
					alert("삭제실패");
					history.back();
				</script>
				<%
			}
		}
	%>
</body>
</html>