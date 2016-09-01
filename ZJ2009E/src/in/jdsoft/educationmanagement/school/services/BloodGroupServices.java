package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.BloodGroupDAO;
import in.jdsoft.educationmanagement.school.model.BloodGroup;



@Service
public class BloodGroupServices {

	@Autowired
	BloodGroupDAO bloodGroupDAO;
	
	@Transactional
	public BloodGroup getBloodGroupById(int bloodgroupId){
			return bloodGroupDAO.getBloodGroupById(bloodgroupId);
	}
	
	@Transactional
	public ArrayList<BloodGroup> getBloodGroupList(){
			return (ArrayList<BloodGroup>) bloodGroupDAO.getList();
	}
	
	@Transactional
	public void addBloodGroup(BloodGroup bloodGroup){
			 bloodGroupDAO.persist(bloodGroup);
	}
	
	@Transactional
	public void updateBloodGroup(BloodGroup bloodGroup){
			bloodGroupDAO.update(bloodGroup);
	}
	
	@Transactional
	public void deleteBloodGroup(int bloodGroupId){
			bloodGroupDAO.delete(bloodGroupDAO.getBloodGroupById(bloodGroupId));
	} 
	
}
