package in.jdsoft.educationmanagement.school.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Category;



@Repository
public class CategoryDAO extends GenericDAO<Category>{

	public CategoryDAO() {
		super(Category.class);
	}
	
	public Category getCategoryById(java.lang.Integer id) {
		try {
			Category instance = (Category) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.Category", id);
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
	
	public Category getCategoryByCategoryName(String categoryName){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Category.class);
			criteria.add(Restrictions.eq("categoryName",categoryName));
			Category category=(Category)criteria.uniqueResult();
			if (category == null) {
				//logging
			} else {
				//logging
			}
			return category;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
