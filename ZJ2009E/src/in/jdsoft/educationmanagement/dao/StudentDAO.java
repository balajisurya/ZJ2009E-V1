package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Student;

@Repository
public class StudentDAO extends GenericDAO<Student> {

	public StudentDAO() {
		super(Student.class);
	}
	
	public Student getStudentById(java.lang.Integer id) {
		try {
			Student instance = (Student) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Student", id);
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
