<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/plaine; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = "[";
   	BookDAO dao = BookDAO.getInstance();
	ArrayList<BookVO> list = dao.findAll();
	for(BookVO d : list){
		str += "{\"bookid\":\""+d.getBookid()+"\",\"bookname\":\""+d.getBookname()+
			"\",\"publisher\":\""+d.getPublisher()+"\",\"price\":\""+d.getPrice()+"\"},";
	}
	str.substring(0, str.length()-1);
	str += "]";
%>

<%= str%>