package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class insertBoardOKAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String path = request.getRealPath("upload");
		System.out.println(path);
		MultipartRequest multi = new MultipartRequest(
										request,
										path,
										1024*1024*5,
										"utf-8",
										new DefaultFileRenamePolicy()
									);
		BoardVO b = new BoardVO();
		
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setTitle(multi.getParameter("title"));
		b.setContent(multi.getParameter("content"));
		
		String fname = "";
		File uploadFile =  multi.getFile("uploadFile");
		if(uploadFile != null){
			fname = uploadFile.getName();
		}
		b.setFname(fname);
		
		BoardDAO dao = new BoardDAO();		
		
		//일단 새글 이라고 본다.
		int no = dao.getNextNo();
		int b_ref = no;
		int b_step = 0;
		int b_level = 0;
		
		int pno = Integer.parseInt(multi.getParameter("no"));
		if(pno != 0){
			BoardVO p = dao.findByNo(pno);
			b_ref = p.getB_ref();
			b_step = p.getB_step();
			b_level = p.getB_level();
			dao.updateStep(b_ref,b_step);
			b_step++;
			b_level++;
		}
		
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_step(b_step);
		b.setB_level(b_level);
		
		int re = dao.insertBoard(b);
		request.setAttribute("re", re);
		return "insertBoardOK.jsp";
	}
}
