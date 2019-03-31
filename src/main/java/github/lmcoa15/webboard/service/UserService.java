package github.lmcoa15.webboard.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import github.lmcoa15.webboard.dao.UserDao;
import github.lmcoa15.webboard.dto.User;

@Service
public class UserService {
	
	 @Inject
	 UserDao userDao;

	 public User login(String userId, String password) {
		 
		 User user=new User();
		 user.setId(userId);
		 user.setPassword(password);
		 return user;
		 
		 //return userDao.login(userId, password);
	 }
}
