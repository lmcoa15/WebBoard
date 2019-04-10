package github.lmcoa15.webboard.dto;

public class Category {
	
	Integer seq;
	String cateName; //카테고리 명
	String alias; //domain 명
	public Category(Integer seq, String cateName, String alias) {
		super();
		this.seq = seq;
		this.cateName = cateName;
		this.alias = alias;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
}
