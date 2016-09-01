package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionDocument;

@Repository
public class AdmissionDocumentDAO extends GenericDAO<AdmissionDocument> {
		
	
	public AdmissionDocumentDAO() {
		super(AdmissionDocument.class);
	}
	
	public AdmissionDocument getAdmissionDocumentById(java.lang.Integer id) {
		try {
			AdmissionDocument instance = (AdmissionDocument) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionDocument", id);
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
