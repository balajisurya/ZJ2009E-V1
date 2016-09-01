package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.school.exceptions.SpecialCategoryException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;



@Service
public class SpecialCategoryServices {

	@Autowired
	SpecialCategoryDAO specialCategoryDAO;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@Transactional(rollbackFor=SpecialCategoryException.class)
	public void addSpecialCategory(SpecialCategory specialCategory)throws SpecialCategoryException
	{
		try{
			specialCategoryDAO.persist(specialCategory);
		}
		catch (Exception e) {
			
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				  
				  String valid=exceptionComparator.containsWord(e.getMessage());
					if(valid!=null)
					{
						throw new SpecialCategoryException(new Message("duplicate", "Cannot Create Duplicate Special Category Name"));
						
					}else
					{
						 throw e;
					}
				  
			  }else
			  {
				  throw e;
			  }
		  }
	}
	
	@Transactional
	public ArrayList<SpecialCategory> getSpecialCategoryList(){
			return (ArrayList<SpecialCategory>) specialCategoryDAO.getList();
	}
	
	@Transactional
	public ArrayList<SpecialCategory> getInstitutionSpecialCategoryList(Integer institutionId){
			Institution institution= institutionDAO.getInstitutionById(institutionId);
			Hibernate.initialize(institution.getSpecialCategories());
			ArrayList<SpecialCategory> specialCategories=new ArrayList<SpecialCategory>();
			specialCategories.addAll(institution.getSpecialCategories());
			return specialCategories;
	}
	
	@Transactional
	public void deleteSpecialCategory(int specialCategoryId)throws DataIntegrityViolationException{
			specialCategoryDAO.delete(specialCategoryDAO.getSpecialCategoryById(specialCategoryId));
	}
	
	@Transactional
	public void updateSpecialCategory(SpecialCategory specialCategory)throws DataIntegrityViolationException{
			specialCategoryDAO.update(specialCategory);
	}

	@Transactional
	public SpecialCategory getSpecialCategoryById(Integer specialCategoryId){
			return specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
	}
}
