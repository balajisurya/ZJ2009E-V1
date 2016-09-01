package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.components.FileUploadHandler;
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.model.BloodGroup;
import in.jdsoft.educationmanagement.model.Category;
import in.jdsoft.educationmanagement.model.Courses;
import in.jdsoft.educationmanagement.model.Department;
import in.jdsoft.educationmanagement.model.Institution;
import in.jdsoft.educationmanagement.model.MasterUserType;
import in.jdsoft.educationmanagement.model.Module;
import in.jdsoft.educationmanagement.model.Staff;
import in.jdsoft.educationmanagement.model.StaffAttendance;
import in.jdsoft.educationmanagement.model.StaffAttendanceType;
import in.jdsoft.educationmanagement.model.StaffCategories;
import in.jdsoft.educationmanagement.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.model.StaffLeaveType;
import in.jdsoft.educationmanagement.model.StaffPerformance;
import in.jdsoft.educationmanagement.model.StaffTypes;
import in.jdsoft.educationmanagement.model.Users;
import in.jdsoft.educationmanagement.services.BloodGroupServices;
import in.jdsoft.educationmanagement.services.CategoryServices;
import in.jdsoft.educationmanagement.services.CourseServices;
import in.jdsoft.educationmanagement.services.DepartmentServices;
import in.jdsoft.educationmanagement.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.services.InstitutionServices;
import in.jdsoft.educationmanagement.services.StaffServices;
import in.jdsoft.educationmanagement.services.UserService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffServices staffServices;
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	GeographicalLocationServices geographicalServices;
	@Autowired
	DepartmentServices departmentServices;
	@Autowired
	BloodGroupServices bloodGroupServices;
	@Autowired
	UserService userServices;
	@Autowired
	HashGenerator hashGenerator;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	FileUploadHandler fileUploadHandler;
	@Autowired
	CourseServices courseServices;
	

	
	
	@RequestMapping(value="manage")
	public ModelAndView displayStaffPage(HttpServletRequest request){
		ModelAndView modelandview=new ModelAndView("managestaff");
		try {
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("staffTypeList",staffServices.getStaffTypeList());
			modelandview.addObject("categoryList",categoryServices.getCategoryList());
			modelandview.addObject("departmentList",institutionServices.getInstituteDepartments(instituteId));
			modelandview.addObject("bloodGroupList",bloodGroupServices.getBloodGroupList());
			modelandview.addObject("teachingStaffList",staffServices.getTeachingStaffList());
			modelandview.addObject("nonteachingStaffList",staffServices.getNonTeachingStaffList());
			modelandview.addObject("staffList",staffServices.getStaffList());
			modelandview.addObject("staffCategoryList",staffServices.getStaffCategories());
			modelandview.addObject("countryList",geographicalServices.getCountryList());
			modelandview.addObject("stateList", geographicalServices.getStateList());
			modelandview.addObject("cityList", geographicalServices.getCityList());
			modelandview.addObject("institutionList", institutionServices.getInstitutionsList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteStaff(HttpServletRequest request){
		try {
			Integer staffId=Integer.parseInt(request.getParameter("staffId"));
			staffServices.deleteStaff(staffId);
			return "redirect:/staff/manage";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/staff/manage";
		}
		
	}
	

	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addNewStaff(HttpServletRequest request,@RequestParam("staffProfilePic") MultipartFile multipartFile) throws Exception{
	  try {
	         System.out.println("Catalina Home"+System.getProperty("catalina.home"));
	    	  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	  String staffFirstName=request.getParameter("staffFirstName");
	    	  String staffLastName=request.getParameter("staffLastName");
	    	  String staffSex=request.getParameter("staffGender");
	    	  Date staffBirthDate = formatter.parse(request.getParameter("staffDOB"));
	    	  String staffContact=request.getParameter("staffContact");
	    	  String staffEmail=request.getParameter("staffEmail");
	    	  String accessId=request.getParameter("staffAccessId");
	    	  String parentOrGuardianFirstName=request.getParameter("staffParentOrGuardianFirstName");
	    	  String parentOrGuardianLastName=request.getParameter("staffParentOrGuardianLastName");
	    	  String spouseName=request.getParameter("staffSpouseName");
	    	  Category category=categoryServices.getCategoryById(Integer.parseInt(request.getParameter("categoryId")));
	    	  String staffAddressLineOne=request.getParameter("staffAddressLine1");
	    	  String staffAddressLineTwo=request.getParameter("staffAddressLine2");
	    	  Integer countryId=Integer.parseInt(request.getParameter("staffCountryId"));
	    	  Integer stateId=Integer.parseInt(request.getParameter("staffStateId"));
	    	  Integer cityId=Integer.parseInt(request.getParameter("staffCityId"));
	    	  String postCode=request.getParameter("staffPostCode");
	    	  String bankName=request.getParameter("staffBankName");
	    	  String bankAccountNo=request.getParameter("staffBankAccountNo");
	    	  String bankIFSC=request.getParameter("staffBankIFSC");
	    	  String bankAddress=request.getParameter("staffBankAddress");
	    	  String tallyAccountNo=request.getParameter("staffTallyAccountNo");
	    	  String passportNo=request.getParameter("staffPassportNo");
	    	  String panNO=request.getParameter("staffPANNo");
	    	  String pfNo=request.getParameter("staffPFAccountNo");
	    	  String profilePicturePath=fileUploadHandler.uploadFile(multipartFile.getBytes(),request.getContextPath(),"resources/themes/images/profile-pic/staffs" ,multipartFile.getOriginalFilename());
	    	  System.out.println("Path: "+profilePicturePath);
	    	  String scannedSignaturePath="signature path";
	    	  StaffTypes staffType=staffServices.getStaffTypeById(Integer.parseInt(request.getParameter("staffTypeId")));
	    	  StaffCategories staffCategory=staffServices.getStaffCategoryById(Integer.parseInt(request.getParameter("staffCategoryId")));
	    	  
	    	  Date joiningDate=null;
	    	  
	    	  if(!request.getParameter("staffJoinedDate").isEmpty()){
	    		   joiningDate = formatter.parse(request.getParameter("staffJoinedDate"));
	    		  
	    	  }
	    	  
	    	  double previousExperience=0;
	    	 if(!request.getParameter("previousExp").isEmpty())
	    	 {
	    		 previousExperience=Double.parseDouble(request.getParameter("previousExp"));
	    	 }
	    		 
	    	  
	    	  String resumePath="resume path";
	    	  String healthInsuranceNo=request.getParameter("healthInsuranceNo");
	    	  String offerLetterPath="offerletter path";
	    	  String form16path="form 16 path";
	    	  Integer status=Integer.parseInt(request.getParameter("staffStatus"));
	    	  String staffCreatedBy=request.getSession().getAttribute("username").toString();
	    	  String staffLastModifiedBy=request.getSession().getAttribute("username").toString();
	    	  
	    	  BloodGroup bloodGroup=null;
	    	  if(request.getParameter("staffBloodGroupId")!=null){
		    	  bloodGroup=bloodGroupServices.getBloodGroupById(Integer.parseInt(request.getParameter("staffBloodGroupId")));

	    	  }
	    	  
	    	  
	    	  
	    	  Department department=departmentServices.getDepartmentById(Integer.parseInt(request.getParameter("departmentId")));
	    	  Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
	    	  Integer approverId=Integer.parseInt(request.getParameter("approverId"));
	    	  Staff approverStaff=staffServices.getStaffById(approverId);
	    	  Users approver=null;
	    	  if(approverStaff!=null){
	    		 approver=approverStaff.getUser();
	    	  }
	    	  Staff staff=new Staff(department, staffFirstName, staffLastName, staffSex, staffBirthDate, staffContact, staffEmail, accessId, parentOrGuardianFirstName, parentOrGuardianLastName, spouseName, category, staffAddressLineOne, staffAddressLineTwo, countryId, stateId, cityId, postCode, bankName, bankAccountNo, bankIFSC, bankAddress, tallyAccountNo, passportNo,approver,panNO, pfNo, profilePicturePath, scannedSignaturePath, staffType, staffCategory, joiningDate, previousExperience, resumePath, healthInsuranceNo, offerLetterPath, form16path, status, staffCreatedBy, staffLastModifiedBy, bloodGroup,institution);
	    	  staffServices.addStaff(staff);
	    	  return "redirect:/staff/manage";
		} catch (Exception e) {
			 e.printStackTrace();
			 return "redirect:/staff/manage";
		}
		
	}
	
	@RequestMapping(value="updateStaffDetails",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateStaffDetails(HttpServletRequest request) throws Exception{
		
		try {
			 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	  
	    	  String staffFirstName=request.getParameter("editStaffFirstName");
	    	  String staffLastName=request.getParameter("ediStaffLastName");
	    	  String staffSex=request.getParameter("editStaffGender");
	    	  Date staffBirthDate = formatter.parse(request.getParameter("editStaffDOB"));
	    	  String staffContact=request.getParameter("editStaffContact");
	    	  String staffEmail=request.getParameter("editStaffEmail");
	    	  String accessId=request.getParameter("editAccessId");
	    	  String parentOrGuardianFirstName=request.getParameter("editStaffParentOrGuardianFirstName");
	    	  String parentOrGuardianLastName=request.getParameter("editStaffParentOrGuardianLastName");
	    	  String spouseName=request.getParameter("editStaffSpouseName");
	    	  Category category=categoryServices.getCategoryById(Integer.parseInt(request.getParameter("editCategoryId")));
	    	  String staffAddressLineOne=request.getParameter("editStaffAddressLine1");
	    	  String staffAddressLineTwo=request.getParameter("editStaffAddressLine2");
	    	  Integer countryId=Integer.parseInt(request.getParameter("editStaffCountryId"));
	    	  Integer stateId=Integer.parseInt(request.getParameter("editStaffStateId"));
	    	  Integer cityId=Integer.parseInt(request.getParameter("editStaffCityId"));
	    	  String postCode=request.getParameter("editStaffPostCode");
	    	  String bankName=request.getParameter("editStaffBankName");
	    	  String bankAccountNo=request.getParameter("editStaffBankAccountNo");
	    	  String bankIFSC=request.getParameter("editStaffBankIFSC");
	    	  String bankAddress=request.getParameter("editStaffBankAddress");
	    	  String tallyAccountNo=request.getParameter("editStaffTallyAccountNo");
	    	  String passportNo=request.getParameter("editStaffPassportNo");
	    	  String panNO=request.getParameter("editStaffPANNo");
	    	  String pfNo=request.getParameter("editStaffPFAccountNo");
	    	  String profilePicturePath="profile picture path";
	    	  String scannedSignaturePath="signature path";
	    	  StaffTypes staffType=staffServices.getStaffTypeById(Integer.parseInt(request.getParameter("editStaffTypeId")));
	    	  StaffCategories staffCategory=staffServices.getStaffCategoryById(Integer.parseInt(request.getParameter("editStaffCategoryId")));
	    	  Date joiningDate = formatter.parse(request.getParameter("editStaffJoinedDate"));
	    	  Double previousExperience=Double.parseDouble(request.getParameter("editPreviousExp"));
	    	  String resumePath="resume path";
	    	  String healthInsuranceNo=request.getParameter("editHealthInsuranceNo");
	    	  String offerLetterPath="offerletter path";
	    	  String form16path="form 16 path";
	    	  Integer status=Integer.parseInt(request.getParameter("editStaffStatus"));
	    	  String staffLastModifiedBy=request.getSession().getAttribute("username").toString();
	    	  BloodGroup bloodGroup=bloodGroupServices.getBloodGroupById(Integer.parseInt(request.getParameter("editStaffBloodGroupId")));
	    	  Department department=departmentServices.getDepartmentById(Integer.parseInt(request.getParameter("editDepartmentId")));
	    	  
	    	  Institution institution=institutionServices.getInstitutionById(Integer.parseInt(request.getSession().getAttribute("instituteId").toString()));
	    	  Integer approverId=Integer.parseInt(request.getParameter("editApproverId"));
	    	  Staff approverStaff=staffServices.getStaffById(approverId);
	    	  Users approver=null;
	    	  if(approverStaff!=null){
	    		 approver=approverStaff.getUser();
	    	  }
	    	  
	    	  Staff staff=staffServices.getStaffById(Integer.parseInt(request.getParameter("staffId")));
	    	  
	    	  staff.setStaffFirstName(staffFirstName);
	    	  staff.setStaffLastName(staffLastName);
	    	  staff.setStaffSex(staffSex);
	    	  staff.setStaffBirthDate(staffBirthDate);
	    	  staff.setStaffContact(staffContact);
	    	  staff.setStaffEmail(staffEmail);
	    	  staff.setAccessId(accessId);
	    	  staff.setParentOrGuardianFirstName(parentOrGuardianFirstName);
	    	  staff.setParentOrGuardianLastName(parentOrGuardianLastName);
	    	  staff.setSpouseName(spouseName);
	    	  staff.setCategory(category);
	    	  staff.setStaffAddressLineOne(staffAddressLineOne);
	    	  staff.setStaffAddressLineTwo(staffAddressLineTwo);
	    	  staff.setCountryId(countryId);
	    	  staff.setStateId(stateId);
	    	  staff.setCityId(cityId);
	    	  staff.setPostCode(postCode);
	    	  staff.setBankName(bankName);
	    	  staff.setBankAccountNo(bankAccountNo);
	    	  staff.setBankIFSC(bankIFSC);
	    	  staff.setBankAddress(bankAddress);
	    	  staff.setTallyAccountNo(tallyAccountNo);
	    	  staff.setPassportNo(passportNo);
	    	  staff.setPanNO(panNO);
	    	  staff.setPfNo(pfNo);
	    	  staff.setProfilePicturePath(profilePicturePath);
	    	  staff.setScannedSignaturePath(scannedSignaturePath);
	    	  staff.setStaffType(staffType);
	    	  staff.setStaffCategory(staffCategory);
	    	  staff.setJoiningDate(joiningDate);
	    	  staff.setPreviousExperience(previousExperience);
	    	  staff.setResumePath(resumePath);
	    	  staff.setOfferLetterPath(offerLetterPath);
	    	  staff.setForm16path(form16path);
	    	  staff.setHealthInsuranceNo(healthInsuranceNo);
	    	  staff.setStatus(status);
	    	  staff.setStaffLastModifiedBy(staffLastModifiedBy);
	    	  staff.setDepartment(department);
	    	  staff.setBloodGroup(bloodGroup);
	    	  staff.setInstitution(institution);
	    	  staff.setApprover(approver);
	    	  
	    	  staffServices.updateStaff(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	  	}
	
	@RequestMapping(value="getStaff",method=RequestMethod.GET)
	@ResponseBody
	public Staff getStaff(HttpServletRequest request)
	{
		try {
			Staff staff=staffServices.getStaffLazyById(Integer.parseInt(request.getParameter("staffId")));
			return staff;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@RequestMapping(value="category")
	public ModelAndView staffcategory(HttpServletRequest request) throws Exception{
		try{
			ModelAndView modelandview=new ModelAndView("staffcategory");
			modelandview.addObject("staffTypeList",staffServices.getStaffTypeList());
			modelandview.addObject("staffCategories",staffServices.getStaffCategoriesWithStaffType());
			modelandview.addObject("staffRoleTypes",userServices.getUserTypeList());
			return modelandview;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="category/add",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addStaffcategory(HttpServletRequest request) throws Exception{
		try{
			String staffCategoryName=request.getParameter("staffCategoryName");
			StaffTypes staffType=staffServices.getStaffTypeById(Integer.parseInt(request.getParameter("staffTypeId")));
			Integer staffCategoryVisible=Integer.parseInt(request.getParameter("staffCategoryVisible"));
			String staffCategoryCreatedBy=request.getSession().getAttribute("username").toString();
			String staffCategoryLastModifiedBy=request.getSession().getAttribute("username").toString();
			MasterUserType roleType=userServices.getMasterUserTypeById(Integer.parseInt(request.getParameter("staffRoleType")));
			StaffCategories staffCategories=new StaffCategories
					(staffCategoryName, staffType, staffCategoryVisible, staffCategoryCreatedBy, staffCategoryLastModifiedBy,roleType);
			staffServices.addStaffCategoy(staffCategories);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="category/delete",method=RequestMethod.GET)
	public String deleteStaffcategory(HttpServletRequest request) throws Exception{
		try {
			Integer staffCategoryId=Integer.parseInt(request.getParameter("staffCategoryId"));
			staffServices.deleteStaffCategory(staffCategoryId);
			return "redirect:/staff/category";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/staff/category";
		}
		
	}
	@RequestMapping(value="category/update",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateStaffcategory(HttpServletRequest request) throws Exception{
		try {
			Integer staffCategoryId=Integer.parseInt(request.getParameter("staffCategoryId"));			
			StaffCategories staffCategories=staffServices.getStaffCategoryById(staffCategoryId);
			Integer staffCategoryVisible=Integer.parseInt(request.getParameter("editStaffCategoryVisible"));
	    	String staffCategoryName=request.getParameter("editStaffCategoryName");
	    	staffCategories.setStaffCategoryName(staffCategoryName);
	    	staffCategories.setStaffCategoryVisible(staffCategoryVisible);
			staffServices.updateStaffCategory(staffCategories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="category/edit",method=RequestMethod.GET)
	@ResponseBody
	public StaffCategories editStaffcategory(HttpServletRequest request) throws Exception{
		try {
			Integer staffCategoryId=Integer.parseInt(request.getParameter("staffCategoryId"));
			return staffServices.getStaffCategoryById(staffCategoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="attendance")
	public ModelAndView staffAttendance(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("staffattendance");
			modelandview.addObject("staffList",staffServices.getStaffListOfUser(request.getSession().getAttribute("username").toString()));
			modelandview.addObject("staffAttendanceTypeList",staffServices.getStaffAttendanceTypeList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	@RequestMapping(value="attendance/save",method=RequestMethod.POST) 
	@ResponseStatus(value=HttpStatus.OK)
	public void attendanceList(HttpServletRequest request){
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date attendancedate=formatter.parse(request.getParameter("staffAttendanceDate"));
			String attendanceLists=request.getParameter("attendanceLists");
			String records[]=attendanceLists.split("-");
			for(int i=1;i<records.length;i++){
				String record=records[i];
				String fields[]=record.split(",");
				  Staff staff=staffServices.getStaffById(Integer.parseInt(fields[0]));
				  StaffAttendanceType staffAttendanceType=staffServices.getStaffAttendanceTypeById(Integer.parseInt(fields[1]));
				  String staffAttendanceRemarks=fields[2];
				  StaffAttendance staffAttendance=new StaffAttendance(staff, staffAttendanceType, staffAttendanceRemarks,attendancedate,request.getSession().getAttribute("username").toString(), request.getSession().getAttribute("username").toString());
				  staffServices.addStaffAttendance(staffAttendance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="allocatemodules")
	public ModelAndView allocateStaffModules(HttpServletRequest request){
		ModelAndView modelandview=null;
		try {
			modelandview=new ModelAndView("allocatemodules");
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			modelandview.addObject("courseList",institutionServices.getInstituteCourses(instituteId));
			modelandview.addObject("staffList",staffServices.getStaffList());
			modelandview.addObject("modueList",institutionServices.getInstituteModules(instituteId));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return modelandview;
		}
			
	}
	
	@RequestMapping(value="allocatemodules/getModulesByCourseSemester",method=RequestMethod.GET)
	@ResponseBody
	public Set<Module> getModulesByCourseSemester(HttpServletRequest request){
		Set<Module> modules=null;
		try {
			 Integer courseId=Integer.parseInt(request.getParameter("courseId"));
			 byte semester=Byte.parseByte(request.getParameter("semester"));
			 Courses course=courseServices.getCourseById(courseId);
			 modules=courseServices.getModulesOfCourseSemester(course, semester);
			 return modules;
		} catch (Exception e) {
			 return null;
		}
	}
	
	@RequestMapping(value="staffprofile")
	public ModelAndView staffprofile(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("staffprofile");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="teachingstaffdashboard")
	public ModelAndView teachingstaffdashboard(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("teachingstaffdashboard");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	@RequestMapping(value="myperformance")
	public ModelAndView staffperformance(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("teachingstaffperformance");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="assignments")
	public ModelAndView TeachingStaffAssignments(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("teachingstaffassignments");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	@RequestMapping(value="lessons")
	public ModelAndView Lessons(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("lessons");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(value="labs")
	public ModelAndView Labs(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("labs");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="staffappraisal")
	public ModelAndView StaffApprasial(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("staffappraisal");
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	@RequestMapping(value="staffcategory",method=RequestMethod.GET)
	@ResponseBody
	public Set<StaffCategories>  staffcategoryByStaffTypeId(HttpServletRequest request) throws Exception{
		try {
			Integer staffTypeId=Integer.parseInt(request.getParameter("staffTypeId")); 
			   Set<StaffCategories> staffCategories =staffServices.getStaffCategoriesFromStaffTypeId(staffTypeId);
			   return staffCategories;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	   
    }
	

	@RequestMapping(value="addStaffAppraisal",method = RequestMethod.POST)
	public String addStaffAppraisal(HttpServletRequest request) throws Exception{
	
		
		try{
			
			Integer staffId=Integer.parseInt(request.getParameter("staffId"));
			String appraisalTerm=request.getParameter("appraisalTerm");
			String relationshipRating=request.getParameter("relationshipRating");
			String relationshipComments=request.getParameter("relationshipComments");
			String teachingRating=request.getParameter("teachingRating");
			String teachingComments=request.getParameter("teachingComments");
			String researchAndHigherQualificationRating=request.getParameter("researchAndHigherQualificationRating");
			String researchAndHigherQualificationComments=request.getParameter("researchAndHigherQualificationComments");
			String initiativeAndOrganizationRating=request.getParameter("initiativeAndOrganizationRating");
			String initiativeAndOrganizationComments=request.getParameter("initiativeAndOrganizationComments");
			String innovationRating=request.getParameter("innovationRating");
			String innovationComments=request.getParameter("innovationComments");
			String punctualityRating=request.getParameter("punctualityRating");
			String punctualityComments=request.getParameter("punctualityComments");
			String goalAlignmentRating=request.getParameter("goalAlignmentRating");
			String goalAlignmentcomments=request.getParameter("goalAlignmentcomments");
			String recommendations=request.getParameter("recommendations");
			String appraisalStatus=request.getParameter("appraisalStatus");
			String appraisalCreatedByUser=request.getSession().getAttribute("username").toString();
			Staff staff=staffServices.getStaffById(staffId);
			StaffPerformance staffPerformance=new StaffPerformance(appraisalTerm, relationshipRating, relationshipComments, teachingRating, teachingComments, researchAndHigherQualificationRating, researchAndHigherQualificationComments, initiativeAndOrganizationRating, initiativeAndOrganizationComments, innovationRating, innovationComments, punctualityRating, punctualityComments, goalAlignmentRating, goalAlignmentcomments, appraisalCreatedByUser, recommendations,  new Timestamp(Calendar.getInstance().getTime().getTime()), appraisalStatus, staff);
			staffServices.addStaffAppraisal(staffPerformance);
			return "redirect:/staff/staffappraisal";
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/staff/staffappraisal";
		}
	}
	@RequestMapping(value="getStaffPerformanceList")
	@ResponseBody
	public Set<StaffPerformance> getStaffPerformanceList(HttpServletRequest request) throws ServletException, IOException 
	{
		try {
			Integer staffId=Integer.parseInt(request.getParameter("getStaffId"));
			Set<StaffPerformance> staffPerformance=staffServices.getStaffPerformanceRecords(staffId);
			return staffPerformance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@RequestMapping(value="editStaffPerformance")
	@ResponseBody
	public StaffPerformance editStaffPerformance(HttpServletRequest request) 
	{
		try {
			Integer staffPerformanceId=Integer.parseInt(request.getParameter("staffPerformanceId"));
			StaffPerformance staffPerformance=staffServices.getStaffPerformanceById(staffPerformanceId);	
		    return staffPerformance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@RequestMapping(value="updateStaffPerformance",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateStaffPerformance(HttpServletRequest request) throws Exception
	{
		
		try {
			Integer editStaffId=Integer.parseInt(request.getParameter("editStaffId"));
			String editAppraisalTerm=request.getParameter("editAppraisalTerm");
			String editRelationshipRating=request.getParameter("editRelationshipRating");
			String editRelationshipComments=request.getParameter("editRelationshipComments");
			String editTeachingRating=request.getParameter("editTeachingRating");
			String editTeachingComments=request.getParameter("editTeachingComments");
			String editResearchAndHigherQualificationRating=request.getParameter("editResearchAndHigherQualificationRating");
			String editResearchAndHigherQualificationComments=request.getParameter("editResearchAndHigherQualificationComments");
			String editInitiativeAndOrganizationRating=request.getParameter("editInitiativeAndOrganizationRating");
			String editInitiativeAndOrganizationComments=request.getParameter("editInitiativeAndOrganizationComments");
			String editInnovationRating=request.getParameter("editInnovationRating");
			String editInnovationComments=request.getParameter("editInnovationComments");
			String editPunctualityRating=request.getParameter("editPunctualityRating");
			String editPunctualityComments=request.getParameter("editPunctualityComments");
			String editGoalAlignmentRating=request.getParameter("editGoalAlignmentRating");
			String editGoalAlignmentcomments=request.getParameter("editGoalAlignmentcomments");
			String editRecommendations=request.getParameter("editRecommendations");
			String editAppraisalStatus=request.getParameter("editAppraisalStatus");
			String appraisalCreatedByUser=request.getSession().getAttribute("username").toString();
			Integer staffPerformanceId=Integer.parseInt(request.getParameter("staffPerformanceId"));
			
			Staff staff=staffServices.getStaffById(editStaffId);
			StaffPerformance staffPerformance=staffServices.getStaffPerformanceById(staffPerformanceId);
			staffPerformance.setAppraisalTerm(editAppraisalTerm);
			staffPerformance.setRelationshipRating(editRelationshipRating);
			staffPerformance.setRelationshipComments(editRelationshipComments);
			staffPerformance.setTeachingRating(editTeachingRating);
			staffPerformance.setTeachingComments(editTeachingComments);
			staffPerformance.setResearchAndHigherQualificationRating(editResearchAndHigherQualificationRating);
			staffPerformance.setResearchAndHigherQualificationComments(editResearchAndHigherQualificationComments);
			staffPerformance.setInitiativeAndOrganizationRating(editInitiativeAndOrganizationRating);
			staffPerformance.setInitiativeAndOrganizationComments(editInitiativeAndOrganizationComments);
			staffPerformance.setInnovationRating(editInnovationRating);
			staffPerformance.setInnovationComments(editInnovationComments);
			staffPerformance.setPunctualityRating(editPunctualityRating);
			staffPerformance.setPunctualityComments(editPunctualityComments);
			staffPerformance.setGoalAlignmentRating(editGoalAlignmentRating);
			staffPerformance.setGoalAlignmentComments(editGoalAlignmentcomments);
			staffPerformance.setRecommendations(editRecommendations);
			staffPerformance.setAppraisalStatus(editAppraisalStatus);
			staffPerformance.setAppraisalCreatedByUser(appraisalCreatedByUser);
			staffPerformance.setCreatedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
			staffPerformance.setStaff(staff);
			staffServices.updateStaffAppraisal(staffPerformance);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@RequestMapping(value="deleteStaffPerformance",method=RequestMethod.GET)
	public String deleteStaffPerformance(HttpServletRequest request) throws Exception{
		try {
			Integer deleteStaffPerformanceId=Integer.parseInt(request.getParameter("staffPerformanceId"));
			staffServices.deleteStaffAppraisal(deleteStaffPerformanceId);
			return "redirect:/staff/staffappraisal";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/staff/staffappraisal";
		}
		
	}
	
	/*staff Requision*/

	@RequestMapping(value="/requisition")
	public ModelAndView displayStaffRequisitionPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("requisition");
			modelandview.addObject("staffLeaveTypeList",staffServices.getStaffLeaveTypeList());
			modelandview.addObject("staffLeaveRequistions",staffServices.getStaffLeaveRequests(request.getSession().getAttribute("username").toString()));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/requisition/staffLeaveRequest",method=RequestMethod.POST)
	public String addStaffLeaveRequisition(HttpServletRequest request) throws Exception{
		
		try{
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			StaffLeaveType staffLeaveType=staffServices.getStaffLeaveTypeById(Integer.parseInt(request.getParameter("staffLeaveType")));
	        String approvalStatus="Pending";
			String staffLeaveReason=request.getParameter("staffLeaveReason");
			String staffLeaveStartAndEndDate=request.getParameter("staffLeaveStartAndEndDate");
			Staff staff=userServices.getUserByEmail(request.getSession().getAttribute("username").toString()).getStaff();
			Users leaveApprover=staff.getApprover();
			String []dates=staffLeaveStartAndEndDate.split("-");
			Date staffLeaveStartDate=formatter.parse(dates[0].trim());
			Date staffLeaveEndDate=formatter.parse(dates[1].trim());
			StaffLeaveRequisition staffLeaveRequisition=new StaffLeaveRequisition(staffLeaveType, staffLeaveReason, staff, leaveApprover, approvalStatus, staffLeaveStartDate, staffLeaveEndDate);
			staffServices.addStaffLeaveRequisition(staffLeaveRequisition);
			return "redirect:/staff/requisition";
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/staff/requisition";
		}
	}
	
	@RequestMapping(value="/requisition/staffLeaveRequest/cancel",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void cancelStaffLeaveRequisition(HttpServletRequest request) throws Exception{
		try{
			Integer staffLeaveRequistionId=Integer.parseInt(request.getParameter("staffLeaveRequisitionId"));
			StaffLeaveRequisition staffLeaveRequisition=staffServices.getStaffLeaveRequisitionById(staffLeaveRequistionId);
			staffLeaveRequisition.setApprovalStatus("Cancelled");
			System.out.println("cancelled");
			staffServices.cancelStaffLeaveRequisition(staffLeaveRequisition);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
	/*staff approvals related*/
	@RequestMapping(value="/approvals")
	public ModelAndView displayApprovalsPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("approvals");
			modelandview.addObject("leaveApporvalsList",staffServices.getStaffLeaveApprovals(request.getSession().getAttribute("username").toString()));
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping(value="/approvals/updatestatus")
	public String updateApprovalsStatus(HttpServletRequest request){
		
		try {
			Integer staffLeaveRequisitionId=Integer.parseInt(request.getParameter("staffLeaveRequistionId")) ;
		    String status=request.getParameter("staffLeaveRequistionStatus");
			StaffLeaveRequisition staffLeaveRequisition= staffServices.getStaffLeaveRequisitionById(staffLeaveRequisitionId);
			staffLeaveRequisition.setApprovalStatus(status);
			staffServices.updateStaffLeaveRequisition(staffLeaveRequisition);
			return "redirect:/approvals";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/approvals";
		}
	}
	
}
