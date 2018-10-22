package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertPostServlet
 */
@WebServlet("/insertPost")
public class InsertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/post/insertPost.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
				
		String post_title = request.getParameter("post_title");
		String post_article = request.getParameter("smarteditor");
		String post_userId = request.getParameter("userId");
		
		
		System.out.println("post_title :" + post_title);
		System.out.println("post_article :" + post_article);
		System.out.println("post_userId :" + post_userId);
	}

}
