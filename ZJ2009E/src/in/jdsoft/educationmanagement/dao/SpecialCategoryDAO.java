package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.SpecialCategory;

@Repository
public class SpecialCategoryDAO extends GenericDAO<SpecialCategory> {

	public SpecialCategoryDAO() {
		super(SpecialCategory.class);
	}
	
	public SpecialCategory getSpecialCategoryById(java.lang.Integer id) {
		try {
			SpecialCategory instance = (SpecialCategory) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.SpecialCategory", id);
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
