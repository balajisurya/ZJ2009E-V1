package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;
import in.jdsoft.educationmanagement.model.FacilityType;

@Repository
public class FacilityTypeDAO extends GenericDAO<FacilityType> {

	public FacilityTypeDAO() {
		super(FacilityType.class);
		
	}

	public FacilityType getFacilityTypeById(Integer id) {
		try {
			FacilityType instance = (FacilityType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityType", id);
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
