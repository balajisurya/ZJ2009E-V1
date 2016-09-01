package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CommunicationTargetGroupMember;
@Repository
public class CommunicationTargetGroupMemberDAO extends GenericDAO<CommunicationTargetGroupMember> {
	
	
public CommunicationTargetGroupMemberDAO(){
	
	super(CommunicationTargetGroupMember.class);
	
}
public CommunicationTargetGroupMember getCommunicationTargetGroupMemberById(java.lang.Integer id) {
	try {
		CommunicationTargetGroupMember instance = (CommunicationTargetGroupMember) sessionFactory.getCurrentSession()
				.get("in.jdsoft.educationmanagement.model.CommunicationTargetGroupMember", id);
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
