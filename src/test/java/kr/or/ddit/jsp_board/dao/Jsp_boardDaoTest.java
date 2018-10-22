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
	public void updateBoardTest() {
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
	public void insertBoardTest(){
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
	
	@Test
	public void selectBoardTest(){
		/***Given***/
		int board_id = 2;

		/***When***/
		Jsp_boardVo boardVo = boardDao.selectBoard(board_id);
		String board_subject = boardVo.getBoard_subject();

		/***Then***/
		assertEquals("자유게시판", board_subject);
		
	}
	

}












