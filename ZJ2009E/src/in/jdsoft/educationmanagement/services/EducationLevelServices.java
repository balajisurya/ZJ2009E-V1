package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.EducationLevelDAO;
import in.jdsoft.educationmanagement.dao.EducationLevelSubjectDAO;
import in.jdsoft.educationmanagement.model.EducationLevel;
import in.jdsoft.educationmanagement.model.EducationLevelSubject;

@Service
public class EducationLevelServices {
	
	@Autowired
	EducationLevelDAO educationLevelDAO;
	@Autowired
	EducationLevelSubjectDAO educationLevelSubjectDAO;

	@Transactional
	public void addEducationLevel(EducationLevel educationLevel){
		educationLevelDAO.persist(educationLevel);
	}
	
	@Transactional
	public ArrayList<EducationLevel> getEducationLevelList(){
		return (ArrayList<EducationLevel>) educationLevelDAO.getList();
	}
	
	@Transactional
	public void deleteEducationLevel(int educationLevelId){
		educationLevelDAO.delete(educationLevelDAO.getEducationLevelById(educationLevelId));
	}
	
	@Transactional
	public void updateEducationLevel(EducationLevel educationLevel){
		educationLevelDAO.update(educationLevel);
	}

	@Transactional
	public EducationLevel getEducationLevelById(Integer educationLevelId){
		return educationLevelDAO.getEducationLevelById(educationLevelId);
	}
	
	@Transactional
	public void addEducationLevelSubject(EducationLevelSubject educationLevelSubject){
		educationLevelSubjectDAO.persist(educationLevelSubject);
	}
	
	@Transactional
	public ArrayList<EducationLevelSubject> getEducationLevelSubjectList(){
		return (ArrayList<EducationLevelSubject>) educationLevelSubjectDAO.getList();
	}
	
	@Transactional
	public void deleteEducationLevelSubject(int educationLevelSubjectId){
		educationLevelSubjectDAO.delete(educationLevelSubjectDAO.getEducationLevelSubjectById(educationLevelSubjectId));
	}
	
	@Transactional
	public void updateEducationLevelSubject(EducationLevelSubject educationLevelSubject){
		educationLevelSubjectDAO.update(educationLevelSubject);
	}

	@Transactional
	public EducationLevelSubject getEducationLevelSubjectById(Integer educationLevelSubjectId){
		return educationLevelSubjectDAO.getEducationLevelSubjectById(educationLevelSubjectId);
	}
	
	@Transactional
	public Set<EducationLevelSubject> getEducationLevelSubjectByEducationLevelId(Integer educationLevelId){
		EducationLevel educationLevel= educationLevelDAO.getEducationLevelById(educationLevelId);
		Hibernate.initialize(educationLevel.getEducationLevelSubjects());
		return educationLevel.getEducationLevelSubjects();
	}
}
