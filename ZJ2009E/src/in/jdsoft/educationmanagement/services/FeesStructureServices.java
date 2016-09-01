package in.jdsoft.educationmanagement.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.dao.FeesTemplateDAO;
import in.jdsoft.educationmanagement.dao.FeesTemplateItemDAO;
import in.jdsoft.educationmanagement.model.FeesTemplate;
import in.jdsoft.educationmanagement.model.FeesTemplateItem;

@Service
public class FeesStructureServices {
	
	@Autowired
	FeesTemplateDAO feesTemplateDAO;
	@Autowired
	FeesTemplateItemDAO feesTemplateItemDAO;
	
	@Transactional
	public void addFeesTemplate(FeesTemplate feesTemplate){
		feesTemplateDAO.persist(feesTemplate);
	}
	
	/*@Transactional
	public ArrayList<FeesTemplate> getFeesTemplates(){
		ArrayList<FeesTemplate> feesTemplates=(ArrayList<FeesTemplate>) feesTemplateDAO.getList();
		for(FeesTemplate feesTemplate:feesTemplates){
			Hibernate.initialize(feesTemplate.getFeesTemplateItems());
		}
		return feesTemplates;
	}*/
	
	@Transactional
	public void deleteTemplate(int feesTemplateId){
		feesTemplateDAO.delete(feesTemplateDAO.getFeesTemplateById(feesTemplateId));
	}
	
	@Transactional
	public void updateTemplate(FeesTemplate feesTemplate){
		feesTemplateDAO.update(feesTemplate);
	}
	
	@Transactional
	public FeesTemplate getFeesTemplateById(int templateId){
		return feesTemplateDAO.getFeesTemplateById(templateId);
	}
	
	@Transactional
	public FeesTemplate getFeesTemplateLazyById(int templateId){
		try {
			FeesTemplate feesTemplate= feesTemplateDAO.getFeesTemplateById(templateId);
			  Hibernate.initialize(feesTemplate);
			  Hibernate.initialize(feesTemplate.getFeesTemplateItems());
			  return feesTemplate;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Transactional
	public void addTemplateItem(FeesTemplateItem feesTemplateItem){
		feesTemplateItemDAO.persist(feesTemplateItem);
	}
	
	/*@Transactional
	public ArrayList<FeesTemplateItem> viewTemplateItem(){
		return (ArrayList<FeesTemplateItem>) feesTemplateItemDAO.getList();
	}*/
	
	@Transactional
	public void deleteTemplateItem(int feesTemplateItemId){
		feesTemplateItemDAO.delete(feesTemplateItemDAO.getFeesTemplateItemById(feesTemplateItemId));
	}
	
	@Transactional
	public FeesTemplate getFeesTemplateWithTemplateItems(int templateId){
		try {
			FeesTemplate feesTemplate= feesTemplateDAO.getFeesTemplateById(templateId);
			  Hibernate.initialize(feesTemplate.getFeesTemplateItems());
			  return feesTemplate;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public void updateTemplateItem(FeesTemplateItem feesTemplateItem){
		feesTemplateItemDAO.update(feesTemplateItem);
	}
	
	
	@Transactional
	public FeesTemplateItem getFeesItemById(int feesTemplateItemId){
		 
			
			  return feesTemplateItemDAO.getFeesTemplateItemById(feesTemplateItemId);
		
		
	}
	@Transactional
	public FeesTemplateItem getFeesItemLazyById(int feesTemplateItemId){
		try {
			FeesTemplateItem feesTemplateItem= feesTemplateItemDAO.getFeesTemplateItemById(feesTemplateItemId);
			  Hibernate.initialize(feesTemplateItem);
			  return feesTemplateItem;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
