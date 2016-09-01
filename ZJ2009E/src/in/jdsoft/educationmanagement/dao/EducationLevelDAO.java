package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.EducationLevel;

@Repository
public class EducationLevelDAO extends GenericDAO<EducationLevel> {

	public EducationLevelDAO() {
		super(EducationLevel.class);
	}
	
	public EducationLevel getEducationLevelById(java.lang.Integer id) {
		try {
			EducationLevel instance = (EducationLevel) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.EducationLevel", id);
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
