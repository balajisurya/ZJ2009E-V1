package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.dao.AdmissionDAO;
import in.jdsoft.educationmanagement.dao.AdmissionStatusDAO;
import in.jdsoft.educationmanagement.dao.FeesCollectionRecordDAO;
import in.jdsoft.educationmanagement.dao.MasterUserTypeDAO;
import in.jdsoft.educationmanagement.dao.StudentAcademicDAO;
import in.jdsoft.educationmanagement.dao.StudentAcademicDetailedResultsDAO;
import in.jdsoft.educationmanagement.dao.StudentAttendanceTypeDAO;
import in.jdsoft.educationmanagement.dao.StudentDAO;
import in.jdsoft.educationmanagement.dao.StudentFeesHistoryDAO;
import in.jdsoft.educationmanagement.dao.StudentInvoicesDAO;
import in.jdsoft.educationmanagement.dao.StudentPerformanceDAO;
import in.jdsoft.educationmanagement.dao.StudentStatusDAO;
import in.jdsoft.educationmanagement.dao.UsersDAO;
import in.jdsoft.educationmanagement.model.Admission;
import in.jdsoft.educationmanagement.model.AdmissionStatus;
import in.jdsoft.educationmanagement.model.FeesCollectionRecord;
import in.jdsoft.educationmanagement.model.MasterUserType;
import in.jdsoft.educationmanagement.model.Student;
import in.jdsoft.educationmanagement.model.StudentAcademic;
import in.jdsoft.educationmanagement.model.StudentAttendanceType;
import in.jdsoft.educationmanagement.model.StudentInvoice;
import in.jdsoft.educationmanagement.model.StudentPerformance;
import in.jdsoft.educationmanagement.model.StudentStatus;
import in.jdsoft.educationmanagement.model.Users;

@Service
public class StudentServices {
	
	@Autowired
	StudentAcademicDAO studentAcademicDAO;
	@Autowired
	StudentAcademicDetailedResultsDAO studentAcademicDetailedResultsDAO;
	@Autowired
	StudentFeesHistoryDAO studentFeesHistoryDAO;
	@Autowired
	StudentInvoicesDAO studentInvoicesDAO;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	StudentStatusDAO studentStatusDAO;
	@Autowired
	StudentPerformanceDAO studentPerformanceDAO;
	@Autowired
	AdmissionDAO admissionDAO;
	@Autowired
	AdmissionStatusDAO admissionStatusDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	MasterUserTypeDAO masterUserTypeDAO;
	@Autowired
	StudentAttendanceTypeDAO studentAttendanceTypeDAO;
	@Autowired
	HashGenerator hashGenerator;
	@Autowired
	FeesCollectionRecordDAO feesCollectionRecordDAO; 
	
	
	@Transactional
	public void addFeesCollectionRecord(FeesCollectionRecord feesCollectionRecord){
		feesCollectionRecordDAO.persist(feesCollectionRecord);
	}

	@Transactional
	public void deleteFeesCollectionRecord(int feesCollectionRecordId){
		feesCollectionRecordDAO.delete(feesCollectionRecordDAO.getFeesCollectionRecordById(feesCollectionRecordId));
	}

	@Transactional
	public void updateFeesCollectionRecord(FeesCollectionRecord feesCollectionRecord){
		feesCollectionRecordDAO.update(feesCollectionRecord);
	}

