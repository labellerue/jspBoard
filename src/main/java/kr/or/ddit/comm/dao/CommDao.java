package kr.or.ddit.comm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.comm.model.CommVo;
import kr.or.ddit.db.SqlFactoryBuilder;

public class CommDao implements CommDaoInf {
	
	private SqlSessionFactory factory;

	@Override
	public List<CommVo> selectComm(int post_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<CommVo> commList = session.selectList("comm.selectComm", post_id);
		session.close();
		return commList;
	}

	@Override
	public int insertComm(CommVo commVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("comm.insertComm", commVo);
		session.commit();
		session.close();
		return insertCnt;
	}

	@Override
	public int updateComm(int comm_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("comm.updateComm", comm_id);
		session.commit();
		session.close();
		return updateCnt;
	}

}
