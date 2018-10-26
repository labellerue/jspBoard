package kr.or.ddit.file_post.service;

import java.util.List;

import kr.or.ddit.file_post.dao.FilesDao;
import kr.or.ddit.file_post.dao.FilesDaoInf;
import kr.or.ddit.file_post.model.FilesVo;

public class FilesService implements FilesServiceInf {
	private FilesDaoInf filesDao = new FilesDao();

	@Override
	public List<FilesVo> selectFiles(int post_id) {
		return filesDao.selectFiles(post_id);
	}

	@Override
	public int insertFiles(FilesVo filesVo) {
		return filesDao.insertFiles(filesVo);
	}

	@Override
	public int deleteFiles(int post_id) {
		return filesDao.deleteFiles(post_id);
	}

}
