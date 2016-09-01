package in.jdsoft.educationmanagement.school.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.MasterUserType;


@Repository
public class MasterUserTypeDAO extends GenericDAO<MasterUserType>{

	public MasterUserTypeDAO() {
		super(MasterUserType.class);
	}
	
	public MasterUserType getMasterUserTypeById(java.lang.Integer id) {
		try {
			MasterUserType instance = (MasterUserType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.MasterUserType", id);
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
