package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.post.model.PostVo;


public interface PostServiceInf {

	public List<PostVo> selectAllPost();

	public PostVo selectPost(String post_id);

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
	* Method : insertPost
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	public int insertPost(PostVo postVo);
	
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
