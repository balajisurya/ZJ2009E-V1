package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.CategoryDAO;
import in.jdsoft.educationmanagement.model.Category;

@Service
public class CategoryServices {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Transactional
	public void addCategory(Category category){
		categoryDAO.persist(category);
	}
	
	@Transactional
	public ArrayList<Category> getCategoryList(){
		return (ArrayList<Category>) categoryDAO.getList();
	}
	
	@Transactional
	public void deleteCategory(int categoryId){
		categoryDAO.delete(categoryDAO.getCategoryById(categoryId));
	}
	
	@Transactional
	public void updateCategory(Category category){
		categoryDAO.update(category);
	}

	@Transactional
	public Category getCategoryById(Integer categoryId){
		return categoryDAO.getCategoryById(categoryId);
	}
}
