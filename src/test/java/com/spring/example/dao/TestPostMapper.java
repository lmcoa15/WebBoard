package com.spring.example.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import github.lmcoa15.webboard.dto.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestPostMapper {

	@Inject
	SqlSessionTemplate session;
	
	@Test
	public void test() {
		assertNotNull(session);
		System.out.println("OK??");
		List<Post> posts = session.selectList("PostMapper.findAll");
		for(Post p : posts) {
			System.out.println(p);
		}
		
	}

}
