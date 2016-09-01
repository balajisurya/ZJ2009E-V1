package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CourseCategory;

@Repository
public class CourseCategoryDAO extends GenericDAO<CourseCategory>{
		
	public CourseCategoryDAO() {
		super(CourseCategory.class);
	}
	public CourseCategory getCourseCategoryById(java.lang.Integer id) {
		try {
			CourseCategory instance = (CourseCategory) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.CourseCategory", id);
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
