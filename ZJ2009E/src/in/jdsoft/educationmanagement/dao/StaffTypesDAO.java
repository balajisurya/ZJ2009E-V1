package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffTypes;

@Repository
public class StaffTypesDAO extends GenericDAO<StaffTypes>{

	public StaffTypesDAO() {
		super(StaffTypes.class);
	}
	
	public StaffTypes getStaffTypesById(java.lang.Integer id) {
		try {
			StaffTypes instance = (StaffTypes) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffTypes", id);
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
