package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AcademicYear;





@Repository
public class AcademicYearDAO extends GenericDAO<AcademicYear> {

	public AcademicYearDAO() {
		super(AcademicYear.class);
	}
	
	public AcademicYear getAcademicYearById(java.lang.Integer id) {
		try {
			AcademicYear instance = (AcademicYear) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicYear", id);
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
