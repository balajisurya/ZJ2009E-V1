package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.SemesterSystemDAO;
import in.jdsoft.educationmanagement.dao.SemesterSystemSubsetDAO;
import in.jdsoft.educationmanagement.model.SemesterSystem;
import in.jdsoft.educationmanagement.model.SemesterSystemSubset;

@Service
public class SemesterSystemServices {

	@Autowired
	SemesterSystemDAO semesterSystemDAO;
	@Autowired
	SemesterSystemSubsetDAO semesterSystemSubsetDAO;
	
	@Transactional
	public void addSemesterSystem(SemesterSystem semesterSystem){
		semesterSystemDAO.persist(semesterSystem);
	}
	
	@Transactional
	public ArrayList<SemesterSystem> getSemesterSystemList(){
		try {
			List<SemesterSystem> semesterSystemList=semesterSystemDAO.getList();
			for(SemesterSystem semesterSystem:semesterSystemList){
				Hibernate.initialize(semesterSystem.getSemesterSystemStatus());
			}
			return (ArrayList<SemesterSystem>)semesterSystemList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	@Transactional
	public void deleteSemesterSystem(int semesterSystemId){
		semesterSystemDAO.delete(semesterSystemDAO.getSemesterSystemById(semesterSystemId));
	}
	
	@Transactional
	public void updateSemesterSystem(SemesterSystem semesterSystem){
		semesterSystemDAO.update(semesterSystem);
	}

	@Transactional
	public SemesterSystem getSemesterSystemById(Integer semesterSystemId){
		SemesterSystem semesterSystem=semesterSystemDAO.getSemesterSystemById(semesterSystemId);
		Hibernate.initialize(semesterSystem.getSemesterSystemSubsets());
		return semesterSystem;
	}
	
	@Transactional
	public SemesterSystemSubset getSemesterSystemSubsetById(Integer semesterSystemSubsetId){
		return semesterSystemSubsetDAO.getSemesterSystemSubsetById(semesterSystemSubsetId);
	}
	
	@Transactional
	public Set<SemesterSystemSubset> getSemesterSystemSubsetBySemesterSystemId(Integer semesterSystemId){
		try{
			SemesterSystem semesterSystem=semesterSystemDAO.getSemesterSystemById(semesterSystemId);
			Hibernate.initialize(semesterSystem.getSemesterSystemSubsets());
			return semesterSystem.getSemesterSystemSubsets();
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}

