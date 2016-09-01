package in.jdsoft.educationmanagement.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.school.model.PortalNotification;


@Service
public class PortalNotificationServices {

	@Autowired
	PortalNotificationDAO portalNotificationDAO;
	
	@Transactional
	public void addPortalNotification(PortalNotification portalNotification){
			portalNotificationDAO.persist(portalNotification);
	}
	
}
