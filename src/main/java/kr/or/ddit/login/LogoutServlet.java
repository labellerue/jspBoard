package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 무효화
		// 1. session 객체를 확보
		// 2. session invalidate 메소드를 통해 무효화

		//servlet 객체 확보
		// page 		: 존재하지 않음
		// request 		: 메소드 인자로 제공
		// session 		: request객체에서 획득 가능
		// application 	: getServletContext()
		
		//jsp 객체 확보
		// page 		: pageContext(내장객체)
		// request 		: request(내장객체)
		// session 		: session(내장객체)
		// application 	: application(내장객체)
		
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect("/"); //기본 루트인 login.jsp 로 갑니다.
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
