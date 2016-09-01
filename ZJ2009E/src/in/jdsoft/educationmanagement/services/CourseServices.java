package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.customexceptions.CourseException;
import in.jdsoft.educationmanagement.dao.AcademicCourseSemesterModuleDAO;
import in.jdsoft.educationmanagement.dao.CourseCategoryDAO;
import in.jdsoft.educationmanagement.dao.CourseSemestersDAO;
import in.jdsoft.educationmanagement.dao.CourseTypeDAO;
import in.jdsoft.educationmanagement.dao.CoursesDAO;
import in.jdsoft.educationmanagement.dao.GroupMappingDAO;
import in.jdsoft.educationmanagement.dao.ModuleDAO;
import in.jdsoft.educationmanagement.model.AcademicCourseSemesterModule;
import in.jdsoft.educationmanagement.model.CourseCategory;
import in.jdsoft.educationmanagement.model.CourseSemesters;
import in.jdsoft.educationmanagement.model.CourseType;
import in.jdsoft.educationmanagement.model.Courses;
import in.jdsoft.educationmanagement.model.GroupMapping;
import in.jdsoft.educationmanagement.model.Module;

@Service
public class CourseServices {
	
	@Autowired
	CourseCategoryDAO courseCategoryDAO;
	@Autowired
	CoursesDAO coursesDAO;
	@Autowired
	CourseSemestersDAO courseSemestersDAO;
	@Autowired
	GroupMappingDAO groupMappingDAO;
	@Autowired
	ModuleDAO moduleDAO;
	@Autowired
	AcademicCourseSemesterModuleDAO academicCourseSemesterModuleDAO;
	@Autowired
	CourseTypeDAO courseTypeDAO;
	
	
	@Transactional
	public ArrayList<CourseCategory> getCourseCategoryList(){
		return (ArrayList<CourseCategory>)courseCategoryDAO.getList();
	}
	
	@Transactional
	public CourseCategory getCourseCategoryById(int courseCategoryId){
		return courseCategoryDAO.getCourseCategoryById(courseCategoryId);
	}
	
	/*@Transactional
	public ArrayList<Courses> getCourseList(){
		try {
			ArrayList<Courses> courseList=(ArrayList<Courses>) coursesDAO.getList();
			for(Courses course:courseList){
				Hibernate.initialize(course.getCourseType());
				Hibernate.initialize(course.getDepartment());
			}
			return courseList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}*/
	@Transactional
	public void deleteCourse(int courseId) throws CourseException{
		coursesDAO.delete(coursesDAO.getCourseById(courseId));
	}
	
	@Transactional
	public void updateCourse(Courses course){
		coursesDAO.update(course);
	}

	@Transactional
	public Courses getCourseById(Integer id){
		return coursesDAO.getCourseById(id);
	}
	
	@Transactional
	public Courses getCourseLazyById(Integer id){
		try {
			 Courses courses=coursesDAO.getCourseById(id);
			 Hibernate.initialize(courses.getDepartment());
			 Hibernate.initialize(courses.getSemesterSystem().getSemesterSystemSubsets());
			 Hibernate.initialize(courses.getCourseType());
			 Hibernate.initialize(courses.getCourseCategories());
			 Hibernate.initialize(courses.getCourseSemesterses());
			 for(CourseSemesters courseSemester:courses.getCourseSemesterses()){
				   Hibernate.initialize(courseSemester.getModules());
			 }
			 return courses;
		} catch (Exception e) {
			throw e;
		}
		 
	}
	
	@Transactional
	public void addCourse(Courses course){
		//coursesDAO.save(course);
		coursesDAO.persist(course);
	}
	
	@Transactional
	public void lockStatus(int courseSemesterId,int grouplock){
		CourseSemesters courseSemster=courseSemestersDAO.getCourseSemesterById(courseSemesterId);
		courseSemster.setGroupLock(grouplock);
		courseSemestersDAO.update(courseSemster);
	}
	
