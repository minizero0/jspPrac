<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkDelete(dno) {
		if(confirm("정말로 삭제하시겠어요?")){
			location.href = "deleteDeptOK.do?no="+dno;
		}
	}

</script>
</head>
<body>
	<h2>게시물 상세보기</h2>
	<hr>
	<h4>부서번호 : ${dv.dno }</h4>
	<h4>부서이름 : ${dv.dname }</h4>
	<h4>부서위치 : ${dv.dloc }</h4>
	<hr>
	<a href = "updateDept.do?no=${dv.dno }">수정하기</a><br>
	<a href = "#" onclick = "checkDelete(${dv.dno })">삭제하기</a><br>
	<hr>
	<a href = "listDept.do">게시물 목록</a>
</body>
</html>