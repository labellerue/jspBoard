package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

/**
 * Servlet implementation class InsertPostServlet
 */
@WebServlet("/insertPost")
public class InsertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostServiceInf postService;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/post/insertPost.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		postService = new PostService();
				
		String post_title = request.getParameter("post_title");
		String post_article = request.getParameter("smarteditor");
		String post_userId = request.getParameter("userId");
		String board_id = request.getParameter("board_id");
		
		PostVo postVo = new PostVo();
		postVo.setBoard_id(Integer.parseInt(board_id));
		postVo.setPost_title(post_title);
		postVo.setPost_article(post_article);
		postVo.setPost_userid(post_userId);
		
		//새로운 게시글 저장하기
		int insertCnt = postService.insertPost(postVo);
		
		if(insertCnt > 0) {
			System.out.println("post Insert 성공");
		}else {
			System.out.println("post Insert 실패");
		}
		
		
		
		
		
		response.sendRedirect("/postPageList?page=1&pageSize=10&board_id="+board_id);
		
	}

}
