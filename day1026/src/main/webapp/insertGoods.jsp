<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertGoodsOK.jsp" method = "post" enctype="multipart/form-data">
		상품이름 : <input type="text" name = "name"><br>
		상품개수 : <input type="number" name = "qty"><br>
		상품가격 : <input type="number" name = "price"><br>
		첨부파일 : <input type="file" name = "uploadFile"><br>
		<input type="submit" value = "상품등록">
		<input type="reset" value = "등록취소">
	</form>
</body>
</html>