package in.jdsoft.educationmanagement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {

	@RequestMapping(value="/home")
	public String home(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				
				if(request.getSession().getAttribute("type").equals("admission")){
					return "forward:/admissions/candidate/unversityprofile";
				}
				else if(request.getSession().getAttribute("type").equals("nonteachingadmin")){
					return "forward:/admindashboard";
				}
				else if(request.getSession().getAttribute("type").equals("principal")){
					return "forward:/principaldashboard";
				}
				else if(request.getSession().getAttribute("type").equals("student")||request.getSession().getAttribute("type").equals("parent")){
					return "forward:/studentdashboard";
				}
				else if(request.getSession().getAttribute("type").equals("teachingstaff")){
					return "forward:/teachingstaffdashboard";
				}
				else if(request.getSession().getAttribute("type").equals("teachingheadofdepartment")){
					return "forward:/teachingheadofdepartmentdashboard";
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
	
	@RequestMapping(value="/admindashboard")
	public ModelAndView dashboardAdmin(HttpServletRequest request){
		try {
			return new ModelAndView("admindashboard");
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	
	@RequestMapping(value="/principaldashboard")
	public ModelAndView dashboardPrincipal(HttpServletRequest request){
		try {
			return new ModelAndView("principaldashboard");
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	
	@RequestMapping(value="/studentdashboard")
	public ModelAndView dashboardStudent(HttpServletRequest request){
		try {
			return new ModelAndView("studentdashboard");
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	@RequestMapping(value="/teachingstaffdashboard")
	public ModelAndView dashboardStaff(HttpServletRequest request){
		try {
			return new ModelAndView("teachingstaffdashboard");
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	@RequestMapping(value="/teachingheadofdepartmentdashboard")
	public ModelAndView dashboardteachingheadofdepartment(HttpServletRequest request){
		try {
			return new ModelAndView("teachingheadofdepartmentdashboard");
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	
	
	@RequestMapping(value="/dashboard")
	public ModelAndView dashboard(HttpServletRequest request){
		try {
			return new ModelAndView("dashboard");
		} catch (Exception e) {
			e.printStackTrace();
			throw null;
		}
		
	}
	
	
}
