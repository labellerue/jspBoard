package kr.or.ddit.comm.service;

import java.util.List;

import kr.or.ddit.comm.model.CommVo;

public interface CommServiceInf {
	/**
	 * Method : selectComm
	 * 작성자 : Bella
	 * 변경이력 :
	 * @param post_id
	 * @return
	 * Method 설명 : 댓글 조회
	 */
	List<CommVo> selectComm(int post_id);
	
	/**
	 * Method : insertComm
	 * 작성자 : Bella
	 * 변경이력 :
	 * @param commVo
	 * @return
	 * Method 설명 : 댓글 등록
	 */
	int insertComm(CommVo commVo);
	
	/**
	 * Method : updateComm
	 * 작성자 : Bella
	 * 변경이력 :
	 * @param comm_id
	 * @return
	 * Method 설명 : 댓글 수정 -> 삭제로 바꾸기
	 */
	int updateComm(int comm_id);
	
}
