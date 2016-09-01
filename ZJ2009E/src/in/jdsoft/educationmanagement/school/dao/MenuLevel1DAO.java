package in.jdsoft.educationmanagement.school.dao;


import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.MenuLevel1;


@Repository
public class MenuLevel1DAO extends GenericDAO<MenuLevel1> {

	public MenuLevel1DAO() {
		super(MenuLevel1.class);
	}
	


	public MenuLevel1 getMenuLevelOneById(java.lang.Integer id) {
		try {
			MenuLevel1 instance = (MenuLevel1) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.MenuLevel1", id);
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
