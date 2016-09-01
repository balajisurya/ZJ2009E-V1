package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffLeaveRequisition;

@Repository
public class StaffLeaveRequisitionDAO extends GenericDAO<StaffLeaveRequisition>{

	public StaffLeaveRequisitionDAO() {
	    super(StaffLeaveRequisition.class);
	}
	
	public StaffLeaveRequisition getStaffLeaveRequisitionById(java.lang.Integer id) {
		try {
			StaffLeaveRequisition instance = (StaffLeaveRequisition) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffLeaveRequisition", id);
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
