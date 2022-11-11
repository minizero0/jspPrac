<%@page import="java.io.File"%>
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
<jsp:useBean id="d" class = "w"/>
	<%
		if(request.getParameter("no")!=null){
			int no = Integer.parseInt(request.getParameter("no"));
			String path = request.getRealPath("data");
			GoodsVO gv = dao.findByNo(no);
			String fname = gv.getFname();
			
			int re = dao.deleteGoods(no);	
			if(re > 0 ){
				if(fname != null){
					File file2 = new File(path + "/" + fname);
					file2.delete();
				}%>
				<script type="text/javascript">
				alert("삭제완료");
				location.href = "listGoods.jsp";
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