package github.lmcoa15.webboard.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import github.lmcoa15.webboard.dto.Category;
import github.lmcoa15.webboard.dto.Post;

@Repository
public class CategoryDao {
	
	@Inject SqlSessionTemplate session ;
	
	public List<Category> findAll() {
		
		return session.selectList("CategoryMapper.findAll");
		
	}
	
	//category 타이들
	public Category findCategoryByAlias(String value) {

		return session.selectOne("CategoryMapper.findCategoryByAlias",value);
		
	}

}
