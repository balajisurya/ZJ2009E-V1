package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.jdsoft.educationmanagement.model.GroupMapping;
import in.jdsoft.educationmanagement.model.Groups;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.services.CourseServices;
import in.jdsoft.educationmanagement.services.GroupServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupServices groupServices;
	@Autowired
	CourseServices courseServices;
	@Autowired
	InstitutionServices institutionServices;
	
	
	@RequestMapping
	public ModelAndView displayGroupPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("groups");
			Integer instituteId= Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("grouplist",institutionServices.getInstituteGroups(instituteId));
			modelandview.addObject("coursesemesterlist",institutionServices.getInstituteCourseSemester(instituteId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addGroup(HttpServletRequest request){

		try {
			String groupName=request.getParameter("group-name");
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			Groups group=new Groups(groupName,institution);
			String courseSemesterId[]=request.getParameterValues("courseSemList");
			for(String courseSemId:courseSemesterId){
				GroupMapping groupMapping=new GroupMapping(group,Integer.parseInt(courseSemId));
				group.getGroupMapping().add(groupMapping);
			}
			groupServices.addGroup(group);
			return "redirect:/group";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/group";

		}
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateGroup(HttpServletRequest request){
		try
		{
			Integer groupId=Integer.parseInt(request.getParameter("groupId")); 			
 			groupServices.deleteGroup(groupId);
	      	String groupName=request.getParameter("editGroup-name");
			
			String courseSemesterId[]=request.getParameterValues("editCourseSemList");
			Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
			Groups group=new Groups(groupName,institution);
			
			for(String courseSemId:courseSemesterId){
				GroupMapping groupMapping=new GroupMapping(group,Integer.parseInt(courseSemId));
				group.getGroupMapping().add(groupMapping);
			}
			groupServices.addGroup(group);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 			
	}
	
	@RequestMapping(value="delete")
	public String deleteGroup(HttpServletRequest request){
		try {
			int groupId=Integer.parseInt(request.getParameter("groupId"));
			   groupServices.deleteGroup(groupId);
			return "redirect:/group";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/group";
		}
		
	}
	@RequestMapping(value="getGroup",method=RequestMethod.GET)
	@ResponseBody
	public Groups getGroup(HttpServletRequest request){
		try {
			int groupId=Integer.parseInt(request.getParameter("groupId"));
			Groups groups=  groupServices.groupLazyById(groupId);
			return groups;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="list")
	public ModelAndView listGroup(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			int groupId=Integer.parseInt(request.getParameter("groupId"));
			Groups group= groupServices.groupById(groupId);
			String json = null;
	        json = new Gson().toJson(group);
	        response.setContentType("application/json");
	        response.getWriter().write(json);
	        System.out.println(json);
			return new ModelAndView("/group");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
