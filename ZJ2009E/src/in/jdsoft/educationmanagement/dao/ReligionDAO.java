package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Religion;

@Repository
public class ReligionDAO extends GenericDAO<Religion>{

	public ReligionDAO() {
		super(Religion.class);
	}
	
	public Religion getReligionById(java.lang.Integer id) {
		try {
			Religion instance = (Religion) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Religion", id);
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
