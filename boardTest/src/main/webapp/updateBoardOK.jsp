<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.sist.vo.BoardVO"%>
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
	<% 	request.setCharacterEncoding("utf-8"); 
		BoardVO b = new BoardVO();
		
		
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request,path,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
		String oldFname = multi.getParameter("oldFname");
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setTitle(multi.getParameter("title"));
		b.setContent(multi.getParameter("content"));
		
		String fname = "";
		File file =  multi.getFile("uploadFile");
		if(file != null){
			fname = file.getName();
		}else{
			fname = oldFname;
		}
		b.setFname(fname);
		
		int re = dao.updateBoard(b);
		if(re > 0){
			if (!fname.equals("") ){
				File file2 = new File(path + "/" + oldFname);
				file2.delete();
			}
			
			%>
			<script type="text/javascript">
				alert("수정 성공");
				location.href = "detailBoard.jsp?no=<%=b.getNo()%>";
			</script>
			<%
		}else{
			File file2 = new File(path + "/" + fname);
			file2.delete();
			%>
			<script type="text/javascript">
				alert("수정 실패");
				location.href = "listBoard.jsp";
			</script>
			<%
		}
	%>

</body>
</html>