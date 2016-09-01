package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Groups;

@Repository
public class GroupsDAO extends GenericDAO<Groups>{

	public GroupsDAO() {
		super(Groups.class);
	}
	public Groups getGroupById(java.lang.Integer id) {
		try {
			Groups instance = (Groups) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Groups", id);
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
