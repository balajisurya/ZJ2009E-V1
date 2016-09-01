package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.FeesTerm;

@Repository
public class FeesTermDAO extends GenericDAO<FeesTerm> {

	public FeesTermDAO() {
	super(FeesTerm.class);
	}
	
	public FeesTerm getFeesTermById(java.lang.Integer id) {
		try {
			FeesTerm instance = (FeesTerm) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.FeesTerm", id);
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
