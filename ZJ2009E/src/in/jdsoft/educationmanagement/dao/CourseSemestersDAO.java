package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.CourseSemesters;
import in.jdsoft.educationmanagement.model.Courses;
@Repository
public class CourseSemestersDAO extends GenericDAO<CourseSemesters> {
	
	public CourseSemestersDAO() {
		super(CourseSemesters.class);
	}
	
	public CourseSemesters getCourseSemesterById(java.lang.Integer id) {
		
		try {
			CourseSemesters instance = (CourseSemesters) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.CourseSemesters", id);
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
	
	public CourseSemesters getCourseSemesterByCourseAndSemester(Courses course,byte semester) {
		try {
			Criteria courseSemesterCriteria =sessionFactory.getCurrentSession().createCriteria(CourseSemesters.class);
			courseSemesterCriteria.add(Restrictions.eq("course",course));
			courseSemesterCriteria.add(Restrictions.eq("semester", semester));
			 CourseSemesters courseSemester=(CourseSemesters) courseSemesterCriteria.uniqueResult();
			if (courseSemester == null) {
				//logging
			} else {
				//logging
			}
			return courseSemester;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	}
