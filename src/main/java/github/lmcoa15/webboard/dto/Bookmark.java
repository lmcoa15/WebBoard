package github.lmcoa15.webboard.dto;

public class Bookmark {
	
	Integer post;
	Integer bookmaker;
	String bmkDate;
	
	public Bookmark(Integer post,Integer bookmaker, String bmkDate) {
		super();
		this.post = post;
		this.bookmaker = bookmaker;
		this.bmkDate = bmkDate;
	}
	
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public Integer getBookmaker() {
		return bookmaker;
	}
	public void setBookmaker(Integer bookmaker) {
		this.bookmaker = bookmaker;
	}
	public String getBmkDate() {
		return bmkDate;
	}
	public void setBmkDate(String bmkDate) {
		this.bmkDate = bmkDate;
	}
	
	
}
