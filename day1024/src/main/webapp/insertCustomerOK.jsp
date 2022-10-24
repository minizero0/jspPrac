<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dao" class = "com.sist.dao.CustomerDAO"/>
<jsp:useBean id="vo" class = "com.sist.vo.CustomerVO"/>
<jsp:setProperty property="*" name="vo"/>

<%
	int re = dao.insertCustomer(vo);
	if(re>0){
		%> 
		<script type="text/javascript">
			alert("등록완료");
			location.href = "listCustomer.jsp";
		</script>
		<%
	}else{
		%>
			<script type="text/javascript">
				alert("등록실패");
			</script>
		<%
	}
%>


</body>
</html>