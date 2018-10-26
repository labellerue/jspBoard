package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {

	public List<UserVo> selectUserAll();

	public UserVo selectUser(String userId);

}
