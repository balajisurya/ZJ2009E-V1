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

import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.MasterUserType;
import in.jdsoft.educationmanagement.model.Message;
import in.jdsoft.educationmanagement.model.Users;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.UserService;

@Controller
@RequestMapping("/user")
public class UserManagementController {
	
	@Autowired
	UserService userService;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	HashGenerator hashGenerator;
	
	
	@RequestMapping
	public ModelAndView displayUserPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("usermanagement");
			modelandview.addObject("usertypelist",userService.getUserTypeList());
			modelandview.addObject("userList",userService.getUsersList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request){
         try {
        	 String userName=request.getParameter("user-name");
    	     String userEmail=request.getParameter("user-email");
    	     String userPassword=request.getParameter("user-password");
    	     int masterUserTypeId=Integer.parseInt(request.getParameter("master-user-type-id"));
    	     int userStatus=Integer.parseInt(request.getParameter("user-status"));
    	     String createdBy=request.getSession().getAttribute("username").toString();
    	     MasterUserType masterUserType=userService.getMasterUserTypeById(masterUserTypeId);
    	     String hash=hashGenerator.encoder(userPassword);
    	     String profilepic="a.png";
    	     Institution institute=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
    	     Users user=new Users(masterUserType,userName, userEmail, userPassword,createdBy,userStatus,hash,profilepic,institute);
    	     userService.addUser(user);
    		return new ModelAndView("/user");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/user");
		}
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request){
		try {
			String userName=request.getParameter("editusername");
		     String userEmail=request.getParameter("edituseremail");
		     String userPassword=request.getParameter("edituserpassword");
		     int userTypeId= Integer.parseInt(request.getParameter("editusertypeid"));
		     int statusId=Integer.parseInt(request.getParameter("edituserstatus"));
		 	 int userId=Integer.parseInt(request.getParameter("userId"));
		 	 	Users user=userService.getUserById(userId);
		 	 		user.setName(userName);
		 	 		user.setEmail(userEmail);
		 	 		user.setPassword(userPassword);
		 	 		user.getUserTypes().setTypeId(userTypeId);
		 	 		user.setStatus(statusId);
		 	 		userService.updateUser(user);
				return new ModelAndView("/user");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="delete")
	public String deleteUser(HttpServletRequest request){
		try {
			int UserId=Integer.parseInt(request.getParameter("userId"));
			userService.deleteUser(UserId);
			return "redirect:/user";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/user";
		}
		
	}
	
	@RequestMapping(value="list")
	public ModelAndView listUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			int userId=Integer.parseInt(request.getParameter("userId"));
			Users user=userService.getUserById(userId);
			String json = new Gson().toJson(user);
	        response.setContentType("application/json");
	        response.getWriter().write(json);
			return new ModelAndView("/user");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("/user");
		}
	
	}
	
	@RequestMapping(value="roleType/add",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addRoleType(HttpServletRequest request){
		try {
			String userTypeName=request.getParameter("roleTYpeName");
			String userTypeTheme=request.getParameter("userTypeTheme");
			Integer userTypeStatus=Integer.parseInt(request.getParameter("userTypestatus"));
			MasterUserType userType=new MasterUserType(userTypeName,userTypeTheme,userTypeStatus);
			userService.addUserType(userType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping(value="roleType/delete",method=RequestMethod.GET)
	public String deleteRoleType(HttpServletRequest request){
		try {
			Integer userTypeId=Integer.parseInt(request.getParameter("userTypeId"));
			userService.deleteUserType(userTypeId);
			return "redirect:/user";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/user";
		}
		
	}
	
	@RequestMapping(value="availablity",method=RequestMethod.GET)
	@ResponseBody
    public Message validateUsernameAvailablity(HttpServletRequest request){
		try {
			 return userService.emailAvailablityCheck(request.getParameter("username"));  
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
    }
	
}
