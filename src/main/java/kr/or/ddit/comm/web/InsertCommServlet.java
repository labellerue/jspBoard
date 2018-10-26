package kr.or.ddit.comm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.model.CommVo;
import kr.or.ddit.comm.service.CommService;
import kr.or.ddit.comm.service.CommServiceInf;

/**
 * Servlet implementation class InsertCommServlet
 */
@WebServlet("/insertComm")
public class InsertCommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommServiceInf commService;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		commService = new CommService();
		
		String post_id		=  request.getParameter("post_id");
		String comm_note	=  request.getParameter("comm_note");
		String comm_userid	= request.getParameter("comm_userid");
		
		CommVo commVo = new CommVo();
		commVo.setPost_id(Integer.parseInt(post_id));
		commVo.setComm_note(comm_note);
		commVo.setComm_userid(comm_userid);
		
		int insertCnt = commService.insertComm(commVo);
		
		if(insertCnt > 0) {
			System.out.println("comm Insert 성공");
		}else {
			System.out.println("comm Insert 실패");
		}
		response.sendRedirect("/detailPost?post_id="+post_id);
	}

}






















