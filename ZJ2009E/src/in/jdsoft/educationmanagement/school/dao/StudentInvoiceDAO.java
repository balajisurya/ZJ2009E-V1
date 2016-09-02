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
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;

@Repository
public class StudentInvoiceDAO extends GenericDAO<StudentInvoice>{
	
	public StudentInvoiceDAO() {
		super(StudentInvoice.class);
	}
	
	public StudentInvoice getStudentInvoiceById(java.lang.Integer id) {
		try {
			StudentInvoice instance = (StudentInvoice) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentInvoice", id);
			if (instance == null) {
				//logging
			} else {
				//logging
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<StudentInvoice> getStudentPendingInvoices(Student student) {
		try {
			Criteria invoicecriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
			invoicecriteria.add(Restrictions.conjunction()
					.add(Restrictions.eq("student", student))
					.add(Restrictions.eq("invoiceStatus",1)));
			 ArrayList<StudentInvoice> studentInvoices =(ArrayList<StudentInvoice>) invoicecriteria.list();
			if (studentInvoices == null) {
				//logging
			} else {
				//logging
			}
			return studentInvoices;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<StudentInvoice> getStudentInvoicesForDueRange(Date startDate,Date endDate,Institution institution) {
		try {
			Criteria invoicecriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.ge("dueDate",startDate));
			and.add(Restrictions.le("dueDate",endDate));
			and.add(Restrictions.eq("invoiceStatus",1));
			and.add(Restrictions.eq("institution",institution));
			invoicecriteria.add(and);
			ArrayList<StudentInvoice> studentInvoices =(ArrayList<StudentInvoice>) invoicecriteria.list();
			if (studentInvoices == null) {
			
			} else {
			
			}
			return studentInvoices;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentInvoice> getAllStudentInvoices(AcademicYear academicYear,Student student){
		try {
			Criteria invoicecriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.eq("academicYear",academicYear));
			and.add(Restrictions.eq("student",student));
			invoicecriteria.add(and);
			ArrayList<StudentInvoice> studentInvoices =(ArrayList<StudentInvoice>) invoicecriteria.list();
			if (studentInvoices == null) {
			
			} else {
			
			}
			return studentInvoices;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<StudentInvoice> getStudentInvoicesInInstitutionAndByStatus(Institution institution,Integer invoiceStatus){
		try {
			Criteria invoicecriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.eq("invoiceStatus",invoiceStatus));
			and.add(Restrictions.eq("institution",institution));
			invoicecriteria.add(and);
			ArrayList<StudentInvoice> studentInvoices =(ArrayList<StudentInvoice>) invoicecriteria.list();
			if (studentInvoices == null) {
			
			} else {
			
			}
			return studentInvoices;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentInvoice> getStudentInvoicesByAcademicYear(Student student,AcademicYear academicYear){
		try {
			Criteria invoicecriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
			Conjunction and=Restrictions.conjunction();
			and.add(Restrictions.eq("student",student));
			and.add(Restrictions.eq("academicYear",academicYear));
			invoicecriteria.add(and);
			ArrayList<StudentInvoice> studentInvoices =(ArrayList<StudentInvoice>) invoicecriteria.list();
			if (studentInvoices == null) {
			
			} else {
			
			}
			return studentInvoices;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
