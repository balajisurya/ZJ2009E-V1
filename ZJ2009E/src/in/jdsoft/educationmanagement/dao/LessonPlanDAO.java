package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.LessonPlan;

@Repository
public class LessonPlanDAO extends GenericDAO<LessonPlan>{
	
	public LessonPlanDAO() {
		super(LessonPlan.class);
	}
	
	public LessonPlan getLessonPlanById(java.lang.Integer id) {
		try {
			LessonPlan instance = (LessonPlan) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.LessonPlan", id);
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