	/*@Transactional
	public ArrayList<CourseSemesters> getAllCourseSemesters(){
		ArrayList<CourseSemesters> courseSemesters=(ArrayList<CourseSemesters>) courseSemestersDAO.getList();
		for(CourseSemesters courseSemester:courseSemesters){
			Hibernate.initialize(courseSemester.getCourse());
		}
		return (ArrayList<CourseSemesters>)courseSemestersDAO.getList();
	}*/
	
	
	
	@Transactional
	public ArrayList<CourseSemesters> getCourseSemestersInGroup(int groupId){
		
		ArrayList<CourseSemesters> courseSemestersByGroupId=new ArrayList<>();
		List<GroupMapping> groupMappingOfGroupId=(ArrayList<GroupMapping>)groupMappingDAO.getGroupMappingByGroupId(groupId);
		ArrayList<GroupMapping> groupmappinglist=new ArrayList<>();
		groupmappinglist.addAll(groupMappingOfGroupId);
		for(GroupMapping groupMapping:groupmappinglist){
			CourseSemesters courseSemester=courseSemestersDAO.getCourseSemesterById(groupMapping.getCourseSemId());
			courseSemestersByGroupId.add(courseSemester);
		}
		return courseSemestersByGroupId;
	}
	
	@Transactional
	public CourseSemesters getCourseSemesters(int courseSemID){
		return courseSemestersDAO.getCourseSemesterById(courseSemID);
	}
	

	@Transactional
	public void addModule(Module module){
		moduleDAO.persist(module);
	}
	
	/*@Transactional
	public ArrayList<Module> modulesList(){
		return (ArrayList<Module>) moduleDAO.getList();
	}
	*/
	
	@Transactional
	public void deleteModules(int moduleId){
		moduleDAO.delete(moduleDAO.getModuleById(moduleId));
	}
	
	@Transactional
	public void updateModules(Module module){
		moduleDAO.update(module);
	}
	
	@Transactional
	public Module getModuleById(int moduleId){
		return moduleDAO.getModuleById(moduleId);
	}
	
	@Transactional
	public Set<Module> getModulesOfCourseSemester(Courses course,byte semester){
		try {
			 CourseSemesters courseSemester=courseSemestersDAO.getCourseSemesterByCourseAndSemester(course,semester);
			 Hibernate.initialize(courseSemester.getModules());
			 return courseSemester.getModules();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Transactional
	public void addAcademicCourseSemesterModule(AcademicCourseSemesterModule acsm){
		academicCourseSemesterModuleDAO.persist(acsm);
	}
	
	@Transactional
	public ArrayList<AcademicCourseSemesterModule> getAcademicCourseSemesterModuleList(){
		return (ArrayList<AcademicCourseSemesterModule>) academicCourseSemesterModuleDAO.getList();
	}
	
	@Transactional
	 public void deleteAcademicCourseSemesterModule(int acsmId){
		academicCourseSemesterModuleDAO.delete(academicCourseSemesterModuleDAO.getAcademicCourseSemesterModuleById(acsmId));
	 }
	 
	@Transactional
	 public AcademicCourseSemesterModule getAcademicCourseSemesterModule(int acsmId){
		 return academicCourseSemesterModuleDAO.getAcademicCourseSemesterModuleById(acsmId);
		 
	 }
	
	@Transactional
	public void updateAcademicCourseSemesterModule(AcademicCourseSemesterModule academicCourseSemesterModule)
	{
		academicCourseSemesterModuleDAO.update(academicCourseSemesterModule);
	}
	
	@Transactional
	public void addCourseType(CourseType courseType){
		courseTypeDAO.persist(courseType);
	}
	
	@Transactional
	public ArrayList<CourseType> getCourseTypeList(){
		return (ArrayList<CourseType>) courseTypeDAO.getList();
		//return (ArrayList<Courses>)coursesDAO.getCourseList();
	}
	@Transactional
	public void deleteCourseType(int courseTypeId){
		courseTypeDAO.delete(courseTypeDAO.getCourseTypeById(courseTypeId));
	}
	
	@Transactional
	public void updateCourseType(CourseType coursetype){
		courseTypeDAO.update(coursetype);
	}

	@Transactional
	public CourseType getCourseTypeById(Integer id){
		return courseTypeDAO.getCourseTypeById(id);
	}
	
	
}