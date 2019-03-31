package github.lmcoa15.webboard.dto;

public class Vote {
	
	Integer post; //게시글 주인
	Integer voter; //투표자
	Integer counts; //찬반
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public Integer getVoter() {
		return voter;
	}
	public void setVoter(Integer voter) {
		this.voter = voter;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
}
