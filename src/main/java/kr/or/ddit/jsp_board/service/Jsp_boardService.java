package kr.or.ddit.jsp_board.service;

import java.util.List;
import kr.or.ddit.jsp_board.dao.Jsp_boardDao;
import kr.or.ddit.jsp_board.dao.Jsp_boardDaoInf;
import kr.or.ddit.jsp_board.model.Jsp_boardVo;

public class Jsp_boardService implements Jsp_boardServiceInf {
	private Jsp_boardDaoInf boardDao = new Jsp_boardDao();

	@Override
	public int insertBoard(Jsp_boardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(Jsp_boardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public List<Jsp_boardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	@Override
	public Jsp_boardVo selectBoard(int board_id) {
		return boardDao.selectBoard(board_id);
	}


}





















