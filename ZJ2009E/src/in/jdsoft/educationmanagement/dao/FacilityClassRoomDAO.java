package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.FacilityClassRoom;

@Repository
public class FacilityClassRoomDAO extends GenericDAO<FacilityClassRoom>
{


	public FacilityClassRoomDAO() {
		super(FacilityClassRoom.class);
		
	}

	public FacilityClassRoom getFacilityClassRoomById(java.lang.Integer id) {
		try {
			FacilityClassRoom instance = (FacilityClassRoom) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.FacilityClassRoom", id);
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
