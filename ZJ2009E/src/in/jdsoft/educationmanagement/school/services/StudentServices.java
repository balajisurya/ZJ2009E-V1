package in.jdsoft.educationmanagement.school.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import in.jdsoft.educationmanagement.components.NumberGenerator;
import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.BloodGroupDAO;
import in.jdsoft.educationmanagement.school.dao.CategoryDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.GeographicalLocationDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.MasterUserTypeDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentStatusDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentStatus;




@Service
public class StudentServices {
	
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	StudentStatusDAO studentStatusDAO;
	@Autowired
	UserDAO usersDAO;
	@Autowired
	MasterUserTypeDAO masterUserTypeDAO;
	@Autowired
	AcademicYearDAO academicYearDAO;
	@Autowired
	GeographicalLocationDAO geographicalLocationDAO;
	@Autowired
	ClassDAO classDAO;
	@Autowired
	SectionDAO sectionDAO;
	@Autowired
	BloodGroupDAO bloodGroupDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SpecialCategoryDAO specialCategoryDAO;
	@Autowired
	HashGenerator hashGenerator;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	ExceptionComparator exceptionComparator;
	@Autowired
	NumberGenerator admissionNumberGenerator;

	@Transactional(rollbackFor=StudentException.class)
	 public void addStudent(Student student) throws StudentException
	 {
		  try 
		  {
			  if(student.getAdmissionNo()==null)
			  {
				  student.setAdmissionNo(admissionNumberGenerator.generateAdmissionNumber().toString());  
			  }
			  	studentDAO.persist(student);
			} catch (ConstraintViolationException e) {
			  if(e.getClass().equals(ConstraintViolationException.class)){
				
				  String valid=exceptionComparator.containsWord(e.getMessage());
					System.out.println(valid);
					if(valid!=null)
					{
						if(valid.equalsIgnoreCase("Class_id")){
							valid="Roll No In Class";
						}
						else{
							valid = valid.replace('_',' ');	
						}
						throw new StudentException(new Message("duplicate", "Cannot Create Duplicate "+valid));
						
					}else
					{
						 throw e;
					}
				  
			  }else
			  {
				  throw e;
			  }
		  }
		 
	 }
	 
	 @Transactional
	 public void updateStudent(Student student)throws DataIntegrityViolationException
	 {	
			 studentDAO.update(student);		 
	 }
	 
	 @Transactional
	 public void deleteStudent(int studentId)throws DataIntegrityViolationException
	 {
	 		 studentDAO.delete(studentDAO.getStudentById(studentId));
	 }
	 
	 @Transactional
	 public ArrayList<Student> getStudentsList()
	 {
			 return (ArrayList<Student>) studentDAO.getList();
	 }
	 
	 
	 @Transactional
	 public Student getStudentById(int studentId)	 
	 { 
			 return studentDAO.getStudentById(studentId);
	 }
	 
	 @Transactional
	 public Student getLazyStudentById(int studentId)	 
	 { 
		 Student student=studentDAO.getStudentById(studentId);
		 Hibernate.initialize(student.getSection());
		 Hibernate.initialize(student.getBloodGroup());
		 Hibernate.initialize(student.getCategory());
		 Hibernate.initialize(student.getSpecialCategory());
		 Hibernate.initialize(student.getStudentClass());
		 Hibernate.initialize(student.getStudentStatus());
		 Hibernate.initialize(student.getJoinedAcademicYear());
	     return student;
	 }
	 
	 
	 
	 @Transactional
	 public StudentStatus getStudentStatusById(int studentStatusId){
	 	 return studentStatusDAO.getStudentStatusById(studentStatusId);
	 }
	 
	 
	 @Transactional
	 public ArrayList<StudentStatus> getStudentStatusList()
	 {
			 return (ArrayList<StudentStatus>) studentStatusDAO.getList();
	 }
	 
	@Transactional
	 public ArrayList<Student> getAllStudentFromClassAndSection(Class clazz,Section section){
		ArrayList<Student> students= (ArrayList<Student>)studentDAO.getStudentsByClassAndSection(clazz, section);
		Iterator<Student> iterator=students.iterator();
		while(iterator.hasNext()){
			Student student=iterator.next();
				 Hibernate.initialize(student.getStudentClass());
				 Hibernate.initialize(student.getSection());
				 Hibernate.initialize(student.getBloodGroup());
				 Hibernate.initialize(student.getCategory());
				 Hibernate.initialize(student.getSpecialCategory());
				 Hibernate.initialize(student.getStudentStatus());
				 Hibernate.initialize(student.getJoinedAcademicYear());
				 Hibernate.initialize(student.getJoinedClass());
			
		}
		 return students; 
	 }
	 
