package in.jdsoft.educationmanagement.dao;

import in.jdsoft.educationmanagement.model.AcademicCalendar;

public class AcademicCalendarDAO extends GenericDAO<AcademicCalendar>{

	public AcademicCalendarDAO() {
		super(AcademicCalendar.class);
	}
	
	public AcademicCalendar getAcademicCalendarById(java.lang.Integer id) {
		try {
			AcademicCalendar instance = (AcademicCalendar) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicCalendar", id);
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
