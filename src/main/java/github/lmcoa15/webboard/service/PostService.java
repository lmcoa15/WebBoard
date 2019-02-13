package github.lmcoa15.webboard.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import github.lmcoa15.webboard.dao.PostDao;
import github.lmcoa15.webboard.dto.Post;

@Service
public class PostService {

	@Inject
	PostDao postDao ;
	
	// UserDao userDao;
	
	/**
	 * 모든 게시물들을 전부 반환함
	 * @return
	 */
	public List<Post> findAll() {
		List<Post> posts = postDao.findAll();
		return posts;
	}

	// Object lock = new Object();
	public Post findBySeq(Integer seq) {
		Post p = postDao.findBySeq(seq);
		if(p!=null) {
			p.setViewCount(p.getViewCount() + 1 ); // 1.5 이상 !!							
		}
		return p;
	}

	public void Insert(Post newPost) {
		postDao.insert(newPost);
	}
	
	public void update(Post post) {
		// 글 쓴 사람이 수정해야 함
		
		postDao.update(post);
	}

	public void Delete(String seq) {
		// 
		postDao.delete(seq);
		
	}
}
