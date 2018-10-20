package kr.or.ddit.jsp_board.dao;

import java.util.List;

import kr.or.ddit.jsp_board.model.Jsp_boardVo;

public interface Jsp_boardDaoInf {
	/**
	* Method : insertBoard
	* 작성자 : sohyoung
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 등록
	*/
	int insertBoard(Jsp_boardVo boardVo);
	
	/**
	* Method : updateBoard
	* 작성자 : sohyoung
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(Jsp_boardVo boardVo);
	
	/**
	* Method : selectAllBoard
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	*/
	List<Jsp_boardVo> selectAllBoard();
	
}



















