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
	String content;
	String creationTime; // java.util.Date
	// User writer; [ id, email, joinDate]
	int viewCount; // 0
	
	ArrayList<Integer> num;
	ArrayList<Double> ddd;
	
	public Post(Integer seq, String title, String content, String creationTime, Integer viewCount) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.creationTime = creationTime;
		this.viewCount = viewCount;
	}
	
	
	public Post(String title, String content) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	@Override
	public String toString() {
		return "Post [seq=" + seq + ", title=" + title + ", content=" + content + ", creationTime=" + creationTime
				+ "]";
	}
	
}

