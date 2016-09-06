package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.AcademicYearFeesTermDAO;
import in.jdsoft.educationmanagement.school.dao.FeesTemplateDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDetailDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentInvoiceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTemplate;
import in.jdsoft.educationmanagement.school.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesStructure;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;

@Service
public class InvoiceServices {

	@Autowired
	StudentInvoiceDAO studentInvoiceDAO;
	@Autowired
    StudentDAO studentDAO;
	@Autowired
	StudentInvoiceDetailDAO studentInvoiceDetailDAO;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	AcademicYearDAO academicYearDAO;

	@Autowired
	AcademicYearFeesTermDAO academicYearFeesTermDAO;
	@Autowired
	FeesTemplateDAO feesTemplateDAO;
	
	@Transactional
	public void generateInvoice(Integer []studentIds,ArrayList<FeesTermAndFeesStructure> feesTermsAndStructure,AcademicYear academicYear,String createdBy,Institution institution){
		for (Integer studentId : studentIds) {
			Student student=studentDAO.getStudentById(studentId);
			for (FeesTermAndFeesStructure feesTermAndFeesStructure : feesTermsAndStructure) {
				FeesTemplate feesTemplate= feesTemplateDAO.getFeesTemplateById(feesTermAndFeesStructure.getFeesStructureId());
				AcademicYearFeesTerm academicYearFeesTerm=academicYearFeesTermDAO.getAcademicYearFeesTermById(feesTermAndFeesStructure.getFeesTermId());
				StudentInvoice studentInvoice=new StudentInvoice(student, academicYear, academicYearFeesTerm,1, createdBy, createdBy, institution);
				double invoiceAmount=0.0;
				Set<FeesTemplateItem> feesTemplateItems=feesTemplate.getFeesTemplateItems();
				for (FeesTemplateItem feesTemplateItem : feesTemplateItems) {
					invoiceAmount=invoiceAmount+feesTemplateItem.getTemplateItemPrice();
					StudentInvoiceDetail studentInvoiceDetail=
							new StudentInvoiceDetail(studentInvoice, feesTemplateItem,feesTemplateItem.getTemplateItemPrice(),0,1,studentInvoice.getCreatedBy(),studentInvoice.getModifiedBy());
					studentInvoice.getStudentInvoiceDetails().add(studentInvoiceDetail);
				}
				studentInvoice.setInvoiceAmount(invoiceAmount);
				StudentInvoice studentInvoiceNo=studentInvoiceDAO.save(studentInvoice);
				String invoiceNo=studentInvoiceNo.getStudentInvoiceId().toString();
				studentInvoiceNo.setInvoiceNo(invoiceNo);
				studentInvoiceDAO.update(studentInvoiceNo);
			}
		}
	}
	
	@Transactional
	public ArrayList<StudentInvoice> getStudentPendingInvoices(String admissionNo){
		Student student =studentDAO.getStudentByAdmissionNo(admissionNo);
		ArrayList<StudentInvoice> students=studentInvoiceDAO.getStudentPendingInvoices(student);
		for (StudentInvoice studentInvoice : students) {
			Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
			Hibernate.initialize(studentInvoice.getAcademicYear());
			Hibernate.initialize(studentInvoice.getAcademicYearFeesTerm());
		}
		return students;
	}
	
