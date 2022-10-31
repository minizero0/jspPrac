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

public class UpdateBoardOKAction implements SistAction{
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO b = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		String path = request.getRealPath("upload");
		MultipartRequest multi = new MultipartRequest(request,path,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
		
		b.setNo(Integer.parseInt(multi.getParameter("no")));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setTitle(multi.getParameter("title"));
		b.setContent(multi.getParameter("content"));
		
		String oldFname = multi.getParameter("oldFname");
		
		if(oldFname == null || oldFname.equals("null")){
			oldFname = "";
		}
		
		String fname = "";
		File file =  multi.getFile("uploadFile");
		if(file != null){
			fname = file.getName();
		}else{
			fname = oldFname;
		}
		
		b.setFname(fname);
		
		int re = dao.updateBoard(b);
		if(re > 0){
			if (!fname.equals("") && oldFname != null && !oldFname.equals("")){
				File file2 = new File(path + "/" + oldFname);
				file2.delete();
			}
		}
		request.setAttribute("re", re);
		return "updateBoardOK.jsp";
	}
}
