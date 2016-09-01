package in.jdsoft.educationmanagement.school.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;

@Repository
public class StudentInvoiceDetailDAO extends GenericDAO<StudentInvoiceDetail> {

	public StudentInvoiceDetailDAO() {
		super(StudentInvoiceDetail.class);
	}
	
	public StudentInvoiceDetail getStudentInvoiceDetailById(java.lang.Integer id) {
		try {
			StudentInvoiceDetail instance = (StudentInvoiceDetail) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail", id);
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
	public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItems(StudentInvoice studentInvoice) {
		try {
			Criteria invoiceDetailCriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
			invoiceDetailCriteria.add(Restrictions.conjunction()
					.add(Restrictions.eq("studentInvoice", studentInvoice))
					.add(Restrictions.eq("studentInvoiceElementPaymentStatus",1)));
			 ArrayList<StudentInvoiceDetail> studentInvoiceDetails =(ArrayList<StudentInvoiceDetail>) invoiceDetailCriteria.list();
			if (studentInvoiceDetails == null) {
				//logging
			} else {
				//logging
			}
			return studentInvoiceDetails;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
