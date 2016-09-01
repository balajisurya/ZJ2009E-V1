package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Courses;

@Repository
public class CoursesDAO extends GenericDAO<Courses>{
	
	public CoursesDAO() {
		super(Courses.class);
	}
	
	public Courses getCourseById(java.lang.Integer id) {
		try {
			Courses instance = (Courses) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Courses", id);
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
