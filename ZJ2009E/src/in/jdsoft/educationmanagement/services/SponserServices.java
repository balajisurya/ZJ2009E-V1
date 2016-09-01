package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.SponserDAO;
import in.jdsoft.educationmanagement.model.Sponser;

@Service
public class SponserServices {

	@Autowired
	SponserDAO sponserDAO;
	
	@Transactional
	public void addSponser(Sponser sponser){
		sponserDAO.persist(sponser);
	}
	
	@Transactional
	public ArrayList<Sponser> getSponserList(){
		return (ArrayList<Sponser>) sponserDAO.getList();
	}
	
	@Transactional
	public void deleteSponser(int sponserId){
		sponserDAO.delete(sponserDAO.getSponserById(sponserId));
	}
	
	@Transactional
	public void updateSponser(Sponser sponser){
		sponserDAO.update(sponser);
	}

	@Transactional
	public Sponser getSponserById(Integer sponserId){
		return sponserDAO.getSponserById(sponserId);
	}
}
