package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffLeaveType;

@Repository
public class StaffLeaveTypeDAO extends GenericDAO<StaffLeaveType>{

	public StaffLeaveTypeDAO() {
	super(StaffLeaveType.class);
	}
	
	public StaffLeaveType getStaffLeaveTypeById(java.lang.Integer id) {
		try {
			StaffLeaveType instance = (StaffLeaveType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffLeaveType", id);
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
