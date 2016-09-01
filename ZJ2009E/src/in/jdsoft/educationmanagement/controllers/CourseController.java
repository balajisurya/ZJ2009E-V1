package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.jdsoft.educationmanagement.customexceptions.CourseException;
import in.jdsoft.educationmanagement.model.CourseCategory;
import in.jdsoft.educationmanagement.model.CourseSemesters;
import in.jdsoft.educationmanagement.model.CourseType;
import in.jdsoft.educationmanagement.model.Courses;
import in.jdsoft.educationmanagement.model.Department;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.Module;
import in.jdsoft.educationmanagement.model.SemesterSystem;
import in.jdsoft.educationmanagement.model.SemesterSystemSubset;
import in.jdsoft.educationmanagement.services.CourseServices;
import in.jdsoft.educationmanagement.services.DepartmentServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.SemesterSystemServices;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseServices courseServices;
	
	@Autowired
	DepartmentServices departmentServices;
	
	@Autowired
	SemesterSystemServices semesterSystemServices;
	@Autowired
	InstitutionServices institutionServices;
	
	
	@RequestMapping
	public ModelAndView displayCoursePage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("course");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("courseList",institutionServices.getInstituteCourses(instituteId));
			modelandview.addObject("departmentList",institutionServices.getInstituteDepartments(instituteId));
			modelandview.addObject("moduleList",institutionServices.getInstituteModules(instituteId));
			modelandview.addObject("courseTypeList",courseServices.getCourseTypeList());
			modelandview.addObject("semesterSystemsList",semesterSystemServices.getSemesterSystemList());
			modelandview.addObject("courseCategoryList",courseServices.getCourseCategoryList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	public ModelAndView addCourses(HttpServletRequest request){
	try {
		String courseName=request.getParameter("course_name");	
		int durationInYears=Integer.parseInt(request.getParameter("years"));
		int departmentId=Integer.parseInt(request.getParameter("department"));
		int semesterSystemId=Integer.parseInt(request.getParameter("semestersystem"));
		int courseStatus=Integer.parseInt(request.getParameter("status"));
		int durationInSemesters=Integer.parseInt(request.getParameter("sems"));
		int courseTypeId=Integer.parseInt(request.getParameter("courseType"));
		CourseType courseType= courseServices.getCourseTypeById(courseTypeId);
		Department department=departmentServices.getDepartmentById(departmentId);
		String courseDescription=request.getParameter("description");
		String courseCategoryIds[]=request.getParameterValues("coursecategories");
		SemesterSystem semesterSystem=semesterSystemServices.getSemesterSystemById(semesterSystemId);
		Integer totalSeats=Integer.parseInt(request.getParameter("totalSeats"));
		Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
		
		Courses course=new Courses(departmentId, semesterSystemId, courseName, courseDescription, durationInYears, durationInSemesters, courseStatus, request.getSession().getAttribute("username").toString(),"courses.png",courseType,department,semesterSystem,totalSeats,institution);
		
		for(String courseCategoryId:courseCategoryIds){
			CourseCategory courseCategory=courseServices.getCourseCategoryById(Integer.parseInt(courseCategoryId));
			course.getCourseCategories().add(courseCategory);
		}
		
			for(int i=1;i<=durationInSemesters;i++){
				int semester=i;
				String semesterSystemSubsetParamName="semesterSystemSubset"+i;
				Integer semesterSystemSubsetId=  Integer.parseInt(request.getParameter(semesterSystemSubsetParamName));
			    SemesterSystemSubset semesterSystemSubset=semesterSystemServices.getSemesterSystemSubsetById(semesterSystemSubsetId);
				int groupLock=0;
				CourseSemesters courseSemester=new CourseSemesters(course, (byte) semester,semesterSystemSubset, groupLock);
				String semesterId="semester"+i;
				String []semestermodulesId=request.getParameterValues(semesterId);
				for(String semestermoduleId:semestermodulesId){
					Module module=courseServices.getModuleById(Integer.parseInt(semestermoduleId));
					courseSemester.getModules().add(module);
				}
				course.getCourseSemesterses().add(courseSemester);
			}
			courseServices.addCourse(course);
			return new ModelAndView("/course");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteCourses(HttpServletRequest request) throws CourseException{
		
		try {
			int courseId=Integer.parseInt(request.getParameter("courseId"));
	    	courseServices.deleteCourse(courseId);
	    	return "redirect:/course";
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return "redirect:/course";
		}
		
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	public ModelAndView updateCourses(HttpServletRequest request){
			try {
				String courseName=request.getParameter("editcoursename");	
				int durationInyears=Integer.parseInt(request.getParameter("edityear"));
				int durationInsem=Integer.parseInt(request.getParameter("editsem"));
				int courseId=Integer.parseInt(request.getParameter("courseId"));
				Courses course=courseServices.getCourseById(courseId);
				course.setCourseName(courseName);
				course.setDurationInYears(durationInyears);
				course.setDurationInSemesters(durationInsem);
				courseServices.updateCourse(course);
				return new ModelAndView("/course");
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	@RequestMapping(value="get",method=RequestMethod.GET)
	@ResponseBody
	public Courses getCourseById(HttpServletRequest request){
		try {
			String s=request.getParameter("courseId");
			return courseServices.getCourseLazyById(Integer.parseInt(s));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="module") 
	public ModelAndView displayModulePage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("module");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("modulelist",institutionServices.getInstituteModules(instituteId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="module/add",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addModule(HttpServletRequest request){
		try {
			String moduleName=request.getParameter("module-name");
			int moduleCredits=Integer.parseInt(request.getParameter("module-credit"));
			String moduleType=request.getParameter("moduleType");
			Integer totalHours=Integer.parseInt(request.getParameter("totalHours"));
			
			boolean isValid;
			if(request.getParameter("hasExam").equals("1"))
			{
				isValid=true;
			}
			else
			{
				isValid=false;
			}
			
			
			boolean hasExam=isValid;
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			Module module=new Module(moduleName, moduleCredits, moduleType, totalHours, hasExam,institution);
			courseServices.addModule(module);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="module/update",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateModule(HttpServletRequest request){
		try {
			String moduleName=request.getParameter("editModule-name");
			Integer moduleCredits=Integer.parseInt(request.getParameter("editModule-credit"));
			String moduleType=request.getParameter("editModuleType");
			Integer totalHours=Integer.parseInt(request.getParameter("editTotalHours"));
			boolean isValid;
			if(request.getParameter("editHasExam").equals("1"))
			{
				isValid=true;
			}
			else
			{
				isValid=false;
			}
			
			
			boolean hasExam=isValid;
		
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			
			Integer moduleId=Integer.parseInt(request.getParameter("moduleId"));
			
			Module module=courseServices.getModuleById(moduleId);
			
			module.setModuleName(moduleName);
			module.setModuleCredit(moduleCredits);
			module.setModuleType(moduleType);
			module.setTotalHours(totalHours);
			module.setHasExam(hasExam);
			module.setInstitution(institution);
			courseServices.updateModules(module);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="module/get",method=RequestMethod.GET)
	@ResponseBody
	public Module getModule(HttpServletRequest request){
			try {
				int moduleId=Integer.parseInt(request.getParameter("moduleId"));
				Module module=courseServices.getModuleById(moduleId);
				return module;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		
		
		
	}
	@RequestMapping(value="module/delete",method = RequestMethod.GET)
	public String deleteModule(HttpServletRequest request){
		try {
			int moduleId=Integer.parseInt(request.getParameter("moduleId"));
			courseServices.deleteModules(moduleId);
			return "redirect:/course/module";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/course/module";
		}
		
	}
	
	@RequestMapping(value="module/list")
	public ModelAndView listModule(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			int moduleId=Integer.parseInt(request.getParameter("moduleId"));
			Module module=courseServices.getModuleById(moduleId);
			String json = null;
	        json = new Gson().toJson(module);
	        response.setContentType("application/json");
	        response.getWriter().write(json);
			return new ModelAndView("/course/module");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	@RequestMapping(value="semesterSystemSubset/get",method=RequestMethod.GET)
	@ResponseBody
	public Set<SemesterSystemSubset> getSemesterSystemSubsetBySemesterSystemId(HttpServletRequest request) throws IOException{
		
		try {
			Integer semesterSystemId=Integer.parseInt(request.getParameter("semesterSystemId"));
			return semesterSystemServices.getSemesterSystemSubsetBySemesterSystemId(semesterSystemId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	@ExceptionHandler(CourseException.class)
	public ModelAndView handleException(HttpServletRequest request, CourseException ex){
		try {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("message",ex.getCustomMessage());
			modelAndView.setViewName("redirect:/course");
		    return  modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}	
	
}
