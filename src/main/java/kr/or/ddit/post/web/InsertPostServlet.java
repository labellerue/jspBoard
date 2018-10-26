package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file_post.model.FilesVo;
import kr.or.ddit.file_post.service.FilesService;
import kr.or.ddit.file_post.service.FilesServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5) // 5메가를 byte로 계산, 5메가 5개
@WebServlet("/insertPost")
public class InsertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostServiceInf postService;
	private FilesServiceInf filesService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 답글 작성하기 위한 이전 게시글 정보(ID들)
		String post_pid = request.getParameter("post_id");
		String post_groupid = request.getParameter("post_groupid");

		Map<String, String> postIds = new HashMap<String, String>();
		postIds.put("post_pid", post_pid);
		postIds.put("post_groupid", post_groupid);

		request.setAttribute("postIds", postIds);

		request.getRequestDispatcher("/post/insertPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		postService = new PostService();
		filesService = new FilesService();

		int insertCnt = 0;

		String post_title = request.getParameter("post_title");
		String post_article = request.getParameter("smarteditor");
		String post_userId = request.getParameter("userId");
		String board_id = request.getParameter("board_id");

		// 답글일 경우 추가로 받는 값 ID들
		String post_pid = request.getParameter("post_pid");
		String post_groupid = request.getParameter("post_groupid");

		PostVo postVo = new PostVo();
		postVo.setBoard_id(Integer.parseInt(board_id));
		postVo.setPost_title(post_title);
		postVo.setPost_article(post_article);
		postVo.setPost_userid(post_userId);
		if (post_pid != null && post_groupid != null) {
			postVo.setPost_pid(Integer.parseInt(post_pid));
			postVo.setPost_groupid(Integer.parseInt(post_groupid));

			// 새로운 답글 저장하기
			insertCnt = postService.insertReply(postVo);

			if (insertCnt > 0) {
				System.out.println("reply Insert 성공");
			} else {
				System.out.println("reply Insert 실패");
			}

		} else {
			// 새로운 게시글 저장하기
			insertCnt = postService.insertPost(postVo);
		}
		if (insertCnt > 0) {
			System.out.println("post Insert 성공");
		} else {
			System.out.println("post Insert 실패");
		}
		// 게시글 작업 끝--------------------------------------------

		//파일
		try {
			// 파일 저장 및 경로 가져오기 파일 처리
			// 모든 파일 받기
			Collection<Part> files = request.getParts();

			for(Part file : files) {
				if(file.getName().equals("files")) {
					System.out.println(file.getName());

					String contentDisposition = file.getHeader("Content-disposition");
					// file 경로 가져오는 메서드를 StringUtil 클래스에 넣었어요.
					String fileName = StringUtil.getFileNameFromHeader(contentDisposition);

					// url 정보를 실제 파일 경로로 변경(배포되는 경로입니다.)
					String path = getServletContext().getRealPath("/files");
					String savePath = path + File.separator + fileName;
					System.out.println("realPath" + path);

					// DB에 파일 저장
					String file_path = "/files/" + fileName;
					int post_id = postVo.getTofile_id();
					FilesVo filesvo = new FilesVo();
					filesvo.setFile_path(file_path);
					filesvo.setPost_id(post_id);
					int insertFCnt = filesService.insertFiles(filesvo);

					if (insertFCnt > 0) {
						System.out.println("file Insert 성공");
						// 파일 쓰기
						file.write(savePath);
						file.delete();

					} else {
						System.out.println("file Insert 실패");
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/postPageList?page=1&pageSize=10&board_id="+board_id);

	}

}
