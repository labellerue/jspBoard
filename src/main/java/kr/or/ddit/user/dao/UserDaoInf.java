package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.user.model.UserVo;


public interface UserDaoInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);

	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	/**
	* Method : getUserCnt
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	public int getUserCnt();
	
	/**
	* Method : insertUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	public int insertUser(UserVo userVo);
	
	/**
	* Method : deleteUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	public int deleteUser(String userId);
	
	/**
	* Method : updateUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 수정
	*/
	public int updateUser(UserVo userVo);
}














