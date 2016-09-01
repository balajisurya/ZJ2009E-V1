package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentStatus;

@Repository
public class StudentStatusDAO extends GenericDAO<StudentStatus>{

	public StudentStatusDAO() {
		super(StudentStatus.class);
	}
	
	public StudentStatus getStudentStatusById(java.lang.Integer id) {
		try {
			StudentStatus instance = (StudentStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentStatus", id);
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
