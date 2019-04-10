package github.lmcoa15.webboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import github.lmcoa15.webboard.dao.CategoryDao;
import github.lmcoa15.webboard.dto.Category;

@Service
public class CategoryService {
	
	@Inject
	CategoryDao categoryDao;
	
	public List<Category> findAll(){
		// List<Category> category = categoryDao.findAll();
		// return category;
		return categoryDao.findAll();
	}
}
