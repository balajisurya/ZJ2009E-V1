package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionStatus;

@Repository
public class AdmissionStatusDAO extends GenericDAO<AdmissionStatus> {
	
	public AdmissionStatusDAO() {
		super(AdmissionStatus.class);
	}

	public AdmissionStatus getAdmissionStatusById(java.lang.Integer id) {
		try {
			AdmissionStatus instance = (AdmissionStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionStatus", id);
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
