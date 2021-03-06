package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentAcademicDetailedResults;

@Repository
public class StudentAcademicDetailedResultsDAO extends GenericDAO<StudentAcademicDetailedResults>{

	public StudentAcademicDetailedResultsDAO() {
		super(StudentAcademicDetailedResults.class);
	}
	
	public StudentAcademicDetailedResults getStudentAcademicDetailedResultsId(java.lang.Integer id) {
		try {
			StudentAcademicDetailedResults instance = (StudentAcademicDetailedResults) sessionFactory
					.getCurrentSession().get("in.jdsoft.educationmanagement.model.StudentAcademicDetailedResults", id);
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
