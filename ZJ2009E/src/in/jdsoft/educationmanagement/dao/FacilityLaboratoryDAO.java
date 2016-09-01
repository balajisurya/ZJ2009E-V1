package in.jdsoft.educationmanagement.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FacilityLaboratory;

@Repository
public class FacilityLaboratoryDAO extends GenericDAO<FacilityLaboratory>
{


	public FacilityLaboratoryDAO() {
		super(FacilityLaboratory.class);
		
	}

	public FacilityLaboratory getFacilityLaboratoryById(java.lang.Integer id) {
		try {
			FacilityLaboratory instance = (FacilityLaboratory) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityLaboratory", id);
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