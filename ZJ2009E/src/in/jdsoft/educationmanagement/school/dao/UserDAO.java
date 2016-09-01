package in.jdsoft.educationmanagement.school.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.User;


@Repository
public class UserDAO extends GenericDAO<User>{

	public UserDAO() {
			super(User.class);
	}
	
	
	public User getUserByEmail(String email) {
		try {
			Criteria emailcriteria=sessionFactory.getCurrentSession().createCriteria(User.class);
			emailcriteria.add(Restrictions.eq("email", email));
			User user=(User)emailcriteria.uniqueResult();
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
	
	
	public User getUserById(java.lang.Integer id) {
		try {
			User instance = (User) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.User", id);
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
