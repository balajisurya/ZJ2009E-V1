package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentPerformance;

@Repository
public class StudentPerformanceDAO extends GenericDAO<StudentPerformance>{
	
	public StudentPerformanceDAO() {
		super(StudentPerformance.class);
	}
	
	public StudentPerformance getStudentPerformanceById(java.lang.Integer id) {
		try {
			StudentPerformance instance = (StudentPerformance) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentPerformance", id);
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
