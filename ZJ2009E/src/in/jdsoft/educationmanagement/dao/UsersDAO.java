package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.Users;

@Repository
public class UsersDAO extends GenericDAO<Users>{

	public UsersDAO() {
			super(Users.class);
	}
	
	
	public Users getUserByEmail(String email) {
		try {
			Criteria emailcriteria=sessionFactory.getCurrentSession().createCriteria(Users.class);
			emailcriteria.add(Restrictions.eq("email", email));
			Users user=(Users)emailcriteria.uniqueResult();
			if (user == null) {
				//logging
			} else {
				//logging
			}
			return user;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	public Users getUserById(java.lang.Integer id) {
		try {
			Users instance = (Users) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.Users", id);
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
	
	/*public Integer saveUser(Users instance) throws Exception{
		try {
			sessionFactory.getCurrentSession().save(instance);
			return instance.getUserId();
		} catch (Exception e) {
			throw new Exception();
		}
	}*/
	
}
