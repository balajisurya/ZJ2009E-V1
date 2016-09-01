package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.LessonPlanSchedule;
@Repository
public class LessonPlanScheduleDAO extends GenericDAO<LessonPlanSchedule>{
	public LessonPlanScheduleDAO() {
		super(LessonPlanSchedule.class);
	}
	
	public LessonPlanSchedule getLessonPlanScheduleById(java.lang.Integer id) {
		try {
			LessonPlanSchedule instance = (LessonPlanSchedule) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.LessonPlanSchedule", id);
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
