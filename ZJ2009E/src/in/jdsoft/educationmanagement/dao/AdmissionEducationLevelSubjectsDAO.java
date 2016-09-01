package in.jdsoft.educationmanagement.dao;

import in.jdsoft.educationmanagement.model.AdmissionEducationLevelSubjects;

public class AdmissionEducationLevelSubjectsDAO extends GenericDAO<AdmissionEducationLevelSubjects> {

	public AdmissionEducationLevelSubjectsDAO() {
		super(AdmissionEducationLevelSubjects.class);
	}
	
	
	public AdmissionEducationLevelSubjects getAdmissionEducationLevelSubjectById(java.lang.Integer id) {
		try {
			AdmissionEducationLevelSubjects instance = (AdmissionEducationLevelSubjects) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionEducationLevelSubjects", id);
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
