package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.AdmissionRuleHandler;
import in.jdsoft.educationmanagement.components.EmailHandler;
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.model.Admission;
import in.jdsoft.educationmanagement.model.AdmissionConfig;
import in.jdsoft.educationmanagement.model.AdmissionDocument;
import in.jdsoft.educationmanagement.model.AdmissionEducationLevelDetails;
import in.jdsoft.educationmanagement.model.AdmissionEducationLevelSubjects;
import in.jdsoft.educationmanagement.model.AdmissionFeesPaymentDetails;
import in.jdsoft.educationmanagement.model.AdmissionProcessStatus;
import in.jdsoft.educationmanagement.model.AdmissionStatus;
import in.jdsoft.educationmanagement.model.Category;
import in.jdsoft.educationmanagement.model.CourseCategory;
import in.jdsoft.educationmanagement.model.CourseType;
import in.jdsoft.educationmanagement.model.Courses;
import in.jdsoft.educationmanagement.model.Department;
import in.jdsoft.educationmanagement.model.EducationLevelSubject;
import in.jdsoft.educationmanagement.model.HearedUs;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.MasterUserType;
import in.jdsoft.educationmanagement.model.Message;
import in.jdsoft.educationmanagement.model.Religion;
import in.jdsoft.educationmanagement.model.SpecialCategory;
import in.jdsoft.educationmanagement.model.Sponser;
import in.jdsoft.educationmanagement.model.Users;
import in.jdsoft.educationmanagement.services.AdmissionServices;
import in.jdsoft.educationmanagement.services.BloodGroupServices;
import in.jdsoft.educationmanagement.services.CategoryServices;
import in.jdsoft.educationmanagement.services.CourseServices;
import in.jdsoft.educationmanagement.services.DepartmentServices;
import in.jdsoft.educationmanagement.services.EducationLevelServices;
import in.jdsoft.educationmanagement.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.services.HearedUsServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.ReligionServices;
import in.jdsoft.educationmanagement.services.SpecialCategoryServices;
import in.jdsoft.educationmanagement.services.SponserServices;
import in.jdsoft.educationmanagement.services.StaffServices;
import in.jdsoft.educationmanagement.services.StudentServices;
import in.jdsoft.educationmanagement.services.UserService;

@Controller
@RequestMapping("/admissions")
public class AdmissionController {
	
	
	
	@Autowired
	private EmailHandler emailComponent;
	@Autowired
	private UserService userService;
	@Autowired
	private AdmissionServices admissionServices;
	@Autowired
	private GeographicalLocationServices geographicalLocationServices;
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	private SpecialCategoryServices specialCategoryServices;
	@Autowired
	private SponserServices sponserServices;
	@Autowired
	private HearedUsServices hearedUsServices;
	@Autowired
	private EducationLevelServices educationLevelServices;
	@Autowired
	private CourseServices courseServices;
	@Autowired
	private DepartmentServices departmentServices;
	@Autowired
	private ReligionServices religionServices;
	@Autowired
	private AdmissionRuleHandler admissionRuleHandler;
	@Autowired
	private InstitutionServices institutionServices;
	@Autowired
	private HashGenerator hashGenerator;
	@Autowired
	private BloodGroupServices bloodGroupServices;
	@Autowired 
	private StudentServices studentServices;
	@Autowired 
	private StaffServices staffServices;

	
	String url="Failed to generate url";
	
	@RequestMapping(value="candidate/unversityprofile") //list
	public ModelAndView displayUniversityProfilePage(){
		try {
			ModelAndView modelandview=new ModelAndView("universityprofile");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("404");
		}
		
	}
	
