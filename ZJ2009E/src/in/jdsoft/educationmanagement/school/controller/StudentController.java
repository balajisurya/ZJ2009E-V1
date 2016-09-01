package in.jdsoft.educationmanagement.school.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.services.AcademicYearServices;
import in.jdsoft.educationmanagement.school.services.BloodGroupServices;
import in.jdsoft.educationmanagement.school.services.CategoryServices;
import in.jdsoft.educationmanagement.school.services.ClassAndSectionServices;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationServices;
import in.jdsoft.educationmanagement.school.services.InstitutionServices;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryServices;
import in.jdsoft.educationmanagement.school.services.StudentServices;
import in.jdsoft.educationmanagement.school.services.UserService;




@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	
	StudentServices studentServices;
	@Autowired
	UserService userServices;
	@Autowired
	InstitutionServices institutionServices;
	@Autowired
	CategoryServices categoryServices;
	@Autowired
	GeographicalLocationServices geographicalServices;
	@Autowired
	AcademicYearServices academicYearServices;
	@Autowired
	BloodGroupServices bloodGroupServices;
	@Autowired
	ClassAndSectionServices classAndSectionServices;
	@Autowired
	SpecialCategoryServices specialCategoryServices;
	@Autowired
	ExceptionComparator exceptionComparator;
	@Autowired
	FileUploadHandler fileUploadHandler;
	
	@RequestMapping 
	public ModelAndView displayStudentRegistrationPage(HttpServletRequest request){
		try {
				Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				ModelAndView modelandview=new ModelAndView("studentRegistration");
				modelandview.addObject("specialCategories", institutionServices.getInstitutionSpecialCategory(instituteId));
				modelandview.addObject("categories", categoryServices.getCategoryList());
				modelandview.addObject("countries", geographicalServices.getCountryList());
				modelandview.addObject("classes", institutionServices.getInstitutionClasses(instituteId));
				modelandview.addObject("academicYear", academicYearServices.getInstitutionCurrentAcademicYear(instituteId));
				modelandview.addObject("bloodGroups", bloodGroupServices.getBloodGroupList());
			    return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="add",method=RequestMethod.POST) 
	public String addStudent(HttpServletRequest request,RedirectAttributes redirectAttributes,@RequestParam("studentProfilePic") MultipartFile multipartFile) throws Exception{
		try {
			Integer classId=Integer.parseInt(request.getParameter("joinedClass"));
			Class studentClass=classAndSectionServices.getClassById(classId);
			Integer sectionId=Integer.parseInt(request.getParameter("joinedsection"));
			Section section=classAndSectionServices.getSectionById(sectionId);
			Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
			Category category=categoryServices.getCategoryById(categoryId);
			Integer specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
			SpecialCategory specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
			Integer studentStatusId=1;
			StudentStatus studentStatus=studentServices.getStudentStatusById(studentStatusId);
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String parentGuardianFirstName=request.getParameter("parentOrGuardianFirstName");
			String parentGuardianLastName=request.getParameter("parentOrGuardianLastName");
			String parentGuardianEmail=request.getParameter("parentOrGuardianEmail");
			String sex=request.getParameter("studentGender");
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date birthDate=formatter.parse(request.getParameter("dateOfBirth"));
			Double fathersIncome=null;
			if(!request.getParameter("fatherIncome").isEmpty()){
				fathersIncome=Double.parseDouble(request.getParameter("fatherIncome"));
			}
			Double mothersIncome=null;
			if(!request.getParameter("motherIncome").isEmpty()){
				mothersIncome=Double.parseDouble(request.getParameter("motherIncome"));
			}
			BloodGroup bloodGroup=null;
			if(request.getParameter("bloodGroupId")!=null){
				bloodGroup=bloodGroupServices.getBloodGroupById(Integer.parseInt(request.getParameter("bloodGroupId")));
			}
			String addressLine1=request.getParameter("addressLine1");
			String addressLine2=request.getParameter("addressLine2");
			Integer countryId=Integer.parseInt(request.getParameter("countryId"));
			Integer stateId=Integer.parseInt(request.getParameter("stateId"));
			Integer cityId=Integer.parseInt(request.getParameter("cityId"));
			String postcode=request.getParameter("postCode");
			String email=request.getParameter("eMail");
			String contact=request.getParameter("contact");
			String passportNumber=request.getParameter("passportNo");
			String photoPath="";
			if((multipartFile!=null) && !(multipartFile.isEmpty()))
			{
				photoPath=fileUploadHandler.uploadFile(multipartFile.getBytes(),request.getRealPath("/resources/themes/images/profile-pic/student-profilepic/"),"/resources/themes/images/profile-pic/student-profilepic/",multipartFile.getOriginalFilename());
			}
			if(photoPath=="")
			{
				photoPath="/resources/themes/images/com.png";
			}
			Date joinedDate=formatter.parse(request.getParameter("joinedDate"));
			String scannedSignaturePath="s.png";
			String accessNo=request.getParameter("studentAccessNo");
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			Institution institution=institutionServices.getInstitutionById(institutionId);
			Integer academicYearId=Integer.parseInt(request.getParameter("academicYearId"));
			AcademicYear academicYear=academicYearServices.getAcademicYearById(academicYearId);
			String createdBy=request.getSession().getAttribute("username").toString();
			 String rollNo=null;
			 if(!request.getParameter("rollNo").isEmpty()){
				 rollNo=request.getParameter("rollNo");
			 }
			
			
			String parentContact=request.getParameter("parentContact");
			Student student=new Student(academicYear, studentClass, section, category, specialCategory, studentStatus, firstName, lastName, parentGuardianFirstName, parentGuardianLastName, parentGuardianEmail, sex, birthDate, fathersIncome, mothersIncome, addressLine1, addressLine2, cityId, stateId, countryId, postcode, email, contact, passportNumber, photoPath, joinedDate, scannedSignaturePath, bloodGroup, accessNo,rollNo,parentContact,institution, createdBy);
			studentServices.addStudent(student);
			return "redirect:/student";
		} catch (StudentException e) {
			if(e.getClass().equals(StudentException.class))
			{
				StudentException studentException=(StudentException)e;
				redirectAttributes.addFlashAttribute("errorMessage", studentException.getCustomMessage());
				return "redirect:/student";
			}
			else{
				throw new Exception();
			}
		}
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST) 
	public String deleteStudent(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			Integer studentId=Integer.parseInt(request.getParameter("deleteStudentId"));
			studentServices.deleteStudent(studentId);
			return "redirect:/student/studentdetails";
		} catch (Exception e) {
			if(e.getClass().equals(DataIntegrityViolationException.class))
			{
				redirectAttributes.addFlashAttribute("errorMessage", new Message("errorMessage", "Cannot Be Deleted"));
				return "redirect:/student/studentdetails";
			}
			else{
				throw new Exception();
			}
		}
	}

	@RequestMapping(value="bulkdelete",method=RequestMethod.POST) 
	public String deleteBulkStudent(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception{
		try {
			 String studentIds[]=request.getParameterValues("selectedStudentIds");
			 for (String studetId : studentIds) {
				 String stuid[] =studetId.split(",");
					for(String studentId:stuid)
					{
						studentServices.deleteStudent(Integer.parseInt(studentId));
					}
			}
			
			 return "redirect:/student/studentdetails";
		} catch (Exception e) {
			if(e.getClass().equals(DataIntegrityViolationException.class))
			{
				redirectAttributes.addFlashAttribute("errorMessage", new Message("errorMessage", "Cannot Be Deleted"));
				return "redirect:/student/studentdetails";
			}
			else{
				throw new Exception();
			}
		}
	}
	@RequestMapping(value = "/studentExcelFormat", method = RequestMethod.GET)
	public ModelAndView downloadStudentExcelFormat(){
		try {
			return new ModelAndView("studentExcelFormat","studentList",studentServices.getStudentsList());
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@RequestMapping(value = "/excelDownload", method = RequestMethod.POST)
	public ModelAndView downloadStudentExcelWithDatat(HttpServletRequest request) throws Exception{
		try {
			ArrayList<Student> students=new ArrayList<Student>();
			
			Integer classId=Integer.parseInt(request.getParameter("class"));
			Class clazz=classAndSectionServices.getClassById(classId);
			Integer sectionId=Integer.parseInt(request.getParameter("section"));
			Section section=classAndSectionServices.getSectionById(sectionId);
			String category=request.getParameter("category");
			String admissionNo=null;
			if(request.getParameter("admissionNo")!=null){
				admissionNo=request.getParameter("admissionNo");
			}
			Integer specialCategoryId=null;
			SpecialCategory specialCategory=null;
			if(request.getParameter("specialCategoryId")!=null){
				specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
				specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
			}
			if(category.equals("all"))
			{
				return new ModelAndView("studentDetails","studentList",studentServices.getAllStudentFromClassAndSection(clazz, section));
			}
			else if(category.equals("specificstudent"))
			{
				ArrayList<Student> students1=new ArrayList<Student>();
				students1.add(studentServices.getStudentFromClassAndSectionByAdmissionNo(clazz, section, admissionNo));
				return new ModelAndView("studentDetails","studentList",students1);
			}
			else if(category.equals("specialcategory"))
			{
				return new ModelAndView("studentDetails","studentList",studentServices.getStudentFromClassAndSectionBySpecialCategory(clazz, section, specialCategory));
			}
			else
			{
				return new ModelAndView("studentDetails","studentList",students); 
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping (value="studentdetails")
	public ModelAndView displayStudentDetailsPage(HttpServletRequest request){
		try {
			Integer instituteId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			ModelAndView modelandview=new ModelAndView("studentdetails");
			modelandview.addObject("specialCategories", institutionServices.getInstitutionSpecialCategory(instituteId));
			modelandview.addObject("classes", institutionServices.getInstitutionClasses(instituteId));
			modelandview.addObject("sections", institutionServices.getInstitutionSections(instituteId));
			modelandview.addObject("categories", categoryServices.getCategoryList());
			modelandview.addObject("academicYear", academicYearServices.getInstitutionCurrentAcademicYear(instituteId));
			modelandview.addObject("bloodGroups", bloodGroupServices.getBloodGroupList());
			modelandview.addObject("countryList",geographicalServices.getCountryList());
			modelandview.addObject("stateList", geographicalServices.getStateList());
			modelandview.addObject("cityList", geographicalServices.getCityList());
			modelandview.addObject("studentStatusList", studentServices.getStudentStatusList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

    
	@RequestMapping(value="editReterive", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Student> editReterive(HttpServletRequest request,RedirectAttributes redirectAttributes)throws Exception{
		try {
			ArrayList<Student> students=new ArrayList<Student>();
			
			Integer classId=Integer.parseInt(request.getParameter("class"));
			Class clazz=classAndSectionServices.getClassById(classId);
			Integer sectionId=Integer.parseInt(request.getParameter("section"));
			Section section=classAndSectionServices.getSectionById(sectionId);
			String category=request.getParameter("category");
			String admissionNo=null;
			if(request.getParameter("admissionNo")!=null){
				admissionNo=request.getParameter("admissionNo");
			}
			Integer specialCategoryId=null;
			SpecialCategory specialCategory=null;
			if(request.getParameter("specialCategoryId")!=null){
				specialCategoryId=Integer.parseInt(request.getParameter("specialCategoryId"));
				specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
			}
			if(category.equals("all"))
			{
				return studentServices.getAllStudentFromClassAndSection(clazz, section);
			}
			else if(category.equals("specificstudent"))
			{
				students.add(studentServices.getStudentFromClassAndSectionByAdmissionNo(clazz, section, admissionNo));
				return students;
			}
			else if(category.equals("specialcategory"))
			{
				return studentServices.getStudentFromClassAndSectionBySpecialCategory(clazz, section, specialCategory);
			}
			else
			{
				return students;
			}
			
		} 
		catch (Exception e) 
		{
			if(e.getClass().equals(StudentException.class))
			{
				StudentException studentException=(StudentException)e;
				redirectAttributes.addFlashAttribute("errorMessage", studentException.getCustomMessage());
				return null;
			}
			else
			{
				throw new Exception();
			}
		}
		
	}
	
	
	@RequestMapping(value="editStudentDetailsRetreive", method=RequestMethod.GET)
	@ResponseBody
	public Student editStudentDetailsRetreive(HttpServletRequest request){
		try {
			Integer studentId=Integer.parseInt(request.getParameter("studentId"));
			Student student=studentServices.getLazyStudentById(studentId);
			return student;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	@RequestMapping(value="uploadStudentExcel", method=RequestMethod.POST)
	public String studentBulkUpload(@RequestParam("studentExcelfile") MultipartFile studentExcelFile,RedirectAttributes redirectAttributes,HttpServletRequest request) throws Exception{
	
			try {
				Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				String createdBy=request.getSession().getAttribute("username").toString();
				studentServices.studentBulkUpload(studentExcelFile, institutionId, createdBy);
				redirectAttributes.addFlashAttribute("errorMessage",new Message("success","Uploaded Successfully"));
				return "redirect:/student";
			} catch (Exception e) {
				if(e.getClass().equals(StudentException.class)){
					StudentException studentException=(StudentException)e;
					redirectAttributes.addFlashAttribute("errorMessage", studentException.getCustomMessage());
					return "redirect:/student";
				}
				else{
					e.printStackTrace();
					throw e;
				}
				
			}
		
	}

	@RequestMapping(value="updateStudentExcel", method=RequestMethod.POST)
	public String studentBulkUpdate(@RequestParam("studentBulkUpdate") MultipartFile studentExcelFile,RedirectAttributes redirectAttributes,HttpServletRequest request) throws Exception{
	
			try {
				Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
				String createdBy=request.getSession().getAttribute("username").toString();
				studentServices.studentBulkUpdate(studentExcelFile,institutionId,createdBy);
				redirectAttributes.addFlashAttribute("errorMessage",new Message("success","Updated Successfully"));
				return "redirect:/student/studentdetails";
			} catch (Exception e) {
				if(e.getClass().equals(StudentException.class)){
					StudentException studentException=(StudentException)e;
					redirectAttributes.addFlashAttribute("errorMessage", studentException.getCustomMessage());
					return "redirect:/student/studentdetails";
				}
				else{
					e.printStackTrace();
					throw e;
				}
				
			}
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="update",method=RequestMethod.POST) 
	public String updateStudent(HttpServletRequest request,RedirectAttributes redirectAttributes,@RequestParam("studentProfilePic") MultipartFile multipartFile) throws Exception
	{
		try {
			Integer updateStudentId=Integer.parseInt(request.getParameter("updateStudentId"));
			Integer classId=Integer.parseInt(request.getParameter("editJoinedClass"));
			Class studentClass=classAndSectionServices.getClassById(classId);
			Integer sectionId=Integer.parseInt(request.getParameter("editJoinedSection"));
			Section section=classAndSectionServices.getSectionById(sectionId);
			Integer categoryId=Integer.parseInt(request.getParameter("editCategoryId"));
			Category category=categoryServices.getCategoryById(categoryId);
			Integer specialCategoryId=Integer.parseInt(request.getParameter("editSpecialCategoryId"));
			SpecialCategory specialCategory=specialCategoryServices.getSpecialCategoryById(specialCategoryId);
			String firstName=request.getParameter("editFirstName");
			String lastName=request.getParameter("editLastName");
			String parentGuardianFirstName=request.getParameter("editParentOrGuardianFirstName");
			String parentGuardianLastName=request.getParameter("editParentOrGuardianLastName");
			String parentGuardianEmail=request.getParameter("editParentOrGuardianEmail");
			String sex=request.getParameter("editStudentGender");
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date birthDate=formatter.parse(request.getParameter("editDateOfBirth"));
			Double fathersIncome=null;
			if(!request.getParameter("editFatherIncome").isEmpty()){
				fathersIncome=Double.parseDouble(request.getParameter("editFatherIncome"));
			}
			Double mothersIncome=null;
			if(!request.getParameter("editMotherIncome").isEmpty()){
				mothersIncome=Double.parseDouble(request.getParameter("editMotherIncome"));
			}
			BloodGroup bloodGroup=null;
			if(request.getParameter("editBloodGroupId")!=null){
				bloodGroup=bloodGroupServices.getBloodGroupById(Integer.parseInt(request.getParameter("editBloodGroupId")));
			}
			StudentStatus studentStatus=null;
			if(request.getParameter("editStudentStatus")!=null){
				studentStatus=studentServices.getStudentStatusById(Integer.parseInt(request.getParameter("editStudentStatus")));
			}
			String addressLine1=request.getParameter("editAddressLine1");
			String addressLine2=request.getParameter("editAddressLine2");
			Integer countryId=Integer.parseInt(request.getParameter("editCountryId"));
			Integer stateId=Integer.parseInt(request.getParameter("editStateId"));
			Integer cityId=Integer.parseInt(request.getParameter("editCityId"));
			String postcode=request.getParameter("editPostCode");
			String email=request.getParameter("editEMail");
			String contact=request.getParameter("editContact");
			String parentContact=request.getParameter("editParentContact");
		
			String passportNumber=request.getParameter("editPassportNo");
			
			
			String scannedSignaturePath="s.png";
			String accessNo=request.getParameter("editStudentAccessNo");
			Integer institutionId=Integer.parseInt(request.getSession().getAttribute("instituteId").toString());
			Institution institution=institutionServices.getInstitutionById(institutionId);
			String createdBy=request.getSession().getAttribute("username").toString();
			String rollNo=request.getParameter("editRollNo");
			String admissionNo=request.getParameter("editAdmissionNo");
			Student student=studentServices.getStudentById(updateStudentId);
			
			
			student.setFirstName(firstName);
			student.setAccessNo(accessNo);
			student.setAddressLine1(addressLine1);
			student.setAddressLine2(addressLine2);
			student.setAdmissionNo(admissionNo);
			student.setBirthDate(birthDate);
			student.setBloodGroup(bloodGroup);
			student.setCategory(category);
			student.setCityId(cityId);
			student.setContact(contact);
			student.setParentContact(parentContact);
			student.setCountryId(countryId);
			student.setCreatedBy(createdBy);
			student.setEmail(email);
			student.setFathersIncome(fathersIncome);
			student.setInstitution(institution);
			student.setLastName(lastName);
			student.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
			student.setMothersIncome(mothersIncome);
			student.setParentGuardianEmail(parentGuardianEmail);
			student.setParentGuardianFirstName(parentGuardianFirstName);
			student.setParentGuardianLastName(parentGuardianLastName);
			student.setPassportNumber(passportNumber);
			student.setPostcode(postcode);
			
			if(!request.getParameter("editRollNo").isEmpty()){
				 rollNo=request.getParameter("editRollNo");
				 student.setRollNo(rollNo);
			 }
			String photoPath="";
			if((multipartFile!=null) && !(multipartFile.isEmpty()))
			{
				photoPath=fileUploadHandler.uploadFile(multipartFile.getBytes(),request.getRealPath("/resources/themes/images/profile-pic/student-profilepic/"),"/resources/themes/images/profile-pic/student-profilepic/",multipartFile.getOriginalFilename());
			}
			if(photoPath!="")
			{
				student.setPhotoPath(photoPath);
			}
			student.setScannedSignature(scannedSignaturePath);
			student.setSection(section);
			student.setSex(sex);
			student.setSpecialCategory(specialCategory);
			student.setStateId(stateId);
			student.setStudentClass(studentClass);
			student.setStudentStatus(studentStatus);
			studentServices.updateStudent(student);
			return "redirect:/student/studentdetails";
		} 
		catch (DataIntegrityViolationException e) {
	
			  if(e.getClass().equals(DataIntegrityViolationException.class)){
				  Throwable cause=e.getCause();
				  if(cause.getClass().equals(ConstraintViolationException.class))
				  {
					  String valid=exceptionComparator.containsWord(e.getMessage());
						System.out.println(e.getMessage());
						if(valid!=null)
						{
							if(valid.equalsIgnoreCase("Class_id")){
								valid="Same Roll No In Class";
							}
							else{
								valid = valid.replace('_',' ');	
							}
							 redirectAttributes.addFlashAttribute("errorMessage",new Message("duplicate", "Already Exist "+valid));			
							 return "redirect:/student/studentdetails";
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
	
}
