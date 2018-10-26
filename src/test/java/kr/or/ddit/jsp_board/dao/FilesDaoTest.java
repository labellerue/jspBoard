package kr.or.ddit.jsp_board.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.file_post.dao.FilesDao;
import kr.or.ddit.file_post.dao.FilesDaoInf;
import kr.or.ddit.file_post.model.FilesVo;

public class FilesDaoTest {
	FilesDaoInf filesDao;
	
	@Before
	public void setUp() throws Exception {
		filesDao = new FilesDao();
	}

	@Test
	public void insertFilesTest() {
		/***Given***/
		FilesVo filesVo = new FilesVo();
		filesVo.setFile_path("/files/new.jpg");
System.out.println(filesVo.getFile_path());
		/***When***/
		//int insertFCnt = filesDao.insertFiles(filesVo);

		/***Then***/
		//assertEquals(1, insertFCnt);
	}

}
