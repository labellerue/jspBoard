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
@WebServlet("/deleteComm")
public class DeleteCommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommServiceInf commService;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		commService = new CommService();
		
		String comm_id = request.getParameter("comm_id");
		String post_id = request.getParameter("post_id");
		
		int updateCnt = commService.updateComm(Integer.parseInt(comm_id));
		
		if(updateCnt > 0) {
			System.out.println("comm update 성공");
		}else {
			System.out.println("comm update 실패");
		}
		response.sendRedirect("/detailPost?post_id="+post_id);
	}

}






















