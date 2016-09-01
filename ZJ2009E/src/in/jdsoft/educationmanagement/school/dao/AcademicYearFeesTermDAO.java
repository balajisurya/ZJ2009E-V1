package in.jdsoft.educationmanagement.school.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm;

@Repository
public class AcademicYearFeesTermDAO extends GenericDAO<AcademicYearFeesTerm> {

	public AcademicYearFeesTermDAO() {
		super(AcademicYearFeesTerm.class);
	}
	
	public AcademicYearFeesTerm getAcademicYearFeesTermById(java.lang.Integer id) {
		try {
			AcademicYearFeesTerm instance = (AcademicYearFeesTerm) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm", id);
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
