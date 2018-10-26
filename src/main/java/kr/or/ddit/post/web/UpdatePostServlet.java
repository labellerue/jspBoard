package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

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

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/updatePost")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostServiceInf postService;
	private FilesServiceInf filesService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 수정할 게시글vo를 수정폼으로 넘겨줍니다.
		String post_id = request.getParameter("post_id");

		postService = new PostService();
		PostVo postVo = postService.selectPost(Integer.parseInt(post_id));
		filesService = new FilesService();
		List<FilesVo> filesList = filesService.selectFiles(Integer.parseInt(post_id));
		
		request.setAttribute("postVo", postVo);
		request.setAttribute("filesList", filesList);

		request.getRequestDispatcher("/post/updatePost.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");

		postService = new PostService();

		String post_id = request.getParameter("post_id");
		System.out.println("update " + post_id);
		String post_title = request.getParameter("post_title");
		String post_article = request.getParameter("smarteditor");

		PostVo postVo = new PostVo();
		postVo.setPost_id(Integer.parseInt(post_id));
		postVo.setPost_title(post_title);
		postVo.setPost_article(post_article);

		// 수정 게시글 저장하기
		int insertCnt = postService.updatePost(postVo);

		if (insertCnt > 0) {
			System.out.println("post Update 성공");
		} else {
			System.out.println("post Update 실패");
		}

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
					FilesVo filesvo = new FilesVo();
					filesvo.setFile_path(file_path);
					filesvo.setPost_id(Integer.parseInt(post_id));
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

		response.sendRedirect("/detailPost?post_id="+post_id);
	}
	
}




























