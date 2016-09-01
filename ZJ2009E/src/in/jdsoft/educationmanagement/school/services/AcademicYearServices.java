package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.FeesTermDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.AcademicYearException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;

@Service
public class AcademicYearServices {

	@Autowired
	AcademicYearDAO academicYearDAO;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	FeesTermDAO feesTermDAO;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	
	@Transactional(rollbackFor=AcademicYearException.class)
	public void addAcademicYear(AcademicYear academicYear,Integer []feesTermIds) throws AcademicYearException{
		try{
			if(academicYear.getAcademicYearStatus()==1){
				if(getInstitutionCurrentAcademicYear(academicYear.getInstitution().getInstitutionId())!=null){
					throw new AcademicYearException(new Message("cannotSaved", "Already Active Academic Year Exist,Close it or save this with closed status"));
				}
				else{
					for (Integer feesTermId : feesTermIds) {
						FeesTerm feesTerm= feesTermDAO.getFeesTermById(feesTermId);
						AcademicYearFeesTerm academicYearFeesTerm=new AcademicYearFeesTerm(academicYear,feesTerm.getFeesTermName(),feesTerm.getTermOrder());
						academicYear.getAcademicYearFeesTerms().add(academicYearFeesTerm);
					}
					academicYearDAO.persist(academicYear);
				}
			}
			else{
				for (Integer feesTermId : feesTermIds) {
					FeesTerm feesTerm= feesTermDAO.getFeesTermById(feesTermId);
					AcademicYearFeesTerm academicYearFeesTerm=new AcademicYearFeesTerm(academicYear,feesTerm.getFeesTermName(),feesTerm.getTermOrder());
					academicYear.getAcademicYearFeesTerms().add(academicYearFeesTerm);
				}
				academicYearDAO.persist(academicYear);
			}
		}catch (Exception e) {
			
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				  String valid=exceptionComparator.containsWord(e.getMessage());
					if(valid!=null)
					{
						throw new AcademicYearException(new Message("duplicate", "Cannot Create Duplicate Academic Year Title"));
						
					}else
					{
						 throw e;
					}
				  
			  }
			  else
			  {
				  
				  throw e;
			  }
		  }
		
	}
	
	@Transactional
	public ArrayList<AcademicYear> getAcademicYearList(){
			return (ArrayList<AcademicYear>) academicYearDAO.getList();
	}
	
	@Transactional
	public ArrayList<AcademicYear> getInstitutionAcademicYearList(Integer institutionId){
			Institution institution= institutionDAO.getInstitutionById(institutionId);
			Hibernate.initialize(institution.getAcademicYears());
			ArrayList<AcademicYear> academicyears=new ArrayList<AcademicYear>();
			academicyears.addAll(institution.getAcademicYears());
			return academicyears;
	}
	
	@Transactional
	public void deleteAcademicYear(int academicYearId) throws AcademicYearException,DataIntegrityViolationException{
			 AcademicYear academicYear=academicYearDAO.getAcademicYearById(academicYearId);
			 if(academicYear.getAcademicYearStatus()==1){
				 throw new AcademicYearException(new Message("isActive","Active Academic Cannot be deleted"));
			 }
			 else{
				 academicYearDAO.delete(academicYear);
			 }
	}
	
	@Transactional
	public void updateAcademicYear(AcademicYear academicYear) throws AcademicYearException{
			if(academicYear.getAcademicYearStatus()==1){
				AcademicYear currentAcademic=getInstitutionCurrentAcademicYear(academicYear.getInstitution().getInstitutionId());
				if(currentAcademic!=null){
					if(currentAcademic.getAcademicYearId()!=academicYear.getAcademicYearId())
					{
						Message message =new Message("cannotUpdate", "Already Active Academic Year Exist,Close it then update this");
						throw new AcademicYearException(message);
					}
					else
					{
						if(currentAcademic.getAcademicYearStatus()==0){
							Message message =new Message("cannotUpdate", "Closed Acdemic Year Cannot Be Made Active");
							throw new AcademicYearException(message);
						}
						else{
							currentAcademic.setAcademicYearStatus(academicYear.getAcademicYearStatus());
							currentAcademic.setAcademicYearTitle(academicYear.getAcademicYearTitle());
							academicYearDAO.update(currentAcademic);
						}
					}
					
				}
				else{
					
					AcademicYear currentAcademic1=getAcademicYearById(academicYear.getAcademicYearId());
					currentAcademic1.setAcademicYearStatus(academicYear.getAcademicYearStatus());
					currentAcademic1.setAcademicYearTitle(academicYear.getAcademicYearTitle());
					academicYearDAO.update(currentAcademic1);
				}
			 }
			else{
				academicYearDAO.update(academicYear);
			}
		
	}

	@Transactional
	public AcademicYear getAcademicYearById(Integer academicYearId){
		AcademicYear academicYear=academicYearDAO.getAcademicYearById(academicYearId);
		Hibernate.initialize(academicYear.getAcademicYearFeesTerms());
	    return academicYear;
	}
	
	@Transactional
	public AcademicYear getInstitutionCurrentAcademicYear(Integer institutionId){
			Institution institution= institutionDAO.getInstitutionById(institutionId);
			Hibernate.initialize(institution.getAcademicYears());
			Set<AcademicYear> institutionAcademicYears=institution.getAcademicYears();
			Iterator<AcademicYear> iterator=institutionAcademicYears.iterator();
			AcademicYear academicYear=null;
			while(iterator.hasNext()){
				academicYear=iterator.next();
				if(academicYear.getAcademicYearStatus()==1){
					break;
				}
				academicYear=null;
			}
			return academicYear;
	}
}
