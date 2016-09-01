package in.jdsoft.educationmanagement.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FacilityTransport;

@Repository
public class FacilityTransportDAO extends GenericDAO<FacilityTransport>
{


	public FacilityTransportDAO() {
		super(FacilityTransport.class);
		
	}

	public FacilityTransport getFacilityTransportById(java.lang.Integer id) {
		try {
			FacilityTransport instance = (FacilityTransport) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityTransport", id);
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