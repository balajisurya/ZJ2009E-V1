package in.jdsoft.educationmanagement.school.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.components.BackUpComponent;
import in.jdsoft.educationmanagement.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.services.BloodGroupServices;
import in.jdsoft.educationmanagement.school.services.CategoryServices;
import in.jdsoft.educationmanagement.school.services.ClassAndSectionServices;
import in.jdsoft.educationmanagement.school.services.DashboardServices;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryServices;


@Controller
public class DashboardController {

	@Autowired
	SpecialCategoryServices specialCategoryServices;
	@Autowired
	DashboardServices  dashboardServices;
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	BloodGroupServices bloodGroupServices;
	@Autowired
	ClassAndSectionServices classAndSectionServices;
	@Autowired
	BackUpComponent backUpComponent;
	
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				
				if(request.getSession().getAttribute("type").equals("Admin")){
					return "forward:/dashboard";
				}
				
				else{
					return "forward:/dashboard";
				}
			}
			else{
				return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/subadmindashboard")
	public ModelAndView dashboardAdmin(HttpServletRequest request){
		try {
			ModelAndView mv=new ModelAndView("subadmindashboard");
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			mv.addObject("specialCategoryList",specialCategoryServices.getInstitutionSpecialCategoryList(institutionId));
			mv.addObject("categories", categoryServices.getCategoryList());
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	
	@RequestMapping(value="/dashboard")
	public ModelAndView dashboard(HttpServletRequest request){
		try {
			ModelAndView mv=new ModelAndView("dashboard");
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			mv.addObject("specialCategoryList",specialCategoryServices.getInstitutionSpecialCategoryList(institutionId));
			mv.addObject("categories", categoryServices.getCategoryList());
			mv.addObject("bloodGroupList", bloodGroupServices.getBloodGroupList());
			mv.addObject("classList", classAndSectionServices.getClassList());
			return mv; 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	@RequestMapping(value="/dashboard/studentRatioFromSpecialCategory",method=RequestMethod.GET)
	@ResponseBody
	public ThreeFieldReports getStudentRatioFromSpecialCategory(HttpServletRequest request){
		try {
			Integer specialCategoryId=Integer.parseInt(request.getParameter("specialCategory"));
			return  dashboardServices.getStudentRatioFromSpecialCategory(specialCategoryId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value="/dashboard/studentRatioFromCategory",method=RequestMethod.GET)
	@ResponseBody
	public ThreeFieldReports getStudentRatioFromCategory(HttpServletRequest request){
		try {
			Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
			return  dashboardServices.getStudentRatioFromCategory(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value="/dashboard/studentRatioFromClass",method=RequestMethod.GET)
	@ResponseBody
	public ThreeFieldReports getStudentRatioFromClass(HttpServletRequest request){
		try {
			Integer classId=Integer.parseInt(request.getParameter("classId"));
			return  dashboardServices.getStudentRatioFromClass(classId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value="/dashboard/bloodGroupWiseStudentCount",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCount(){
		try {
			return  dashboardServices.getBloodGroupWiseStudentCount();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	
}
