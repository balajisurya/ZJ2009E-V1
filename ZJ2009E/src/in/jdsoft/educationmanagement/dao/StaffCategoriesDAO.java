package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.StaffCategories;

@Repository
public class StaffCategoriesDAO extends GenericDAO<StaffCategories>{

	public StaffCategoriesDAO() {
		super(StaffCategories.class);
	}
	

	public StaffCategories getStaffCategoryById(java.lang.Integer id) {
		try {
			StaffCategories instance = (StaffCategories) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.StaffCategories", id);
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
