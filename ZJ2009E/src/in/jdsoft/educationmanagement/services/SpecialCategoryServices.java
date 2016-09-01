package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.model.SpecialCategory;

@Service
public class SpecialCategoryServices {

	@Autowired
	SpecialCategoryDAO specialCategoryDAO;
	
	@Transactional
	public void addSpecialCategory(SpecialCategory specialCategory){
		specialCategoryDAO.persist(specialCategory);
	}
	
	@Transactional
	public ArrayList<SpecialCategory> getSpecialCategoryList(){
		return (ArrayList<SpecialCategory>) specialCategoryDAO.getList();
		//return (ArrayList<Courses>)coursesDAO.getCourseList();
	}
	@Transactional
	public void deleteSpecialCategory(int specialCategoryId){
		specialCategoryDAO.delete(specialCategoryDAO.getSpecialCategoryById(specialCategoryId));
	}
	
	@Transactional
	public void updateSpecialCategory(SpecialCategory specialCategory){
		specialCategoryDAO.update(specialCategory);
	}

	@Transactional
	public SpecialCategory getSpecialCategoryById(Integer specialCategoryId){
		return specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
	}
}