	@Transactional
	public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItems(Integer invoiceId){
		StudentInvoice studentInvoice=studentInvoiceDAO.getStudentInvoiceById(invoiceId);
		ArrayList<StudentInvoiceDetail> studentInvoiceDetails= studentInvoiceDetailDAO.getStudentPendingInvoiceFeesItems(studentInvoice);
		for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
			Hibernate.initialize(studentInvoiceDetail.getFeesTemplateItem());
		}
		return studentInvoiceDetails;
	}
	
	
	
	
	@Transactional
	public ArrayList<StudentInvoice> getAllStudentInvoices(AcademicYear academicYear,Class clazz,Section section){
		ArrayList<Student> students= (ArrayList<Student>) studentDAO.getStudentsByClassAndSection(clazz, section);
		ArrayList<StudentInvoice> studentInvoices=new ArrayList<StudentInvoice>();
		for (Student student : students) {
			ArrayList<StudentInvoice> studentInvoices1=(ArrayList<StudentInvoice>) studentInvoiceDAO.getAllStudentInvoices(academicYear, student);
			for (StudentInvoice studentInvoice : studentInvoices1) {
				Hibernate.initialize(studentInvoice.getAcademicYear());
				Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				Hibernate.initialize(studentInvoice.getAcademicYearFeesTerm());
			}
			studentInvoices.addAll(studentInvoices1);
		}
		return studentInvoices;
	}
	
	@Transactional
	public ArrayList<StudentInvoice> getStudentInvoicesBySpecialCategory(AcademicYear academicYear,Class clazz,Section section,SpecialCategory specialCategory){
		ArrayList<Student> students= (ArrayList<Student>)studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
		ArrayList<StudentInvoice> studentInvoices=new ArrayList<StudentInvoice>();
		for (Student student : students) {
			ArrayList<StudentInvoice> studentInvoices1=(ArrayList<StudentInvoice>)studentInvoiceDAO.getAllStudentInvoices(academicYear, student);
			for (StudentInvoice studentInvoice : studentInvoices1) {
				Hibernate.initialize(studentInvoice.getAcademicYear());
				Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
				Hibernate.initialize(studentInvoice.getAcademicYearFeesTerm());
			}
			studentInvoices.addAll(studentInvoices1);
		}
		return studentInvoices;
	}
	
	@Transactional
	public ArrayList<StudentInvoice> getStudentInvoicesByAdmisssionNo(String admissionNo){
		ArrayList<StudentInvoice> studentInvoices=new ArrayList<StudentInvoice>();
		Set<StudentInvoice> studentInvoices1=studentDAO.getStudentByAdmissionNo(admissionNo).getInvoices();
		for (StudentInvoice studentInvoice : studentInvoices1) {
			Hibernate.initialize(studentInvoice.getAcademicYear());
			Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
			Hibernate.initialize(studentInvoice.getStudent());
			Hibernate.initialize(studentInvoice.getAcademicYearFeesTerm());
		}
		studentInvoices.addAll(studentInvoices1);
		return studentInvoices;
	}
	
	@Transactional
	public ArrayList<StudentInvoice> getStudentInvoicesFromIds(Integer []studentInvoiceIds){
		ArrayList<StudentInvoice> studentInvoices=new ArrayList<StudentInvoice>();
		for (int i = 0; i < studentInvoiceIds.length; i++) {
			studentInvoices.add(studentInvoiceDAO.getStudentInvoiceById(studentInvoiceIds[i]));
		}
		for (StudentInvoice studentInvoice : studentInvoices) {
			Hibernate.initialize(studentInvoice.getAcademicYear());
			Hibernate.initialize(studentInvoice.getAcademicYearFeesTerm());
		}
		return studentInvoices;
	}
	

	@Transactional
	public StudentInvoice getStudentInvoiceDetails(Integer invoiceId){
		StudentInvoice studentInvoice=studentInvoiceDAO.getStudentInvoiceById(invoiceId);
		Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
		Set<StudentInvoiceDetail> studentInvoicedetails=studentInvoice.getStudentInvoiceDetails();
		for (StudentInvoiceDetail studentInvoiceDetail : studentInvoicedetails) {
			Hibernate.initialize(studentInvoiceDetail.getFeesTemplateItem());
		}
		Hibernate.initialize(studentInvoice.getStudent().getSpecialCategory());
		Hibernate.initialize(studentInvoice.getInstitution());
		Hibernate.initialize(studentInvoice.getAcademicYear());
		Hibernate.initialize(studentInvoice.getAcademicYearFeesTerm());
		return studentInvoice;
	}
	
	@Transactional
	public void deleteStudentInvoicesByAcademicYear(Integer []studentIds,Integer academicYearId) throws StudentInvoiceException{
		 AcademicYear academicYear=academicYearDAO.getAcademicYearById(academicYearId);
		for (Integer studentId : studentIds) {
			Student student=studentDAO.getStudentById(studentId);
			List<StudentInvoice> studentInvoices=studentInvoiceDAO.getStudentInvoicesByAcademicYear(student, academicYear);
			if(studentInvoices!=null){
				for (StudentInvoice studentInvoice : studentInvoices) {
					if(studentInvoice.getInvoiceStatus()==0){
						throw new StudentInvoiceException(new Message("cannotdelete", "Cannot delete term fees for student ! Please uncheck the student with admission no : "+studentInvoice.getStudent().getAdmissionNo()));
					}
				}
				 for (StudentInvoice studentInvoice : studentInvoices) {
					 studentInvoiceDAO.delete(studentInvoice);
				 }
					
				}
			}
		
		}
	
	@Transactional
    public boolean invoiceValidation(Integer invoiceIds[]){
    	boolean valid=true;
    	
    	StudentInvoice studentInvoice = studentInvoiceDAO.getStudentInvoiceById(invoiceIds[0]);
    	Student student=studentInvoice.getStudent();
    	Set<StudentInvoice> studentInvoiceSet=student.getInvoices();
    	Iterator<StudentInvoice> studentInvoices= studentInvoiceSet.iterator();
    	while(studentInvoices.hasNext()){
    		StudentInvoice studentInvoice1=studentInvoices.next();
    		if(studentInvoice1.getInvoiceStatus()==0){
    			studentInvoices.remove();
    		}
    	}
    	
    	for(Integer invoiceId:invoiceIds){
    		StudentInvoice invoice= studentInvoiceDAO.getStudentInvoiceById(invoiceId);
    		for (StudentInvoice studentInvoice2 : studentInvoiceSet) {
    			if(studentInvoice2.getStudentInvoiceId()<=invoice.getStudentInvoiceId()){
    				valid=false;
    				Integer checkInArray=studentInvoice2.getStudentInvoiceId();
    				for(Integer invoiceId1:invoiceIds){
    					if(invoiceId1==checkInArray){
    						valid=true;
    						break;
    					}
    				}
    				if(valid){
    					continue;
    				}
    				else{
    					return valid;
    				}
    			}
    		}
    	}
    	return valid;
    }

	
	@Transactional
	public ArrayList<Student> getPendingFeesTermStudentList(Integer academicYear,Integer academicYearfeesTermId){
		ArrayList<Student> students=new ArrayList<Student>();
		AcademicYearFeesTerm academicYearFeesTerm= academicYearFeesTermDAO.getAcademicYearFeesTermById(academicYearfeesTermId);
		AcademicYear academicYear1= academicYearDAO.getAcademicYearById(academicYear);
		ArrayList<StudentInvoice> studentInvoices=(ArrayList<StudentInvoice>) studentInvoiceDAO.getPendingTermFeesStudentInvoice(academicYearFeesTerm, academicYear1);
		for (StudentInvoice studentInvoice : studentInvoices) {
			Student student=studentInvoice.getStudent();
			Hibernate.initialize(student.getStudentClass());
			Hibernate.initialize(student.getSection());
			Hibernate.initialize(student.getSpecialCategory());
			students.add(student);
		}
		return students;
	}
}

