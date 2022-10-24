<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"/>
	<% 
		int re = 0;
		if(request.getParameter("custid")!=null){
			int custid = Integer.parseInt(request.getParameter("custid"));
			re = dao.deleteCustomer(custid);
			if(re > 0){
				%>
				<script type="text/javascript">
					alert("삭제완료");
					location.href = "listCustomer.jsp";
				</script>
				<%
			}else{
				%>
				<script type="text/javascript">
					alert("삭제실패");
				</script>
				<%
			}
				
		}
	%>
</body>
</html>