package kr.or.ddit.jsp_board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.jsp_board.model.Jsp_boardVo;

public class Jsp_boardDao implements Jsp_boardDaoInf {
	
	private SqlSessionFactory factory;

	@Override
	public int insertBoard(Jsp_boardVo boardVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("board.insertBoard", boardVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	@Override
	public int updateBoard(Jsp_boardVo boardVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}

	@Override
	public List<Jsp_boardVo> selectAllBoard() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<Jsp_boardVo> boardList = session.selectList("board.selectAllBoard");
		session.close();
		
		return boardList;
		
	}

	@Override
	public Jsp_boardVo selectBoard(int board_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		Jsp_boardVo boardVo = session.selectOne("board.selectBoard",board_id);
		session.close();
		
		return boardVo;
	}
	


}






















