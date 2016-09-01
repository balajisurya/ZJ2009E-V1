package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentAcademic;
@Repository
public class StudentAcademicDAO extends GenericDAO<StudentAcademic>{

	public StudentAcademicDAO() {
		super(StudentAcademic.class);
	}
	
	public StudentAcademic getStudentAcademicById(java.lang.Integer id) {
		try {
			StudentAcademic instance = (StudentAcademic) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentAcademic", id);
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
