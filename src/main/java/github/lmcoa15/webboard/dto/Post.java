package github.lmcoa15.webboard.dto;

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
	public Post(Integer seq, String title, String content, String creationTime) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.creationTime = creationTime;
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
	@Override
	public String toString() {
		return "Post [seq=" + seq + ", title=" + title + ", content=" + content + ", creationTime=" + creationTime
				+ "]";
	}
	
}
