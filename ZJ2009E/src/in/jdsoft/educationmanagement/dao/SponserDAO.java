package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Sponser;

@Repository
public class SponserDAO extends GenericDAO<Sponser> {

	public SponserDAO() {
		super(Sponser.class);
	}
	
	public Sponser getSponserById(java.lang.Integer id) {
		try {
			Sponser instance = (Sponser) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Sponser", id);
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
