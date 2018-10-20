package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {

	private UserDaoInf userDao = new UserDao();
	
	public List<UserVo> selectUserAll() {
		return userDao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		return userDao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		return userDao.selectUser(userVo);
	}

	/**
	* Method : selectUserPageList
	* 작성자 : pc02
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		//페이지에 해당하는 유저 리스트(1~10건 사이)
		List<UserVo> pageList = userDao.selectUserPageList(pageVo);
		
		//페이지 네비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = userDao.getUserCnt();
		
		//결과를 담는 mapp 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageList", pageList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}
	

	
	

}
