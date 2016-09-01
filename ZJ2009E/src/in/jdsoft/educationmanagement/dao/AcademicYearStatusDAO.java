package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AcademicYearStatus;

@Repository
public class AcademicYearStatusDAO extends GenericDAO<AcademicYearStatus>{

	public AcademicYearStatusDAO() {
	  super(AcademicYearStatus.class);
	}
	
	public AcademicYearStatus getAcademicYearStatusById(java.lang.Integer id) {
		try {
			AcademicYearStatus instance = (AcademicYearStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicYearStatus", id);
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
