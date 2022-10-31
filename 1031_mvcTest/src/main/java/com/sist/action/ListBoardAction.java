package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class ListBoardAction implements SistAction{
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		int pageNUM = 1;
		String searchColumn = "";
		String keyword = "";
		
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("searchColumn", searchColumn);
		
		ArrayList<BoardVO> list = dao.listBoard(pageNUM, map);
		request.setAttribute("list", list);
		
		
		return "listBoard.jsp";
	}
	
}
