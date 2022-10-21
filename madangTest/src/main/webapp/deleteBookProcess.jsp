<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="dao" class ="com.sist.dao.BookDAO"/>
<body>
	<%
	if(request.getParameter("bookid")!=null){
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		int re = dao.deleteBook(bookid);
		
		if(re > 0){
			%>
			<script type="text/javascript">
				alert("삭제 확인");
				location.href = "bookList.jsp";
			</script>	
			<%
		}
		else{
		%>
			<script type="text/javascript">
				alert("삭제 실패");
			</script>
		<%
		}
	}
	else{
		%>
		<script type="text/javascript">
			alert("삭제할 도서번호 확인");
			location.href("bookList.jsp");
		</script>
		<%	
	}
	%>
</body>
</html>