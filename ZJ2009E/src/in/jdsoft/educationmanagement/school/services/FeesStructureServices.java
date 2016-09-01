package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.FeesTemplateDAO;
import in.jdsoft.educationmanagement.school.dao.FeesTemplateItemDAO;
import in.jdsoft.educationmanagement.school.dao.FeesTermDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.FeesStructureException;
import in.jdsoft.educationmanagement.school.exceptions.FeesTermException;
import in.jdsoft.educationmanagement.school.model.FeesTemplate;
import in.jdsoft.educationmanagement.school.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;


@Service
public class FeesStructureServices {
	
	@Autowired
	FeesTemplateDAO feesTemplateDAO;
	@Autowired
	FeesTemplateItemDAO feesTemplateItemDAO;
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	ExceptionComparator exceptionComparator;
	@Autowired
	FeesTermDAO feesTermDAO;
	
	@Transactional(rollbackFor=FeesStructureException.class) 
	public void addFeesTemplate(FeesTemplate feesTemplate)throws FeesStructureException{
		try{
		feesTemplateDAO.persist(feesTemplate);
		}catch (Exception e) {
			
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				  String valid=exceptionComparator.containsWord(e.getMessage());
					if(valid!=null)
					{
						throw new FeesStructureException(new Message("duplicate", "Cannot Create Duplicate Fees Structure"));
						
					}else
					{
						 throw e;
					}
			  }else
			  {
				  throw e;
			  }
		  }
	}
	
	@Transactional
	public void deleteTemplate(int feesTemplateId)throws DataIntegrityViolationException{
		feesTemplateDAO.delete(feesTemplateDAO.getFeesTemplateById(feesTemplateId));
	}
	
	@Transactional
	public void updateTemplate(FeesTemplate feesTemplate)throws DataIntegrityViolationException{
		feesTemplateDAO.update(feesTemplate);
	}
	
	@Transactional
	public FeesTemplate getFeesTemplateById(int templateId){
		return feesTemplateDAO.getFeesTemplateById(templateId);
	}
	
	@Transactional
	public FeesTemplate getFeesTemplateLazyById(int templateId){
			FeesTemplate feesTemplate= feesTemplateDAO.getFeesTemplateById(templateId);
			  Hibernate.initialize(feesTemplate);
			  Hibernate.initialize(feesTemplate.getFeesTemplateItems());
			  return feesTemplate;
	}
	
	@Transactional(rollbackFor=FeesStructureException.class) 
	public void addTemplateItem(FeesTemplateItem feesTemplateItem)throws FeesStructureException
	{
		try{
		feesTemplateItemDAO.persist(feesTemplateItem);
		}
		catch (Exception e) {
			
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				  String valid=exceptionComparator.containsWord(e.getMessage());
					if(valid!=null)
					{
						throw new FeesStructureException(new Message("duplicate", "Cannot Create Duplicate Fees Item"));
						
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
	public void deleteTemplateItem(int feesTemplateItemId)throws DataIntegrityViolationException{
		feesTemplateItemDAO.delete(feesTemplateItemDAO.getFeesTemplateItemById(feesTemplateItemId));
	}
	
	@Transactional
	public FeesTemplate getFeesTemplateWithTemplateItems(int templateId){
			FeesTemplate feesTemplate= feesTemplateDAO.getFeesTemplateById(templateId);
			  Hibernate.initialize(feesTemplate.getFeesTemplateItems());
			  return feesTemplate;
	}
	
	@Transactional
	public void updateTemplateItem(FeesTemplateItem feesTemplateItem)throws DataIntegrityViolationException{
		feesTemplateItemDAO.update(feesTemplateItem);
	}
	
	
	@Transactional
	public FeesTemplateItem getFeesItemById(int feesTemplateItemId){
		 
			
			  return feesTemplateItemDAO.getFeesTemplateItemById(feesTemplateItemId);
		
		
	}
	@Transactional
	public FeesTemplateItem getFeesItemLazyById(int feesTemplateItemId){
			FeesTemplateItem feesTemplateItem= feesTemplateItemDAO.getFeesTemplateItemById(feesTemplateItemId);
			  Hibernate.initialize(feesTemplateItem.getLedgerAccount());
			  return feesTemplateItem;
	}
	
	
	@Transactional 
	public ArrayList<FeesTemplate> getInstitutionFeesTemplate(Integer instituteId){
			Institution institution= institutionDAO.getInstitutionById(instituteId);
			Hibernate.initialize(institution.getFeesTemplates());
			ArrayList<FeesTemplate> feesTemplates=new ArrayList<FeesTemplate>();
			feesTemplates.addAll(institution.getFeesTemplates());
			return  feesTemplates;
	
	}
	
	@Transactional 
	public ArrayList<FeesTemplateItem> getInstitutionFeesTemplateItems(Integer instituteId){
			Institution institution= institutionDAO.getInstitutionById(instituteId);
			Hibernate.initialize(institution.getFeesTemplateItems());
			ArrayList<FeesTemplateItem> feesTemplates=new ArrayList<FeesTemplateItem>();
			feesTemplates.addAll(institution.getFeesTemplateItems());
			return  feesTemplates;
	
	}
	
	@Transactional(rollbackFor=FeesTermException.class)
	public void addFeesTerm(FeesTerm feesTerm) throws FeesTermException{
		try {
			feesTermDAO.persist(feesTerm);
		} catch (Exception e) {
			if(e.getClass().equals(ConstraintViolationException.class)){
				//Duplicate entry '1-Janauary' for key 'institution_id'
				ConstraintViolationException cv= (ConstraintViolationException)e;
				String message=exceptionComparator.containsWord(cv.getMessage());
				if(message.equals("institution_id")){
					throw new FeesTermException(new Message("duplicateTerm","Duplicate Fees Term or order no"));
				}
			}
		}
		
	}
	
	@Transactional
	public FeesTerm getFeesTermById(Integer feesTermId){
		return	feesTermDAO.getFeesTermById(feesTermId);
	}
	
	@Transactional(rollbackFor=FeesTermException.class)
	public void updateFeesTerm(FeesTerm feesTerm) throws DataIntegrityViolationException{
		try {
			feesTermDAO.update(feesTerm);
		} catch (Exception e) {
				throw e;
		    
	    }
		
	}
	
	@Transactional
	public void deleteFeesTerm(Integer feesTermId){
		feesTermDAO.delete(feesTermDAO.getFeesTermById(feesTermId));
	}
}


