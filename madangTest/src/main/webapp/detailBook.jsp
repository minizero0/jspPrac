<%@page import="com.sist.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkDelete(bookid) {
		var re = confirm("정말로 삭제하시겠어요?")
		if (re == true){
			location.href = "deleteBookProcess.jsp?bookid="+bookid;
		}
	}
</script>
</head>

<jsp:useBean id="dao" class = "com.sist.dao.BookDAO"/>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookVO bv = dao.findById(bookid);
	%>
	<h2>bookid : <%= bv.getBookid() %></h2>
	<h2>bookname : <%=  bv.getBookname() %></h2>
	<h2>publisher : <%= bv.getPublisher() %></h2>
	<h2>price : <%= bv.getPrice() %></h2>
	<h2><a href = "bookList.jsp">목록</a></h2> 
	<h2><a href = "updateBook.jsp?bookid=<%=bv.getBookid()%>">수정</a></h2> 
	<h2><a href = "#" onclick="checkDelete(<%=bv.getBookid()%>)">삭제</a></h2> 
</body>
</html>