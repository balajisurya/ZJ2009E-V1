package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Category;

@Repository
public class CategoryDAO extends GenericDAO<Category>{

	public CategoryDAO() {
		super(Category.class);
	}
	
	public Category getCategoryById(java.lang.Integer id) {
		try {
			Category instance = (Category) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Category", id);
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
