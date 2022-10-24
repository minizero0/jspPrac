<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="vo" class = "com.sist.vo.CustomerVO"/>
	<jsp:setProperty property="*" name="vo"/>
	<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"/>
	
	<%
		int re = dao.updateCustomer(vo);
		if(re > 0){
			%> 
				<script type="text/javascript">
					alert("수정완료");
					location.href = "detailCustomer.jsp?custid=<%=vo.getCustid()%>"
				</script>
			 <%
		}else{
			%>
				<script type="text/javascript">
					alert("수정실패");
				</script>
			<%
		}
	%>
	
</body>
</html>