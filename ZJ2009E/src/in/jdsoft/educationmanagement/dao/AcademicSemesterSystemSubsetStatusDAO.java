package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubsetStatus;

@Repository
public class AcademicSemesterSystemSubsetStatusDAO extends GenericDAO<AcademicSemesterSystemSubsetStatus>{

	
	public AcademicSemesterSystemSubsetStatusDAO() {
	    super(AcademicSemesterSystemSubsetStatus.class);
	}
	
	public AcademicSemesterSystemSubsetStatus getAcademicSemesterSystemSubsetStatusById(java.lang.Integer id) {
		try {
			AcademicSemesterSystemSubsetStatus instance = (AcademicSemesterSystemSubsetStatus) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubsetStatus", id);
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
