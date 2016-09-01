package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CourseType;

@Repository
public class CourseTypeDAO extends GenericDAO<CourseType>{

	public CourseTypeDAO() {
	  super(CourseType.class);
	}
	
	public CourseType getCourseTypeById(java.lang.Integer id) {
		try {
			CourseType instance = (CourseType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.CourseType", id);
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
