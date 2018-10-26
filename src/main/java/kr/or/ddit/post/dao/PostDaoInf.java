package kr.or.ddit.post.dao;

import java.util.List;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.util.model.PageVo;

public interface PostDaoInf {
	
	/**
	* Method : selectPost
	* 작성자 : sohyoung
	* 변경이력 :
	* @param post_id
	* @return
	* Method 설명 : 게시글 1개 조회
	*/
	PostVo selectPost(int post_id);
	
	/**
	* Method : selectPostPageList
	* 작성자 : sohyoung
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 게시판 페이징 조회
	*/
	List<PostVo> selectPostPageList(PageVo pageVo);
	
	/**
	* Method : insertPost
	* 작성자 : sohyoung
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시판 등록
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
	* @param postVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updatePost(PostVo postVo);
	
	/**
	* Method : getPostCnt
	* 작성자 : sohyoung
	* 변경이력 :
	* @param board_id
	* @return 게시판 개수
	* Method 설명 : 해당 board_id의 게시판 개수
	*/
	int getPostCnt(int board_id);
}



















