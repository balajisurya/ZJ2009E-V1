package in.jdsoft.educationmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.model.PortalTask;

@Service
public class PortalTaskServices {

	@Autowired
	PortalTaskDAO portalTaskDAO;
	
	@Transactional
	public void addPortalTask(PortalTask portalTask){
		try {
			portalTaskDAO.persist(portalTask);
		} catch (Exception e) {
		  throw e;
		}
		
	}
}
