<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="text/plaine; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookDAO dao = BookDAO.getInstance();
	ArrayList<BookVO> list = dao.findAll();
	String str = "[";
	for(BookVO d:list){
		str += "{\"bookid\":\""+d.getBookid()+"\",\"bookname\":\""+d.getBookname()+
				"\",\"publisher\":\""+d.getPublisher()+"\",\"price\":\""+d.getPrice()+"\"},";
	}
	
	str += "]";
%>

<%= str%>