	 @Transactional
	 public ArrayList<Student> getStudentFromClassAndSectionBySpecialCategory(Class clazz,Section section,SpecialCategory specialCategory){
		 ArrayList<Student> students= (ArrayList<Student>) studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
		 Iterator<Student> iterator=students.iterator();
			while(iterator.hasNext()){
				Student student=iterator.next();
				
					 Hibernate.initialize(student.getStudentClass());
					 Hibernate.initialize(student.getSection());
					 Hibernate.initialize(student.getBloodGroup());
					 Hibernate.initialize(student.getCategory());
					 Hibernate.initialize(student.getSpecialCategory());
					 Hibernate.initialize(student.getStudentStatus());
					 Hibernate.initialize(student.getJoinedAcademicYear());
					 Hibernate.initialize(student.getJoinedClass());
				
			}
			 return students;
	 }
	 
	 
	 @Transactional
	 public Student getStudentFromClassAndSectionByAdmissionNo(Class clazz,Section section,String admissionNo)throws StudentException{
		try{
		 Student student=studentDAO.getStudentsByClassSectionAndAdmissionNo(clazz, section, admissionNo);
		 	if(student!=null)
		 	{
		 		Hibernate.initialize(student.getStudentClass());
		 		Hibernate.initialize(student.getSection());
		 		Hibernate.initialize(student.getBloodGroup());
		 		Hibernate.initialize(student.getCategory());
		 		Hibernate.initialize(student.getSpecialCategory());
		 		Hibernate.initialize(student.getStudentStatus());
		 		Hibernate.initialize(student.getJoinedAcademicYear());
		 		Hibernate.initialize(student.getJoinedClass());
		 		return student;  
		 	}
		 	else
		 	{
		 		throw new StudentException(new Message("errorMessage", "Admission Number Not Found"));
		 	}
		}
		catch(Exception e)
		{
			if(e.getClass().equals(NullPointerException.class))
			{
				throw new StudentException(new Message("errorMessage", "Admission Number Not Found"));
			}
			else
			{
				throw e;
			}
		}
	}
	 
	
	 @Transactional(rollbackFor=StudentException.class)
	 public Integer studentBulkUpload(MultipartFile studentExcelFile,Integer institutionId,String createdBy) throws StudentException{
		 
		 int i = 1;
		try {
			ArrayList<Student> students=new ArrayList<Student>();
			 DataFormatter formatter=new DataFormatter();
			 HSSFWorkbook workbook = new HSSFWorkbook(studentExcelFile.getInputStream());
			 HSSFSheet worksheet = workbook.getSheetAt(0);
			 Institution institution=institutionDAO.getInstitutionById(institutionId);
			 while(i<=worksheet.getLastRowNum()){
				 HSSFRow row = worksheet.getRow(i++);
				 
				 
				 String admissionNo=null;
				 if(!formatter.formatCellValue(row.getCell(0)).isEmpty()){
					 admissionNo=formatter.formatCellValue(row.getCell(0)).trim();
				 }
				 else{
					 //admissionNo=Long.toString(System.currentTimeMillis());
					 admissionNo=admissionNumberGenerator.generateAdmissionNumber().toString();
				 }
				 
				 String firstName=null;
				 if(!formatter.formatCellValue(row.getCell(1)).isEmpty()){
					 firstName=formatter.formatCellValue(row.getCell(1)).trim();
				 }
				 else{
					 throw new StudentException(new Message("firstNameNotFound", "Upload Failed : You have to mention First Name in row "+i));
				 }
				 
				 String lastName=null;
				 if(!formatter.formatCellValue(row.getCell(2)).isEmpty()){
					 lastName=formatter.formatCellValue(row.getCell(2)).trim();
				 }
				 
				 Class studentClass=null;
				 if(!formatter.formatCellValue(row.getCell(3)).isEmpty()){
					 studentClass=classDAO.getClassByClassName(formatter.formatCellValue(row.getCell(3)).trim(),institution);
					 if(studentClass==null){
						 throw new StudentException(new Message("classnotfound", "Upload Failed : Invalid Current class in row "+i));
					 }
				 }
				 else{
					 throw new StudentException(new Message("classnotfound", "Upload Failed : You have to mention Current class in row "+i));
				 }
				 
				 Section section=null; 
				 if(!formatter.formatCellValue(row.getCell(4)).isEmpty()){
					 Section sectionReceived=sectionDAO.getSectionBySectionName(formatter.formatCellValue(row.getCell(4)).trim(), institution);
					 if(sectionReceived==null){
						 throw new StudentException(new Message("sectionnotfound", "Upload Failed : Invalid Section in row "+i));
					 }
					 else{
						 if(studentClass.getSections().contains(sectionReceived)){
							 section=sectionReceived;
						 }
						 else{
							 throw new StudentException(new Message("sectionnotfound", "Upload Failed : No Such Section for a class in row "+i));
						 }
					 }
				  }
				 else {
					 throw new StudentException(new Message("sectionnotfound", "Upload Failed : You have to mention section for row "+i));
				 }
				
				 SpecialCategory specialCategory=null;
				 if(!formatter.formatCellValue(row.getCell(5)).isEmpty()){
					 specialCategory=specialCategoryDAO.getSpecialCategoryByName(formatter.formatCellValue(row.getCell(5)).trim(),institution);
					 if(specialCategory==null){
						 throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : Invalid special category in row "+i));
					 }
				 }
				 else{
					 throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : You have to mention special category in row "+i));
				 }
				 
				 StudentStatus studentStatus=null;
				 if(!formatter.formatCellValue(row.getCell(6)).isEmpty()){
					 studentStatus=studentStatusDAO.getStudentStatusByName(formatter.formatCellValue(row.getCell(6)).trim());
					 if(studentStatus==null){
						 throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : Invalid student status in row "+i));
					 }
				 }
				 else{
					 throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : You have to mention student status in row "+i));
				 }
				 
				 String rollNo=null;
				 if(!formatter.formatCellValue(row.getCell(7)).isEmpty()){
					 rollNo=formatter.formatCellValue(row.getCell(7)).trim();
				 }
				 
				 String sex=null;
				 if(!formatter.formatCellValue(row.getCell(8)).isEmpty()){
					String gender=formatter.formatCellValue(row.getCell(8)).trim();
					 if(gender.equals("Male") || gender.equals("Female") || gender.equals("Others")){
						 sex=gender;
					 }
					 else{
						 throw new StudentException(new Message("genderNotFound", "Upload Failed : Gender can be Male/Female/Others in row "+i)); 
					 }
					 
				 }
				 else{
					 throw new StudentException(new Message("genderNotFound", "Upload Failed : You have to mention gender in row "+i));
				 }
				 
				 Date birthDate=null;
				 if(!formatter.formatCellValue(row.getCell(9)).isEmpty()){
					 DateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
					 try {
						birthDate=dateformatter.parse(formatter.formatCellValue(row.getCell(9)).trim());
					} catch (ParseException e) {
						throw new StudentException(new Message("invalidDateFormat", "Upload Failed : Invalid Birth Date Format in row "+i+" correct format [eg:dd/mm/yyyy]"));
					}
				 }
				 
				 Category category=null;
				 if(!formatter.formatCellValue(row.getCell(10)).isEmpty()){
					 category=categoryDAO.getCategoryByCategoryName(formatter.formatCellValue(row.getCell(10)).trim());
					 if(category==null){
						 throw new StudentException(new Message("categorynotfound", "Upload Failed : Invalid category in row "+i));
					 }
				 }
				 
				 BloodGroup bloodGroup=null;
				 if(!formatter.formatCellValue(row.getCell(11)).isEmpty()){
					 bloodGroup=bloodGroupDAO.getBloodGroupByName(formatter.formatCellValue(row.getCell(11)).trim());
					 if(bloodGroup==null){
						 throw new StudentException(new Message("bloodGroupnotfound", "Upload Failed : Invalid Blood Group in row "+i));
					 }
				 }

				 AcademicYear joinedAcademicYear=null;
				 if(!formatter.formatCellValue(row.getCell(12)).isEmpty()){
					 joinedAcademicYear=academicYearDAO.getAcademiYearByAcademicYearTitle(formatter.formatCellValue(row.getCell(12)).trim(),institution);
					 if(joinedAcademicYear==null){
						 throw new StudentException(new Message("academicyearnotfound", "Upload Failed : Invalid Academic Year in row "+i));
					 }
				 }
				 
				 Class joinedClass=null;
				 if(!formatter.formatCellValue(row.getCell(13)).isEmpty()){
					 joinedClass=classDAO.getClassByClassName(formatter.formatCellValue(row.getCell(13)).trim(),institution);
					 if(joinedClass==null){
						 throw new StudentException(new Message("classnotfound", "Upload Failed : Invalid Joined Class in row "+i));
					 }
				 }
				 
				 String parentGuardianFirstName=null;
				 if(!formatter.formatCellValue(row.getCell(14)).isEmpty()){
					 parentGuardianFirstName=formatter.formatCellValue(row.getCell(14)).trim();
				 }
				 String parentGuardianLastName=null;
				 if(!formatter.formatCellValue(row.getCell(15)).isEmpty()){
					 parentGuardianLastName=formatter.formatCellValue(row.getCell(15)).trim();
				 }
				 String parentGuardianEmail=null;
				 if(!formatter.formatCellValue(row.getCell(16)).isEmpty()){
					 parentGuardianEmail=formatter.formatCellValue(row.getCell(16)).trim();
				 }
				 
				 String addressLine1=null;
				 if(!formatter.formatCellValue(row.getCell(17)).isEmpty()){
					 addressLine1=formatter.formatCellValue(row.getCell(17)).trim();
				 }
				 String addressLine2=null;
				 if(!formatter.formatCellValue(row.getCell(18)).isEmpty()){
					 addressLine2=formatter.formatCellValue(row.getCell(18)).trim();
				 }
				 
				 Integer countryId=null;
				 if(!formatter.formatCellValue(row.getCell(19)).isEmpty()){
					GeographicalLocation geoGraphicalLocation=geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue(row.getCell(19)).trim());
					 if( geoGraphicalLocation!=null){
						 if(geoGraphicalLocation.getGeographicalLocationType()==0){
							 countryId=geoGraphicalLocation.getGeographicalLocationId();
						}
						 else{
							 throw new StudentException(new Message("countryNotFound", "Upload Failed :" +formatter.formatCellValue(row.getCell(19))+" is not a country in row "+i));
						 }
					 }
					 else{
						 throw new StudentException(new Message("countryNotFound", "Upload Failed : Invalid Country in row "+i));
					 }
				 }
				 
                 Integer stateId=null;
                 if(!formatter.formatCellValue(row.getCell(20)).isEmpty()){
 					GeographicalLocation geoGraphicalLocation=geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue(row.getCell(20)).trim());
 					 if( geoGraphicalLocation!=null){
 						 if(geoGraphicalLocation.getGeographicalLocationType()==1){
 							 if(geoGraphicalLocation.getParentId()==countryId){
 								stateId=geoGraphicalLocation.getGeographicalLocationId();
 							 }
 							 else{
 								throw new StudentException(new Message("stateNotFound", "Upload Failed :No such state for given country in row "+i));
 							 }
 						 }
 						 else{
 							throw new StudentException(new Message("stateNotFound", "Upload Failed :" +formatter.formatCellValue(row.getCell(20))+" is not a state in row "+i));
 						 }
 					 }
 					 else{
 						 throw new StudentException(new Message("stateNotFound", "Upload Failed : Invalid State in row "+i));
 					 }
 				 }
                 
				 Integer cityId=null;
				 if(!formatter.formatCellValue(row.getCell(21)).isEmpty()){
	 					GeographicalLocation geoGraphicalLocation=geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue(row.getCell(21)).trim());
	 					 if( geoGraphicalLocation!=null){
	 						 if(geoGraphicalLocation.getGeographicalLocationType()==2){
	 							 if(geoGraphicalLocation.getParentId()==stateId){
	 								cityId=geoGraphicalLocation.getGeographicalLocationId();
	 							 }
	 							 else{
	 								throw new StudentException(new Message("stateNotFound", "Upload Failed :No such city for given state in row "+i));
	 							 }
	 						 }
	 						 else{
	 							throw new StudentException(new Message("stateNotFound", "Upload Failed :" +formatter.formatCellValue(row.getCell(21))+" is not a city in row "+i));
	 						 }
	 					 }
	 					 else{
	 						 throw new StudentException(new Message("stateNotFound", "Upload Failed : Invalid city in row "+i));
	 					 }
	 				 }
				 
