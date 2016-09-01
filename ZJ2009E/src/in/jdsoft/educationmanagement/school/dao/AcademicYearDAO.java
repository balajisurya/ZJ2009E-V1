package in.jdsoft.educationmanagement.school.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;

@Repository
public class AcademicYearDAO extends GenericDAO<AcademicYear>{

	
	public AcademicYearDAO() {
		super(AcademicYear.class);
	}
	
	public AcademicYear getAcademicYearById(java.lang.Integer id) {
		try {
			AcademicYear instance = (AcademicYear) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.AcademicYear", id);
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
	
	public AcademicYear getAcademiYearByAcademicYearTitle(String academicYearTitle,Institution institution){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(AcademicYear.class);
			criteria.add(Restrictions.conjunction().
					add(Restrictions.eq("academicYearTitle",academicYearTitle))
					.add(Restrictions.eq("institution", institution)));
			AcademicYear academicYear=(AcademicYear)criteria.uniqueResult();
			if (academicYear == null) {
				//logging
			} else {
				//logging
			}
			return academicYear;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
