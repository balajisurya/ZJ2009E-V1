package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.MasterUserType;

@Repository
public class MasterUserTypeDAO extends GenericDAO<MasterUserType>{

	public MasterUserTypeDAO() {
		super(MasterUserType.class);
	}
	
	public MasterUserType getMasterUserTypeById(java.lang.Integer id) {
		try {
			MasterUserType instance = (MasterUserType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.MasterUserType", id);
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
