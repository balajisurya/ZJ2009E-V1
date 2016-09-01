package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CommunicationTargetGroup;

@Repository
public class CommunicationTargetGroupDAO extends GenericDAO<CommunicationTargetGroup>{

	public CommunicationTargetGroupDAO() {
		super(CommunicationTargetGroup.class);
	}
	
	public CommunicationTargetGroup getCommunicationTargetGroupById(java.lang.Integer id) {
		try {
			CommunicationTargetGroup instance = (CommunicationTargetGroup) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.CommunicationTargetGroup", id);
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
