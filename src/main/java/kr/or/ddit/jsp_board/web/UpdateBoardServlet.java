package kr.or.ddit.jsp_board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.jsp_board.model.Jsp_boardVo;
import kr.or.ddit.jsp_board.service.Jsp_boardService;
import kr.or.ddit.jsp_board.service.Jsp_boardServiceInf;

/**
 * Servlet implementation class UpdateBoard
 */
@WebServlet("/updateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jsp_boardServiceInf boardService = new Jsp_boardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Jsp_boardVo> boardList = boardService.selectAllBoard();
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		response.sendRedirect("/board/detailBoard.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("업데이트 서블릿 들어왔어요.");
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		String board_id = request.getParameter("board_id");
		String board_subject = request.getParameter("board_subject");
		String board_avail = request.getParameter("board_avail");
		String userId = request.getParameter("userId");
		System.out.println("board_id는 "+ board_id);
		System.out.println("board_subject는 "+ board_subject);
		System.out.println("board_avail는 "+ board_avail);
		System.out.println("userId는 "+ userId);
		
		Jsp_boardVo boardVo = new Jsp_boardVo();
		boardVo.setBoard_id(Integer.parseInt(board_id));
		boardVo.setBoard_subject(board_subject);
		boardVo.setBoard_avail(Integer.parseInt(board_avail));
		boardVo.setBoard_userid(userId);
		
		//신규 게시판 생성
		if(boardVo.getBoard_id() < 1 ){
			int insertCnt = boardService.insertBoard(boardVo);
			
			if(insertCnt > 0){
				System.out.println("추가 성공했습니다. " + insertCnt);
			}else{
				System.out.println("추가 실패..");
			}
			
		//기존 게시판 수정
		}else if(boardVo.getBoard_id() > 0){
			int updateCnt = boardService.updateBoard(boardVo);
			
			if(updateCnt > 0){
				System.out.println("업데이트 성공했습니다. " + updateCnt);
			}else{
				System.out.println("업데이트 실패..");
			}
		}
		
		doGet(request, response);
		
	}

}
