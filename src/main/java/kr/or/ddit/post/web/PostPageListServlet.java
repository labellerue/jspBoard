package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.jsp_board.model.Jsp_boardVo;
import kr.or.ddit.jsp_board.service.Jsp_boardService;
import kr.or.ddit.jsp_board.service.Jsp_boardServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet(urlPatterns={"/postPageList","/detailPost"})
public class PostPageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jsp_boardServiceInf boardService;
	private PostServiceInf postService;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 uri를 로직 분기
		String uri = request.getRequestURI();
		System.out.println("PostPageServlet doGet URI => " + uri);

		// 게시글 페이징처리
		if (uri.equals("/postPageList"))
			postPageList(request, response);
		// 게시글 상세조회
		else if (uri.equals("/detailPost"))
			detailPost(request, response);
		
	}
	
	/**
	* Method : postPageList
	* 작성자 : sohyoung
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 게시글 페이징처리
	 * @throws IOException 
	 * @throws ServletException 
	*/
	protected void postPageList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String board_id = request.getParameter("board_id");
		boardService = new Jsp_boardService();
		postService = new PostService();
		
		// 해당 board_id의 게시판 명 가져오기
		Jsp_boardVo boardVo = boardService.selectBoard(Integer.parseInt(board_id));
		
		request.setAttribute("boardVo", boardVo);
		
		//해당 보드 아이디의 모든 게시글들을 가져오는 쿼리문
		PageVo pageVo = new PageVo();
		pageVo.setBoard_id(Integer.parseInt(board_id));
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		Map<String, Object> resultMap = postService.selectPostPageList(pageVo);
		
		List<PostVo> postPageList = (List<PostVo>)resultMap.get("pageList");
		
		int pageCnt = (int)resultMap.get("pageCnt");
		
		//request객체에 저장
		request.setAttribute("postPageList", postPageList);
		request.setAttribute("postPageCnt", pageCnt);
		
		HttpSession session = request.getSession();
		session.setAttribute("board_id", board_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/post/postPageList.jsp");
		rd.forward(request, response);
		
	}

	/**
	* Method : postDetail
	* 작성자 : sohyoung
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 게시글 상세조회
	 * @throws IOException 
	 * @throws ServletException 
	*/
	protected void detailPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String post_id = request.getParameter("post_id");
		
		postService = new PostService();
		
		System.out.println("post_id 는" + post_id+"인거야");
		PostVo detailPost = postService.selectPost(Integer.parseInt(post_id));
		
		request.setAttribute("detailPost", detailPost);
		
		request.getRequestDispatcher("/post/detailPost.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}





















