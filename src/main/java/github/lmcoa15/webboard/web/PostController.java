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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import github.lmcoa15.webboard.dto.Category;
import github.lmcoa15.webboard.dto.Post;
import github.lmcoa15.webboard.dto.User;
import github.lmcoa15.webboard.service.CategoryService;
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
	
	@Inject
	CategoryService categoryService; // = new cateService();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String pageList(HttpServletRequest req, Locale locale, Model model) {
		
		List<Category> categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		return "main";
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
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String pageWrite (HttpServletRequest req) {
		// FIXME 로그인 한 사람만 이 페이지를 봐야 합니다.
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);
		
		return "pageWrite";
	}
	
	@RequestMapping(value="/invalid", method=RequestMethod.GET)
	public String pageInvalidReq() {
		return "invalid";
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
		String content = req.getParameter("contents");
		System.out.println(title + ", " + content);
		
		Post post = postService.findBySeq(seq);
		post.setTitle(title);
		post.setContents(content);
		
		postService.update(post);
		String s= null;
		String v = "a" + s; // "anull"
		
		return "redirect:/"+post.getCategory().getAlias();
	}
	
	@RequestMapping(value="/doWrite", method=RequestMethod.POST)
	public String pagedoWrite (HttpServletRequest req) throws UnsupportedEncodingException {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		req.setCharacterEncoding("UTF-8"); // 인코딩을 변경해줘야 합니다. 

//		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
//		Date currentTime = new Date ();
//		String mTime = mSimpleDateFormat.format ( currentTime );


		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String cate = req.getParameter("category");


		Post post = new Post(title,contents);
		User writer = null;
		
		//글 작성자 저장
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		if(loginUser==null)
			return "redirect:/login";
		
		//카테고리 저장
		Category category = categoryService.findCategoryByAlias(cate);

		post.setWriter(loginUser);
		post.setCategory(category);
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
	
	@RequestMapping(value="/pageRead", method=RequestMethod.GET)
	public String pageRead2(
		@RequestParam Integer pid, @RequestParam String cate, HttpServletRequest req, Model model ) {
		
		List<Category> categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		Post post = postService.readPost(pid);
		post.getCategory();
		System.out.println("post: " + post);
		req.setAttribute("post",post);
		
		Boolean isWriter = true;
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		
		req.setAttribute("isWriter", isWriter);
		
		/*
		 * 현재 조회한 게시글이 속한 카테고리가 아니라, 방금전에 보여지던 카테고리를 나타냄
		 * (전체글을 타고 현재 링크를 클릭했을 수 잇기 때문에 [목록] 링크의 카테고리 별칭(alias) 가 일치하지 않음
		 * */
		Category category ;
		if( "main".equals(cate)) {
			category = new Category("main", "전체글");
		} else {
			category = categoryService.findCategoryByAlias(cate);
		}
		
		req.setAttribute("category", category);
		
		return "pageRead"; //internal resource view에서 주어진 문자열로 jsp까지의 경로를 조립합니다.
	
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String pageMain(HttpServletRequest req, Model model) {

		//게시글 위한 post정보 다시 가져온다.
		List<Post> posts = postService.findAll();
		model.addAttribute("posts",posts);
				
		List<Category> categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		//실제 Category table(DB)에는 없는 전체글 표시하기 위해 설정
		Category category = new Category();
		category.setCateName("전체글");
		category.setAlias("main");
		
		model.addAttribute("category", category);
		return "pagePost"; 
	}
	
	@RequestMapping(value="/pageEdit", method=RequestMethod.GET)
	public String pageEdit (HttpServletRequest req, Model model) {
		// FIXME 지금 수정하려는 글을 작성한 사람만이 접근할 수 있어야 함!
		
		List<Category> categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		String value = req.getParameter("pid");
		Integer seq = Integer.parseInt(value);
		
		HttpSession http = req.getSession();
		User loginUser = (User)http.getAttribute("LOGIN_USER");
		Post post = postService.findBySeq(seq);
		
		//DB접근으로 수정
		User writer = post.getWriter();

		
		// NULL.method() NUll pointer exception
		if(loginUser==null || !loginUser.equals(writer)) {
			return "redirect:/invalid?err=NOT_A_WRITER";
		}
		
		Post p = postService.findBySeq(seq);
		req.setAttribute("post",p);
		
		return "pageEdit";
	}
	
	/*
	 *requestMapping에 있는 {}안에 있는 변수에(value)에 값 넣어준다.
	 *@PathVariable에 있는 value변수는 위에 requestMapping에 있는 변수와 이름을 맞춰줘야 한다.
	 *   /example/yes
	 *   /example/good
	 *   /example/hello
	 *   만약 login이 이미 @RequestMapping 되어 있으면 login으로 가고 남는것들 여기로 온다.
	 * */
	@RequestMapping(value="/{value}") 
	public String pageCategory(@PathVariable String value, Model model) { 
		
		//게시글 위한 post정보 다시 가져온다.
		List<Post> posts = postService.findPostsByAlias(value);
		model.addAttribute("posts",posts);
		
		//left-side를 위해 카테고리 정보 다시 가지고 와야한다.
		List<Category> categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		//왼쪽 카테고리 선택했을 때 타이틀 값 저장
		Category category = categoryService.findCategoryByAlias(value);
		model.addAttribute("category", category);

		return "pagePost";
	}
	
}
