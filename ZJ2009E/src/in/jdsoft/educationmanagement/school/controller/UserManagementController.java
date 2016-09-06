package in.jdsoft.educationmanagement.school.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.school.exceptions.UserServiceExceptions;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.MasterUserType;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.UserService;


@Controller
@RequestMapping("/schooluser")
public class UserManagementController {
	
	@Autowired
	UserService userService;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	HashGenerator hashGenerator;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@RequestMapping
	public ModelAndView displayUserPage(HttpServletRequest request){
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				if(request.getSession().getAttribute("type").equals("Admin")){
					ModelAndView modelandview=new ModelAndView("schoolusermanagement");
					modelandview.addObject("userList",userService.getUserList());
					return modelandview;
				}
				else{
					ModelAndView modelandview=new ModelAndView("redirect:/home");
					return modelandview;
				}
			}
			else{
				return new ModelAndView("redirect:/");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addSchoolUser(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
         try 
         {
        	 String userName=request.getParameter("username");
    	     String userEmail=request.getParameter("useremail");
    	     String userPassword=request.getParameter("userpassword");
    	     
    	     int userStatus=Integer.parseInt(request.getParameter("userstatus"));
    	     String createdBy=request.getSession().getAttribute("username").toString();
    	     MasterUserType masterUserType=userService.getMasterUserTypeById(2);
    	     String hash=hashGenerator.encoder(userPassword);
    	     String profilepic="com.png";
    	     Institution institute=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
    	     User user=new User(masterUserType,userName, userEmail, userPassword,createdBy,userStatus,hash,profilepic,institute);
    	     userService.addUser(user);
    	     return "redirect:/schooluser";
         } 
         catch (UserServiceExceptions e)
         {
 			if(e.getClass().equals(UserServiceExceptions.class)){
 				UserServiceExceptions userServiceExceptions=(UserServiceExceptions)e;
 				redirectAttributes.addFlashAttribute("errorMessage", userServiceExceptions.getCustomMessage());
 				return "redirect:/schooluser";
 			}
 			else{
 				
 				throw new Exception();
 			}
 		} 
        
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateUser(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			
			String userName=request.getParameter("editUserName");
		     String userEmail=request.getParameter("editUserEmail");
		     String userPassword=request.getParameter("editPassword");
		     int statusId=Integer.parseInt(request.getParameter("editUserStatus"));
		 	 int userId=Integer.parseInt(request.getParameter("updateUserId"));
		 	 	User user=userService.getUserById(userId);
		 	 		user.setName(userName);
		 	 		user.setEmail(userEmail);
		 	 		user.setPassword(userPassword);
		 	 		user.setStatus(statusId);
		 	 		userService.updateUser(user);
		 	 		return "redirect:/schooluser";
		} catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						if(valid!=null)
						{
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist Email Id"));
							 
							 return "redirect:/schooluser";
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
			  else
			  {
				  throw e;
			  }
}
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteUser(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			 User user=userService.getUserByEmail(request.getSession().getAttribute("username").toString());
			 int userId=Integer.parseInt(request.getParameter("deleteUserId"));
			if(!user.getUserId().equals(userId))
			{
				userService.deleteUser(userId);
				return "redirect:/schooluser";
			}
			else
			{	
				throw new UserServiceExceptions(new Message("delete", "Cannot delete yourself"));
				
			}
					
			
		} catch (UserServiceExceptions e) 
		{
			if(e.getClass().equals(UserServiceExceptions.class))
			{
				UserServiceExceptions userServiceExceptions=(UserServiceExceptions)e;
				redirectAttributes.addFlashAttribute("errorMessage", userServiceExceptions.getCustomMessage());
				return "redirect:/schooluser";
			}
			else if(e.getClass().equals(DataIntegrityViolationException.class))
			{
					  Throwable cause=e.getCause();
					  if(cause.getClass().equals(ConstraintViolationException.class))
					  {
						 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","User Cannot be deleted"));
						 return "redirect:/schooluser";
					   }
					  else
					  {
						 throw e;
					  }
					  
			 }		
			else
			{
				
				throw new Exception();
			}
	}
	}
	
	@RequestMapping(value="editRetreive",method=RequestMethod.GET)
	@ResponseBody
	public User editRetreive(HttpServletRequest request){
		try {
			int UserId=Integer.parseInt(request.getParameter("userId"));
			User user=userService.getUserById(UserId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="list")
	public ModelAndView listUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			int userId=Integer.parseInt(request.getParameter("userId"));
			User user=userService.getUserById(userId);
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
	@RequestMapping(value="forgotPassword",method=RequestMethod.POST)
	public String forgotPassword(HttpServletRequest request,RedirectAttributes attributes) throws Exception {
		try {
		    	 String userEmail=request.getParameter("e_mail");
				 userService.resetPasswordByEmail(userEmail);
				 attributes.addFlashAttribute("message",new Message("success","Your login details have been send to your e-mail successfully"));
				 return "redirect:/";
			 } catch (Exception e) {
				if(e.getClass().equals(UserServiceExceptions.class)){
					UserServiceExceptions userex=(UserServiceExceptions)e;
					attributes.addFlashAttribute("message",userex.getCustomMessage());
					return "redirect:/";
				}
				else{
					throw e;
				}
			}
		
		
	}
	
	

	
}
