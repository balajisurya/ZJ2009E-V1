package in.jdsoft.educationmanagement.school.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Institution;


@Repository
public class InstitutionDAO extends GenericDAO<Institution>{

	public InstitutionDAO() {
		super(Institution.class);
	}
	
	public Institution getInstitutionById(java.lang.Integer id) {
		try {
			Institution instance = (Institution) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.Institution", id);
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
