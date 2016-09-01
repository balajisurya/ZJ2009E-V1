package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.SemesterSystem;

@Repository
public class SemesterSystemDAO extends GenericDAO<SemesterSystem> {

	public SemesterSystemDAO() {
		super(SemesterSystem.class);
	}
	
	public SemesterSystem getSemesterSystemById(java.lang.Integer id) {
		try {
			SemesterSystem instance = (SemesterSystem) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.SemesterSystem", id);
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
