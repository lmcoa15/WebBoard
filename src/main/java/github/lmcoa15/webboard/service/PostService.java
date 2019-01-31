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

	public Post findBySeq(Integer seq) {
		return postDao.findBySeq(seq);
	}

	public void update(Post post) {
		postDao.update(post);
	}
}
