package in.jdsoft.educationmanagement.school.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceFineDetail;

@Repository
public class StudentInvoiceFineDetailDAO extends GenericDAO<StudentInvoiceFineDetail> {

	public StudentInvoiceFineDetailDAO() {
		super(StudentInvoiceFineDetail.class);
	}
	
	public StudentInvoiceFineDetail getStudentInvoiceFineDetailById(java.lang.Integer id) {
		try {
			StudentInvoiceFineDetail instance = (StudentInvoiceFineDetail) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentInvoiceFineDetail", id);
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
	public ArrayList<StudentInvoiceFineDetail> getPendingStudentInvoiceFineItems(StudentInvoice studentInvoice) {
		try {
			Criteria invoiceFineCriteria=sessionFactory.getCurrentSession().createCriteria(StudentInvoiceFineDetail.class);
			invoiceFineCriteria.add(Restrictions.conjunction()
					.add(Restrictions.eq("studentInvoice", studentInvoice))
					.add(Restrictions.eq("fineStatus",1)));
			 ArrayList<StudentInvoiceFineDetail> studentInvoiceFines =(ArrayList<StudentInvoiceFineDetail>) invoiceFineCriteria.list();
			if (studentInvoiceFines == null) {
				//logging
			} else {
				//logging
			}
			return studentInvoiceFines;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
