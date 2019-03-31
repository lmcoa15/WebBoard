package github.lmcoa15.webboard.dto;

public class Comments {
	
	Integer seq;
	Integer post;
	Integer writer;
	String initDate;
	String modiDate;
	String contents;
	
	public Comments(Integer seq, Integer post, Integer writer, String initDate, String modiDate, String contents) {
		super();
		this.seq = seq;
		this.post = post;
		this.writer = writer;
		this.initDate = initDate;
		this.modiDate = modiDate;
		this.contents = contents;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public Integer getWriter() {
		return writer;
	}

	public void setWriter(Integer writer) {
		this.writer = writer;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public String getModiDate() {
		return modiDate;
	}

	public void setModiDate(String modiDate) {
		this.modiDate = modiDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
