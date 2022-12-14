<%@page import="java.util.HashMap"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 리스트</h2>
	<hr>
	
	<form action="listBoard.jsp" method = "post">
		<select name = "searchColumn">
			<option value = "writer">작성자</option>
			<option value = "title">제목</option>
			<option value = "content">글내용</option>
		</select>
		<input type = "search" name = "keyword">
		<input type = "submit" value = "검색">
	</form>
	<%
		request.setCharacterEncoding("utf-8");
		HashMap<String,String> map = new HashMap<>();
		String searchColumn = "";
		String keyword = "";
		
		if(session.getAttribute("map") != null){
			map = (HashMap<String,String>)session.getAttribute("map");
			searchColumn = map.get("searchColumn");
			keyword = map.get("keyword");
		}
		
		if(request.getParameter("keyword")!=null && !request.getParameter("keyword").equals("")){
			searchColumn = request.getParameter("searchColumn");
			keyword = request.getParameter("keyword");
			
		}
		map.put("searchColumn", searchColumn);
		map.put("keyword", keyword);
		
		int pageNUM = 1;
		if(request.getParameter("pageNUM")!=null){
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
	}
		out.print(pageNUM);
			

		
	%>
	<jsp:useBean id="dao" class = "com.sist.dao.BoardDAO"/>
	<jsp:useBean id="vo" class = "com.sist.vo.BoardVO"/>
	
	<% 
	ArrayList<BoardVO> list = dao.listBoard(pageNUM, map);
	session.setAttribute("map", map);
		%>
	<table border = "1" width = "80%">
	<thead>
		<tr>
			<th>NO</th>
			<th>Writer</th>
			<th>Title</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(BoardVO bv : list){
				%>
				<tr>
					<td><%=bv.getNo()%></td>
					<td>
						<%
								for(int i=1; i<=bv.getB_level(); i++ ){
									out.print("&nbsp;&nbsp;");
								}
							%>
					<a href = "detailBoard.jsp?no=<%=bv.getNo()%>"><%=bv.getWriter()%></a></td>
					<td><%=bv.getTitle()%></td>
					
				</tr>
				<%
			}
		%>
	</tbody>
	</table>
	<hr>
	<h3>총페이지 : <%= dao.countBoard(map) %></h3>
	<%
		for(int i =1;i<=dao.totalPage; i++){
			%>
			<a href = "listBoard.jsp?pageNUM=<%=i %>"><%= i %></a>&nbsp;
			<%
		}
	%>
	<hr>
	<h3><a href = "insertBoard.jsp">등록</a></h3>
	
	
</body>
</html>