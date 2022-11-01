<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateDeptOK.do" method = "post">
		부서번호 : ${dv.dno }
		<input type = "hidden" name = "dno" value = "${dv.dno }"><br>
		부서이름 : <input type = "text" name = "dname" value = "${dv.dname }" required="required"><br>
		부서위치 : <input type = "text" name = "dloc" value = "${dv.dloc }" required="required"><br>
		<input type="submit" value = "등록">
		<input type="reset" value = "취소">
	</form>
</body>
</html>