package in.jdsoft.educationmanagement.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FacilityEquipment;


@Repository
public class FacilityEquipmentDAO extends GenericDAO<FacilityEquipment>
{


	public FacilityEquipmentDAO() {
		super(FacilityEquipment.class);
		
	}

	public FacilityEquipment getFacilityEquipmentById(java.lang.Integer id) {
		try {
			FacilityEquipment instance = (FacilityEquipment) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityEquipment", id);
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
