package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.components.EmailHandler;
import in.jdsoft.educationmanagement.customexceptions.AdmissionProcessServiceException;
import in.jdsoft.educationmanagement.dao.AdmissionConfigDAO;
import in.jdsoft.educationmanagement.dao.AdmissionDAO;
import in.jdsoft.educationmanagement.dao.AdmissionDocumentTypeDAO;
import in.jdsoft.educationmanagement.dao.AdmissionProcessStatusDAO;
import in.jdsoft.educationmanagement.dao.AdmissionStatusDAO;
import in.jdsoft.educationmanagement.dao.CourseCategoryDAO;
import in.jdsoft.educationmanagement.dao.CoursesDAO;
import in.jdsoft.educationmanagement.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.model.Admission;
import in.jdsoft.educationmanagement.model.AdmissionConfig;
import in.jdsoft.educationmanagement.model.AdmissionDocumentTypes;
import in.jdsoft.educationmanagement.model.AdmissionProcessStatus;
import in.jdsoft.educationmanagement.model.AdmissionStatus;
import in.jdsoft.educationmanagement.model.PortalNotification;
import in.jdsoft.educationmanagement.model.Users;

@Service
public class AdmissionServices {
	
	@Autowired
	private AdmissionDAO admissionDAO;
	@Autowired
	private AdmissionConfigDAO admissionConfigDAO;
	@Autowired
	private AdmissionProcessStatusDAO admissionProcessStatusDAO;
	@Autowired
	private AdmissionDocumentTypeDAO admissionDocumentTypeDAO;
	@Autowired
	private AdmissionStatusDAO admissionStatusDAO; 
	@Autowired
	private CoursesDAO courseDAO;
	@Autowired
	private CourseCategoryDAO courseCategoryDAO;
	@Autowired
	private PortalNotificationDAO portalNotificationDAO;
	@Autowired
	private EmailHandler emailHandler;
	
	
	
	
	@Transactional
	public void addAdmission(Admission admission){
			admissionDAO.persist(admission);
	}
	
	@Transactional
	public void updateAdmission(Admission admission){	
			admissionDAO.update(admission);
	}
	
