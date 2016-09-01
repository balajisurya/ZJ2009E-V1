package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FeesTemplateItem;

@Repository
public class FeesTemplateItemDAO extends GenericDAO<FeesTemplateItem> {

	public FeesTemplateItemDAO() {
		super(FeesTemplateItem.class);
	}

	public FeesTemplateItem getFeesTemplateItemById(java.lang.Integer id) {
		try {
			FeesTemplateItem instance = (FeesTemplateItem) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FeesTemplateItem", id);
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
