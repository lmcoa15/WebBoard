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
		/*
		if(p!=null) {
			p.setViewCount(p.getViewCount() + 1 ); // 1.5 이상 !!							
		}
		*/
		return p;
	}
	
	public Post readPost(Integer seq) {
		postDao.increaseViewCount(seq);
		Post p = findBySeq(seq);
		return p;
	}

	public void Insert(Post post) {
		postDao.insert(post);
	}
	
	public void update(Post post) {
		// 글 쓴 사람이 수정해야 함
		// 1) 주문디비 
		// 2) 재고 조정
		// 3) 결제 
		// 4) 문자 발송
		// 5) 포인트 적립
		postDao.update(post);
	}

	public void Delete(Integer seq) {
		// 
		postDao.delete(seq);
		
	}

	public List<Post> findPostsByAlias(String value) {
		// TODO Auto-generated method stub
		
		return postDao.findPostsByAlias(value);
	}
}
