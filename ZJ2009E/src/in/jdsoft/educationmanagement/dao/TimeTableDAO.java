package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.TimeTable;

@Repository
public class TimeTableDAO extends GenericDAO<TimeTable> {

	public TimeTableDAO() {
		super(TimeTable.class);
	}
	
	public TimeTable getTimeTableById(java.lang.Integer id) {
		try {
			TimeTable instance = (TimeTable) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.TimeTable", id);
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
