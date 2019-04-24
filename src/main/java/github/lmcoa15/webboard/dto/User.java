package github.lmcoa15.webboard.dto;
/**
 * 
 * - id
 * - email
 * - birth
 * - password
 * - 
 * @author Moon
 *
 */
public class User {
	
	Integer seq;
	String userId;
	String password;
	String email;
	String joinDate;
	
	public User() {}
	
	public User(Integer seq, String userId, String password, String email, String joinDate) {
		super();
		this.seq = seq;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [seq=" + seq + ", userId=" + userId + ", password=" + password + ", email=" + email + ", joinDate="
				+ joinDate + "]";
	}
	

}
