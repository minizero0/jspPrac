<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1" width = "80%">
	<%
	String arr[] ={"일", "월","화","수","목","금","토"};
	int last[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	Date today = new Date();
	int year = today.getYear();
	int month = today.getMonth();
	out.print(today.getYear()+1900+"년\t");
	out.print(today.getMonth()+1+"월");
	Date startDay = new Date(year, month, 1);
	int yoil = startDay.getDay();
	%>
	
	<thead>
		<tr>
			<%for(String a:arr){
				%>
				<th><%=a %></th>
				<%	
				
			}
			%>
		</tr>
	</thead>
	<tr>
	<%
		for(int j = 1; j<=yoil; j++){
			out.print("<td></td");
		}
		for(int i = 1; i <= 30; i++){
			%>
				<td><%=i %></td>
			<%
			if(i+yoil % 7 ==0){
				%>
				</tr><tr>
				<%
			}
		}
	%>
	</tr>
	</table>
</body>
</html>