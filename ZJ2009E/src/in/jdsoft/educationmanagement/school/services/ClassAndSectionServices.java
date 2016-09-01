package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.exceptions.ClassAndSectionException;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;

@Service
public class ClassAndSectionServices {

	
	@Autowired
	ClassDAO classDAO;
	@Autowired
	SectionDAO sectionDAO;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@Transactional(rollbackFor=ClassAndSectionException.class) 
	public void createNewClass(Class newClass,Set<Section> classSections)throws ClassAndSectionException{//logic for not to  add section if class is not there
		try{
		for (Section section : classSections) {
				newClass.getSections().add(section);
			}
			 classDAO.persist(newClass);
		}
		catch (Exception e) {
		
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				String valid=exceptionComparator.containsWord(e.getMessage());
				if(valid!=null)
				{
					throw new ClassAndSectionException(new Message("duplicate", "Cannot Create Duplicate Class Name"));
					
				}else
				{
					 throw e;
				}
			  }
			  else
			  {
				  throw e;
			  }
		  }
	}
	
	@Transactional 
	public void deleteClass(int classId)throws DataIntegrityViolationException {
			Class clazz=classDAO.getClassById(classId);
			classDAO.delete(clazz);
		
	}
	
	@Transactional 
	public ArrayList<Class> getClassList() {
			return  (ArrayList<Class>) classDAO.getList();
    }
	
	@Transactional 
	public ArrayList<Class> getInstitutionClassList(Integer instituteId){
		Institution institution= institutionDAO.getInstitutionById(instituteId);
			Hibernate.initialize(institution.getClasses());
			Set<Class> classesSet=institution.getClasses();
			if(classesSet!=null){
				for (Class clazz : classesSet) {
					Hibernate.initialize(clazz.getSections());
				}
			}
			ArrayList<Class> classes=new ArrayList<Class>();
			classes.addAll(classesSet);
			return  classes;
	}
	
	@Transactional 
	public ArrayList<Class> getClassListWithSections(){
			 List<Class> classes=classDAO.getList();
			 for (Class clazz : classes) {
				Hibernate.initialize(clazz.getSections());
			  }
			 return (ArrayList<Class>) classes;
	}
	

	@Transactional 
	public void updateNewClass(Class updatedclazz) throws DataIntegrityViolationException{
			classDAO.saveOrUpdate(updatedclazz);
	}

	@Transactional(rollbackFor=ClassAndSectionException.class) 
	public void createNewSection(Section section)throws ClassAndSectionException
	{
		try
		{
			sectionDAO.persist(section);
			
		}
		catch (Exception e) {
			
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				  String valid=exceptionComparator.containsWord(e.getMessage());
					if(valid!=null)
					{
						throw new ClassAndSectionException(new Message("duplicate", "Cannot Create Duplicate Section Name"));
						
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
	public void deleteSection(int sectionId) throws DataIntegrityViolationException{
			sectionDAO.delete(sectionDAO.getSectionById(sectionId));		
	}
	
	@Transactional 
	public ArrayList<Section> getSectionList(){
		return  (ArrayList<Section>) sectionDAO.getList();
	}
	
	
	@Transactional 
	public ArrayList<Section> getInstitutionSectionList(Integer instituteId){
			Institution institution= institutionDAO.getInstitutionById(instituteId);
			Hibernate.initialize(institution.getSections());
			ArrayList<Section> sections=new ArrayList<Section>();
			sections.addAll(institution.getSections());
			return  sections;
	
	}
	
	@Transactional 
	public void updateSection(Section section)throws DataIntegrityViolationException
	{					sectionDAO.update(section);
	}
	
	@Transactional 
	public Section getSectionById(Integer sectionId){
				return sectionDAO.getSectionById(sectionId);
	}
	
	@Transactional 
	public Class getClassLazyById(Integer classId){
		   Class singleclass=classDAO.getClassById(classId);
		   Hibernate.initialize(singleclass.getSections());
		   return singleclass;
	}
	@Transactional 
	public Class getClassById(Integer classId){
				return classDAO.getClassById(classId);
	}
	
	@Transactional 
	public ArrayList<Section> getSectionsOfClass(Integer classId){
		Class clazz= classDAO.getClassById(classId);
		Hibernate.initialize(clazz.getSections());
		ArrayList<Section> classSections=new ArrayList<Section>();
		classSections.addAll(clazz.getSections());
		return classSections;
	}
}
