package in.jdsoft.educationmanagement.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.GroupsDAO;
import in.jdsoft.educationmanagement.model.Groups;

@Service
public class GroupServices {
	
	@Autowired
	GroupsDAO groupsDAO;
	

	@Transactional
	 public void addGroup(Groups group){
		 groupsDAO.persist(group);
	}
	 
	/*@Transactional
	 public ArrayList<Groups> viewGroups(){
		 return (ArrayList<Groups>) groupsDAO.getList();
	 }*/
	
	@Transactional
	 public void updateGroup(Groups group){
		 groupsDAO.update(group);
	 }
	
	@Transactional
	 public void deleteGroup(int groupId){
		 groupsDAO.delete(groupsDAO.getGroupById(groupId));
	 }
	 
	@Transactional
	 public Groups groupById(int groupId){
		 return groupsDAO.getGroupById(groupId);
	 }
	
	@Transactional
	 public Groups groupLazyById(int groupId){
		try {
			Groups groups=groupsDAO.getGroupById(groupId);
			Hibernate.initialize(groups.getGroupMapping());
			 return groups;
		} catch (Exception e) {
			throw e;
		}
		
	 }
	
	
}
