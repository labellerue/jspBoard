package kr.or.ddit.jsp_board.dao;

import static org.junit.Assert.*;
import kr.or.ddit.jsp_board.model.Jsp_boardVo;

import org.junit.Before;
import org.junit.Test;

public class Jsp_boardDaoTest {

	private Jsp_boardDaoInf boardDao;
	
	@Before
	public void setUp() throws Exception {
		boardDao = new Jsp_boardDao();
	}

	@Test
	public void updateBoard() {
		/***Given***/
		Jsp_boardVo boardVo = new Jsp_boardVo();
		boardVo.setBoard_id(1);
		boardVo.setBoard_avail(1);
		boardVo.setBoard_subject("수정성공");

		/***When***/
		int updateCnt = boardDao.updateBoard(boardVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void insertBoard(){
		/***Given***/
		Jsp_boardVo boardVo = new Jsp_boardVo();
		boardVo.setBoard_subject("새 게시판");
		boardVo.setBoard_avail(0);
		boardVo.setBoard_userid("sally");

		/***When***/
		int insertCnt = boardDao.insertBoard(boardVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
		
		
		
	}

}
