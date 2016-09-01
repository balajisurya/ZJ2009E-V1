package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.dao.MasterUserTypeDAO;
import in.jdsoft.educationmanagement.dao.UsersDAO;
import in.jdsoft.educationmanagement.model.AcademicYear;
import in.jdsoft.educationmanagement.model.CourseSemesters;
import in.jdsoft.educationmanagement.model.Courses;
import in.jdsoft.educationmanagement.model.Department;
import in.jdsoft.educationmanagement.model.FeesTemplate;
import in.jdsoft.educationmanagement.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.model.Groups;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.Module;
import in.jdsoft.educationmanagement.model.Users;

@Service
public class InstitutionServices {
	
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	MasterUserTypeDAO masterUserTypeDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	HashGenerator hashGenerator;
	
	@Transactional
	 public Institution addInstitution(Institution institution){
		 return institutionDAO.save(institution);
	 }
	
	@Transactional
	 public void updateInstitution(Institution institution){
		 institutionDAO.update(institution);
	 }
	
	@Transactional
	public ArrayList<Institution> getInstitutionsList(){
		return (ArrayList<Institution>) institutionDAO.getList();
	
	}

	@Transactional
	public Institution getInstitutionById(Integer id){
		return institutionDAO.getInstitutionById(id);
	}
	
	@Transactional
	public void deleteInstitution(Integer institutionId){
		Institution institution= institutionDAO.getInstitutionById(institutionId);
		institutionDAO.delete(institution);
	}
	
	@Transactional
	public Set<Courses> getInstituteCourses(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getCourses());
			Set<Courses> courses=institution.getCourses();
			for(Courses course:courses){
				Hibernate.initialize(course.getCourseType());
				Hibernate.initialize(course.getDepartment());
			}
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Transactional
	public Set<Department> getInstituteDepartments(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getDepartments());
			Set<Department> departments=institution.getDepartments();
			return departments;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Transactional
	public Set<Module> getInstituteModules(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getModules());
			Set<Module> modules=institution.getModules();
			return modules;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public Set<FeesTemplate> getInstituteFeesTemplates(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getFeesTemplates());
			Set<FeesTemplate> feesTemplates=institution.getFeesTemplates();
			for(FeesTemplate feesTemplate:feesTemplates){
				Hibernate.initialize(feesTemplate.getFeesTemplateItems());
			}
			return feesTemplates;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public Set<FeesTemplateItem> getInstituteFeesTemplateItems(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getFeesTemplateItems());
			Set<FeesTemplateItem> feesTemplateItems=institution.getFeesTemplateItems();
			return feesTemplateItems;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public Set<Groups> getInstituteGroups(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getGroups());
			Set<Groups> groups=institution.getGroups();
			return groups;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public Set<CourseSemesters> getInstituteCourseSemester(Integer instituteId){
		try {
			Set<CourseSemesters> courseSemesters=new HashSet<CourseSemesters>(0);
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getCourses());
			Set<Courses> courses=institution.getCourses();
			for(Courses course:courses){
				Hibernate.initialize(course.getCourseSemesterses());
				courseSemesters.addAll(course.getCourseSemesterses());
			}
			return courseSemesters;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public Set<AcademicYear> getAcademicYears(Integer instituteId){
		try {
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getAcademicYears());
			Set<AcademicYear> academicYears=institution.getAcademicYears();
			return academicYears;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public void setUpInstitutionWithAdmin(Institution institution,String userName,String userEmail,String password,String profilePath){
		try {
			Integer institutionId= institutionDAO.save(institution).getInstitutionId();
			Users user=new Users(masterUserTypeDAO.getMasterUserTypeById(2), userName,userEmail, password,"defaullt",1,hashGenerator.encoder(password),profilePath,institutionDAO.getInstitutionById(institutionId));
			usersDAO.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
