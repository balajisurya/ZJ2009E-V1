package in.jdsoft.educationmanagement.dao;

import in.jdsoft.educationmanagement.model.AcademicCalendarType;

public class AcademicCalendarTypeDAO extends GenericDAO<AcademicCalendarType>{

	public AcademicCalendarTypeDAO() {
		super(AcademicCalendarType.class);
	}
	
	public AcademicCalendarType getAcademicCalendarTypeById(java.lang.Integer id) {
		try {
			AcademicCalendarType instance = (AcademicCalendarType) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicCalendarType", id);
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
