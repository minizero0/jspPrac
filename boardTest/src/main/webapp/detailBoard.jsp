<%@page import="com.sist.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteBoard(no) {
		if(confirm("정말 삭제하시겠어요?")){
			location.href = "deleteBoardOK.jsp?no="+no;
		}
	}
</script>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.BoardDAO"/>
<jsp:useBean id="vo" class = "com.sist.vo.BoardVO"></jsp:useBean>
	<%
		if(request.getParameter("no")!=null){
			int no =  Integer.parseInt(request.getParameter("no")); 
			vo = dao.findByNo(no);
			dao.plusHit(no);
			%>
			<h4>글번호 : <%=vo.getNo() %></h4>
			<h4>글제목 : <%=vo.getTitle() %></h4>
			<h4>작성자 : <%=vo.getWriter() %></h4>
			<h4>글내용 :<br>
			<textarea rows="10" cols="60" readonly="readonly"><%=vo.getContent() %></textarea> </h4>
			<h4>등록일 : <%=vo.getRegdate() %></h4>
			<h4>조회수 : <%=vo.getHit() %></h4>
			
			<hr>
			<h4><a href = "updateBoard.jsp?no=<%=vo.getNo()%>">수정</a></h4>
			<h4><a href = "deleteBoard.jsp?no=<%=vo.getNo()%>">삭제</a></h4>
			<%
		}
	%>
	
</body>
</html>