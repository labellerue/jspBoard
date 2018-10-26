package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;


public interface UserDaoInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userId);
	

}














