package github.lmcoa15.webboard.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import github.lmcoa15.webboard.dto.User;

@Repository
public class UserDao {

	 List<User> fakeUsers = new ArrayList<>();
	 {
		 // TODO 2019-02-18 아래와 같이 가짜 사용자를 몇 개 등록함
		 // fakeUsers.add(new User(....) );
	
		// FIXME 테스트를 위해서 가짜로 넣어둠
	    fakeUsers.add(new User(1000, "aaa", "john@naver.com", "1999-10-01", "111"));
	    fakeUsers.add(new User(1001, "bbb", "jane@naver.com", "2000-10-01", "111"));
	
	 }
	 

	
	 public User login(String userId, String password) {
		 
		 // TODO 2019-02-18 fakeUsers 리스트에서 주어진 id와 암호에 대응하는 사용자를 찾아서 반환함 없으면 null 리턴함
		 for(int i=0;i<fakeUsers.size();i++) {
			 User u = fakeUsers.get(i);
			 if(u.getId().equals(userId) && u.getPassword().equals(password))
				 return u;
		 }
		 
		 return null;
	}	
	
}
