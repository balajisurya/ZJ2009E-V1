package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PaymentModeDAO;
import in.jdsoft.educationmanagement.school.dao.PaymentStatusDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceFineDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentReceiptDAO;
import in.jdsoft.educationmanagement.school.exceptions.ReceiptException;
import in.jdsoft.educationmanagement.school.exceptions.StudentReceiptException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceFineDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;

@Service
public class ReceiptServices {

	@Autowired
	StudentReceiptDAO studentReceiptDAO;
	@Autowired
	PaymentModeDAO paymentModeDAO;
	@Autowired
	PaymentStatusDAO paymentStatusDAO;
	@Autowired
	StudentInvoiceDetailDAO studentInvoiceDetailDAO;
	@Autowired
	StudentInvoiceDAO studentInvoiceDAO;
	@Autowired
	StudentInvoiceFineDetailDAO studentInvoiceFineDetailDAO;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	InstitutionDAO institutionDAO;
	
	
	@Transactional
	public Integer receiptByCash(Integer paidStudentInvoiceDetails[],Integer paidInvoiceFines[],Double totalAmountPaid,PaymentMode paymentMode,Date receivedDate,String createdBy,String modifiedBy) throws ReceiptException{
		Student student=null;
		Institution institution=null;
		AcademicYear academicYear=null;
		StudentInvoice studentInvoice=null;
		PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(1);
		ArrayList<StudentInvoiceDetail> studentInvoiceDetails=new ArrayList<StudentInvoiceDetail>();
		ArrayList<StudentInvoiceFineDetail> studentInvoiceFineDetails=new ArrayList<StudentInvoiceFineDetail>();
		
		if(paidStudentInvoiceDetails!=null){
			for (int i = 0; i < paidStudentInvoiceDetails.length; i++) {
				studentInvoiceDetails.add(studentInvoiceDetailDAO.getStudentInvoiceDetailById(paidStudentInvoiceDetails[i]));
			}
			
		}
		
		if(paidInvoiceFines!=null){
			for (int i = 0; i < paidInvoiceFines.length; i++) {
				studentInvoiceFineDetails.add(studentInvoiceFineDetailDAO.getStudentInvoiceFineDetailById(paidInvoiceFines[i]));
			}
		}
		
		if(paidStudentInvoiceDetails!=null){
			int count=1;
			Iterator<StudentInvoiceDetail> studentInvoices=studentInvoiceDetails.iterator();
			while(studentInvoices.hasNext()){
				if(count==1){
					StudentInvoiceDetail studentInvoiceDetail=studentInvoices.next();
					studentInvoice= studentInvoiceDetail.getStudentInvoice();
					Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				    student=studentInvoice.getStudent();
				    academicYear=studentInvoice.getAcademicYear();
				    institution=studentInvoice.getInstitution();
				   break;
				}
			}
		}else if(studentInvoiceFineDetails!=null){
			int count=1;
			Iterator<StudentInvoiceFineDetail> studentInvoiceFineDetailIterator= studentInvoiceFineDetails.iterator();
			while(studentInvoiceFineDetailIterator.hasNext()){
				if(count==1){
					StudentInvoiceFineDetail studentInvoiceFineDetail=studentInvoiceFineDetailIterator.next();
					studentInvoice= studentInvoiceFineDetail.getStudentInvoice();
					Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				    student=studentInvoice.getStudent();
				    academicYear=studentInvoice.getAcademicYear();
				    institution=studentInvoice.getInstitution();
				   break;
				}
			}
		}
		
		
		
		
		StudentReceipt studentReceipt=new StudentReceipt(institution, academicYear, paymentMode, receivedDate, totalAmountPaid, student, paymentStatus, createdBy, modifiedBy);
		
		for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
			studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(2);
			studentInvoiceDetailDAO.update(studentInvoiceDetail);
			StudentReceiptDetail studentReceiptDetail=new StudentReceiptDetail(studentReceipt, studentInvoiceDetail, createdBy, modifiedBy);
			studentReceipt.getReceiptDetails().add(studentReceiptDetail);
		}
		
