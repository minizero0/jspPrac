<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.GoodsDAO"/>
	<% 
	request.setCharacterEncoding("utf-8"); 
	GoodsVO gv = new GoodsVO();
	
	String path = request.getRealPath("data");
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
	gv.setNo(Integer.parseInt(multi.getParameter("no")));
	gv.setName(multi.getParameter("name"));
	gv.setQty(Integer.parseInt(multi.getParameter("qty")));
	gv.setPrice(Integer.parseInt(multi.getParameter("price")));
	
	String oldFname = multi.getParameter("oldFname");
	if(oldFname != null && oldFname.equals("null"))
		oldFname = "";
	
	String fname;
	File file = multi.getFile("uploadFile");
	if(file != null){	
		fname = file.getName();
	}else{
		fname = oldFname;
	}
	gv.setFname(fname);
	
	int re = dao.updateGoods(gv);
	if(re > 0){
		if (!fname.equals("") && oldFname != null && !oldFname.equals("")){
			File file2 = new File(path + "/" + oldFname);
			file2.delete();
		}
		%>
		<script type="text/javascript">
			alert("수정 성공");
			location.href = "detailGoods.jsp?no=<%=gv.getNo()%>";
		</script>
		<%
	}
	else{
		File file2 = new File(path + "/" + fname);
		file2.delete();
		%>
		<script type="text/javascript">
			alert("수정 실패");
			location.href = "listGoods.jsp";
		</script>
		<%
	}
	
	%>
</body>
</html>