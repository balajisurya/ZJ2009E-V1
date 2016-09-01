package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.LabPlanSchedule;
@Repository
public class LabPlanScheduleDAO extends GenericDAO<LabPlanSchedule>{
	
	public LabPlanScheduleDAO() {
		super(LabPlanSchedule.class);
	}
	
	public LabPlanSchedule getLabPlanScheduleById(java.lang.Integer id) {
		try {
			LabPlanSchedule instance = (LabPlanSchedule) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.LabPlanSchedule", id);
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
