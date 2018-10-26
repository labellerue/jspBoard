package kr.or.ddit.post.service;

import java.util.Map;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.util.model.PageVo;


public interface PostServiceInf {

	/**
	* Method : selectPost
	* 작성자 : sohyoung
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 한개 조회
	*/
	public PostVo selectPost(int post_id);
	
	/**
	* Method : selectUserPageList
	* 작성자 : sohyoung
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시글 페이징 조회
	*/
	public Map<String, Object> selectPostPageList(PageVo pageVo);

	/**
	* Method : getPostCnt
	* 작성자 : sohyoung
	* 변경이력 :
	* @param board_id
	* @return 게시판 개수
	* Method 설명 : 해당 board_id의 게시판 개수
	*/
	int getPostCnt(int board_id);
	
	/**
	* Method : insertPost
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	int insertPost(PostVo postVo);
	
	/**
	 * Method : insertReply
	 * 작성자 : sohyoung
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 답글 등록
	 */
	int insertReply(PostVo postVo);
	
	/**
	* Method : updatePost
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 게시글 정보 수정
	*/
	public int updatePost(PostVo postVo);
	
}