	@RequestMapping(value="candidate/applyforadmission") //list
	public ModelAndView displayadmissionPage(HttpServletRequest request){
		
		try {
			ModelAndView modelandview=new ModelAndView("admission");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			AdmissionConfig admissionConfig=admissionServices.getCurrentAdmissionConfig();
				modelandview.addObject("admissionConfig",admissionConfig);
			if(admissionConfig!=null){
				modelandview.addObject("categoryList", categoryServices.getCategoryList());
				modelandview.addObject("specialCategoryList",specialCategoryServices.getSpecialCategoryList());
				modelandview.addObject("countryList", geographicalLocationServices.getCountryList());
				modelandview.addObject("sponserList",sponserServices.getSponserList());
				modelandview.addObject("hearedUsType", hearedUsServices.getHearedUsList());
				modelandview.addObject("educationQualificationLevelList", educationLevelServices.getEducationLevelList());
				modelandview.addObject("courseTypeList", courseServices.getCourseTypeList());
				modelandview.addObject("courseCategoryList",courseServices.getCourseCategoryList());
				modelandview.addObject("departmentList",institutionServices.getInstituteDepartments(instituteId));
				modelandview.addObject("courseList",institutionServices.getInstituteCourses(instituteId));
				modelandview.addObject("admissionDocumentTypeList",admissionServices.getAdmissionDocumentTypeList());
				modelandview.addObject("appliedApplicationsList",userService.getUsersAdmissionApplication(request.getSession().getAttribute("username").toString()));
				modelandview.addObject("religionList",religionServices.getReligionList());
				return modelandview;
			}
			else{
				return modelandview;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="candidate/newAdmission/save") //list
	public ModelAndView saveNewAdmission(HttpServletRequest request) throws ParseException{
		
		try {
			AdmissionConfig currentConfig=admissionServices.getCurrentAdmissionConfig();
			String candidateFirstName=request.getParameter("candidateFirstName");
			String candidateLastName=request.getParameter("candidateLastName");
			String candidateGender=request.getParameter("candidateGender");
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    Date dateOfBirth =null;
		    if(!request.getParameter("dateOfBirth").isEmpty()){
		    	dateOfBirth = formatter.parse(request.getParameter("dateOfBirth"));
		    }
	       Religion religion=null;
			if(request.getParameter("religionId")!=null){
				religion=religionServices.getReligionById(Integer.parseInt(request.getParameter("religionId")));
			}
			Category category=null;
			if(request.getParameter("categoryId")!=null){
				category=categoryServices.getCategoryById(Integer.parseInt(request.getParameter("categoryId")));
			}
			SpecialCategory specialCategory=null;
			if(request.getParameter("specialCategoryId")!=null){
				specialCategory=specialCategoryServices.getSpecialCategoryById(Integer.parseInt(request.getParameter("specialCategoryId")));
			}
			String passportNo=request.getParameter("passportNo");
			int passportIssuedCountry=0;
			if(request.getParameter("passportissuedCountryId")!=null){
				passportIssuedCountry=Integer.parseInt(request.getParameter("passportissuedCountryId"));
			}
			String studiedHereBefore=request.getParameter("IsStudiedBefore");
			String previousStudentIdOfThisInstitute=request.getParameter("previousStudentId");
			Sponser sponser=null;
			if(request.getParameter("sponserId")!=null){
				sponser=sponserServices.getSponserById(Integer.parseInt(request.getParameter("sponserId")));
			}
			String disability=request.getParameter("isDisability");
			String fatherFirstName=request.getParameter("fatherFirstName");
			String fatherLastName=request.getParameter("fatherLastName");
			String fatherOccupation=request.getParameter("fatherOccupation");
			String motherFirstName=request.getParameter("motherFirstName");
			String motherLastName=request.getParameter("motherLastName");
			String motherOccupation=request.getParameter("motherOccupation");
			double fatherIncome=0;
			if(!request.getParameter("fatherIncome").isEmpty()){
				fatherIncome=Double.parseDouble(request.getParameter("fatherIncome"));
			}
			double motherIncome=0;
			if(!request.getParameter("motherIncome").isEmpty()){
				motherIncome=Double.parseDouble(request.getParameter("motherIncome"));
			}
			String guardianFirstName=request.getParameter("guardianFirstName");
			String guardianLastName=request.getParameter("guardianLastName");
			String referenceOneFirstName=request.getParameter("reference1FirstName");
			String referenceOneLastName=request.getParameter("reference1LastName");
			String referenceOneEmail=request.getParameter("reference1Email");
			String referenceOneMobile=request.getParameter("reference1Mobile");
			String referenceOneAddressLineOne=request.getParameter("reference1AddressLine1");
			String referenceOneAddressLineTwo=request.getParameter("reference1AddressLine2");
			int referenceOneCountry=0;
			if(request.getParameter("reference1CountryId")!=null){
				referenceOneCountry=Integer.parseInt(request.getParameter("reference1CountryId"));
			}
			String referenceOnePincode=request.getParameter("reference1Pincode");
			String referenceTwoFirstName=request.getParameter("reference2FirstName");
			String referenceTwoLastName=request.getParameter("reference2LastName");
			String referenceTwoEmail=request.getParameter("reference2Email");
			String referenceTwoMobile=request.getParameter("reference2Mobile");
			String referenceTwoAddressLineOne=request.getParameter("reference2AddressLine1");
			String referenceTwoAddressLineTwo=request.getParameter("reference2AddressLine2");
			int referenceTwoCountry=0;
			if(request.getParameter("reference2CountryId")!=null){
				referenceOneCountry=Integer.parseInt(request.getParameter("reference2CountryId"));
			}
			String referenceTwoPincode=request.getParameter("reference2Pincode");
			String candidatePhotoPath="candidate.png";//request.getParameter("");
			String scannedSignaturePath="signature.jpeg";//request.getParameter("");
			HearedUs hearedUs=null;
			if(request.getParameter("hearedUsid")!=null){
				hearedUs=hearedUsServices.getHearedUsById(Integer.parseInt(request.getParameter("hearedUsid")));
			}
			//contact details
			String candidateAddressLineOne=request.getParameter("candidateAddressLine1");
			String candidateAddressLineTwo=request.getParameter("candidateAddressLine2");
			String candidateEmail=request.getParameter("candidateEmail");
			String candidateContact=request.getParameter("mobileNumber");
			int candidateCountry=0;
			if(request.getParameter("candidateCountryid")!=null){
				candidateCountry=Integer.parseInt(request.getParameter("candidateCountryid"));
			}
			int candidateState=0;
			if(request.getParameter("candidateStateid")!=null){
				candidateState=Integer.parseInt(request.getParameter("candidateStateid"));
			}
			int candidateCity=0;
			if(request.getParameter("candidateCityid")!=null){
				candidateCity=Integer.parseInt(request.getParameter("candidateCityid"));
			}
			String candidatePostcode=request.getParameter("candidatePostCode");
			//apply for course
			CourseType courseType=null;
			if(request.getParameter("courseTypeId")!=null){
				courseType=courseServices.getCourseTypeById(Integer.parseInt(request.getParameter("courseTypeId")));
			}
			Department department=null;
			if(request.getParameter("departmentId")!=null){
				department=departmentServices.getDepartmentById(Integer.parseInt(request.getParameter("departmentId")));
			}
			Courses course=null;
			if(request.getParameter("departmentId")!=null){
				course=courseServices.getCourseById(Integer.parseInt(request.getParameter("courseId")));
			}
			CourseCategory courseCategory=null;
			if(request.getParameter("courseCategoryId")!=null){
				courseCategory=courseServices.getCourseCategoryById(Integer.parseInt(request.getParameter("courseCategoryId")));
			}
			//other details
			String admissionCode =currentConfig.getApplicationCodeFormat().concat(Long.toString(System.currentTimeMillis()));
			AdmissionStatus admissionStatus=admissionServices.getAdmissionStatusById(1);
			int submitStatus=0;
			Users user=userService.getUserByEmail(request.getSession().getAttribute("username").toString());
			Double admissionRank=0.0;
			Set<AdmissionEducationLevelDetails> admissionAcademicsDetails=null;
			Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects=null;
			Set<AdmissionDocument> admissionDocuments=null;
			AdmissionFeesPaymentDetails admissionFeesPaymentDetails=null;
			
			Admission newAdmission=new Admission(currentConfig, courseType, department,course, courseCategory,
					        admissionStatus,religion, sponser, category, specialCategory,hearedUs, 
							admissionCode,candidateFirstName, candidateLastName, fatherFirstName, fatherLastName, 
							fatherOccupation, motherFirstName, motherLastName, motherOccupation, fatherIncome, motherIncome,
							guardianFirstName, guardianLastName, passportNo, studiedHereBefore, previousStudentIdOfThisInstitute, 
							disability,referenceOneFirstName, referenceOneLastName, referenceOneEmail, referenceOneMobile,
							referenceOneAddressLineOne, referenceOneAddressLineTwo, referenceOneCountry,
							referenceOnePincode, referenceTwoFirstName, referenceTwoLastName, referenceTwoEmail,
							referenceTwoMobile, referenceTwoAddressLineOne, referenceTwoAddressLineTwo, referenceTwoCountry,
							referenceTwoPincode, scannedSignaturePath, candidateGender, dateOfBirth, candidateEmail,
							candidateContact,passportIssuedCountry, candidateAddressLineOne, candidateAddressLineTwo,
							candidateCountry, candidateState, candidateCity, candidatePostcode, candidatePhotoPath, 
							submitStatus,admissionRank,user,admissionDocuments,admissionAcademicsDetails, admissionFeesPaymentDetails,
							admissionEducationLevelSubjects);
			
			admissionServices.addAdmission(newAdmission);
			ModelAndView modelandview=new ModelAndView("admission");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("admission");
		}
	}
	
	@RequestMapping(value="candidate/newAdmission/edit") 
	@ResponseBody
	public Admission editNewAdmission(HttpServletRequest request){
		
		try {
			int admissionId=Integer.parseInt(request.getParameter("admissionId"));
			 Admission admission=admissionServices.editAdmissionApplication(admissionId);
			 return admission;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 
	}
	
	@RequestMapping(value="candidate/newAdmission/submit") 
	public ModelAndView submitNewAdmission(HttpServletRequest request){
		
		try {
			ModelAndView modelandview=new ModelAndView("admission");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="candidate/admissioncourses") 
	public ModelAndView displayadmissioncoursePage(HttpServletRequest request){
		try {	
			ModelAndView modelandview=new ModelAndView("admissioncourses");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@RequestMapping(value="candidate/admissionfacilities") 
	public ModelAndView displayadmissionfacilitiesPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("admissionfacilities");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="candidate/statusandcommunication") 
	public ModelAndView displaystatusPage(HttpServletRequest request){
		try {	
			ModelAndView modelandview=new ModelAndView("statusandcommunication");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@RequestMapping(value="candidate/signup",method=RequestMethod.POST)
	public String addAdmissionUser(HttpServletRequest request,RedirectAttributes redirectAttributes) throws ServletException, IOException{
		try{
			 String userEmail=request.getParameter("e-mail");
		     Message message=userService.emailAvailablityCheck(userEmail);
		     if(message.getStatus().equals("success")){
		    	 String userPassword=request.getParameter("pass_word");
		    	 String name=request.getParameter("name");
			     int institutionId=Integer.parseInt(request.getParameter("institutionId")) ;
			     String hashedvalue=hashGenerator.encoder(userPassword);
			     int masterUserTypeId=19;
			     int userStatus=0;
			     String createdBy=request.getParameter("e-mail");
			     MasterUserType masterUserType=userService.getMasterUserTypeById(masterUserTypeId);
			     Institution institution= institutionServices.getInstitutionById(institutionId);
		    	 Users user=new Users(masterUserType,name, userEmail, userPassword,createdBy,userStatus,hashedvalue,"a.png",institution);
			     userService.addUser(user);
			     url=emailComponent.getProjectPath()+"/admissions/candidate/verify?email="+userEmail+"&hash="+hashedvalue;
			     String emailmessage="Dear "+name.toUpperCase()+",\n\n You have signed up for edumaat, please verify your account by "
							+ "clicking the below given link to activate it.\n\n"+url+"\n\n Thank You\n Edumaat \n JD Soft";
			     emailComponent.sendEmail(userEmail, "Verify You Login Details",emailmessage);
			     redirectAttributes.addFlashAttribute("message", new Message("success", "You have successfully created Account!! You have to verify your account to Log in"));
			     return "redirect:/";
		     }else{
		    	 redirectAttributes.addFlashAttribute("message", message);
		    	 return "redirect:/";
		     }
		  
		}catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",new Message("failed", "Some Error Occurred Contact Institution Admin"));
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="candidate/verify",method=RequestMethod.GET)
	public String verifyAdmissionUser(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		
		try {
			String username=request.getParameter("email");
			String hash=request.getParameter("hash");
			Users users=userService.getUserByEmail(username);
			if(users.getStatus()==0){
				if(users.getHash().equals(hash)){
					users.setStatus(1);
					userService.updateUser(users);
					String message="Welcome !! "+users.getName().toUpperCase()+",\n\n You have successfully verified Your account, now you can login with your username and password"
							+ "\n\n Login @ " +emailComponent.getProjectPath()+ "\n\n Thank You\n Edumaat \n JD Soft";
					emailComponent.sendEmail(username, "Welcome to EDUMAAT",message);
					redirectAttributes.addFlashAttribute("message", new Message("success", "successfully verified"));
					return "redirect:/";
				}
				else{
					redirectAttributes.addFlashAttribute("message", new Message("failure", "Invalid Link !!"));
					return "redirect:/";
				}
			}
			else if(users.getStatus()==1){
				if(users.getHash().equals(hash)){
					redirectAttributes.addFlashAttribute("message", new Message("success", "already your account is verified"));
					return "redirect:/";
				}
				else{
					redirectAttributes.addFlashAttribute("message", new Message("failure", "Invalid Link !!"));
					return "redirect:/";
				}
			}
			else{
				redirectAttributes.addFlashAttribute("message", new Message("failure", "Error Contact Admin"));
				 return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
		
		
	}
	
	@RequestMapping(value="admissiondashboard") //list
	public ModelAndView displayAdmissionDashboardPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("admissiondashboard");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="admissionconfig") //list
	public ModelAndView displayAdmissionConfigPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("admissionconfig");
			modelandview.addObject("admissionProcessStatusList", admissionServices.getAdmissionProcessStatusList());
			modelandview.addObject("admissionConfigList",admissionServices.getAdmissionConfigList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	@RequestMapping(value="admissionconfig/add",method = RequestMethod.POST) 
	public String  addAdmissionConfig(HttpServletRequest request) throws ParseException{
		try {
			AdmissionConfig currentAdmissionConfig=admissionServices.getCurrentAdmissionConfig();
			if(currentAdmissionConfig==null){
				String applicationCodeFormat=request.getParameter("admissionCodeFormat");
				double applicationFees=Double.parseDouble(request.getParameter("admissionApplicationFees"));
				String []admissionStartAndEndDate=request.getParameter("admissionStartAndEndDate").split("-");
				DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				Date startdate= formatter.parse(admissionStartAndEndDate[0].trim());
				Date enddate=formatter.parse(admissionStartAndEndDate[1].trim());
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(startdate);
				int year=calendar.get(Calendar.YEAR);
				String admissionProcessYear=Integer.toString(year);
				AdmissionProcessStatus admissionProcessStatus=admissionServices.getAdmissionProcessStatusById(Integer.parseInt(request.getParameter("admissionProcessStatusId")));
				AdmissionConfig admissionConfig=new AdmissionConfig(admissionProcessStatus, admissionProcessYear, startdate, enddate, applicationCodeFormat, applicationFees);
				admissionServices.addAdmissionConfig(admissionConfig);
				return "redirect:/admissions/admissionconfig";
			}
			else{
				System.out.println("Admission Config Exist,Close Current Exist Config.");
				return "redirect:/admissions/admissionconfig";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admissions/admissionconfig";
		}
		
		
	}
	
	@RequestMapping(value="admissionconfig/delete",method = RequestMethod.GET) 
	public String deleteAdmissionConfig(HttpServletRequest request){
		try {
			int admissionConfigId=Integer.parseInt(request.getParameter("admissionConfigId"));
			 admissionServices.deleteAdmissionConfig(admissionConfigId);
			 return "redirect:/admissions/admissionconfig";
		} catch (Exception e) {
			e.printStackTrace();
			 return "redirect:/admissions/admissionconfig";
		}
	 
	}
	
	@RequestMapping(value="newadmission") //list
	public ModelAndView displayNewAdmissionPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("newadmission");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("categoryList", categoryServices.getCategoryList());
			modelandview.addObject("specialCategoryList",specialCategoryServices.getSpecialCategoryList());
			modelandview.addObject("countryList", geographicalLocationServices.getCountryList());
			modelandview.addObject("stateList", geographicalLocationServices.getStateList());
			modelandview.addObject("cityList", geographicalLocationServices.getCityList());
			modelandview.addObject("sponserList",sponserServices.getSponserList());
			modelandview.addObject("hearedUsType", hearedUsServices.getHearedUsList());
			modelandview.addObject("educationQualificationLevelList", educationLevelServices.getEducationLevelList());
			modelandview.addObject("courseTypeList", courseServices.getCourseTypeList());
			modelandview.addObject("courseCategoryList",courseServices.getCourseCategoryList());
			modelandview.addObject("departmentList",institutionServices.getInstituteDepartments(instituteId));
			modelandview.addObject("courseList",institutionServices.getInstituteCourses(instituteId));
			modelandview.addObject("feesTemplateList",institutionServices.getInstituteFeesTemplates(instituteId));
			modelandview.addObject("bloodGroupList",bloodGroupServices.getBloodGroupList());
			modelandview.addObject("studentStatusList",studentServices.getStudentStatusList());
			modelandview.addObject("studentList",studentServices.getStudentsList());
			modelandview.addObject("staffList",staffServices.getStaffList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("newadmission");
		}
		
		
	}
	
	@RequestMapping(value="notification") //list
	public ModelAndView displayNotificationage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("notification");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value="finalization") //list
	public ModelAndView displayFinalizationPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("finalization");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("courseList",institutionServices.getInstituteCourses(instituteId));
			modelandview.addObject("courseCategoryList",courseServices.getCourseCategoryList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	@RequestMapping(value="finalization/applyAdmssionRule",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Admission> applyAdmissionRule(HttpServletRequest request){
		try {
			int courseId=Integer.parseInt(request.getParameter("courseId"));
			Courses course= courseServices.getCourseById(courseId);
			int courseCategoryId=Integer.parseInt(request.getParameter("courseCategoryId"));
			int ruleId=Integer.parseInt(request.getParameter("ruleId"));
			int maxSelect=course.getTotalSeats();
			return admissionRuleHandler.executeRule(courseId, courseCategoryId, ruleId, maxSelect);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping(value="admissionStatus") 
	public ModelAndView displayAdmissionStatuspage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("admissionStatus");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("admissionStatus");
		}
		
	}
	
	@RequestMapping(value="finalization/intimateSelectCandidate",method=RequestMethod.POST) 
	@ResponseStatus(value=HttpStatus.OK)
	public void intimateCandidate(HttpServletRequest request){
		try {
			String selectedApplications=request.getParameter("selectedAdmissionCandidates");
			String []split= selectedApplications.trim().split(",");
			if(split.length>0){
				for(String selectedApplication:split){
					Integer selectedApplicationAdmissionId=Integer.parseInt(selectedApplication);
					Admission admission=admissionServices.getAdmissionDetailsById(selectedApplicationAdmissionId);
					admission.setAdmissionStatus(admissionServices.getAdmissionStatusById(4));
					Users createdUser=  userService.getUserByEmail(request.getSession().getAttribute("username").toString());
					admissionServices.intimateApplicationStatus(admission,createdUser);
				}	
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="educationLevelSubject/list")
	@ResponseBody
	public Set<EducationLevelSubject> geteducationLevelSubjects(HttpServletRequest request){
		
		try {
			int educationLevelId=Integer.parseInt(request.getParameter("educationLevelId")) ;
			return educationLevelServices.getEducationLevelSubjectByEducationLevelId(educationLevelId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="getAdmission",method=RequestMethod.GET)
	@ResponseBody
	public Admission getAdmission(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception
	{
		try {
		Admission admission=admissionServices.getFullAdmissionDetails(Integer.parseInt(request.getParameter("admissionId")));
			return admission;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
}
		