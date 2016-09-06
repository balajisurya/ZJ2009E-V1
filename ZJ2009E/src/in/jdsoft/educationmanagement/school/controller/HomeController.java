package in.jdsoft.educationmanagement.school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.services.CurrencyServices;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;


@Controller
public class HomeController {

	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	GeographicalLocationServices geoGraphicalServices;
	@Autowired
	CurrencyServices currencyServices;
	@Autowired
	FileUploadHandler fileUploadHandler;
	
	@RequestMapping(value="/" )	
	public ModelAndView login(HttpServletRequest request)throws Exception {
		try {
			if(request.getSession().getAttribute("authenticated")!=null && request.getSession().getAttribute("authenticated").equals("true")){
				return new ModelAndView("redirect:home");
			}
			else{
				List<Institution> institutions=institutionServices.getInstitutionsList();
				 if(institutions.size()==0){
					 ModelAndView mv=new ModelAndView("install");
					 mv.addObject("geographicallocationList",geoGraphicalServices.getCountryList());
					 mv.addObject("currencies", currencyServices.getCurrecyList());
					 return mv;	
				  }
				 else{
					 ModelAndView mv=new ModelAndView("schooluserlogin");
					 return mv;
				 }
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/install",method=RequestMethod.POST)
	public String setup(HttpServletRequest request,@RequestParam("institutionProfilePic") MultipartFile multipartFile){
		try {
			    String institutionName=request.getParameter("institutionName");
				String institutionAddressline1=request.getParameter("institutionAddressLine1");
				String institutionAddressline2=request.getParameter("institutionAddressLine2");
				String institutionCountry=request.getParameter("institutionCountry");
				String institutionState=request.getParameter("institutionState");
				String institutionCity=request.getParameter("institutionCity");
				String institutionContact=request.getParameter("institutionContact");
				String institutionEmail=request.getParameter("institutionEmail");
				
				String institutionLogo="";
				if((multipartFile!=null) && !(multipartFile.isEmpty()))
				{
					institutionLogo=fileUploadHandler.uploadFile(multipartFile.getBytes(),request.getRealPath("/resources/themes/images/institute-logo/"),"/resources/themes/images/institute-logo/",multipartFile.getOriginalFilename());
				}
				if(institutionLogo=="")
				{
					institutionLogo="/resources/themes/images/com.png";
				}
				String institutionPostcode=request.getParameter("institutionPostCode");
				String currencyCode=request.getParameter("institutionCurrencyCode");
				
				//user setup
				String userName=request.getParameter("adminName");
				String userEmail=request.getParameter("adminEmail");
				String password=request.getParameter("adminPassword");
				String profilePath="com.png";
				Integer institutionStatus=1;
			
				Institution institution=new Institution(institutionName, institutionAddressline1, institutionAddressline2, institutionCountry, institutionState, institutionCity, institutionContact, institutionEmail, institutionLogo, institutionPostcode, currencyCode, institutionStatus);
				institutionServices.setUpInstitutionWithAdmin(institution, userName, userEmail, password, profilePath);
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
