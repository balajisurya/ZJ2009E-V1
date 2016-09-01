package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.HearedUsDAO;
import in.jdsoft.educationmanagement.model.HearedUs;

@Service
public class HearedUsServices {
	
	@Autowired
	HearedUsDAO hearedUsDAO;

	@Transactional
	public void addHearedUs(HearedUs hearedUs){
		hearedUsDAO.persist(hearedUs);
	}
	
	@Transactional
	public ArrayList<HearedUs> getHearedUsList(){
		return (ArrayList<HearedUs>) hearedUsDAO.getList();
	}
	
	@Transactional
	public void deleteHearedUs(int hearedUsId){
		hearedUsDAO.delete(hearedUsDAO.getHearedUsById(hearedUsId));
	}
	
	@Transactional
	public void updateHearedUs(HearedUs hearedUs){
		hearedUsDAO.update(hearedUs);
	}

	@Transactional
	public HearedUs getHearedUsById(Integer hearedUsId){
		return hearedUsDAO.getHearedUsById(hearedUsId);
	}
	
}
