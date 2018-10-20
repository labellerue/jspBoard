package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.com.model.PageVo;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceInf{


	private PostDaoInf postDao = new PostDao();
	
	public List<PostVo> selectAllPost() {
		return postDao.selectAllPost();
	}

	@Override
	public PostVo selectPost(String post_id) {
		return postDao.selectPost(post_id);
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
	public Map<String, Object> selectPostPageList(PageVo pageVo) {
		//페이지에 해당하는 유저 리스트(1~10건 사이)
		List<PostVo> pageList = postDao.selectPostPageList(pageVo);
		
		//페이지 네비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = postDao.getPostCnt();
		
		//결과를 담는 mapp 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageList", pageList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int insertPost(PostVo postVo) {
		return postDao.insertPost(postVo);
	}


	@Override
	public int updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}
	

}
