package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffPerformance;

@Repository
public class StaffPerformanceDAO extends GenericDAO<StaffPerformance>{
	
	public StaffPerformanceDAO() {
		super(StaffPerformance.class);
	}
	
	public StaffPerformance getStaffPerformanceById(java.lang.Integer id) {
		try {
			StaffPerformance instance = (StaffPerformance) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffPerformance", id);
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
