package kr.or.ddit.file_post.service;

import java.util.List;

import kr.or.ddit.file_post.model.FilesVo;

public interface FilesServiceInf {

	/**
	 * Method : selectFiles
	 * 작성자 : Bella
	 * 변경이력 :
	 * @param post_id
	 * @return 같은 게시글의 파일vo
	 * Method 설명 : 파일 조회
	 */
	List<FilesVo> selectFiles(int post_id);
	
	/**
	 * Method : insertFiles
	 * 작성자 : Bella
	 * 변경이력 :
	 * @param filesVo
	 * @return 등록한 갯수
	 * Method 설명 : 파일 등록
	 */
	int insertFiles(FilesVo filesVo);
	
	/**
	 * Method : deleteFiles
	 * 작성자 : Bella
	 * 변경이력 :
	 * @param post_id
	 * @return 삭제한 갯수
	 * Method 설명 : 파일 삭제
	 */
	int deleteFiles(int post_id);
	
	
	
}
