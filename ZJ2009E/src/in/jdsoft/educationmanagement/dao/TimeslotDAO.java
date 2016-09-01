package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Timeslot;

@Repository
public class TimeslotDAO extends GenericDAO<Timeslot>{

	public TimeslotDAO() {
		super(Timeslot.class);
	}
	
	public Timeslot getTimeslotById(java.lang.Integer id) {
		try {
			Timeslot instance = (Timeslot) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Timeslot", id);
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
