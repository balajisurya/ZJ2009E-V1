package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FacilityCategory;
@Repository
public class FacilityCategoryDAO extends GenericDAO<FacilityCategory>
{
	public FacilityCategoryDAO() {
		super(FacilityCategory.class);
		
	}

	public FacilityCategory getFacilityCategoryById(java.lang.Integer id) {
		try {
			FacilityCategory instance = (FacilityCategory) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityCategory", id);
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
