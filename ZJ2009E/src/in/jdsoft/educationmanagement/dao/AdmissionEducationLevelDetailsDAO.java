package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionEducationLevelDetails;

@Repository
public class AdmissionEducationLevelDetailsDAO extends GenericDAO<AdmissionEducationLevelDetails>{

	public AdmissionEducationLevelDetailsDAO() {
		super(AdmissionEducationLevelDetails.class);
	}
	
	public AdmissionEducationLevelDetails getAdmissionAcademicsDetailsById(java.lang.Integer id) {
		try {
			AdmissionEducationLevelDetails instance = (AdmissionEducationLevelDetails) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionEducationLevelDetails", id);
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
