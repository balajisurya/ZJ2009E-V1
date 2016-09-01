package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.PortalNotification;

@Repository
public class PortalNotificationDAO extends GenericDAO<PortalNotification>{

	public PortalNotificationDAO() {
		super(PortalNotification.class);
	}
	
public PortalNotification getPortalNotificationById(java.lang.Integer id) {
		
		try {
			PortalNotification instance = (PortalNotification) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.PortalNotification", id);
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
