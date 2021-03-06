package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;
import in.jdsoft.educationmanagement.model.Staff;

@Repository
public class StaffDAO extends GenericDAO<Staff> {

	public StaffDAO() {
		super(Staff.class);
	}
	

	public Staff getStaffById(java.lang.Integer id) {
		try {
			Staff instance = (Staff) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Staff", id);
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
