package in.jdsoft.educationmanagement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.components.FileUploadHandler;
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.MasterUserType;
import in.jdsoft.educationmanagement.model.Message;
import in.jdsoft.educationmanagement.model.Users;
import in.jdsoft.educationmanagement.services.CurrencyServices;
import in.jdsoft.educationmanagement.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.UserService;

@Controller
@RequestMapping("/institution")
public class InstitutionController {
	
	@Autowired
	GeographicalLocationServices  geographicallocationService;
	@Autowired
	InstitutionServices institutionService;
	@Autowired
	FileUploadHandler fileUploadHandler;
	@Autowired
	UserService userServices;
	@Autowired
	HashGenerator hashGenerator;
	@Autowired
	CurrencyServices currencyServices;

	@RequestMapping()
	public ModelAndView displayInstitutionPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("institution");
			modelandview.addObject("institutionList", institutionService.getInstitutionsList());
			modelandview.addObject("geographicallocationList", geographicallocationService.getCountryList());
			modelandview.addObject("geographicallocationStateList", geographicallocationService.getStateList());
			modelandview.addObject("geographicallocationCityList", geographicallocationService.getCityList());
			modelandview.addObject("geographicallocationService", geographicallocationService);
			modelandview.addObject("currencyList",currencyServices.getCurrecyList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addInstitution(HttpServletRequest request) throws Exception{
		try {
			String institutionName=request.getParameter("institutionName");
			String institutionLogo="a.png";
			String institutionEmail=request.getParameter("institutionEmail");
			String institutionContact=request.getParameter("institutionContact");
			String institutionAddressline1=request.getParameter("institutionAddressLine1");
			String institutionAddressline2=request.getParameter("institutionAddressLine2");
			String institutionAdminName=request.getParameter("institutionAdminName");
			String institutionCountry=request.getParameter("instituteCountryId");
			String institutionState=request.getParameter("instituteStateId");
			String institutionCity=request.getParameter("instituteCityId");
			String institutionPostcode=request.getParameter("institutionPostcode");
			Integer institutionStatus=Integer.parseInt(request.getParameter("instituteStatus"));
			String currencyCode=request.getParameter("currencyCode");
			Institution institution=new Institution(institutionName, institutionAddressline1, institutionAddressline2, institutionCountry, institutionState, institutionCity, institutionContact, institutionEmail, institutionLogo, institutionPostcode, currencyCode, institutionStatus);
			
			try{
				Integer instituteId=institutionService.addInstitution(institution).getInstitutionId();
				if(instituteId!=0){
					String userPassword="Edumaat@123";
					String hash=hashGenerator.encoder(userPassword);
					Institution institution1= institutionService.getInstitutionById(instituteId);
					MasterUserType userTypes=userServices.getMasterUserTypeById(2);
					Users user=new Users(userTypes,institutionAdminName,institutionEmail,userPassword,request.getSession().getAttribute("username").toString() ,1, hash,"a.png",institution1);
					userServices.addUser(user);
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="delete",method = RequestMethod.GET)
	public String deleteInstitute(HttpServletRequest request){
		try{
			Integer instituteId= Integer.parseInt(request.getParameter("institutionId"));
			institutionService.deleteInstitution(instituteId);
			return "redirect:/institution";
		}catch(Exception e){
			if(e.getClass().equals(DataIntegrityViolationException.class)){
				Message message=new Message("exception",e.getMessage());
				System.out.println(e+" "+message.getMessage());
				return "redirect:/institution";
			}
			else{
				return "redirect:/institution";
			}
			
		}
	}
	@RequestMapping(value="getInstitute",method = RequestMethod.GET)
	@ResponseBody
	public Institution getInstitute(HttpServletRequest request)
	{
		try {
			Integer instituteId= Integer.parseInt(request.getParameter("institutionId"));
			Institution institution=institutionService.getInstitutionById(instituteId);
			return institution;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	@RequestMapping(value="update",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateInstitution(HttpServletRequest request) throws Exception{
	
		try {
			Integer institutionId=Integer.parseInt(request.getParameter("institutionId"));
			
			String institutionName=request.getParameter("editInstitutionName");
			String institutionLogo="a.png";
			String institutionEmail=request.getParameter("editInstitutionEmail");
			String institutionContact=request.getParameter("editInstitutionContact");
			String institutionAddressline1=request.getParameter("editInstitutionAddressLine1");
			String institutionAddressline2=request.getParameter("editInstitutionAddressLine2");
			String institutionCountry=request.getParameter("editInstituteCountryId");
			String institutionState=request.getParameter("editInstituteStateId");
			String institutionCity=request.getParameter("editInstituteCityId");
			String institutionPostcode=request.getParameter("editInstitutionPostCode");
			Integer institutionStatus=Integer.parseInt(request.getParameter("editInstituteStatus"));
			String currencyCode=request.getParameter("editCurrencyCode");
			
			Institution institution=institutionService.getInstitutionById(institutionId);
			
			institution.setInstitutionName(institutionName);
			institution.setInstitutionLogo(institutionLogo);
			institution.setInstitutionEmail(institutionEmail);
			institution.setInstitutionContact(institutionContact);
			institution.setInstitutionAddressline1(institutionAddressline1);
			institution.setInstitutionAddressline2(institutionAddressline2);
			institution.setInstitutionCountry(institutionCountry);
			institution.setInstitutionState(institutionState);
			institution.setInstitutionCity(institutionCity);
			institution.setInstitutionPostcode(institutionPostcode);
			institution.setInstitutionStatus(institutionStatus);
			institution.setCurrencyCode(currencyCode);	
			
			institutionService.updateInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
