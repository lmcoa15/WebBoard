package github.lmcoa15.webboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import github.lmcoa15.webboard.dto.User;

@Repository
public class UserDao {

	@Inject SqlSessionTemplate session ; //
	//	 List<User> fakeUsers = new ArrayList<>();
	/*
	 {
		 // TODO 2019-02-18 아래와 같이 가짜 사용자를 몇 개 등록함
		 // fakeUsers.add(new User(....) );
	
		// FIXME 테스트를 위해서 가짜로 넣어둠
	    fakeUsers.add(new User(1000, "aaa", "john@naver.com", "1999-10-01", "111"));
	    fakeUsers.add(new User(1001, "bbb", "jane@naver.com", "2000-10-01", "111"));
	
	 }
	 */

	 @Inject
	 DataSource dataSource; 
	 
	 public List<User> findAll() {
		 return session.selectList("UserMapper.findAll");
		 /*
		 String query = "select * from users";
		 Connection con = null;
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(query);
			
			rs = stmt.executeQuery(); // query가 디비로 날아감
			List<User> users = new ArrayList<User>();
			while ( rs.next()) {
				int seq = rs.getInt("seq");
				String userId = rs.getString("userid");
				String email = rs.getString("email");
				String passwd = rs.getString("pass");
				User user = new User(seq, userId, email, "1900-12-12", passwd);
				users.add(user);
			}
			
			return users;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(con, stmt, rs);
		}
		*/
	 }
	
	 void close(Connection con, PreparedStatement stmt, ResultSet rs) {
		 ;
	}

	public User login(String userId, String password) {
		
		String query = "select * from users where userid=? and pass = ?";
		 Connection con = null;
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, userId);
			stmt.setString(2, password);
			
			
			rs = stmt.executeQuery(); // query가 디비로 날아감
			User user = null;
			if ( rs.next()) {
				int seq = rs.getInt("seq");
				userId = rs.getString("userid");
				String email = rs.getString("email");
				String passwd = rs.getString("pass");
				user = new User(seq, userId, email, "1900-12-12", passwd);
			}
			
			return user;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(con, stmt, rs);
		}
		 /*
		 // TODO 2019-02-18 fakeUsers 리스트에서 주어진 id와 암호에 대응하는 사용자를 찾아서 반환함 없으면 null 리턴함
		 for(int i=0;i<fakeUsers.size();i++) {
			 User u = fakeUsers.get(i);
			 if(u.getId().equals(userId) && u.getPassword().equals(password))
				 return u;
		 }
		 */
	}	
	
}
