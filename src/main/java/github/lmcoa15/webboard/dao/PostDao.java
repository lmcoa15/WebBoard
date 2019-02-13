package github.lmcoa15.webboard.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import github.lmcoa15.webboard.dto.Post;
/**
 * AOP - 
 * @author Moon
 *
 */
@Repository
public class PostDao {
	Post p1 = new Post(1000, "첫번째글", "안녕하세요", "2019-01-11 12:22:11",24);
	Post p2 = new Post(1001, "배고픔", "배교프다", "2019-01-13 12:22:11",26);
	Post p3 = new Post(1002, "Test3", "Content3", "2019-01-21 12:22:11",66);
	List<Post> posts = new ArrayList<>(Arrays.asList(p1, p2, p3));
	

	public List<Post> findAll() {
		// FIXME 지금은 디비가 없으니까 가짜로 아무거나 리턴합니다.
		return posts;
	}

	public Post findBySeq(Integer seq) {
		// 이쪽 코드는 원래 디비에서 조회하는 코드로 대체되어야 함
		for(int i= 0 ; i < posts.size();i++) {
			Post p = posts.get(i);
			// FIXME 이거 나중에 오류낭ㄹ 수 잇음! 128개 이상이면!!
			// 참조 변수는 == 으로 비교하면 안됨!
			if(p.getSeq().equals(seq)) {
				return p;
			}
		}
		
		return null;
	}

	static int seq = 30000;
	public void insert(Post post) {
		// seq 를 가짜로 만들어줌
		// 지금 등록 시간도 가짜로 넣어줌
		post.setSeq(seq++);
		post.setCreationTime(curTime());
		posts.add(post);
	}
	
	String curTime() {
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return df.format(new Date());
//		return "2019-02-12 12:21:00";
	}
	
	public void update(Post post) {
		// 실제로는 업데이트 쿼리를 실행함
		// 지금은 메모리에 있으니까 별효과 없음!
		
	}
}
