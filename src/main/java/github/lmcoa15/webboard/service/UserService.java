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
		 
		 return userDao.login(userId, password);
	 }
}
