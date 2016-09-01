package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentInvoiceDetails;

@Repository
public class StudentFeesHistoryDAO extends GenericDAO<StudentInvoiceDetails>{

		public StudentFeesHistoryDAO() {
			super(StudentInvoiceDetails.class);
		}
	public StudentInvoiceDetails getStudentFeesHistoryById(java.lang.Integer id) {
		try {
			StudentInvoiceDetails instance = (StudentInvoiceDetails) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentFeesHistory", id);
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
