package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentAttendance;

@Repository
public class StudentAttendanceDAO extends GenericDAO<StudentAttendance> {

	public StudentAttendanceDAO() {
		super(StudentAttendance.class);
	}
	
	public StudentAttendance getStudentAttendanceById(java.lang.Integer id) {
		try {
			StudentAttendance instance = (StudentAttendance) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentAttendance", id);
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
