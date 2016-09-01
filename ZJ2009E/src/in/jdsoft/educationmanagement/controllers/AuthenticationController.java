package in.jdsoft.educationmanagement.controllers;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.customexceptions.UserServiceExceptions;
import in.jdsoft.educationmanagement.model.MenuLevel1;
import in.jdsoft.educationmanagement.model.Message;
import in.jdsoft.educationmanagement.model.Users;
import in.jdsoft.educationmanagement.services.MenuServices;
import in.jdsoft.educationmanagement.services.UserService;

@Controller
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuServices menuServices;
	
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,RedirectAttributes redirectAttributes){
		try{
			if(userService.userLogin(request.getParameter("user-name"), request.getParameter("pass-word"))){
				 Users user=userService.getUserByEmail(request.getParameter("user-name"));
				   if(user.getStatus()==1){
					   request.getSession().setAttribute("username",request.getParameter("user-name"));
					   request.getSession().setAttribute("name",user.getName());
					   request.getSession().setAttribute("type",user.getUserTypes().getUserTypeName());
					   request.getSession().setAttribute("profile", user.getProfilePicturePath());
					   request.getSession().setAttribute("instituteId",user.getInstitution().getInstitutionId());
					   request.getSession().setAttribute("logo",user.getInstitution().getInstitutionLogo());
					   request.getSession().setAttribute("portalTasks",user.getReceivedPortalTask());
					   request.getSession().setAttribute("portalNotifications",user.getReceivedPortalNotifications());
						 try{
						   request.getSession().setAttribute("lastlogin",user.getLastLogin());
				    	 }catch(Exception e){
				    		if(e.getClass().equals(NullPointerException.class)){
				    			request.getSession().setAttribute("lastlogin","Never");
				    		}
				    	  }
					   request.getSession().setAttribute("authenticated","true");
				       user.setLastLogin(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
				       ArrayList<MenuLevel1> menulist=menuServices.getMenuList(user.getUserTypes().getUserTypeName());
				       userService.updateUser(user);
				       request.getSession().setAttribute("menulist",menulist);
				       request.getSession().setAttribute("theme",user.getUserTypes().getUserTheme());
				       return "redirect:/home";
				   }
				   else{
					   throw new UserServiceExceptions("Invalid User! please Enter Valid Email Id");
					}
			}
			else{
				  throw new UserServiceExceptions("Username or Password incorrect !");
			   }
		}
		catch(Exception e){
			if(e.getClass()==UserServiceExceptions.class){
				redirectAttributes.addFlashAttribute("message", new Message("failed",e.getMessage()));
				return "redirect:/";
			}
			else{
				e.printStackTrace();//do logging here
				redirectAttributes.addFlashAttribute("message", new Message("failed","Problem Occured: Contact Administrator"));
				return "redirect:/";
			}
		 }
	}
	
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request,RedirectAttributes redirectAttributes){
		try{
			if(request.getSession()!=null){
			    request.getSession().invalidate();
				redirectAttributes.addFlashAttribute("message",new Message("success","You Have Successfully Logged Out"));
				return "redirect:/";
			}
			else{
				redirectAttributes.addFlashAttribute("message",new Message("failed","Session is Empty"));
				return "redirect:/";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",new Message("failed","Problem Occured: Contact Administrator"));
			return "redirect:/";
		}
	}
}
