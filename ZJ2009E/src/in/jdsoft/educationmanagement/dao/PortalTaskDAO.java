package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.PortalTask;

@Repository
public class PortalTaskDAO extends GenericDAO<PortalTask> {

	public PortalTaskDAO() {
		super(PortalTask.class);
	}
	
public PortalTask getPortalTaskById(java.lang.Integer id) {
		
		try {
			PortalTask instance = (PortalTask) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.PortalTask", id);
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
