package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AcademicCourseSemesterModule;

@Repository
public class AcademicCourseSemesterModuleDAO extends GenericDAO<AcademicCourseSemesterModule>{

	public AcademicCourseSemesterModuleDAO() {
		super(AcademicCourseSemesterModule.class);
	}

	public AcademicCourseSemesterModule getAcademicCourseSemesterModuleById(java.lang.Integer id) {
		try {
			AcademicCourseSemesterModule instance = (AcademicCourseSemesterModule) sessionFactory
					.getCurrentSession().get("in.jdsoft.educationmanagement.model.AcademicCourseSemesterModule", id);
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
