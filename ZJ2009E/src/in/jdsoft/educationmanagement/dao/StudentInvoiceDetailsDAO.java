package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentInvoiceDetails;

@Repository
public class StudentInvoiceDetailsDAO extends GenericDAO<StudentInvoiceDetails>{

	public StudentInvoiceDetailsDAO() {
		super(StudentInvoiceDetails.class);
	}

	public StudentInvoiceDetails getStudentInvoiceDetailsById(java.lang.Integer id) {
		try {
			StudentInvoiceDetails instance = (StudentInvoiceDetails) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentInvoiceDetails", id);
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
}
