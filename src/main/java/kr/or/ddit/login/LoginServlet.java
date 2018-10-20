package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.jsp_board.model.Jsp_boardVo;
import kr.or.ddit.jsp_board.service.Jsp_boardService;
import kr.or.ddit.jsp_board.service.Jsp_boardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

/**
 * Servlet implementation class jsp_boardServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jsp_boardServiceInf boardService = new Jsp_boardService();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		/* remember-me */
		String rememberMe = request.getParameter("remember-me");
		// 아이디 기억 안할 경우
		if (rememberMe == null) {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("remember")
						|| cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);
					// 0으로 설정한 후 보내주기
					response.addCookie(cookie);
				}
				System.out.println("cookie는 : " + cookie.getName() + " 값은 "
						+ cookie.getValue());
			}
			// 아이디 기억 사용할 경우
		} else {
			// response 객체에 쿠키를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			response.addCookie(cookie);
			response.addCookie(userIdCookie);
		}
		/* remember-me -END */

		// 2. 사용자가 전송한 userId로 사용자 정보 조회
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);

		// 3. 일치할 경우
		/* 패스워드 암호화 */
		if (userVo != null && userVo.authPass(password)) {

			// 3-1. 메인 화면으로 이동
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			List<Jsp_boardVo> boardList = boardService.selectAllBoard();
			session.setAttribute("boardList", boardList);

			// dispatch
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response); // 저장하기

			// 3-2. login.jsp로 이동
		} else {
			response.sendRedirect("/");
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
