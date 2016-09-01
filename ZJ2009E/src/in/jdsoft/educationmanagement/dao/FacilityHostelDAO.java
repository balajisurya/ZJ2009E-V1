package in.jdsoft.educationmanagement.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FacilityHostel;

@Repository
public class FacilityHostelDAO extends GenericDAO<FacilityHostel>
{


	public FacilityHostelDAO() {
		super(FacilityHostel.class);
		
	}

	public FacilityHostel getFacilityHostelById(java.lang.Integer id) {
		try {
			FacilityHostel instance = (FacilityHostel) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityHostel", id);
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