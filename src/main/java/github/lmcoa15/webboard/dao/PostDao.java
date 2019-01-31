package github.lmcoa15.webboard.dao;

import java.util.Arrays;
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
	Post p1 = new Post(1000, "첫번째글", "안녕하세요", "2019-01-11 12:22:11");
	Post p2 = new Post(1001, "배고픔", "배교프다", "2019-01-13 12:22:11");
	Post p3 = new Post(1002, "Test3", "Content3", "2019-01-21 12:22:11");
	List<Post> posts = Arrays.asList(p1, p2, p3);
	

	public List<Post> findAll() {
		// FIXME 지금은 디비가 없으니까 가짜로 아무거나 리턴합니다.
		return posts;
	}

	public Post findBySeq(Integer seq) {
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

	public void update(Post post) {
		// 실제로는 업데이트 쿼리를 실행함
		// 지금은 메모리에 있으니까 별효과 없음!
		
	}
}