	@Transactional
	public ArrayList<FeesCollectionRecord> getFeesCollectionRecordList(){
		
		return (ArrayList<FeesCollectionRecord>)feesCollectionRecordDAO.getList();
	}
	@Transactional
	public FeesCollectionRecord getFeesCollectionRecordLazyById(int feesCollectionRecordId){
		
		try{
			FeesCollectionRecord feesCollectionRecord=feesCollectionRecordDAO.getFeesCollectionRecordById(feesCollectionRecordId);
			Hibernate.initialize(feesCollectionRecord.getInvoice());
			Hibernate.initialize(feesCollectionRecord.getInvoice().getStudentInvoiceDetails());
			Hibernate.initialize(feesCollectionRecord.getStudent());
			Hibernate.initialize(feesCollectionRecord.getInstitution());
			 
		return feesCollectionRecord;
		
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
	 
	}
	
	@Transactional
	public FeesCollectionRecord getFeesCollectionRecordById(int feesCollectionRecordId){
		
		try{
			
			FeesCollectionRecord feesCollectionRecord=feesCollectionRecordDAO.getFeesCollectionRecordById(feesCollectionRecordId);
			return feesCollectionRecord;
		
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
	 
	}
	
	@Transactional
	public void addStudentAppraisal(StudentPerformance studentPerformance){
		studentPerformanceDAO.persist(studentPerformance);
	}

	@Transactional
	public void deleteStudentAppraisal(int StudentAppraisalId){
		studentPerformanceDAO.delete(studentPerformanceDAO.getStudentPerformanceById(StudentAppraisalId));
	}

	@Transactional
	public void updateStudentAppraisal(StudentPerformance StudentPerformance){
		studentPerformanceDAO.update(StudentPerformance);
	}

	@Transactional
	public ArrayList<StudentPerformance> getStudentPerformanceList(){
		return (ArrayList<StudentPerformance>)studentPerformanceDAO.getList();
	}

	@Transactional
	public StudentPerformance getStudentPerformanceById(int StudentAppraisalId){
		return studentPerformanceDAO.getStudentPerformanceById(StudentAppraisalId);
	}

	
	@Transactional
	 public void addAcademics(StudentAcademic academics){
		 studentAcademicDAO.persist(academics);
	 }
	 
	@Transactional
	 public void updateAcademics(StudentAcademic academics){
		 studentAcademicDAO.update(academics);
	 }
	
	 @Transactional
	 public void deleteAcademics(int academicsId)
	 {
		 studentAcademicDAO.delete(studentAcademicDAO.getStudentAcademicById(academicsId));
	 }
	 
	 @Transactional
	 public void addStudent(Student student)
	 {
		 try {
			 studentDAO.persist(student);
			 Admission admission=student.getAdmission();
			 AdmissionStatus admissionStatus=admissionStatusDAO.getAdmissionStatusById(5);
			 admission.setAdmissionStatus(admissionStatus);
			 admissionDAO.update(admission);
			 Users user=student.getUser();
			 MasterUserType masterUserType=masterUserTypeDAO.getMasterUserTypeById(6);
			 MasterUserType userTypes=masterUserTypeDAO.getMasterUserTypeById(9);
			 user.setUserTypes(masterUserType);
			 usersDAO.update(user);
			 String parentPassword="parent";
			 String hash=hashGenerator.encoder(parentPassword);
			 Users users=new Users(userTypes,student.getParentGuardianFirstName(),student.getParentGuardianEmail(),parentPassword,student.getCreatedBy(),1, hash,"a.png",student.getInstitution());
			 usersDAO.persist(users);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		 
	 }
	 
	 @Transactional
	 public void updateStudent(Student student)
	 {
		 studentDAO.update(student);
	 }
	 
	 @Transactional
	 public void deleteStudent(int studentId)
	 {
		 try {
			 studentDAO.delete(studentDAO.getStudentById(studentId));
		} catch (Exception e) {
			throw e;
		}
		
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
	 public Student getStudentLazyById(int studentId)
	 { 	 
		 try {
			 Student student= studentDAO.getStudentById(studentId);
			 
			/* Hibernate.initialize(student.getStudentInvoices());
			 Hibernate.initialize(student.getInstitution());
			 Hibernate.initialize(student.getSpecialCategory());
			  Hibernate.initialize(student.getCourseType());
			 Hibernate.initialize(student.getCourseCategory());
			 Hibernate.initialize(student.getBloodGroup());
			 Hibernate.initialize(student.getStudentStatus());
			 Hibernate.initialize(student.getApprover().getStaff());
			 Hibernate.initialize(student.getAdmission());
			 Hibernate.initialize(student.getAdmission().getAdmissionStatus());
			 Hibernate.initialize(student.getAdmission().getReligion());
			 Hibernate.initialize(student.getAdmission().getSponser());
			 Hibernate.initialize(student.getAdmission().getHearedUs());
			 Hibernate.initialize(student.getAdmission().getUser());
			 Hibernate.initialize(student.getAdmission().getAdmissionConfig());
			 Hibernate.initialize(student.getApprover());
			 Hibernate.initialize(student.getCategory());*/
			 Hibernate.initialize(student.getUser());
			 Hibernate.initialize(student.getDepartment());
			 Hibernate.initialize(student.getCourse());
			return student;
		} catch (Exception e) {
			throw e;
		}
		 
	 }
	 
	 
	 
	 
	 @Transactional
	 public StudentStatus getStudentStatusById(int studentStatusId)
	 { return studentStatusDAO.getStudentStatusById(studentStatusId);
	 }
	 
	 
	 @Transactional
	 public ArrayList<StudentStatus> getStudentStatusList()
	 {
		 return (ArrayList<StudentStatus>) studentStatusDAO.getList();
	 }
	 
	 @Transactional
	 public Set<StudentPerformance> getStudentPerformanceRecords(int studentId){
		 try{
		  Student student= studentDAO.getStudentById(studentId);
		  Hibernate.initialize(student.getStudentPerformance());
		  Set<StudentPerformance>  studentPerformance=student.getStudentPerformance();
		  return studentPerformance;
		 }
		catch(Exception e){
				e.printStackTrace();
				return null;
			}
	 }
	 
	 @Transactional
	 public  Set<Student> getStudentListOfUser(String emailId){
		 try {
			 Users user=usersDAO.getUserByEmail(emailId);
			 Hibernate.initialize(user.getStudents());
			 Set<Student> students=user.getStudents();
			 for(Student student:students){
				 Hibernate.initialize(student.getCourse());

			 }
			 return students;
		} catch (Exception e) {
			throw e;
		}
	}
	 
	 @Transactional
	 public ArrayList<StudentAttendanceType> getStudentAttendanceTypeList(){
		 try {
			return (ArrayList<StudentAttendanceType>) studentAttendanceTypeDAO.getList();
		 } catch (Exception e) {
			throw e;
		}
	 }
	 
	 @Transactional
	public StudentInvoice getStudentInvoiceById(int studentInvoiceId){
			return studentInvoicesDAO.getStudentInvoicesById(studentInvoiceId);
		}
	 
	 @Transactional
	 public StudentInvoice getStudentInvoiceLazyById(int invoiceId) throws Exception{
			try
			{
				StudentInvoice studentInvoice=studentInvoicesDAO.getStudentInvoicesById(invoiceId); 
				
			     Hibernate.initialize(studentInvoice.getStudent());
				 Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());	
				 Hibernate.initialize(studentInvoice.getStudent().getInstitution());
				 
				return studentInvoice;	
			}
			catch(Exception e){
				
				throw e;
			}
		}
	 
	
	 	@Transactional
		public StudentInvoice getStudentInvoiceByStudentId(int studentId) throws Exception
	 	{
	 		try
			{
	 			ArrayList<StudentInvoice> studentInvoices=(ArrayList<StudentInvoice>) studentInvoicesDAO.getList();
	 		
	 			
	 			StudentInvoice currentStudentInvoice=new StudentInvoice();
	 		
	 			for (StudentInvoice studentInvoice : studentInvoices) 
	 			{
	 				if(studentInvoice.getStudent().getStudentId().equals(studentId))
	 				{
	 					currentStudentInvoice=getStudentInvoiceLazyById(studentInvoice.getStudentInvoiceId());
	 					
	 				
	 				}
	 			}
	 			
	 			
	 			return currentStudentInvoice;
			}
			catch(Exception e){
				
				throw e;
			}
				
		}
}
