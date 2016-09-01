package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1



import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffAttendance;

@Repository
public class StaffAttendanceDAO extends GenericDAO<StaffAttendance>{

	public StaffAttendanceDAO() {
		super(StaffAttendance.class);
	}
	
	public StaffAttendance getStaffAttendanceByAttendanceId(java.lang.Integer id) {
		try {
			StaffAttendance instance = (StaffAttendance) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffAttendance", id);
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
