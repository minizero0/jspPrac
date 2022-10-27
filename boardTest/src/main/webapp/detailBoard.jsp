<%@page import="com.sist.util.SistUtil"%>
<%@page import="javax.swing.border.Border"%>
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
			BoardVO b = new BoardVO();
			b = dao.findByNo(no);
			dao.plusHit(no);
			%>
			<h4>글번호 : <%=b.getNo() %></h4>
			<h4>글제목 : <%=b.getTitle() %></h4>
			<h4>작성자 : <%=b.getWriter() %></h4>
			<h4>글내용 :<br>
			<textarea rows="10" cols="60" readonly="readonly"><%=b.getContent() %></textarea> </h4>
			<h4>조회수 : <%=b.getHit() %></h4>
			<h4>등록일 : <%=b.getRegdate() %></h4>
			<%
				String fname = b.getFname();
				if(fname != null){
					if(SistUtil.isImg(fname)){
						%>
						<img src = "data/<%=fname%>" width = "100" height = "100">
						<%
					}else{
						%>
						<h4>첨부파일 : <a href = "data/<%=vo.getFname()%>"><%=vo.getFname() %></a></h4>
						<%					
					}
				}
			%>
			
			<hr>
			<h4><a href = "updateBoard.jsp?no=<%=b.getNo()%>">수정</a></h4>
			<h4><a href = "deleteBoard.jsp?no=<%=b.getNo()%>">삭제</a></h4>
			<h4><a href = "insertBoard.jsp?no=<%=b.getNo()%>">답글작성</a></h4>
			<%
		}
	%>
	
</body>
</html>