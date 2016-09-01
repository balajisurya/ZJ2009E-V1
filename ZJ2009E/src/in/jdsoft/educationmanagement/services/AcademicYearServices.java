package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.AcademicSemesterSystemSubsetStatusDAO;
import in.jdsoft.educationmanagement.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.dao.AcademicYearStatusDAO;
import in.jdsoft.educationmanagement.dao.SemesterSystemDAO;
import in.jdsoft.educationmanagement.model.AcademicSemesterSystem;
import in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubset;
import in.jdsoft.educationmanagement.model.AcademicSemesterSystemSubsetStatus;
import in.jdsoft.educationmanagement.model.AcademicYear;
import in.jdsoft.educationmanagement.model.AcademicYearStatus;
import in.jdsoft.educationmanagement.model.SemesterSystem;

@Service
public class AcademicYearServices {

	@Autowired
	AcademicYearDAO academicYearDAO;
	@Autowired
	SemesterSystemDAO semesterSystemDAO;
	@Autowired
	AcademicYearStatusDAO academicYearStatusDAO;
	@Autowired
	AcademicSemesterSystemSubsetStatusDAO academicSemesterSystemSubsetStatusDAO;
	
	@Transactional
	public void addAcademicYear(AcademicYear academicyear){
		try {
	academicYearDAO.persist(academicyear);		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			
	}
	
	@Transactional
	public AcademicYear getCurrentAcademicYear(){
		try {
			  AcademicYearStatus academicYearStatus=academicYearStatusDAO.getAcademicYearStatusById(2);
			  
			   Hibernate.initialize(academicYearStatus.getAcademicYears());
			   AcademicYear academicYear=null;
			   Iterator<AcademicYear> iterator=academicYearStatus.getAcademicYears().iterator();
			   while(iterator.hasNext()){
				   academicYear=iterator.next();
			   }
			   if(academicYear!=null){
				   Hibernate.initialize(academicYear.getAcademicSemesterSystems());   
				   for(AcademicSemesterSystem academicSemesterSystem:academicYear.getAcademicSemesterSystems()){
					   Hibernate.initialize(academicSemesterSystem.getAcademicSemesterSystemSubsets());
					   Hibernate.initialize(academicSemesterSystem.getSemesterSystem());
					   for(AcademicSemesterSystemSubset academicSemesterSystemSubset:academicSemesterSystem.getAcademicSemesterSystemSubsets()){
						   Hibernate.initialize(academicSemesterSystemSubset.getSemesterSystemSubset());
					   }
				   }
			   }
			  
			   
			return academicYear;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public ArrayList<AcademicYear> getAcademicYearsList(){
		try {
			List<AcademicYear> academicYearList=academicYearDAO.getList();
			for (AcademicYear academicYear : academicYearList) {
				Hibernate.initialize(academicYear.getAcademicYearStatus());
			}
			return (ArrayList<AcademicYear>)academicYearList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	 }
	
	@Transactional
	public void updateAcademicYear(AcademicYear academicyear){
		try {
			academicYearDAO.update(academicyear);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	public AcademicYear getAcademicYearById(int academicYearId){
		try {
	return academicYearDAO.getAcademicYearById(academicYearId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			}
			
	}
	
	@Transactional
	public void addSemesterSystem(SemesterSystem semesterSystem){
		try {
	semesterSystemDAO.persist(semesterSystem);			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Transactional
	public AcademicYearStatus getAcademicYearStatusById(Integer academicYearStatusId){
		try {
	AcademicYearStatus academicYearStatus=academicYearStatusDAO.getAcademicYearStatusById(academicYearStatusId);
	Hibernate.initialize(academicYearStatus.getAcademicYears());
	return academicYearStatusDAO.getAcademicYearStatusById(academicYearStatusId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			
	}
	
	@Transactional
	public AcademicSemesterSystemSubsetStatus getAcademicSemesterSystemSubsetStatusById(Integer academicSemesterSystemSubsetStatusId){
		try {
			return academicSemesterSystemSubsetStatusDAO.getAcademicSemesterSystemSubsetStatusById(academicSemesterSystemSubsetStatusId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			
	}
	
	
}
