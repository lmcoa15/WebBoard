package github.lmcoa15.webboard.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import github.lmcoa15.webboard.dto.Post;
import github.lmcoa15.webboard.dto.User;
/**
 * AOP - 
 * @author Moon
 *
 */
@Repository
public class PostDao {
	User fakeUser = new User(5000, "aaa", "aaa@naver.com", "1900-12-11", "111");
//	Post p1 = new Post(1000, "첫번째글", "안녕하세요", "2019-01-11 12:22:11","writer1",24, 1);
//	Post p2 = new Post(1001, "배고픔", "배교프다", "2019-01-13 12:22:11","writer2",26, 2);
//	Post p3 = new Post(1002, "Test3", "Content3", "2019-01-21 12:22:11",66, fakeUser);
//	List<Post> posts = new ArrayList<Post>(Arrays.asList(p1, p2, p3));
	
	@Inject SqlSessionTemplate session ;

	public List<Post> findAll() {

		List<Post> posts = session.selectList("PostMapper.findAll");
		return posts;
	}

	public Post findBySeq(Integer seq) {
		
		Post post = session.selectOne("PostMapper.find", seq);
		if(post==null)
			return null;
		
		return post;

	}

	static int seq = 30000;
	public void insert(Post post) {
		// seq 를 가짜로 만들어줌
		// 지금 등록 시간도 가짜로 넣어줌

		session.insert("PostMapper.write", post);
	}
	
	String curTime() {
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return df.format(new Date());
//		return "2019-02-12 12:21:00";
	}
	
	public void update(Post post) {

		session.update("PostMapper.update", post);
		
	}

	public void delete(Integer seq) {
		// TODO Auto-generated method stub
		session.delete("PostMapper.delete",seq);
	}
}
