package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.SemesterSystemSubset;

@Repository
public class SemesterSystemSubsetDAO extends GenericDAO<SemesterSystemSubset> {

	public SemesterSystemSubsetDAO() {
		super(SemesterSystemSubset.class);
	}

	public SemesterSystemSubset getSemesterSystemSubsetById(java.lang.Integer id) {
		try {
			SemesterSystemSubset instance = (SemesterSystemSubset) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.SemesterSystemSubset", id);
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
