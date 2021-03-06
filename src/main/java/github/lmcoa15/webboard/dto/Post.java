package github.lmcoa15.webboard.dto;

import java.util.ArrayList;

public class Post {
	/*
	글번호:유일한 값을 갖는 숫자?
			   제목 : 
			   글 내용 :
			   작성일 : 20181212 12:34:10
	*/
	Integer seq; // PK
	String title;
	String contents;
	String date; 
	User writer; 
	Integer viewCount; // 0
	Category category; // Category;
	
	//기본 생성자
	public Post() {}
	
	public Post(Integer seq, String title, String contents, String date, User writer, Integer viewCount, Category category) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.writer = writer;
		this.viewCount = viewCount;
		this.category = category;
	}

	public Post(String title, String contents) {
		super();
		this.title = title;
		this.contents = contents;
	}

	
	public Integer getSeq() {
		return seq;
	}


	public void setSeq(Integer seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public User getWriter() {
		return writer;
	}


	public void setWriter(User writer) {
		this.writer = writer;
	}


	public Integer getViewCount() {
		return viewCount;
	}


	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post [seq=" + seq + ", title=" + title + ", contents=" + contents + ", date=" + date + ", writer="
				+ writer + ", viewCount=" + viewCount + ", category=" + category + "]";
	}
	
	
}

