package in.jdsoft.educationmanagement.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.model.GroupMapping;

@Repository
public class GroupMappingDAO extends GenericDAO<GroupMapping>{
  
	 public GroupMappingDAO() {
		 super(GroupMapping.class);
	 }
	
	public GroupMapping getGroupMappingById(java.lang.Integer id) {
		try {
			GroupMapping instance = (GroupMapping) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.model.GroupMapping", id);
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
   
  
   @SuppressWarnings("unchecked")
   public List<GroupMapping> getGroupMappingByGroupId(java.lang.Integer groupId) {
		try {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(GroupMapping.class);
			List<GroupMapping> groupBygroupMapping=criteria.add(Restrictions.eq("groupId", groupId)).list();
			if (groupBygroupMapping == null) {
				//logging
			} else {
				//logging
			}
			return groupBygroupMapping;
		} catch (RuntimeException re) {
			throw re;
		}
	}
   
}
