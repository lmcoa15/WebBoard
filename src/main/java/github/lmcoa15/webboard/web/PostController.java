package github.lmcoa15.webboard.web;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import github.lmcoa15.webboard.dto.Post;
import github.lmcoa15.webboard.dto.User;
import github.lmcoa15.webboard.service.PostService;
import github.lmcoa15.webboard.util.Util;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PostController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Inject // spring 한테 호환되는 타입의 빈을 연결시켜달라!
	PostService postService; // = new PostService();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String pageList(HttpServletRequest req, Locale locale, Model model) {
		
		List<Post> allPost = postService.findAll();
		req.setAttribute("posts", allPost);
		
		model.addAttribute("posts", allPost);
		/*
		 * { posts: [p1, p2, p3] }
		 */
		
		// /WEB-INF/views/home.jsp
		return "list";
	}
	
	@RequestMapping(value="/read_old", method=RequestMethod.GET)
	public String pageRead(HttpServletRequest req) {
		
		String value = req.getParameter("pid"); // "1000"
		Integer seq = Integer.parseInt(value); // 1000
		Post post = postService.findBySeq(seq);
		System.out.println("post: " + post);
		req.setAttribute("post",post);
		
		return "read";
	
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String pageRead2(
		@RequestParam Integer pid, HttpServletRequest req ) {
		
		Post post = postService.findBySeq(pid);
		System.out.println("post: " + post);
		req.setAttribute("post",post);
		
		Boolean isWriter = true;
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		
		//User db 접근해서 가져온다
		//User writer = post.getWriter();
		
		// NULL.method() NUll pointer exception
//		if(loginUser==null || !loginUser.equals(writer)) {
//			isWriter=false;
//		}
		req.setAttribute("isWriter", isWriter);
		
		return "read"; //internal resource view에서 주어진 문자열로 jsp까지의 경로를 조립합니다.
	
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String pageWrite (HttpServletRequest req) {
		// FIXME 로그인 한 사람만 이 페이지를 봐야 합니다.
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);
		
		return "write";
	}
	
	@RequestMapping(value="/invalid", method=RequestMethod.GET)
	public String pageInvalidReq() {
		return "invalid";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String pageEdit (HttpServletRequest req) {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		String value = req.getParameter("pid");
		Integer seq = Integer.parseInt(value);
		
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		Post post = postService.findBySeq(seq);
		
		//DB접근으로 수정
		//User writer = post.getWriter();
		
		// NULL.method() NUll pointer exception
//		if(loginUser==null || !loginUser.equals(writer)) {
//			return "redirect:/invalid?err=NOT_A_WRITER";
//		}
		
		Post p = postService.findBySeq(seq);
		req.setAttribute("post",p);
		
		return "edit";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String pageDelete (HttpServletRequest req) {
		
		
		// FIXME 어떤 리소스요청들(/delete, /doDelete, ..)의 경우권한 체크하는 코드가 계속 들어감
		// 스프링에서는 인터셉터라는 기능을 이용해서 이런 권한 확인 코드들도 한군데로 다 빼버립니다.
		String value = req.getParameter("pid");
		Integer seq = Integer.parseInt(value);
		Post post = postService.findBySeq(seq);
		
		HttpSession http = req.getSession();
		if ( !Util.isWriter(http, post) ) {
			return "redirect:/invalid?err=NOT_A_WRITER";
		}
		req.setAttribute("post",post);
		
		return "delete";
	}
	/*
	 * Post 요청은 GET 요청과 다른 점이 있음
	 * 
	 * 대부분의 Post요청은 애플리케이션 기능을 요구하는 요청이기때문에 
	 * 별도의 반환 페이지가 존재하지 않음!
	 * 
	 * 
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String pagedoEdit (HttpServletRequest req) throws UnsupportedEncodingException {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		 
		req.setCharacterEncoding("UTF-8"); // 인코딩을 변경해줘야 합니다. 
		String value = req.getParameter("seq");
		Integer seq = Integer.parseInt(value);
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println(title + ", " + content);
		
		Post post = postService.findBySeq(seq);
		post.setTitle(title);
		post.setContents(content);
		
		postService.update(post);
		
//		
//		List<Post> all = postService.findAll();
//		req.setAttribute("posts", all);
		
		// 리다이렉트로 응답을 보냄! 302 응답!
//		return "list";
		return "redirect:/";
	}
	
	@RequestMapping(value="/doWrite", method=RequestMethod.POST)
	public String pagedoWrite (HttpServletRequest req) throws UnsupportedEncodingException {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		req.setCharacterEncoding("UTF-8"); // 인코딩을 변경해줘야 합니다. 

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );


		//출처: https://includestdio.tistory.com/4 [includestdio]
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		Post post = new Post(title,contents); 
		postService.Insert(post);
		
//		
//		List<Post> all = postService.findAll();
//		req.setAttribute("posts", all);
		
		// 리다이렉트로 응답을 보냄! 302 응답!
//		return "list";
		// /read?pid=30000
		return "redirect:/read?pid="+post.getSeq();
	}
	
	@RequestMapping(value="/doDelete", method=RequestMethod.POST)
	public String pagedoDelete (HttpServletRequest req) throws UnsupportedEncodingException {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		req.setCharacterEncoding("UTF-8"); // 인코딩을 변경해줘야 합니다. 

		
		postService.Delete(Integer.parseInt(req.getParameter("seq")));
		
//		
//		List<Post> all = postService.findAll();
//		req.setAttribute("posts", all);
		
		// 리다이렉트로 응답을 보냄! 302 응답!
//		return "list";
		// /read?pid=30000
		return "redirect:/";
	}
	
//	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String pagedoEdit2 (HttpServletRequest req,
			@RequestParam Integer seq, 
			@RequestParam String title,
			@RequestParam String content) {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		System.out.println(title + ", " + content);
		Post post = postService.findBySeq(seq);
		post.setTitle(title);
		post.setContents(content);
		postService.update(post);
		
//		
//		List<Post> all = postService.findAll();
//		req.setAttribute("posts", all);
		
		// 리다이렉트로 응답을 보냄! 302 응답!
		return "redirect:/";
	}
	
}
