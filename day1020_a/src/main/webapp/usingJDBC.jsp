<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id = "",
			pwd = "",
			name = "",
			num1 = "",
			num2 = "",
			email = "",
			phone = "",
			zipcode = "",
			address = "",
			job = "";
	
	int counter = 0;
	try{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String usr = "c##madang";
		String wd = "madang";
		
		conn = DriverManager.getConnection(url,usr,wd);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from tblRegister");
		%>
			<h2>JSP 스크립트릿에서 데이터베이스 연동 예제</h2>
			<h3>회원정보</h3>
			<table bordercolor = "#0000ff" border = "1">
				<tr>
					<th>ID</th>
					<th>PWD</th>
					<th>NAME</th>
					<th>NUM1</th>
					<th>NUM2</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>ZIPCODE/ADDRESS</th>
					<th>JOB</th>
				</tr>
				<%
					if(rs != null){
						while(rs.next()){
							id = rs.getString("id");
							pwd = rs.getString("pwd");
							name = rs.getString("name");
							num1 = rs.getString("num1");
							num2 = rs.getString("num2");
							email = rs.getString("email");
							phone = rs.getString("phone");
							zipcode = rs.getString("zipcode");
							address = rs.getString("address");
							job = rs.getString("job");
							%>
								<tr>
									<td><%=id %></td>
									<td><%=pwd %></td>
									<td><%=name %></td>
									<td><%=num1 %></td>
									<td><%=num2 %></td>
									<td><%=email %></td>
									<td><%=phone %></td>
									<td><%=zipcode %></td>
									<td><%=address %></td>
									<td><%=job %></td>
								</tr>
							<%
							counter++;
						}
					}
				%>
			</table>
			total records : <%= counter %>
		<%
	}catch(SQLException e){
		out.print(e);
	}catch(Exception e){
		out.print(e);
	}finally{
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				out.print(e);
			}
		}
		if(stmt!=null){
			try{
				stmt.close();
			}catch(Exception e){
				out.print(e);
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				out.print(e);
			}
		}
	}
%>
</body>
</html>