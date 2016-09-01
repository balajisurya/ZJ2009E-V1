package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;

@Repository
public class StudentReceiptFineDAO extends GenericDAO<StudentReceiptFine>{

	public StudentReceiptFineDAO() {
		super(StudentReceiptFine.class);
	}
	
	public StudentReceiptFine getStudentReceiptFineById(java.lang.Integer id) {
		try {
			StudentReceiptFine instance = (StudentReceiptFine) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentReceiptFine", id);
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
