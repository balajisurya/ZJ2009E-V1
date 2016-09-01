package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.TimeTableTemplate;

@Repository
public class TimeTableTemplateDAO extends GenericDAO<TimeTableTemplate> {

	public TimeTableTemplateDAO() {
		super(TimeTableTemplate.class);
	}
	
	public TimeTableTemplate getTimeTableTemplateById(java.lang.Integer id) {
		try {
			TimeTableTemplate instance = (TimeTableTemplate) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.TimeTableTemplate", id);
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
