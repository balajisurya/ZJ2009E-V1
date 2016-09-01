package in.jdsoft.educationmanagement.school.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;

@Repository
public class ClassDAO extends GenericDAO<Class>{

	public ClassDAO() {
	  super(Class.class);
	}
	
	public Class getClassById(java.lang.Integer id) {
		try {
			Class instance = (Class) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.Class", id);
			if (instance == null) {
					//for logging purpose if null
			} else {
				//for logging purpose if not null
			}
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Class getClassByClassName(String className,Institution institution){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Class.class);
			criteria.add(Restrictions.conjunction().
					add(Restrictions.eq("className",className))
					.add(Restrictions.eq("institution", institution)));
			Class clazz=(Class)criteria.uniqueResult();
			if (clazz == null) {
				//logging
			} else {
				//logging
			}
			return clazz;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
