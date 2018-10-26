package kr.or.ddit.file_post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.file_post.model.FilesVo;

public class FilesDao implements FilesDaoInf {
	private SqlSessionFactory factory;

	@Override
	public List<FilesVo> selectFiles(int post_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<FilesVo> filesList = session.selectList("files.selectFiles", post_id);
		session.close();
		
		return filesList;
	}

	@Override
	public int insertFiles(FilesVo filesVo) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("files.insertFiles", filesVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	@Override
	public int deleteFiles(int post_id) {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.delete("files.deleteFiles", post_id);
		session.commit();
		session.close();
		
		return deleteCnt;
	}

}
