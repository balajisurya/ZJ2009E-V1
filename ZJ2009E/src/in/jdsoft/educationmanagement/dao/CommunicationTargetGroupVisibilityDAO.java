package in.jdsoft.educationmanagement.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CommunicationTargetGroupVisibility;
@Repository
public class CommunicationTargetGroupVisibilityDAO extends GenericDAO<CommunicationTargetGroupVisibility>{
	
	
	public CommunicationTargetGroupVisibilityDAO() {
         super(CommunicationTargetGroupVisibility.class);		
	}
	public CommunicationTargetGroupVisibility getCommunicationTargetGroupMemberVisibilityById(java.lang.Integer id) {
		try {
		  CommunicationTargetGroupVisibility instance = (CommunicationTargetGroupVisibility) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.CommunicationTargetGroupMemberVisibility", id);
			if (instance == null) {
					//for logging purpose if null
			} else {
				//for logging purpose if not null
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
