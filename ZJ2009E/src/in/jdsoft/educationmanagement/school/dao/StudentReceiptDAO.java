package in.jdsoft.educationmanagement.school.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;

@Repository
public class StudentReceiptDAO extends GenericDAO<StudentReceipt> {

	public StudentReceiptDAO() {
		super(StudentReceipt.class);
	}
	
	public StudentReceipt getStudentReceiptById(java.lang.Integer id) {
		try {
			StudentReceipt instance = (StudentReceipt) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentReceipt", id);
			if (instance == null) {
					//for logging purpose if null
			} else {
				//for logging purpose if not null
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentReceipt> getStudentReceiptByPaymentModeAndStatus(PaymentMode paymentMode,PaymentStatus paymentStatus){
		try {
			Criteria studentReceiptCriteria=sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
			studentReceiptCriteria.add(Restrictions.conjunction().add(Restrictions.eq("paymentMode", paymentMode))
					  .add(Restrictions.eq("paymentStatus", paymentStatus)));
		    List<StudentReceipt> studentReceipts=studentReceiptCriteria.list();
				if (studentReceipts == null) {
					//logging
				} else {
					//logging
				}
				return studentReceipts;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentReceipt> getStudentReceiptInInstitutionAndByStatus(Institution institution,PaymentStatus paymentStatus){
		try {
			Criteria receiptcriteria=sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.eq("institution",institution));
			and.add(Restrictions.eq("paymentStatus",paymentStatus));
			receiptcriteria.add(and);
			ArrayList<StudentReceipt> studentReceipts =(ArrayList<StudentReceipt>) receiptcriteria.list();
			if (studentReceipts == null) {
			
			} else {
			
			}
			return studentReceipts;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<StudentReceipt> getAllStudentReceipts(AcademicYear academicYear,Student student) {
		try {
			Criteria invoicecriteria=sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.eq("academicYear",academicYear));
			and.add(Restrictions.eq("student",student));
			invoicecriteria.add(and);
			ArrayList<StudentReceipt> studentReceipts =(ArrayList<StudentReceipt>) invoicecriteria.list();
			if (studentReceipts == null) {
			
			} else {
			
			}
			return studentReceipts;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<StudentReceipt> getStudentReceiptInByDate(Date startDate,Date endDate,Institution institution){
		try {
			Criteria receiptcriteria=sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.ge("paymentReceivedDate",startDate));
			and.add(Restrictions.le("paymentReceivedDate",endDate));
			and.add(Restrictions.eq("institution",institution));
			receiptcriteria.add(and);
			ArrayList<StudentReceipt> studentReceipts =(ArrayList<StudentReceipt>) receiptcriteria.list();
			if (studentReceipts == null) {
			
			} else {
			
			}
			return studentReceipts;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
