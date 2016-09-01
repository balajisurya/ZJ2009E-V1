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
import in.jdsoft.educationmanagement.components.HashGenerator;
import in.jdsoft.educationmanagement.school.dao.InstituteLedgerAccountDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.MasterUserTypeDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.InstitutionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTemplate;
import in.jdsoft.educationmanagement.school.model.FeesTemplateItem;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.User;

@Service
public class InstitutionServices {
	
	@Autowired
	InstitutionDAO institutionDAO;
	@Autowired
	MasterUserTypeDAO masterUserTypeDAO;
	@Autowired
	UserDAO usersDAO;
	@Autowired
	InstituteLedgerAccountDAO instituteLedgerAccountDAO;
	@Autowired
	HashGenerator hashGenerator;
	@Autowired
	ExceptionComparator exceptionComparator;
	
	@Transactional
	 public Institution addInstitution(Institution institution){
			return institutionDAO.save(institution);		 
	 }
	
	@Transactional
	 public void updateInstitution(Institution institution){
			institutionDAO.update(institution);
	 }
	
	@Transactional
	public ArrayList<Institution> getInstitutionsList(){
			return (ArrayList<Institution>) institutionDAO.getList();
	}

	@Transactional
	public Institution getInstitutionById(Integer id){
			return institutionDAO.getInstitutionById(id);
	}
	
	@Transactional
	public void deleteInstitution(Integer institutionId){
			Institution institution= institutionDAO.getInstitutionById(institutionId);
			institutionDAO.delete(institution);
	}
	
	


	@Transactional
	public Set<FeesTemplate> getInstituteFeesTemplates(Integer instituteId){
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getFeesTemplates());
			Set<FeesTemplate> feesTemplates=institution.getFeesTemplates();
			for(FeesTemplate feesTemplate:feesTemplates){
				Hibernate.initialize(feesTemplate.getFeesTemplateItems());
			}
			return feesTemplates;
	}
	
	@Transactional
	public Set<FeesTemplateItem> getInstituteFeesTemplateItems(Integer instituteId){
			Institution institution= getInstitutionById(instituteId);
			Hibernate.initialize(institution.getFeesTemplateItems());
			Set<FeesTemplateItem> feesTemplateItems=institution.getFeesTemplateItems();
			for (FeesTemplateItem feesTemplateItem : feesTemplateItems) {
				Hibernate.initialize(feesTemplateItem.getLedgerAccount());
			}
			return feesTemplateItems;
	}
	

	
	@Transactional
	public void setUpInstitutionWithAdmin(Institution institution,String userName,String userEmail,String password,String profilePath){
			Integer institutionId= institutionDAO.save(institution).getInstitutionId();
			User user=new User(masterUserTypeDAO.getMasterUserTypeById(1), userName,userEmail, password,"defaullt",1,hashGenerator.encoder(password),profilePath,institutionDAO.getInstitutionById(institutionId));
			usersDAO.persist(user);
	}
	
	
	
	@Transactional(rollbackFor=InstitutionException.class)
	 public void addInstituteLedgerAccount(InstituteLedgerAccount instituteLedgerAccount)throws InstitutionException {
		try{
			instituteLedgerAccountDAO.persist(instituteLedgerAccount);
		}
		catch (Exception e) {
			
			  if(e.getClass().equals(ConstraintViolationException.class))
			  {
				  String valid=exceptionComparator.containsWord(e.getMessage());
				
					if(valid!=null)
					{
						valid = valid.replace('_',' ');
						throw new InstitutionException(new Message("duplicate", "Cannot Create Duplicate "+valid));
						
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
	 public void updateLedgerAccount(InstituteLedgerAccount instituteLedgerAccount)throws DataIntegrityViolationException{
			instituteLedgerAccountDAO.update(instituteLedgerAccount);
	 }
	
	@Transactional
	public ArrayList<InstituteLedgerAccount> getLedgerAccountList(){
			return (ArrayList<InstituteLedgerAccount>) instituteLedgerAccountDAO.getList();
	}
	

	@Transactional
	public ArrayList<InstituteLedgerAccount> getInstitutionLedgerAccountList(Integer institutionId){			
			Institution institution= institutionDAO.getInstitutionById(institutionId);
			Hibernate.initialize(institution.getLedgerAccounts());
			ArrayList<InstituteLedgerAccount> ledgerAccounts=new ArrayList<InstituteLedgerAccount>();
			ledgerAccounts.addAll(institution.getLedgerAccounts());
			return ledgerAccounts;
	}

	@Transactional
	public InstituteLedgerAccount getLedgerAccountById(Integer id){
			return instituteLedgerAccountDAO.getInstituteLedgerAccountById(id);
	}
	
	@Transactional
	public void deleteLedgerAccount(Integer instituteLedgerAccountId)throws DataIntegrityViolationException{
			instituteLedgerAccountDAO.delete(instituteLedgerAccountDAO.getInstituteLedgerAccountById(instituteLedgerAccountId));
	}
	
	//new methods
	
	@Transactional
	public ArrayList<SpecialCategory> getInstitutionSpecialCategory(Integer institutionId){
		Institution institution= institutionDAO.getInstitutionById(institutionId);
		Hibernate.initialize(institution.getSpecialCategories());
		ArrayList<SpecialCategory> specialCategory=new ArrayList<SpecialCategory>();
		specialCategory.addAll(institution.getSpecialCategories());
		return specialCategory;
	}
	

	
	@Transactional
	public ArrayList<Class> getInstitutionClasses(Integer institutionId){
		Institution institution= institutionDAO.getInstitutionById(institutionId);
		Hibernate.initialize(institution.getClasses());
		ArrayList<Class> classes=new ArrayList<Class>();
		classes.addAll(institution.getClasses());
		return classes;
	}
	@Transactional
	public ArrayList<Section> getInstitutionSections(Integer institutionId){
		Institution institution= institutionDAO.getInstitutionById(institutionId);
		Hibernate.initialize(institution.getSections());
		ArrayList<Section> sections=new ArrayList<Section>();
		sections.addAll(institution.getSections());
		return sections;
	}
	
	@Transactional
	public ArrayList<FeesTerm> getInstitutionFeesTerms(Integer institutionId){
		Institution institution= institutionDAO.getInstitutionById(institutionId);
		ArrayList<FeesTerm> feesTerm=new ArrayList<FeesTerm>();
		feesTerm.addAll(institution.getFeesTerms());
		return feesTerm;
	}
	
	@Transactional
	public ArrayList<AcademicYearFeesTerm> getCurrentAcademicYearFeesTerms(Integer institutionId){
		Institution institution= institutionDAO.getInstitutionById(institutionId);
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
		
		ArrayList<AcademicYearFeesTerm> academicYearFeesTerms=new ArrayList<AcademicYearFeesTerm>();
		 academicYearFeesTerms.addAll(academicYear.getAcademicYearFeesTerms());
		return  academicYearFeesTerms;
	}
}