				 String postcode=null;
				 if(!formatter.formatCellValue(row.getCell(22)).isEmpty()){
					 postcode=formatter.formatCellValue(row.getCell(22)).trim();
				 }
				 String email=null;
				 if(!formatter.formatCellValue(row.getCell(23)).isEmpty()){
					 email=formatter.formatCellValue(row.getCell(23)).trim();
				 }
				 String contact=null;
				 if(!formatter.formatCellValue(row.getCell(24)).isEmpty()){
					 contact=formatter.formatCellValue(row.getCell(24)).trim();
				 }
				 
				 String parentContact=null;
				 if(!formatter.formatCellValue(row.getCell(25)).isEmpty()){
					 parentContact=formatter.formatCellValue(row.getCell(25)).trim();
				 }
				 
				 Date joinedDate=null;
				 if(!formatter.formatCellValue(row.getCell(26)).isEmpty()){
					 DateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
					 try {
						joinedDate=dateformatter.parse(formatter.formatCellValue(row.getCell(26)).trim());
					} catch (ParseException e) {
						throw new StudentException(new Message("invalidDateFormat", "Upload Failed : Invalid Joined Date Format in row "+i+" correct format [eg:dd/mm/yyyy]"));
					}
				 }
				 
				 
				 
				 Double fathersIncome=null;
				 if(!formatter.formatCellValue(row.getCell(27)).isEmpty()){
					 fathersIncome=Double.parseDouble(formatter.formatCellValue(row.getCell(27)).trim());
				 }
				 Double mothersIncome=null;
				 if(!formatter.formatCellValue(row.getCell(28)).isEmpty()){
					 mothersIncome=Double.parseDouble(formatter.formatCellValue(row.getCell(28)).trim());
				 }
				 
