package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionDocumentTypes;

@Repository
public class AdmissionDocumentTypeDAO extends GenericDAO<AdmissionDocumentTypes> {

	public AdmissionDocumentTypeDAO() {
		super(AdmissionDocumentTypes.class);
	}
	
	public AdmissionDocumentTypes getAdmissionDocumentTypesById(java.lang.Integer id) {
		try {
			AdmissionDocumentTypes instance = (AdmissionDocumentTypes) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionDocumentTypes", id);
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
