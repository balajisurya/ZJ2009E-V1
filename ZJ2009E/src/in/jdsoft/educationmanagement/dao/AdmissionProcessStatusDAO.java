package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionProcessStatus;

@Repository
public class AdmissionProcessStatusDAO extends GenericDAO<AdmissionProcessStatus>{
	
	public AdmissionProcessStatusDAO() {
		super(AdmissionProcessStatus.class);	
	}

	public AdmissionProcessStatus getAdmissionProcessStatusById(java.lang.Integer id) {
		try {
			AdmissionProcessStatus instance = (AdmissionProcessStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionProcessStatus", id);
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
