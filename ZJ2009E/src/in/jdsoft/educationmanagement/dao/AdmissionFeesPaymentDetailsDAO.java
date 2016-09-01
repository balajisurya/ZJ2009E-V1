package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionFeesPaymentDetails;


@Repository
public class AdmissionFeesPaymentDetailsDAO extends GenericDAO<AdmissionFeesPaymentDetails>{
	
	public AdmissionFeesPaymentDetailsDAO() {
		super(AdmissionFeesPaymentDetails.class);
	}

	public AdmissionFeesPaymentDetails getAdmissionFeesPaymentDetailsById(java.lang.Integer id) {
		try {
			AdmissionFeesPaymentDetails instance = (AdmissionFeesPaymentDetails) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionFeesPaymentDetails", id);
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
