package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.PortalTask;


@Repository
public class PortalTaskDAO extends GenericDAO<PortalTask> {

	public PortalTaskDAO() {
		super(PortalTask.class);
	}
	
public PortalTask getPortalTaskById(java.lang.Integer id) {
		
		try {
			PortalTask instance = (PortalTask) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.PortalTask", id);
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
