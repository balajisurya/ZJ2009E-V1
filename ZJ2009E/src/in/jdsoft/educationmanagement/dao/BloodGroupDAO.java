package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.BloodGroup;

@Repository
public class BloodGroupDAO extends GenericDAO<BloodGroup>{

	public BloodGroupDAO() {
		super(BloodGroup.class);
	}
	
	public BloodGroup getBloodGroupById(java.lang.Integer id) {
		try {
			BloodGroup instance = (BloodGroup) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.BloodGroup", id);
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
