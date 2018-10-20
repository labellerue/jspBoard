package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.post.model.PostVo;

public class PostDao implements PostDaoInf {
	
	private SqlSessionFactory factory;

	@Override
	public int insertPost(PostVo postVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("post.insertPost", postVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	@Override
	public int updatePost(PostVo postVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("post.updatePost", postVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
	@Override
	public PostVo selectPost(String post_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		PostVo postVo = session.selectOne("post.selectPost");
		session.close();
		
		return postVo;
	}

	@Override
	public List<PostVo> selectAllPost() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<PostVo> boardList = session.selectList("post.selectAllPost");
		session.close();
		
		return boardList;
		
	}

	@Override
	public List<PostVo> selectPostPageList(PageVo pageVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<PostVo> boardList = session.selectList("post.selectPostPageList", pageVo);
		session.close();
		
		return boardList;
	}

	@Override
	public int getPostCnt() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int boardCnt = session.selectOne("post. getPostCnt");
		session.close();
		
		return boardCnt;
	}

	

}






















