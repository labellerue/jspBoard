package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file_post.service.FilesService;
import kr.or.ddit.file_post.service.FilesServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostServiceInf postService;
	private FilesServiceInf filesService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");

		postService = new PostService();
		filesService = new FilesService();

		String post_id = request.getParameter("post_id");
		String board_id = request.getParameter("board_id");
		int post_del = 1;

		PostVo postVo = new PostVo();
		postVo.setPost_id(Integer.parseInt(post_id));
		postVo.setBoard_id(Integer.parseInt(board_id));
		postVo.setPost_del(post_del);

		// del 수정하기
		int updateCnt = postService.updatePost(postVo);
		// 파일 삭제하기
		filesService.deleteFiles(Integer.parseInt(post_id));

		if (updateCnt > 0) {
			System.out.println("post update 성공");
		} else {
			System.out.println("post update 실패");
		}
				
		response.sendRedirect("/postPageList?page=1&pageSize=10&board_id="+board_id);
	}
	
}




























