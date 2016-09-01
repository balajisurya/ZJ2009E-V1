package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.UserStatus;

@Repository
public class UserStatusDAO extends GenericDAO<UserStatus>{

	public UserStatusDAO() {
		super(UserStatus.class);
	}
	
	public UserStatus getStatusById(java.lang.Integer id) {
		try {
			UserStatus instance = (UserStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.UserStatus", id);
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
