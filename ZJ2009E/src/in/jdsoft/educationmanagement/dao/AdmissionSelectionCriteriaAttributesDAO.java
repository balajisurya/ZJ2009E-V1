package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionSelectionCriteriaAttributes;

@Repository
public class AdmissionSelectionCriteriaAttributesDAO extends GenericDAO<AdmissionSelectionCriteriaAttributes>{
	
	public AdmissionSelectionCriteriaAttributesDAO() {
		super(AdmissionSelectionCriteriaAttributes.class);
	}

	public AdmissionSelectionCriteriaAttributes getAdmissionSelectionCriteriaAttributesById(java.lang.Integer id) {
		try {
			AdmissionSelectionCriteriaAttributes instance = (AdmissionSelectionCriteriaAttributes) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionSelectionCriteriaAttributes", id);
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
