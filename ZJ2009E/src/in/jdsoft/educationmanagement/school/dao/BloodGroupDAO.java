package in.jdsoft.educationmanagement.school.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.BloodGroup;



@Repository
public class BloodGroupDAO extends GenericDAO<BloodGroup>{

	public BloodGroupDAO() {
		super(BloodGroup.class);
	}
	
	public BloodGroup getBloodGroupById(java.lang.Integer id) {
		try {
			BloodGroup instance = (BloodGroup) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.BloodGroup", id);
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
	
	public BloodGroup getBloodGroupByName(String bloodGroupName){
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(BloodGroup.class);
			criteria.add(Restrictions.eq("bloodGroupName",bloodGroupName));
			BloodGroup bloodGroup=(BloodGroup)criteria.uniqueResult();
			if (bloodGroup == null) {
				//logging
			} else {
				//logging
			}
			return bloodGroup;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
