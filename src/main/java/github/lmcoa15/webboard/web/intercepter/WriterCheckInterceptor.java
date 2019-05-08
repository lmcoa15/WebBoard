package github.lmcoa15.webboard.web.intercepter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import github.lmcoa15.webboard.dto.Post;
import github.lmcoa15.webboard.dto.User;
import github.lmcoa15.webboard.service.PostService;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Inject // spring 한테 호환되는 타입의 빈을 연결시켜달라!
	PostService postService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("[WRITER  CHEKC] " + req.getRequestURI() );
		//로그인 유저
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		
		//글 소유자
		String value = req.getParameter("pid");
		Integer seq = Integer.parseInt(value);
		Post post = postService.findBySeq(seq);

		User writer = post.getWriter();
		if(loginUser==null || !loginUser.equals(writer)) {
			
			res.sendRedirect(req.getContextPath() + "/invalid?err=NOT_A_WRITER");
			return false;
		}
		
		return true; //=super.preHandle(req, res, handler);
	}

}
