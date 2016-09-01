package in.jdsoft.educationmanagement.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.model.PortalTask;



@Service
public class PortalTaskServices {

	@Autowired
	PortalTaskDAO portalTaskDAO;
	
	@Transactional
	public void addPortalTask(PortalTask portalTask){
			portalTaskDAO.persist(portalTask);
	}
}
