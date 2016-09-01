package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffAttendanceType;

@Repository
public class StaffAttendanceTypeDAO extends GenericDAO<StaffAttendanceType> {

	public StaffAttendanceTypeDAO() {
		super(StaffAttendanceType.class);
	}
	
	public StaffAttendanceType getStaffAttendanceTypeById(java.lang.Integer id) {
		try {
			StaffAttendanceType instance = (StaffAttendanceType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffAttendanceType", id);
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
