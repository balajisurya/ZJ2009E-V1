package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AdmissionSelectionCriteria;

@Repository
public class AdmissionSelectionCriteriaDAO extends GenericDAO<AdmissionSelectionCriteria> {

	public AdmissionSelectionCriteriaDAO() {
		super(AdmissionSelectionCriteria.class);
	}
	public AdmissionSelectionCriteria getAdmissionSelectionCriteriaById(java.lang.Integer id) {
		try {
			AdmissionSelectionCriteria instance = (AdmissionSelectionCriteria) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AdmissionSelectionCriteria", id);
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
