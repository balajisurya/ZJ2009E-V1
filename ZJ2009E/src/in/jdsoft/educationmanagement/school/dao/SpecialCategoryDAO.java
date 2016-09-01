package in.jdsoft.educationmanagement.school.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;


@Repository
public class SpecialCategoryDAO extends GenericDAO<SpecialCategory> {

	public SpecialCategoryDAO() {
		super(SpecialCategory.class);
	}
	
	public SpecialCategory getSpecialCategoryById(java.lang.Integer id) {
		try {
			SpecialCategory instance = (SpecialCategory) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.SpecialCategory", id);
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
	
	public SpecialCategory getSpecialCategoryByName(String specialCategoryName,Institution institution){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SpecialCategory.class);
			criteria.add(Restrictions.conjunction()
					 .add(Restrictions.eq("specialCategoryName",specialCategoryName))
					.add(Restrictions.eq("institution",institution)));
			SpecialCategory specialCategory=(SpecialCategory)criteria.uniqueResult();
			if (specialCategory == null) {
				//logging
			} else {
				//logging
			}
			return specialCategory;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
