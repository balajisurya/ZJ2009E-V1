package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.HearedUs;

@Repository
public class HearedUsDAO extends GenericDAO<HearedUs>{

	public HearedUsDAO() {
		super(HearedUs.class);
	}
	
	public HearedUs getHearedUsById(java.lang.Integer id) {
		try {
			HearedUs instance = (HearedUs) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.HearedUs", id);
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
