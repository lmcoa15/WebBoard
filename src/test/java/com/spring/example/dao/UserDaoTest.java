package com.spring.example.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import github.lmcoa15.webboard.dao.UserDao;
import github.lmcoa15.webboard.dto.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserDaoTest {

	@Inject
	DataSource ds;
	
	@Inject SqlSessionTemplate session ; //
	
	@Inject UserDao userDao;
	
	
	@Test
	public void test() throws SQLException {
		assertNotNull(ds);
		Connection con = ds.getConnection();
		con.close();
	}
	
	@Test
	public void testSession() {
		assertNotNull( session);
		List<User> users = session.selectList("UserMapper.findAll");
		assertEquals(2, users.size());
		assertEquals("aaa", users.get(0).getId());
		assertEquals("aaa@naver.com", users.get(0).getEmail());
		assertEquals("111", users.get(0).getPassword());
	}
	
	@Test
	public void login() {
		
		User bb = userDao.login("bb", "2222");
		assertEquals("bb", bb.getId());
		assertEquals("2222", bb.getPassword());
	}

}