	@Transactional
	public void intimateApplicationStatus(Admission admission,Users createdUser){	
		try {
			admissionDAO.update(admission);
			PortalNotification portalNotification=new PortalNotification("Application Status Updated", "Application Status Updated",admission.getUser(),0,"${pageContext.request.contextPath}/candidate/applyforadmission", createdUser);
			portalNotificationDAO.persist(portalNotification);
			emailHandler.sendEmail(admission.getCandidateEmail(),"Application Status", "you are selected");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Transactional
	public void deleteAdmission(int admissionId){
		try{
			admissionDAO.delete(admissionDAO.getAdmissionById(admissionId));
		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	@Transactional
	public Admission getAdmissionDetailsById(int admissionId){
		try{
			Admission admission= admissionDAO.getAdmissionById(admissionId);
			Hibernate.initialize(admission.getUser());
			return admission;
		}
		catch(Exception e){
			if(e.getClass().equals(NullPointerException.class)){
				throw new AdmissionProcessServiceException(e);
			}
			else{
				throw e;
			}
		}
		
	}
	
	@Transactional
	public Admission editAdmissionApplication(int admissionId){
		try{
		Admission admission= admissionDAO.getAdmissionById(admissionId);
		Hibernate.initialize(admission.getCourseType());
		Hibernate.initialize(admission.getDepartment());
		Hibernate.initialize(admission.getCourse());
		Hibernate.initialize(admission.getCourseCategory());
		Hibernate.initialize(admission.getAdmissionStatus());
		Hibernate.initialize(admission.getReligion());
		Hibernate.initialize(admission.getSponser());
		Hibernate.initialize(admission.getCategory());
		Hibernate.initialize(admission.getSpecialCategory());
		Hibernate.initialize(admission.getHearedUs());
		Hibernate.initialize(admission.getUser());
		return admission;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public Admission getFullAdmissionDetails(int admissionId) throws Exception{
		try{
		Admission admission= admissionDAO.getAdmissionById(admissionId);
			  if(admission.getAdmissionStatus().getAdmissionStatusTitle().equals(admissionStatusDAO.getAdmissionStatusById(4).getAdmissionStatusTitle()))
				{
					Hibernate.initialize(admission.getCourseType());
					Hibernate.initialize(admission.getDepartment());
					Hibernate.initialize(admission.getCourse());
					Hibernate.initialize(admission.getCourseCategory());
					Hibernate.initialize(admission.getReligion());
					Hibernate.initialize(admission.getSponser());
					Hibernate.initialize(admission.getCategory());
					Hibernate.initialize(admission.getSpecialCategory());
			        return admission;	
				}
				else
				{
					throw new Exception("Invalid admission id");
				}
		
		}
		catch(Exception e){
			throw new Exception("Admission id not found");
		}
	}
	
	@Transactional
	public ArrayList<Admission> getAdmissionsList() throws Exception,AdmissionProcessServiceException{
		try{
			return (ArrayList<Admission>) admissionDAO.getList();
		}
		catch(Exception e){
			if(e.getClass().equals(NullPointerException.class)){
				throw new AdmissionProcessServiceException(e);
			}
			else{
				throw new Exception(e.getCause());
			}
		}
		
		
	}
	
	
	
	@Transactional
	public void addAdmissionConfig(AdmissionConfig admissionConfig){
			admissionConfigDAO.persist(admissionConfig);
	}
	
	@Transactional
	public void updateAdmissionConfig(AdmissionConfig admissionConfig) throws Exception, AdmissionProcessServiceException{
		try{
			admissionConfigDAO.update(admissionConfig);
		}
		catch(Exception e){
			if(e.getClass().equals(NullPointerException.class)){
				throw new AdmissionProcessServiceException(e);
			}
			else{
				throw new Exception(e.getCause());
			}
		}
		
	}
	
	@Transactional
	public void deleteAdmissionConfig(int admissionId){
			admissionConfigDAO.delete(admissionConfigDAO.getAdmissionConfigById(admissionId));
	}
	
	@Transactional
	public AdmissionConfig getAdmissionConfigById(int admissionId) throws Exception,AdmissionProcessServiceException{
		try{
			return admissionConfigDAO.getAdmissionConfigById(admissionId);
		}
		catch(Exception e){
			if(e.getClass().equals(NullPointerException.class)){
				throw new AdmissionProcessServiceException(e);
			}
			else{
				throw new Exception(e.getCause());
			}
		}
		
	}
	
	@Transactional
	public ArrayList<AdmissionConfig> getAdmissionConfigList(){
			return (ArrayList<AdmissionConfig>) admissionConfigDAO.getList();
	}
	
	@Transactional
	public ArrayList<AdmissionProcessStatus> getAdmissionProcessStatusList(){
		return (ArrayList<AdmissionProcessStatus>) admissionProcessStatusDAO.getList();
	}
	
	@Transactional
	public AdmissionProcessStatus getAdmissionProcessStatusById(int admissionProcessStatusId){
		return  admissionProcessStatusDAO.getAdmissionProcessStatusById(admissionProcessStatusId);
	}
	
	@Transactional
	public void addAdmissionProcessStatus(AdmissionProcessStatus admissionProcessStatus){
		admissionProcessStatusDAO.persist(admissionProcessStatus);
	}
	
	@Transactional
	public ArrayList<AdmissionDocumentTypes> getAdmissionDocumentTypeList(){
		return (ArrayList<AdmissionDocumentTypes>)admissionDocumentTypeDAO.getList();
	}
	
	@Transactional
	public AdmissionStatus getAdmissionStatusById(int admissionStatusId){
		return admissionStatusDAO.getAdmissionStatusById(admissionStatusId);
	}
	
	@Transactional
	public void addAdmissionStatus(AdmissionStatus admissionStatus){
		admissionStatusDAO.persist(admissionStatus);
	}
	
	@Transactional
	public ArrayList<Admission> getApplicants(int courseId,int courseCategoryId){
		try {
			ArrayList<Admission> admissions=(ArrayList<Admission>) admissionDAO.getApplicants(courseDAO.getCourseById(courseId), courseCategoryDAO.getCourseCategoryById(courseCategoryId));
			AdmissionStatus admissionStatus= getAdmissionStatusById(1);
			
			for(Admission admission:admissions){
				Hibernate.initialize(admission.getCourseType());
				Hibernate.initialize(admission.getDepartment());
				Hibernate.initialize(admission.getCourse());
				Hibernate.initialize(admission.getCourseCategory());
				Hibernate.initialize(admission.getAdmissionStatus());
				Hibernate.initialize(admission.getReligion());
				Hibernate.initialize(admission.getSponser());
				Hibernate.initialize(admission.getCategory());
				Hibernate.initialize(admission.getSpecialCategory());
				Hibernate.initialize(admission.getHearedUs());
				Hibernate.initialize(admission.getUser());
				Hibernate.initialize(admission.getAdmissionAcademicsDetails());
				Hibernate.initialize(admission.getAdmissionDocuments());
				Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
				Hibernate.initialize(admission.getAdmissionFeesPaymentDetails());
				Hibernate.initialize(admission.getAdmissionConfig());
				Hibernate.initialize(admission.getStudent());
							 
			}
			
			Iterator<Admission> iterator=admissions.iterator();
			while(iterator.hasNext()){
				Admission admission=iterator.next();
				if(!admission.getAdmissionStatus().getAdmissionStatusTitle().equals(admissionStatus.getAdmissionStatusTitle())){
				    iterator.remove();	
				}
			}
		
			return admissions;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Transactional
	public AdmissionConfig getCurrentAdmissionConfig(){
		try {
			AdmissionConfig admissionConfig=admissionConfigDAO.getCurrentAdmissionConfig();
			if(admissionConfig!=null){
				Hibernate.initialize(admissionConfig.getAdmissionProcessStatus());
				Hibernate.initialize(admissionConfig.getAdmissions());
			}
			return admissionConfig;
		} catch (Exception e) {
			throw e;
		}
	}
		
}
