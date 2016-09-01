package in.jdsoft.educationmanagement.school.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.FeesTemplate;


@Repository
public class FeesTemplateDAO  extends GenericDAO<FeesTemplate>{

	public FeesTemplateDAO() {
		super(FeesTemplate.class);
	}


	public FeesTemplate getFeesTemplateById(java.lang.Integer id) {
		try {
			FeesTemplate instance = (FeesTemplate) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.FeesTemplate", id);
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
