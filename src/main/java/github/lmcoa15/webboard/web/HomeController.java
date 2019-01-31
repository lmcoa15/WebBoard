package github.lmcoa15.webboard.web;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import github.lmcoa15.webboard.dto.Post;
import github.lmcoa15.webboard.service.PostService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject // spring 한테 호환되는 타입의 빈을 연결시켜달라!
	PostService postService ; // = new PostService();
	
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
		
		return "read";
	
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String pageWrite (HttpServletRequest req) {
		// FIXME 로그인 한 사람만 이 페이지를 봐야 합니다.
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);
		
		return "write";
	}
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String pageEdit (HttpServletRequest req) {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		
		String value = req.getParameter("pid");
		Integer seq = Integer.parseInt(value);
		
		Post p = postService.findBySeq(seq);
		req.setAttribute("post",p);
		
		return "edit";
	}
	/*
	 * Post 요청은 GET 요청과 다른 점이 있음
	 * 
	 * 대부분의 Post요청은 애플리케이션 기능을 요구하는 요청이기때문에 
	 * 별도의 반환 페이지가 존재하지 않음!
	 * 
	 * 
	 */
	@RequestMapping(value="/doEdit_old", method=RequestMethod.POST)
	public String pagedoEdit (HttpServletRequest req) {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		String value = req.getParameter("seq");
		Integer seq = Integer.parseInt(value);
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Post post = postService.findBySeq(seq);
		post.setTitle(title);
		post.setContent(content);
		postService.update(post);
		
//		
//		List<Post> all = postService.findAll();
//		req.setAttribute("posts", all);
		
		// 리다이렉트로 응답을 보냄! 302 응답!
//		return "list";
		return "redirect:/";
	}
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String pagedoEdit2 (HttpServletRequest req,
			@RequestParam Integer seq, 
			@RequestParam String title,
			@RequestParam String content) {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		Post post = postService.findBySeq(seq);
		post.setTitle(title);
		post.setContent(content);
		postService.update(post);
		
//		
//		List<Post> all = postService.findAll();
//		req.setAttribute("posts", all);
		
		// 리다이렉트로 응답을 보냄! 302 응답!
		return "redirect:/";
	}
	
}
