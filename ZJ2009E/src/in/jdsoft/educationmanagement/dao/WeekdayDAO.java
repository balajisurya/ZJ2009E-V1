package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Weekday;

@Repository
public class WeekdayDAO extends GenericDAO<Weekday> {
 
	public WeekdayDAO() {
		super(Weekday.class);
	}
	
	public Weekday getWeekdayById(java.lang.Integer id) {
		try {
			Weekday instance = (Weekday) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Weekday", id);
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
