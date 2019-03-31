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
	String id;
	String password;
	String email;
	String joinDate;
	
	public User() {}
	
	public User(Integer seq, String id, String password, String email, String joinDate) {
		super();
		this.seq = seq;
		this.id = id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