		for (StudentInvoiceFineDetail studentInvoiceFineDetail : studentInvoiceFineDetails) {
			studentInvoiceFineDetail.setFineStatus(2);
			studentInvoiceFineDetailDAO.update(studentInvoiceFineDetail);
			StudentReceiptFine studentReceiptFine=new StudentReceiptFine(studentReceipt, studentInvoiceFineDetail, createdBy, modifiedBy);
			studentReceipt.getReceiptFines().add(studentReceiptFine);
		}
		
		 StudentReceipt persistedStudentReceipt=studentReceiptDAO.save(studentReceipt);
		 
		if (checKForInvoiceClosing(studentInvoice)) {
			studentInvoice.setInvoiceStatus(0);
			studentInvoiceDAO.update(studentInvoice);
		}
		return persistedStudentReceipt.getReceiptId();
	}
	
	@Transactional
	public Integer receiptByCheque(Integer paidStudentInvoiceDetails[],Integer paidInvoiceFines[],Double totalAmountPaid,PaymentMode paymentMode,Date chequeReceivedDate,String chequeNo,Date chequeDate,String chequeBankName,String chequeBranchName,String createdBy,String modifiedBy){
		Student student=null;
		Institution institution=null;
		AcademicYear academicYear=null;
		StudentInvoice studentInvoice=null;
		PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(1);
		ArrayList<StudentInvoiceDetail> studentInvoiceDetails=new ArrayList<StudentInvoiceDetail>();
		ArrayList<StudentInvoiceFineDetail> studentInvoiceFineDetails=new ArrayList<StudentInvoiceFineDetail>();
		
		if(paidStudentInvoiceDetails!=null){
			for (int i = 0; i < paidStudentInvoiceDetails.length; i++) {
				studentInvoiceDetails.add(studentInvoiceDetailDAO.getStudentInvoiceDetailById(paidStudentInvoiceDetails[i]));
			}
			
		}
		
		if(paidInvoiceFines!=null){
			for (int i = 0; i < paidInvoiceFines.length; i++) {
				studentInvoiceFineDetails.add(studentInvoiceFineDetailDAO.getStudentInvoiceFineDetailById(paidInvoiceFines[i]));
			}
		}
		
		if(paidStudentInvoiceDetails!=null){
			int count=1;
			Iterator<StudentInvoiceDetail> studentInvoices=studentInvoiceDetails.iterator();
			while(studentInvoices.hasNext()){
				if(count==1){
					StudentInvoiceDetail studentInvoiceDetail=studentInvoices.next();
					studentInvoice= studentInvoiceDetail.getStudentInvoice();
					Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				    student=studentInvoice.getStudent();
				    academicYear=studentInvoice.getAcademicYear();
				    institution=studentInvoice.getInstitution();
				   break;
				}
			}
		}else if(studentInvoiceFineDetails!=null){
			int count=1;
			Iterator<StudentInvoiceFineDetail> studentInvoiceFineDetailIterator= studentInvoiceFineDetails.iterator();
			while(studentInvoiceFineDetailIterator.hasNext()){
				if(count==1){
					StudentInvoiceFineDetail studentInvoiceFineDetail=studentInvoiceFineDetailIterator.next();
					studentInvoice= studentInvoiceFineDetail.getStudentInvoice();
					Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				    student=studentInvoice.getStudent();
				    academicYear=studentInvoice.getAcademicYear();
				    institution=studentInvoice.getInstitution();
				   break;
				}
			}
		}
		
		
		StudentReceipt studentReceipt=new StudentReceipt(institution, academicYear, paymentMode, chequeReceivedDate,totalAmountPaid, student, paymentStatus, chequeNo, chequeDate, chequeBankName, chequeBranchName, createdBy, modifiedBy);
		
		
		for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
			studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(2);
			studentInvoiceDetailDAO.update(studentInvoiceDetail);
			StudentReceiptDetail studentReceiptDetail=new StudentReceiptDetail(studentReceipt, studentInvoiceDetail, createdBy, modifiedBy);
			studentReceipt.getReceiptDetails().add(studentReceiptDetail);
		}
		
		for (StudentInvoiceFineDetail studentInvoiceFineDetail : studentInvoiceFineDetails) {
			studentInvoiceFineDetail.setFineStatus(2);
			studentInvoiceFineDetailDAO.update(studentInvoiceFineDetail);
			StudentReceiptFine studentReceiptFine=new StudentReceiptFine(studentReceipt, studentInvoiceFineDetail, createdBy, modifiedBy);
			studentReceipt.getReceiptFines().add(studentReceiptFine);
		}

		
		
		StudentReceipt persistedStudentReceipt=studentReceiptDAO.save(studentReceipt);
		if (checKForInvoiceClosing(studentInvoice)) {
			studentInvoice.setInvoiceStatus(0);
			studentInvoiceDAO.update(studentInvoice);
		}
		return persistedStudentReceipt.getReceiptId();
	}
	
	@Transactional
	public Integer receiptByDD(Integer paidStudentInvoiceDetails[],Integer paidInvoiceFines[],Double totalAmountPaid,PaymentMode paymentMode,Date ddReceivedDate,String ddNo,Date ddDate,String ddBankName,String ddBranchName,String createdBy,String modifiedBy){
		Student student=null;
		Institution institution=null;
		AcademicYear academicYear=null;
		StudentInvoice studentInvoice=null;
		PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(1);
		ArrayList<StudentInvoiceDetail> studentInvoiceDetails=new ArrayList<StudentInvoiceDetail>();
		ArrayList<StudentInvoiceFineDetail> studentInvoiceFineDetails=new ArrayList<StudentInvoiceFineDetail>();
		
		if(paidStudentInvoiceDetails!=null){
			for (int i = 0; i < paidStudentInvoiceDetails.length; i++) {
				studentInvoiceDetails.add(studentInvoiceDetailDAO.getStudentInvoiceDetailById(paidStudentInvoiceDetails[i]));
			}
			
		}
		
		if(paidInvoiceFines!=null){
			for (int i = 0; i < paidInvoiceFines.length; i++) {
				studentInvoiceFineDetails.add(studentInvoiceFineDetailDAO.getStudentInvoiceFineDetailById(paidInvoiceFines[i]));
			}
		}
		

		if(paidStudentInvoiceDetails!=null){
			int count=1;
			Iterator<StudentInvoiceDetail> studentInvoices=studentInvoiceDetails.iterator();
			while(studentInvoices.hasNext()){
				if(count==1){
					StudentInvoiceDetail studentInvoiceDetail=studentInvoices.next();
					studentInvoice= studentInvoiceDetail.getStudentInvoice();
					Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				    student=studentInvoice.getStudent();
				    academicYear=studentInvoice.getAcademicYear();
				    institution=studentInvoice.getInstitution();
				   break;
				}
			}
		}else if(studentInvoiceFineDetails!=null){
			int count=1;
			Iterator<StudentInvoiceFineDetail> studentInvoiceFineDetailIterator= studentInvoiceFineDetails.iterator();
			while(studentInvoiceFineDetailIterator.hasNext()){
				if(count==1){
					StudentInvoiceFineDetail studentInvoiceFineDetail=studentInvoiceFineDetailIterator.next();
					studentInvoice= studentInvoiceFineDetail.getStudentInvoice();
					Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				    student=studentInvoice.getStudent();
				    academicYear=studentInvoice.getAcademicYear();
				    institution=studentInvoice.getInstitution();
				   break;
				}
			}
		}
		
		StudentReceipt studentReceipt=new StudentReceipt(institution, academicYear, paymentMode, totalAmountPaid, student, paymentStatus,ddNo, ddDate, ddBankName, ddBranchName, ddReceivedDate, createdBy, modifiedBy);

		for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
			studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(2);
			studentInvoiceDetailDAO.update(studentInvoiceDetail);
			StudentReceiptDetail studentReceiptDetail=new StudentReceiptDetail(studentReceipt, studentInvoiceDetail, createdBy, modifiedBy);
			studentReceipt.getReceiptDetails().add(studentReceiptDetail);
		}
		
		for (StudentInvoiceFineDetail studentInvoiceFineDetail : studentInvoiceFineDetails) {
			studentInvoiceFineDetail.setFineStatus(2);
			studentInvoiceFineDetailDAO.update(studentInvoiceFineDetail);
			StudentReceiptFine studentReceiptFine=new StudentReceiptFine(studentReceipt, studentInvoiceFineDetail, createdBy, modifiedBy);
			studentReceipt.getReceiptFines().add(studentReceiptFine);
		}

		
			StudentReceipt persistedStudentReceipt=studentReceiptDAO.save(studentReceipt);
		if (checKForInvoiceClosing(studentInvoice)) {
			studentInvoice.setInvoiceStatus(0);
			studentInvoiceDAO.update(studentInvoice);
		}
		return persistedStudentReceipt.getReceiptId();
	}
	
	
	@Transactional
	public boolean checKForInvoiceClosing(StudentInvoice studentInvoice){
		boolean closeStatus=false;
		if(studentInvoiceDetailDAO.getStudentPendingInvoiceFeesItems(studentInvoice).isEmpty() && studentInvoiceFineDetailDAO.getPendingStudentInvoiceFineItems(studentInvoice).isEmpty()){
			closeStatus=true;
		}
		return closeStatus;
	}
	
	@Transactional
	public ArrayList<StudentReceipt> getStudentReceiptsByPaymentMode(Integer paymentModeId){
		PaymentMode paymentMode=paymentModeDAO.getPaymentModeById(paymentModeId);
		Set<StudentReceipt> studentReceipts=paymentMode.getStudentReceipts();
		ArrayList<StudentReceipt> studentReceiptList=new ArrayList<StudentReceipt>();
		studentReceiptList.addAll(studentReceipts);
		return studentReceiptList;
	}
	
	@Transactional
	public ArrayList<StudentReceipt> getStudentReceiptsFromPaymentModeAndStatus(Integer paymentModeId,Integer paymentStatusId){
		PaymentMode paymentMode = paymentModeDAO.getPaymentModeById(paymentModeId);
		PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(paymentStatusId);
		ArrayList<StudentReceipt> studentReceipts=(ArrayList<StudentReceipt>) studentReceiptDAO.getStudentReceiptByPaymentModeAndStatus(paymentMode, paymentStatus);
		for (StudentReceipt studentReceipt : studentReceipts) {
			Hibernate.initialize(studentReceipt.getStudent());
		}
		return studentReceipts; 
	}
	
	@Transactional
	public void updateReconcillation(Integer receiptId,Integer paymentStatusId,Date clearanceDate,String comment,String receiptClearedBy) throws StudentReceiptException{
	   StudentReceipt studentReceipt=studentReceiptDAO.getStudentReceiptById(receiptId);
	   PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(paymentStatusId);
	   if(paymentStatusId==2){
		   studentReceipt.setPaymentStatus(paymentStatus);
		   studentReceipt.setPaymentClearedDate(clearanceDate);
		   studentReceipt.setComments(comment);
		   studentReceipt.setReceiptClearedBy(receiptClearedBy);
		   studentReceiptDAO.update(studentReceipt);
	   }
	   else if(paymentStatusId==1){
		   System.out.println("status 1");
		   throw new StudentReceiptException(new Message("invalid","Invoice Status Already Pending"));
	   }
	}
	
	
	@Transactional
	public void updateChequeReconcillation(Integer receiptId,Integer paymentStatusId,Date chequeClearanceDate,String comment,String receiptClearedBy) throws StudentReceiptException{
	   StudentReceipt studentReceipt=studentReceiptDAO.getStudentReceiptById(receiptId);
	   PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(paymentStatusId);
	   if(paymentStatusId==2){
		   studentReceipt.setPaymentStatus(paymentStatus);
		   studentReceipt.setPaymentClearedDate(chequeClearanceDate);
		   studentReceipt.setComments(comment);
		   studentReceipt.setReceiptClearedBy(receiptClearedBy);
		   studentReceiptDAO.update(studentReceipt);
	   }
	   else if(paymentStatusId==3){
		   boolean openInvoice=false;
		   StudentInvoice studentInvoice=null;
		  Set<StudentReceiptDetail> receiptDetails=studentReceipt.getReceiptDetails();
		  if(receiptDetails!=null){
			  for (StudentReceiptDetail studentReceiptDetail : receiptDetails) {
				studentReceiptDetail.getStudentInvoiceDetail().setStudentInvoiceElementPaymentStatus(1);
				if(!openInvoice){
					studentInvoice=studentReceiptDetail.getStudentInvoiceDetail().getStudentInvoice();
					openInvoice=true;
				}
			  }
			  
		  }
		  Set<StudentReceiptFine> receiptFine=studentReceipt.getReceiptFines();
		  if(receiptFine!=null){
			  for (StudentReceiptFine studentReceiptFine : receiptFine) {
				studentReceiptFine.getStudentInvoiceFineDetail().setFineStatus(1);
				if(!openInvoice){
					studentInvoice=studentReceiptFine.getStudentInvoiceFineDetail().getStudentInvoice();
					openInvoice=true;
				}
			  }
		  }
		  studentReceipt.setPaymentStatus(paymentStatus);
		  studentReceiptDAO.update(studentReceipt);
		  if(!checKForInvoiceClosing(studentInvoice)){
			  studentInvoice.setInvoiceStatus(1);
			  studentInvoiceDAO.update(studentInvoice);
		  }
	   }
	   else if(paymentStatusId==1){
		   throw new StudentReceiptException(new Message("invalid","Invoice Status Already Pending"));
	   }
	}
	
	
	@Transactional
	public void updateDdReconcillation(Integer receiptId,Integer paymentStatusId,Date chequeClearanceDate,String comment,String receiptClearedBy) throws StudentReceiptException{
	   StudentReceipt studentReceipt=studentReceiptDAO.getStudentReceiptById(receiptId);
	   PaymentStatus paymentStatus=paymentStatusDAO.getPaymentStatusById(paymentStatusId);
	   if(paymentStatusId==2){
		   studentReceipt.setPaymentStatus(paymentStatus);
		   studentReceipt.setPaymentClearedDate(chequeClearanceDate);
		   studentReceipt.setComments(comment);
		   studentReceipt.setReceiptClearedBy(receiptClearedBy);
		   studentReceiptDAO.update(studentReceipt);
	   }
	   else if(paymentStatusId==3){
		   boolean openInvoice=false;
		   StudentInvoice studentInvoice=null;
		  Set<StudentReceiptDetail> receiptDetails=studentReceipt.getReceiptDetails();
		  if(receiptDetails!=null){
			  for (StudentReceiptDetail studentReceiptDetail : receiptDetails) {
				studentReceiptDetail.getStudentInvoiceDetail().setStudentInvoiceElementPaymentStatus(1);
				if(!openInvoice){
					studentInvoice=studentReceiptDetail.getStudentInvoiceDetail().getStudentInvoice();
					openInvoice=true;
				}
			  }
			  
		  }
		  Set<StudentReceiptFine> receiptFine=studentReceipt.getReceiptFines();
		  if(receiptFine!=null){
			  for (StudentReceiptFine studentReceiptFine : receiptFine) {
				studentReceiptFine.getStudentInvoiceFineDetail().setFineStatus(1);
				if(!openInvoice){
					studentInvoice=studentReceiptFine.getStudentInvoiceFineDetail().getStudentInvoice();
					openInvoice=true;
				}
			  }
		  }
		  studentReceipt.setPaymentStatus(paymentStatus);
		  studentReceiptDAO.update(studentReceipt);
		  if(!checKForInvoiceClosing(studentInvoice)){
			  studentInvoice.setInvoiceStatus(1);
			  studentInvoiceDAO.update(studentInvoice);
		  }
		  
	   }
	   else if(paymentStatusId==1){
		   throw new StudentReceiptException(new Message("invalid","Invoice Status Already Pending"));
	   }
	}
	
	
	@Transactional
	public StudentReceipt getStudentReceiptDetails(Integer receiptId){
		StudentReceipt studentReceipt=studentReceiptDAO.getStudentReceiptById(receiptId);
		Hibernate.initialize(studentReceipt.getReceiptDetails());
		Set<StudentReceiptDetail> studentReceiptdetails=studentReceipt.getReceiptDetails();
		for (StudentReceiptDetail studentReceiptDetail : studentReceiptdetails) {
			Hibernate.initialize(studentReceiptDetail.getStudentInvoiceDetail().getFeesTemplateItem());
		}
	
		Hibernate.initialize(studentReceipt.getReceiptFines());
		Set<StudentReceiptFine> studentReceiptFines=studentReceipt.getReceiptFines();
		for (StudentReceiptFine studentReceiptFine : studentReceiptFines) {
			Hibernate.initialize(studentReceiptFine.getStudentInvoiceFineDetail());
		}
		Hibernate.initialize(studentReceipt.getStudent().getSpecialCategory());
		Hibernate.initialize(studentReceipt.getPaymentMode());
		Hibernate.initialize(studentReceipt.getInstitution());
		return studentReceipt;
	}
	@Transactional
	public ArrayList<StudentReceipt> getAllStudentReceipts(AcademicYear academicYear,Class clazz,Section section){
		
		ArrayList<Student> students= (ArrayList<Student>) studentDAO.getStudentsByClassAndSection(clazz, section);
		ArrayList<StudentReceipt> studentReceipts=new ArrayList<StudentReceipt>();
		for (Student student : students) {
			ArrayList<StudentReceipt> studentReceipts1=(ArrayList<StudentReceipt>) studentReceiptDAO.getAllStudentReceipts(academicYear, student);
			for (StudentReceipt studentReceipt : studentReceipts1) {
				Hibernate.initialize(studentReceipt.getPaymentMode());
				Hibernate.initialize(studentReceipt.getPaymentStatus());
			}
			
			studentReceipts.addAll(studentReceipts1);
		}
		return studentReceipts;
		
	}
	@Transactional
	public ArrayList<StudentReceipt> getStudentReceiptsBySpecialCategory(AcademicYear academicYear,Class clazz,Section section,SpecialCategory specialCategory){
		ArrayList<Student> students= (ArrayList<Student>)studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
		ArrayList<StudentReceipt> studentReceipts=new ArrayList<StudentReceipt>();
		for (Student student : students) {
			ArrayList<StudentReceipt> receipts= (ArrayList<StudentReceipt>) studentReceiptDAO.getAllStudentReceipts(academicYear, student);
			for (StudentReceipt studentReceipt : receipts) {
				Hibernate.initialize(studentReceipt.getPaymentMode());
				Hibernate.initialize(studentReceipt.getPaymentStatus());
			}
			studentReceipts.addAll(receipts);
		}
		return studentReceipts;
	}
	
	@Transactional
	public ArrayList<StudentReceipt> getStudentReceiptsByAdmisssionNo(String admissionNo){
		Student student=studentDAO.getStudentByAdmissionNo(admissionNo);
		Set<StudentReceipt> receipts= student.getStudentReceipts();
		for (StudentReceipt studentReceipt : receipts) {
			Hibernate.initialize(studentReceipt.getPaymentMode());
			Hibernate.initialize(studentReceipt.getPaymentStatus());
		}
		ArrayList<StudentReceipt> studentReceipts=new ArrayList<StudentReceipt>();
		studentReceipts.addAll(receipts);
		return studentReceipts;
	}
	
	@Transactional
	public ArrayList<StudentReceipt> getReceiptsByDateRange(Date startDate,Date endDate,Integer institutionId){
		 ArrayList<StudentReceipt> receipts=(ArrayList<StudentReceipt>) studentReceiptDAO.getStudentReceiptInByDate(startDate, endDate, institutionDAO.getInstitutionById(institutionId));
		 for (StudentReceipt studentReceipt : receipts) {
			Hibernate.initialize(studentReceipt.getReceiptFines());
			Set<StudentReceiptFine> receiptFines=studentReceipt.getReceiptFines();
			for (StudentReceiptFine studentReceiptFine : receiptFines) {
				Hibernate.initialize(studentReceiptFine.getStudentInvoiceFineDetail());
			}
			Hibernate.initialize(studentReceipt.getPaymentStatus());
			
		}
		return receipts;
	}
}
