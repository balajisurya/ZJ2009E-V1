package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StudentAttendanceType;

@Repository
public class StudentAttendanceTypeDAO extends GenericDAO<StudentAttendanceType>{

	public StudentAttendanceTypeDAO() {
		super(StudentAttendanceType.class);
	}
	
	public StudentAttendanceType getStaffAttendanceByAttendanceId(java.lang.Integer id) {
		try {
			StudentAttendanceType instance = (StudentAttendanceType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StudentAttendanceType", id);
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
