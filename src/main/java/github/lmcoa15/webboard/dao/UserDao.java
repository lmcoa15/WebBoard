package github.lmcoa15.webboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import github.lmcoa15.webboard.dto.User;

@Repository
public class UserDao {

	@Inject SqlSessionTemplate session ; //

	 
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
	 /**
	  * 주어진 아이디와 비번에 대응하는 사용자가 있으면 반환함.
	  * 그렇지 않으면 null 을 반환합니다.
	  * @param userId
	  * @param password
	  * @return
	  */
	 // public login(var userId, var password) { ... }
	 
	public User login(String userId, String password) {
		
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("userId", userId);
		param.put("password", password);
		System.out.println("도착");
		System.out.println(param);

		User user = session.selectOne("UserMapper.login", param);
		return user;
		/*
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
		*/
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
