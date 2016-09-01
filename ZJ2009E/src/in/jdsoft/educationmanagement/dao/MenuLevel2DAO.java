package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.MenuLevel2;

@Repository
public class MenuLevel2DAO extends GenericDAO<MenuLevel2> {

	public MenuLevel2DAO() {
		super(MenuLevel2.class);
	}
	
	public MenuLevel2 getMenuLevelTwoById(java.lang.Integer id) {
		try {
			MenuLevel2 instance = (MenuLevel2) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.MenuLevel2", id);
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
