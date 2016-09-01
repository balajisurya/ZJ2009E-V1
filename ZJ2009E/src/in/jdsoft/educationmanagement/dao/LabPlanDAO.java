package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.LabPlan;

@Repository
public class LabPlanDAO extends GenericDAO<LabPlan>{
	
	public LabPlanDAO() {
		super(LabPlan.class);
	}
	
	public LabPlan getLabPlanById(java.lang.Integer id) {
		try {
			LabPlan instance = (LabPlan) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.LabPlan", id);
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
