package github.lmcoa15.webboard.util;

import javax.servlet.http.HttpSession;

import github.lmcoa15.webboard.dto.Post;
import github.lmcoa15.webboard.dto.User;

public class Util {

//	public static boolean isWriter(Post p, User user) {
//		return false;
//	}
	public static boolean isWriter(HttpSession session, Post post) {
		
		User loginUser = (User)session.getAttribute("LOGIN_USER");
		User writer = post.getWriter();
		
		// NULL.method() NUll pointer exception
		if(loginUser==null || !loginUser.equals(writer)) {
			return false;
		}
		
		return true;	
	}
}
