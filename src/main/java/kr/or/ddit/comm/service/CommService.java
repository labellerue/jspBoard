package kr.or.ddit.comm.service;

import java.util.List;

import kr.or.ddit.comm.dao.CommDao;
import kr.or.ddit.comm.dao.CommDaoInf;
import kr.or.ddit.comm.model.CommVo;

public class CommService implements CommServiceInf {
	
	private CommDaoInf commDao =  new CommDao();

	@Override
	public List<CommVo> selectComm(int post_id) {
		return commDao.selectComm(post_id);
	}

	@Override
	public int insertComm(CommVo commVo) {
		return commDao.insertComm(commVo);
	}

	@Override
	public int updateComm(int comm_id) {
		return commDao.updateComm(comm_id);
	}

}
