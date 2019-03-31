package github.lmcoa15.webboard.dto;

public class Category {
	
	Integer seq;
	String cateName; //카테고리 명
	
	public Category(Integer seq, String cateName) {
		super();
		this.seq = seq;
		this.cateName = cateName;
	}
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
}