				 String accessNo=null;
				 if(!formatter.formatCellValue(row.getCell(29)).isEmpty()){
					 accessNo=formatter.formatCellValue(row.getCell(29)).trim();
				 }
				 
				 String passportNumber=null;
				 if(!formatter.formatCellValue(row.getCell(30)).isEmpty()){
					 passportNumber=formatter.formatCellValue(row.getCell(30)).trim();
				 }
				 
				 String photoPath="/resources/themes/images/com.png";
				 String scannedSignature=null;
				 
				 Student student=new Student(joinedAcademicYear, studentClass, section,joinedClass,category, specialCategory, studentStatus, firstName, lastName, parentGuardianFirstName, parentGuardianLastName, parentGuardianEmail, sex, birthDate, fathersIncome, mothersIncome, addressLine1, addressLine2, cityId, stateId, countryId, postcode, email, contact, passportNumber, photoPath, joinedDate, scannedSignature, bloodGroup, accessNo, admissionNo, rollNo, parentContact, institution, createdBy);
				 students.add(student);
			 }
			 
			 for (Student student : students) {
				studentDAO.persist(student);
			 }
			 return i;
		} catch (IOException | ConstraintViolationException e) {
			if(e.getClass().equals(IOException.class)){
				throw new StudentException(new Message("fileError","Excel File Not Found"));
			}
			else if(e.getClass().equals(NullPointerException.class)){
				throw new StudentException(new Message("Null Value","Fields Cannot be Blank"));
			}
			else if(e.getClass().equals(ConstraintViolationException.class)){
				
				throw new StudentException(new Message("duplicateException","Upload Failed: Check for Duplicates in Admission No, Roll No in same Class and Section or in email-id in the Excel"));
			}
			else{
				e.printStackTrace();
				return 0;
			}
		}
		 
	 }
	 
	 
	 
	 
	 
	 @Transactional
	 public ArrayList<Student> getActiveStudentFromClassAndSection(Class clazz,Section section){
		 ArrayList<Student> actualStudent=new ArrayList<Student>();
		ArrayList<Student> students= (ArrayList<Student>)studentDAO.getStudentsByClassAndSection(clazz, section);
		Iterator<Student> iterator=students.iterator();
		while(iterator.hasNext()){
			Student student=iterator.next();
			if(student.getStudentStatus().getStudentStatusId()!=1){
				iterator.remove();
			}
			else{
				if(!checkForStudentInvoiceGenerated(student)){
					Hibernate.initialize(student.getStudentClass());
					 Hibernate.initialize(student.getSection());
					 Hibernate.initialize(student.getBloodGroup());
					 Hibernate.initialize(student.getCategory());
					 Hibernate.initialize(student.getSpecialCategory());
					 Hibernate.initialize(student.getStudentStatus());
					 Hibernate.initialize(student.getJoinedAcademicYear());
					 Hibernate.initialize(student.getJoinedClass());
					 actualStudent.add(student);
				}

				 
			}
		}
		 return actualStudent; 
	 }
	 
	 @Transactional
	 public ArrayList<Student> getActiveStudentFromClassAndSectionBySpecialCategory(Class clazz,Section section,SpecialCategory specialCategory){
		 ArrayList<Student> students= (ArrayList<Student>) studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
		 Iterator<Student> iterator=students.iterator();
			while(iterator.hasNext()){
				Student student=iterator.next();
				if(student.getStudentStatus().getStudentStatusId()!=1){
					iterator.remove();
				}
				else{
					 Hibernate.initialize(student.getStudentClass());
					 Hibernate.initialize(student.getSection());
					 Hibernate.initialize(student.getBloodGroup());
					 Hibernate.initialize(student.getCategory());
					 Hibernate.initialize(student.getSpecialCategory());
					 Hibernate.initialize(student.getStudentStatus());
					 Hibernate.initialize(student.getJoinedAcademicYear());
					 Hibernate.initialize(student.getJoinedClass());
				}
				
			}
			 return students;
	 }
	 
	 
	/* @Transactional
	 public Student getActiveStudentFromClassAndSectionByAdmissionNo(Class clazz,Section section,String admissionNo)throws StudentException{
		try{
		 Student student=studentDAO.getStudentsByClassSectionAndAdmissionNo(clazz, section, admissionNo);
		  if(student.getStudentStatus().getStudentStatusId()==1){
			  Hibernate.initialize(student.getStudentClass());
				 Hibernate.initialize(student.getSection());
				 Hibernate.initialize(student.getBloodGroup());
				 Hibernate.initialize(student.getCategory());
				 Hibernate.initialize(student.getSpecialCategory());
				 Hibernate.initialize(student.getStudentStatus());
				 Hibernate.initialize(student.getJoinedAcademicYear());
				 Hibernate.initialize(student.getJoinedClass());
				 return student;   
		  }
		  else{
			  return null;
		  }
			 
		}
		catch(Exception e)
		{
			if(e.getClass().equals(NullPointerException.class))
			{
				throw new StudentException(new Message("errorMessage", "Admission Number Not Found"));
			}
			else
			{
				throw e;
			}
		}
	}*/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @Transactional(rollbackFor=StudentException.class)
	 public Integer studentBulkUpdate(MultipartFile studentExcelFile,Integer institutionId,String createdBy) throws StudentException{
		 
		 int i = 1;
		try {
			ArrayList<Student> students=new ArrayList<Student>();
			 DataFormatter formatter=new DataFormatter();
			 HSSFWorkbook workbook = new HSSFWorkbook(studentExcelFile.getInputStream());
			 HSSFSheet worksheet = workbook.getSheetAt(0);
			 Institution institution=institutionDAO.getInstitutionById(institutionId);
			 while(i<=worksheet.getLastRowNum()){
				 HSSFRow row = worksheet.getRow(i++);
				 
				 
				 Integer studentId=null;
				 Student student=null;
				 if(!formatter.formatCellValue(row.getCell(0)).isEmpty()){
					 studentId=Integer.parseInt(formatter.formatCellValue(row.getCell(0)).trim());
					 student=studentDAO.getStudentById(studentId);
					 if(student!=null){
						 if(!formatter.formatCellValue(row.getCell(2)).isEmpty()){
							 student.setFirstName(formatter.formatCellValue(row.getCell(2)).trim());
						 }
						 else{
							 throw new StudentException(new Message("firstNameNotFound", "Upload Failed : You have to mention First Name in row "+i));
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(3)).isEmpty()){
							 student.setLastName(formatter.formatCellValue(row.getCell(3)).trim());
						 }
						 
						 Class studentClass=null;
						 if(!formatter.formatCellValue(row.getCell(4)).isEmpty()){
							 studentClass=classDAO.getClassByClassName(formatter.formatCellValue(row.getCell(4)).trim(),institution);
							 if(studentClass==null){
								 throw new StudentException(new Message("classnotfound", "Upload Failed : Invalid Current class in row "+i));
							 }
							 else{
								 student.setStudentClass(studentClass);
							 }
						 }
						 else{
							 throw new StudentException(new Message("classnotfound", "Upload Failed : You have to mention Current class in row "+i));
						 }
						 
						  
						 if(!formatter.formatCellValue(row.getCell(5)).isEmpty()){
							 Section sectionReceived=sectionDAO.getSectionBySectionName(formatter.formatCellValue(row.getCell(5)).trim(), institution);
							 if(sectionReceived==null){
								 throw new StudentException(new Message("sectionnotfound", "Upload Failed : Invalid Section in row "+i));
							 }
							 else{
								 if(studentClass.getSections().contains(sectionReceived)){
									 student.setSection(sectionReceived);
								}
								 else{
									 throw new StudentException(new Message("sectionnotfound", "Upload Failed : No Such Section for a class in row "+i));
								 }
							 }
							}
						 else {
							 throw new StudentException(new Message("sectionnotfound", "Upload Failed : You have to mention section for row "+i));
						 }
						 
						 SpecialCategory specialCategory=null;
						 if(!formatter.formatCellValue(row.getCell(6)).isEmpty()){
							 specialCategory=specialCategoryDAO.getSpecialCategoryByName(formatter.formatCellValue(row.getCell(6)).trim(),institution);
							 if(specialCategory==null){
								 throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : Invalid special category in row "+i));
							 }
							 else{
								 student.setSpecialCategory(specialCategory);
							 }
						 }
						 else{
							 throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : You have to mention special category in row "+i));
						 }
						 
						 StudentStatus studentStatus=null;
						 if(!formatter.formatCellValue(row.getCell(7)).isEmpty()){
							 studentStatus=studentStatusDAO.getStudentStatusByName(formatter.formatCellValue(row.getCell(7)).trim());
							 if(studentStatus==null){
								 throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : Invalid student status in row "+i));
							 }
							 else{
								 student.setStudentStatus(studentStatus);
							 }
						 }
						 else{
							 throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : You have to mention student status in row "+i));
						 }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(8)).isEmpty()){
							 student.setRollNo(formatter.formatCellValue(row.getCell(8)).trim());
						 }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(9)).isEmpty()){
							String gender=formatter.formatCellValue(row.getCell(9)).trim();
							 if(gender.equals("Male") || gender.equals("Female") || gender.equals("Others")){
								 student.setSex(gender);
							 }
							 else{
								 throw new StudentException(new Message("genderNotFound", "Upload Failed : Gender can be Male/Female/Others in row "+i)); 
							 }
							 
						 }
						 else{
							 throw new StudentException(new Message("genderNotFound", "Upload Failed : You have to mention gender in row "+i));
						 }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(10)).isEmpty()){
							 DateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
							 try {
								 student.setBirthDate(dateformatter.parse(formatter.formatCellValue(row.getCell(10)).trim()));
						 	} catch (ParseException e) {
								throw new StudentException(new Message("invalidDateFormat", "Upload Failed : Invalid Birth Date Format in row "+i+" correct format [eg:dd/mm/yyyy]"));
							}
						 }
						 
						 Category category=null;
						 if(!formatter.formatCellValue(row.getCell(11)).isEmpty()){
							 category=categoryDAO.getCategoryByCategoryName(formatter.formatCellValue(row.getCell(11)).trim());
							 if(category==null){
								 throw new StudentException(new Message("categorynotfound", "Upload Failed : Invalid category in row "+i));
							 }
							 else{
								 student.setCategory(category);
							 }
						 }
						 
						 BloodGroup bloodGroup=null;
						 if(!formatter.formatCellValue(row.getCell(12)).isEmpty()){
							 bloodGroup=bloodGroupDAO.getBloodGroupByName(formatter.formatCellValue(row.getCell(12)).trim());
							 if(bloodGroup==null){
								 throw new StudentException(new Message("bloodGroupnotfound", "Upload Failed : Invalid Blood Group in row "+i));
							 }
							 else{
								 student.setBloodGroup(bloodGroup);
							 }
						 }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(15)).isEmpty()){
							 student.setParentGuardianFirstName(formatter.formatCellValue(row.getCell(15)).trim());
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(16)).isEmpty()){
							 student.setParentGuardianLastName(formatter.formatCellValue(row.getCell(16)).trim());
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(17)).isEmpty()){
							 student.setParentGuardianEmail(formatter.formatCellValue(row.getCell(17)).trim());
						}
						 
						 
						 if(!formatter.formatCellValue(row.getCell(18)).isEmpty()){
							 student.setAddressLine1(formatter.formatCellValue(row.getCell(18)).trim());
						}
						
						 if(!formatter.formatCellValue(row.getCell(19)).isEmpty()){
							 student.setAddressLine1(formatter.formatCellValue(row.getCell(19)).trim());
						}
						
						 if(!formatter.formatCellValue(row.getCell(20)).isEmpty()){
							 student.setPostcode(formatter.formatCellValue(row.getCell(20)).trim());
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(21)).isEmpty()){
							 student.setEmail(formatter.formatCellValue(row.getCell(21)).trim());
						 }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(22)).isEmpty()){
							 student.setContact(formatter.formatCellValue(row.getCell(22)).trim());
						  }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(23)).isEmpty()){
							 student.setParentContact(formatter.formatCellValue(row.getCell(23)).trim());
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(25)).isEmpty()){
							 student.setFathersIncome(Double.parseDouble(formatter.formatCellValue(row.getCell(25)).trim()));
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(26)).isEmpty()){
							 student.setMothersIncome(Double.parseDouble(formatter.formatCellValue(row.getCell(26)).trim()));
						 }
						 
						 
						 if(!formatter.formatCellValue(row.getCell(27)).isEmpty()){
							 student.setAccessNo(formatter.formatCellValue(row.getCell(27)).trim());
						 }
						 
						 if(!formatter.formatCellValue(row.getCell(28)).isEmpty()){
							 student.setPassportNumber(formatter.formatCellValue(row.getCell(28)).trim());
						 }
					  
					 }
					 else{
						 throw new StudentException(new Message("invalidStudentId", "No Student Id Found On Row"+i));
					 }
					 }
					 else{
						 throw new StudentException(new Message("invalidStudentId", "Invalid Student Id Found On Row"+i));
					 }
				 	students.add(student);
			 }
			 
			 for (Student student : students) {
				studentDAO.update(student);
			 }
			 return i;
		} catch (IOException | ConstraintViolationException e) {
			if(e.getClass().equals(IOException.class)){
				throw new StudentException(new Message("fileError","Excel File Not Found"));
			}
			else if(e.getClass().equals(NullPointerException.class)){
				throw new StudentException(new Message("Null Value","Fields Cannot be Blank"));
			}
			else{
				e.printStackTrace();
				return 0;
			}
		}
		 
	 }

	 @Transactional
	 public Student getActiveStudentByAdmissionNo(String admissionNo){
		 StudentStatus studentStatus= studentStatusDAO.getStudentStatusById(1);
		 Student student=studentDAO.getActiveStudentByAdmissionNo(admissionNo,studentStatus);
		 if(student!=null){
			 if(checkForStudentInvoiceGenerated(student)){
				 student=null;
			}
			 else{
				 Hibernate.initialize(student.getStudentClass());
				 Hibernate.initialize(student.getSection());
			 }
			 
		 }
		 return  student;
	 }
	 
	 @Transactional
	 public ArrayList<Student> getActiveStudentsFromAllClass(Integer instituteId){
		 ArrayList<Student> students=new ArrayList<Student>();
		 Institution institution= institutionDAO.getInstitutionById(instituteId);
		 Set<Class> classes=institution.getClasses();
		 for (Class clazz : classes) {
			Set<Section> sections= clazz.getSections();
			for (Section section : sections) {
				ArrayList<Student>	students1=(ArrayList<Student>) studentDAO.getStudentsByClassAndSection(clazz, section);
				Iterator<Student> iterator=students1.iterator();
				 while(iterator.hasNext()){
					Student student=iterator.next();
					if(student.getStudentStatus().getStudentStatusId()!=1){
						iterator.remove();
					}
					else{
						if(!checkForStudentInvoiceGenerated(student)){
							students.add(student);
						}
					}
				}
				
			}
		 }
		 return students;
	 }
	 
	 
	 @Transactional
	 public ArrayList<Student> getActiveStudentsFromAllClassBySpecialCategory(Integer instituteId,SpecialCategory specialCategory){
		 ArrayList<Student> students=new ArrayList<Student>();
		 Institution institution= institutionDAO.getInstitutionById(instituteId);
		 Set<SpecialCategory> specialCategories=institution.getSpecialCategories();
		 for (SpecialCategory specialCategory1 : specialCategories) {
			 if(specialCategory1.getSpecialCategoryId()==specialCategory.getSpecialCategoryId()){
				 Set<Student> students1=specialCategory1.getStudents();
				  Iterator<Student> iterator=students1.iterator();
					 while(iterator.hasNext()){
						Student student=iterator.next();
						if(student.getStudentStatus().getStudentStatusId()!=1){
							iterator.remove();
						}
						else{
							if(!checkForStudentInvoiceGenerated(student)){
								Hibernate.initialize(student.getStudentClass());
								 Hibernate.initialize(student.getSection());
								 students.add(student);
							}
						}
					}
			 }
		 }
		 return students;
	 }
	 
	 
		@Transactional
		public boolean checkForStudentInvoiceGenerated(Student student){
			boolean invoiceGenerated=false;
			if(student!=null){
				Set<StudentInvoice> studentInvoices= student.getInvoices();
				Institution institution= student.getInstitution();
				Set<AcademicYear> institutionAcademicYears=institution.getAcademicYears();
				Iterator<AcademicYear> iterator=institutionAcademicYears.iterator();
				AcademicYear academicYear=null;
				while(iterator.hasNext()){
					academicYear=iterator.next();
					if(academicYear.getAcademicYearStatus()==1){
						break;
					}
					academicYear=null;
				}
				
				for (StudentInvoice studentInvoice : studentInvoices) {
					if(studentInvoice.getAcademicYear().getAcademicYearId()==academicYear.getAcademicYearId()){
						invoiceGenerated=true;
						break;
					}
				}
				return invoiceGenerated;
			}
			else{
				return invoiceGenerated;
			}
		}
}
