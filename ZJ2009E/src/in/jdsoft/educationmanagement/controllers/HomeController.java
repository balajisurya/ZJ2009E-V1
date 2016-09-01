package in.jdsoft.educationmanagement.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.services.InstitutionServices;

@Controller
public class HomeController {

	@Autowired
	InstitutionServices institutionServices;
	
	@RequestMapping(value="/" )	
	public ModelAndView login(HttpServletRequest request)throws Exception {
		System.out.println("Entered into home controller");
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				return new ModelAndView("redirect:home");
			}
			else{
				System.out.println("Entered into else condition");
				List<Institution> institutions=institutionServices.getInstitutionsList();
				 if(institutions.size()==0){
					 ModelAndView mv=new ModelAndView("install");
					 return mv;	
				  }
				 else{
					 ModelAndView mv=new ModelAndView("user_login");
					 mv.addObject("institutionList",institutionServices.getInstitutionsList());
					 return mv;
				 }
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@RequestMapping(value="/install",method=RequestMethod.POST)
	public String setup(HttpServletRequest request){
		try {
			    String institutionName=request.getParameter("institutionName");
				String institutionAddressline1=request.getParameter("institutionAddressLine1");
				String institutionAddressline2=request.getParameter("institutionAddressLine2");
				String institutionCountry=request.getParameter("institutionCountry");
				String institutionState=request.getParameter("institutionState");
				String institutionCity=request.getParameter("institutionCity");
				String institutionContact=request.getParameter("institutionContact");
				String institutionEmail=request.getParameter("institutionEmail");
				String institutionLogo="a.png";
				String institutionPostcode=request.getParameter("institutionPostCode");
				String currencyCode=request.getParameter("institutionCurrencyCode");
				
				//user setup
				String userName=request.getParameter("adminName");
				String userEmail=request.getParameter("adminEmail");
				String password=request.getParameter("adminPassword");
				String profilePath="a.png";
				Integer institutionStatus=1;
				
				/*//institution setup
				String institutionName="igce";
				String institutionAddressline1="addressLine1";
				String institutionAddressline2="addressLine2";
				String institutionCountry="India";
				String institutionState="Tamilnadu";
				String institutionCity="Trichy";
				String institutionContact="7871122783";
				String institutionEmail="igce@gmail.com";
				String institutionLogo="a.png";
				String institutionPostcode="620008";
				String currencyCode="INR";
				
				//user setup
				String userName="nikil";
				String userEmail="nikil@jdsoft.in";
				String password="password";
				String profilePath="a.png";
				Integer institutionStatus=1;*/
				Institution institution=new Institution(institutionName, institutionAddressline1, institutionAddressline2, institutionCountry, institutionState, institutionCity, institutionContact, institutionEmail, institutionLogo, institutionPostcode, currencyCode, institutionStatus);
				institutionServices.setUpInstitutionWithAdmin(institution, userName, userEmail, password, profilePath);
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/*@RequestMapping(method = RequestMethod.GET)
	public ModelAndView pageNotFound(HttpServletRequest request)throws Exception {
			return new ModelAndView("error");
	}*/
}
