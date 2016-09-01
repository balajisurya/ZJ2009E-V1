package in.jdsoft.educationmanagement.dao;
// Generated Apr 12, 2016 1:14:43 PM by Hibernate Tools 4.3.1.Final

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubset;

@Repository
public class AcademicSemesterSystemSubsetDAO extends GenericDAO<AcademicSemesterSystemSubset> {

	public AcademicSemesterSystemSubsetDAO() {
		super(AcademicSemesterSystemSubset.class);
	}

	public AcademicSemesterSystemSubset getAcademicSemesterSystemSubsetById(java.lang.Integer id) {
		try {
			AcademicSemesterSystemSubset instance = (AcademicSemesterSystemSubset) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubset", id);
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
