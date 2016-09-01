package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.EducationLevelSubject;

@Repository
public class EducationLevelSubjectDAO extends GenericDAO<EducationLevelSubject> {
	
		public EducationLevelSubjectDAO() {
			super(EducationLevelSubject.class);
		}
		
		public EducationLevelSubject getEducationLevelSubjectById(java.lang.Integer id) {
			try {
				EducationLevelSubject instance = (EducationLevelSubject) sessionFactory.getCurrentSession()
						.get("in.jdsoft.educationmanagement.model.EducationLevelSubject", id);
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
