package in.jdsoft.educationmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.model.PortalNotification;

@Service
public class PortalNotificationServices {

	@Autowired
	PortalNotificationDAO portalNotificationDAO;
	
	@Transactional
	public void addPortalNotification(PortalNotification portalNotification){
		try {
			portalNotificationDAO.persist(portalNotification);
		} catch (Exception e) {
		  throw e;
		}
		
	}
	
}
