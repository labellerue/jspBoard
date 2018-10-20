package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{

	private SqlSessionFactory factory;
	
	/**
	 * 
	* Method : selectUserAll
	* 작성자 : pc02
	* 변경이력 :
	* @return 테이블 전체 list
	* Method 설명 : 테이블 데이터 전체 조회
	 */
	@Override
	public List<UserVo> selectUserAll(){
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		//selectOne : 데이터가 한 건일 때
		//selectList : 여러건의 데이터를 조회할 때
		//메소드 인자: 문자열 = 네임스페이스(모듈명).쿼리아이디
		List<UserVo> userList = session.selectList("jspuser.selectUserAll");
		
		//자동 커밋이 안되기 때문에 명시
		session.rollback();
		session.commit();
		//닫아주세요.
		session.close();
		
		return userList;
	}
	
	// 회원정보 조회 
	@Override
	public UserVo selectUser(String userId){
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userVo = session.selectOne("jspuser.selectUser", userId);
		session.close();
		
		return userVo;
	}
	
	@Override
	public UserVo selectUser(UserVo userVo){
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userVoResult = session.selectOne("jspuser.selectUserByVo", userVo);
		session.close();
		
		return userVoResult;
	}
		

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> userList = session.selectList("jspuser.selectUserPageList", pageVo);
		session.close();
		
		return userList;
	}

	/**
	* Method : getUserCnt
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("jspuser.getUserCnt");
		session.close();
		
		return totalUserCnt;
	}

	/**
	* Method : insertUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("jspuser.insertUser", userVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : insertUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.delete("jspuser.deleteUser", userId);
		session.commit();
		session.close();
		
		return deleteCnt;
	}

	@Override
	public int updateUser(UserVo userVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("jspuser.updateUser", userVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}

	
	
	
}











