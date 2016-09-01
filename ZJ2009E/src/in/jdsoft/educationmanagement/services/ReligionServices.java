package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.ReligionDAO;
import in.jdsoft.educationmanagement.model.Religion;

@Service
public class ReligionServices {
	
	@Autowired
	ReligionDAO religionDAO;
	
	@Transactional
	public void addReligion(Religion religion){
		religionDAO.persist(religion);
	}
	
	@Transactional
	public ArrayList<Religion> getReligionList(){
		return (ArrayList<Religion>) religionDAO.getList();
	}
	
	@Transactional
	public void deleteReligion(int religionId){
		religionDAO.delete(religionDAO.getReligionById(religionId));
	}
	
	@Transactional
	public void updateReligion(Religion religion){
		religionDAO.update(religion);
	}

	@Transactional
	public Religion getReligionById(Integer religionId){
		return religionDAO.getReligionById(religionId);
	}

}
