package github.lmcoa15.webboard.web;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import github.lmcoa15.webboard.dto.Category;
import github.lmcoa15.webboard.dto.User;
import github.lmcoa15.webboard.service.CategoryService;
import github.lmcoa15.webboard.service.UserService;
/**
 *  사용자 가입, /doJoin 
 *  로그인, /login 
 *  정보수정, 
 *  탈퇴, 
 *  내정보 가리기 
 * @author Moon
 *
 */
@Controller
public class UserController {

	/**
	 * @Service, @Controller, @Repository 등으로 생성된 빈들을 주입 받겠다 (저 3개 표시가 인스턴스 만든다는 의미)
	 *  
	 * */
	@Inject // spring 한테 호환되는 타입의 빈을 연결시켜달라!
	UserService userService; // = new UserService();

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String pageLogin(HttpServletRequest req ) {
		return "login"; 
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String pageLogout(HttpServletRequest req ) {
		HttpSession http = req.getSession();
		http.invalidate();
		return "redirect:/"; 
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String doLogin(HttpServletRequest req) {

		String userId = req.getParameter("ID");
		String password = req.getParameter("Password");
		User loginUser = userService.login(userId,password);
		
		System.out.println("login결과");
		System.out.println(loginUser);

		String redirectUrl = "/";
		if(loginUser==null) { 
			System.out.println("로그인 실패");
			redirectUrl= "/login";
		}
		else {
			// session 에 사용자를 담아줘야 합니다.
			HttpSession session = req.getSession(); // 요청과 요청 사이에도 존속시킬 수 있는 저장공간
			session.setAttribute("LOGIN_USER", loginUser); //
			session.setAttribute("LOGIN_TIME", System.currentTimeMillis());
			// session.invalidate(); // 없애라
			System.out.println("로그인 성공");
			
			
			//원래 가려던 경로가 있을 때 
			if(session.getAttribute("orignUrl")!=null) {
				//경로
				redirectUrl = (String) session.getAttribute("orignUrl");
				session.removeAttribute("orignUrl"); //다시 없애준다.
			}
		}
		// 코딩 테크닉 관점에서 보면 return을 두군데서 하면 안좋음...
		
		return "redirect:"+redirectUrl;
		
	}
	
	@RequestMapping(value="/myinfo", method=RequestMethod.GET)
	public String pageMyInfo(HttpServletRequest req ) {
		
		// 그대로 똑같이 가져왔음
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		if(loginUser==null) {
			http.setAttribute("orignUrl", stripUri(req));
			return "redirect:/login";			
		}
		
		return "myinfo"; 
	}
	
	String stripUri(HttpServletRequest req) {
		String ctxpath = req.getContextPath(); // "/example"
		String uri = req.getRequestURI();      // "/example/write"
		return uri.substring(ctxpath.length());
	}
	
}


