package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentInvoice;

@Repository
public class StudentInvoicesDAO extends GenericDAO<StudentInvoice>{

	public StudentInvoicesDAO() {
		super(StudentInvoice.class);
	}

	public StudentInvoice getStudentInvoicesById(java.lang.Integer id) {
		try {
			StudentInvoice instance = (StudentInvoice) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentInvoice", id);
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
