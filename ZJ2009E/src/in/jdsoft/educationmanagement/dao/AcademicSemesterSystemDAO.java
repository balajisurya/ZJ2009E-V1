package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AcademicSemesterSystem;

@Repository
public class AcademicSemesterSystemDAO extends GenericDAO<AcademicSemesterSystem>{

	
	public AcademicSemesterSystemDAO() {
		super(AcademicSemesterSystem.class);
	}
	
	public AcademicSemesterSystem getAcademicSemesterSystemById(java.lang.Integer id) {
		try {
			AcademicSemesterSystem instance = (AcademicSemesterSystem) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicSemesterSystem", id);
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
