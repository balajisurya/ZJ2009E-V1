package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Department;

@Repository
public class DepartmentDAO  extends GenericDAO<Department>{

	public DepartmentDAO() {
	  super(Department.class);
	}
	
	public Department getDepartmentById(java.lang.Integer id) {
		try {
			Department instance = (Department) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Department", id);
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
