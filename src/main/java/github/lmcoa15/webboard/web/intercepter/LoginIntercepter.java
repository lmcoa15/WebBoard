package github.lmcoa15.webboard.web.intercepter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import github.lmcoa15.webboard.dto.User;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	// TODO 소스코드안에 uri 들을 박아넣은 경우
	// https://www.baeldung.com/spring-value-annotation
	// https://www.mkyong.com/spring/spring-value-import-a-list-from-properties-file/
	// 위의 링크를 보면 경로와 같은 설정 정보를 외부로 빼내고 읽어들이는 방법이 잘 나와 있음
	List<String> checkUrl = Arrays.asList("/write", "/doWrite", "/myinfo", "/doDelete");
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		
		//String uri = req.getRequestURI();
		String uri = stripUri(req);
		if(checkUrl.contains(uri)) {
			return checkLogin(uri, req, res);
		} else {
			return true;
		}
	}
	
	private boolean checkLogin(String uri, HttpServletRequest req, HttpServletResponse res) throws IOException {
		/**
		 * 1.로그인 확인
		 * */
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		System.out.println("[LOGIN CHECK] URI: " + uri);
		if(loginUser==null) {
			http.setAttribute("orignUrl", stripUri(req));
			// return "redirect:/login";		
			res.sendRedirect(req.getContextPath() + "/login");
			System.out.println("[LOGIN CHECK] redirect to : /login");
			return false;
		} else {
			System.out.println("[LOGIN CHECK] passed : " + uri);
			return true;
		}
	}
	
	
	String stripUri(HttpServletRequest req) {
		String ctxpath = req.getContextPath(); // "/example"
		String uri = req.getRequestURI();      // "/example/write"
		return uri.substring(ctxpath.length());
	}

}
