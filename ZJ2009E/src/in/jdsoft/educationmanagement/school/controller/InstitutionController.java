package in.jdsoft.educationmanagement.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.components.FileUploadHandler;
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.school.exceptions.InstitutionException;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.MasterUserType;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.CurrencyServices;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.UserService;



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
	@Autowired
	ExceptionComparator exceptionComparator;
	
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
	@RequestMapping(value="editInstitution")
	public ModelAndView displayEditInstitutionPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("editinstitution");
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("institutionDetails", institutionService.getInstitutionById(institutionId));
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
					MasterUserType userTypes=userServices.getMasterUserTypeById(1);
					User user=new User(userTypes,institutionAdminName,institutionEmail,userPassword,request.getSession().getAttribute("username").toString() ,1, hash,"com.png",institution1);
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
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="update",method = RequestMethod.POST)
	public String updateInstitution(HttpServletRequest request,@RequestParam("institutionProfilePic") MultipartFile multipartFile) throws Exception{
	
		try {
		
			Integer institutionId=Integer.parseInt(request.getParameter("updateInstitutionId"));
			String institutionName=request.getParameter("institutionName");
			String institutionLogo="";
			String institutionEmail=request.getParameter("institutionEmail");
			String institutionContact=request.getParameter("institutionContact");
			String institutionAddressline1=request.getParameter("institutionAddressLine1");
			String institutionAddressline2=request.getParameter("institutionAddressLine2");
			String institutionCountry=request.getParameter("institutionCountry");
			String institutionState=request.getParameter("institutionState");
			String institutionCity=request.getParameter("institutionCity");
			String institutionPostcode=request.getParameter("institutionPostCode");
			String currencyCode=request.getParameter("institutionCurrencyCode");
			
			Institution institution=institutionService.getInstitutionById(institutionId);
			
			institution.setInstitutionName(institutionName);
			if((multipartFile!=null) && !(multipartFile.isEmpty()))
			{
				institutionLogo=fileUploadHandler.uploadFile(multipartFile.getBytes(),request.getRealPath("/resources/themes/images/institute-logo/"),"/resources/themes/images/institute-logo/",multipartFile.getOriginalFilename());
			}
			if(institutionLogo!="")
			{
				institution.setInstitutionLogo(institutionLogo);
			}			
			institution.setInstitutionEmail(institutionEmail);
			institution.setInstitutionContact(institutionContact);
			institution.setInstitutionAddressline1(institutionAddressline1);
			institution.setInstitutionAddressline2(institutionAddressline2);
			institution.setInstitutionCountry(institutionCountry);
			institution.setInstitutionState(institutionState);
			institution.setInstitutionCity(institutionCity);
			institution.setInstitutionPostcode(institutionPostcode);
			institution.setCurrencyCode(currencyCode);	
			
			institutionService.updateInstitution(institution);
			return "redirect:/institution/editInstitution";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@RequestMapping(value="ledgerAccounts") 
	public ModelAndView displayInstitutionLedgerAccountPage(HttpServletRequest request){
		try {
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			ModelAndView modelandview=new ModelAndView("institutionLedgerAccount");
			modelandview.addObject("institutionAccountsList",institutionService.getInstitutionLedgerAccountList(institutionId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	 }
   
	@RequestMapping(value="ledgerAccount/add",method=RequestMethod.POST) 
	public String addNewLedgerAccount(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			    String ledgerAccountName=request.getParameter("ledgerAccountName");
			    String ledgerAccountReferenceNo=request.getParameter("ledgerAccountReferenceNo");
			    Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			    Institution institution= institutionService.getInstitutionById(instituteId);
			    InstituteLedgerAccount ledgerAccount=new InstituteLedgerAccount(ledgerAccountName, ledgerAccountReferenceNo, institution);
			    institutionService.addInstituteLedgerAccount(ledgerAccount);
				return "redirect:/institution/ledgerAccounts";
		 }
		catch (InstitutionException e) 
		{
			
			if(e.getClass().equals(InstitutionException.class)){
				InstitutionException institutionException=(InstitutionException)e;
				redirectAttributes.addFlashAttribute("errorMessage", institutionException.getCustomMessage());
				return "redirect:/institution/ledgerAccounts";
			}
			else{
				
				throw e;
			}
		
	  }
    }
	
	@RequestMapping(value="ledgerAccount/editReterive",method=RequestMethod.GET)
	@ResponseBody
	public InstituteLedgerAccount editLedgerAccountReterive(HttpServletRequest request){
		try {
			    Integer ledgerAccountId=Integer.parseInt(request.getParameter("ledgerAccountId"));
			    return institutionService.getLedgerAccountById(ledgerAccountId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="ledgerAccount/editUpdate",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String editLedgerAccountUpdate(HttpServletRequest request,HttpServletRequest response,RedirectAttributes redirectAttributes)throws Exception{
		try {
				Integer ledgerAccountId=Integer.parseInt(request.getParameter("updateLedgerId"));
				String editLedgerAccountReferenceNo=request.getParameter("editLedgerAccountReferenceNo");
				String editLedgerAccountName=request.getParameter("editLedgerAccountName");
				InstituteLedgerAccount ledgerAccount=institutionService.getLedgerAccountById(ledgerAccountId);
				ledgerAccount.setLedgerAccountName(editLedgerAccountName);
				ledgerAccount.setLedgerReferenceNo(editLedgerAccountReferenceNo);
				institutionService.updateLedgerAccount(ledgerAccount);
				return "redirect:/institution/ledgerAccounts";
		} catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						
						if(valid!=null)
						{
							valid = valid.replace('_',' ');
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist "+valid));			
							 return "redirect:/institution/ledgerAccounts";
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
	
	@RequestMapping(value="ledgerAccount/delete",method=RequestMethod.POST)
	public String deleteLedgerAccount(HttpServletRequest request,RedirectAttributes redirectAttributes){
		try {
				Integer ledgerAccountId=Integer.parseInt(request.getParameter("deleteLedgerId"));
				institutionService.deleteLedgerAccount(ledgerAccountId);
				return "redirect:/institution/ledgerAccounts";
		} catch (DataIntegrityViolationException e) {
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class)){
					 redirectAttributes.addFlashAttribute("errorMessage",new Message("constraintViolation","Ledger Account in use cannot be deleted"));
					 return "redirect:/institution/ledgerAccounts";
				   }
				  else{
					 throw e;
				  }
				  
			  }
			  else{
				  e.printStackTrace();
				  throw e;
			  }
		  }
	}

}
