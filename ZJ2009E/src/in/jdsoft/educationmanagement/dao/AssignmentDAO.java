package in.jdsoft.educationmanagement.dao;

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Assignment;

@Repository
public class AssignmentDAO extends GenericDAO<Assignment>{
	
	public AssignmentDAO() {
		super(Assignment.class);
	}
	
	public Assignment getAssignmentById(java.lang.Integer id) {
		try {
			Assignment instance = (Assignment) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Assignment", id);
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
