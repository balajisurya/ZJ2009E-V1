package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;

@Repository
public class StudentReceiptDetailDAO extends GenericDAO<StudentReceiptDetail>{

	public StudentReceiptDetailDAO() {
		super(StudentReceiptDetail.class);
	}
	
	public StudentReceiptDetail getStudentReceiptDetailById(java.lang.Integer id) {
		try {
			StudentReceiptDetail instance = (StudentReceiptDetail) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.StudentReceiptDetail", id);
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
	
	
}
