package in.jdsoft.educationmanagement.services;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.jdsoft.educationmanagement.dao.FacilityCategoryDAO;
import in.jdsoft.educationmanagement.dao.FacilityClassRoomDAO;
import in.jdsoft.educationmanagement.dao.FacilityEquipmentDAO;
import in.jdsoft.educationmanagement.dao.FacilityHostelDAO;
import in.jdsoft.educationmanagement.dao.FacilityLaboratoryDAO;
import in.jdsoft.educationmanagement.dao.FacilityTransportDAO;
import in.jdsoft.educationmanagement.dao.FacilityTypeDAO;
import in.jdsoft.educationmanagement.model.FacilityCategory;
import in.jdsoft.educationmanagement.model.FacilityClassRoom;
import in.jdsoft.educationmanagement.model.FacilityEquipment;
import in.jdsoft.educationmanagement.model.FacilityHostel;
import in.jdsoft.educationmanagement.model.FacilityLaboratory;
import in.jdsoft.educationmanagement.model.FacilityTransport;
import in.jdsoft.educationmanagement.model.FacilityType;

@Service
public class FacilityServices 
{
	
	@Autowired
	FacilityCategoryDAO facilityCategoryDAO;
	@Autowired
	FacilityTypeDAO facilityTypeDAO;
	@Autowired
	FacilityClassRoomDAO facilityClassRoomDAO;
	@Autowired
	FacilityEquipmentDAO facilityEquipmentDAO;
	@Autowired
	FacilityHostelDAO facilityHostelDAO;
	@Autowired
	FacilityLaboratoryDAO facilityLaboratoryDAO;
	@Autowired
	FacilityTransportDAO facilityTransportDAO;
	
		//Facility Category
		@Transactional
		public FacilityCategory getFacilityCategoryById(int facilityCategoryId){
			return facilityCategoryDAO.getFacilityCategoryById(facilityCategoryId);
		}	
		@Transactional
		public ArrayList<FacilityCategory> getFacilityCategoryList(){
			return (ArrayList<FacilityCategory>)facilityCategoryDAO.getList();
		}
	
		//Facility Type
		@Transactional
		public FacilityType getFacilityTypeById(int facilityTypeId){
			return facilityTypeDAO.getFacilityTypeById(facilityTypeId);
		}
		
		@Transactional
		public Set<FacilityType> getFacilityTypesByfacilityCategoryId(int facilityCategoryId){
			try{
				FacilityCategory facilityCategory= facilityCategoryDAO.getFacilityCategoryById(facilityCategoryId);
				Hibernate.initialize(facilityCategory.getFacilityType());
				Set<FacilityType> facilityTypes=facilityCategory.getFacilityType();
				return facilityTypes;
				}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		
		@Transactional
		public ArrayList<FacilityType> getFacilityTypeList(){
			return (ArrayList<FacilityType>)facilityTypeDAO.getList();
		}
		
	
	
		//Facility ClassRoom
		@Transactional
		public void addFacilityClassRoom(FacilityClassRoom facilityClassRoom){
			facilityClassRoomDAO.persist(facilityClassRoom);
		}
	
		@Transactional
		public void deleteFacilityClassRoom(int facilityClassRoomId){
			facilityClassRoomDAO.delete(facilityClassRoomDAO.getFacilityClassRoomById(facilityClassRoomId));
		}
	
		@Transactional
		public void updateFacilityClassRoom(FacilityClassRoom facilityClassRoom){
			facilityClassRoomDAO.update(facilityClassRoom);
		}
	
		@Transactional
		public ArrayList<FacilityClassRoom> getFacilityClassRoomList(){
			return (ArrayList<FacilityClassRoom>)facilityClassRoomDAO.getList();
		}
	
		@Transactional
		public FacilityClassRoom getFacilityClassRoomById(int facilityClassRoomId){
			return facilityClassRoomDAO.getFacilityClassRoomById(facilityClassRoomId);
		}
	
	
		//Facility Equipment
		@Transactional
		public void addFacilityEquipment(FacilityEquipment facilityEquipment){
			facilityEquipmentDAO.persist(facilityEquipment);
		}
		
		@Transactional
		public void deleteFacilityEquipment(int facilityEquipmentId){
			facilityEquipmentDAO.delete(facilityEquipmentDAO.getFacilityEquipmentById(facilityEquipmentId));
		}
		
		@Transactional
		public void updateFacilityEquipment(FacilityEquipment facilityEquipment){
			facilityEquipmentDAO.update(facilityEquipment);
		}
		
		@Transactional
		public ArrayList<FacilityEquipment> getFacilityEquipmentList(){
			return (ArrayList<FacilityEquipment>)facilityEquipmentDAO.getList();
		}
		
		@Transactional
		public FacilityEquipment getFacilityEquipmentById(int facilityEquipmentId){
			return facilityEquipmentDAO.getFacilityEquipmentById(facilityEquipmentId);
		}
		
		
		//Facility Hostel
		@Transactional
		public void addFacilityHostel(FacilityHostel facilityHostel){
			facilityHostelDAO.persist(facilityHostel);
		}
		
		@Transactional
		public void deleteFacilityHostel(int facilityHostelId){
			facilityHostelDAO.delete(facilityHostelDAO.getFacilityHostelById(facilityHostelId));
		}
		
		@Transactional
		public void updateFacilityHostel(FacilityHostel facilityHostel){
			facilityHostelDAO.update(facilityHostel);
		}
		
		@Transactional
		public ArrayList<FacilityHostel> getFacilityHostelList(){
			return (ArrayList<FacilityHostel>)facilityHostelDAO.getList();
		}
		
		@Transactional
		public FacilityHostel getFacilityHostelById(int facilityHostelId){
			return facilityHostelDAO.getFacilityHostelById(facilityHostelId);
		}
		
		
		//Facility Laboratory
		@Transactional
		public void addFacilityLaboratory(FacilityLaboratory facilityLaboratory){
			facilityLaboratoryDAO.persist(facilityLaboratory);
		}
		
		@Transactional
		public void deleteFacilityLaboratory(int facilityLaboratoryId){
			facilityLaboratoryDAO.delete(facilityLaboratoryDAO.getFacilityLaboratoryById(facilityLaboratoryId));
		}
		
		@Transactional
		public void updateFacilityLaboratory(FacilityLaboratory facilityLaboratory){
			facilityLaboratoryDAO.update(facilityLaboratory);
		}
		
		@Transactional
		public ArrayList<FacilityLaboratory> getFacilityLaboratoryList(){
			return (ArrayList<FacilityLaboratory>)facilityLaboratoryDAO.getList();
		}
		
		@Transactional
		public FacilityLaboratory getFacilityLaboratoryById(int facilityLaboratoryId){
			return facilityLaboratoryDAO.getFacilityLaboratoryById(facilityLaboratoryId);
		}
		
		//Facility Transport
		@Transactional
		public void addFacilityTransport(FacilityTransport facilityTransport){
			facilityTransportDAO.persist(facilityTransport);
		}
		
		@Transactional
		public void deleteFacilityTransport(int facilityTransportId){
			facilityTransportDAO.delete(facilityTransportDAO.getFacilityTransportById(facilityTransportId));
		}
		
		@Transactional
		public void updateFacilityTransport(FacilityTransport facilityTransport){
			facilityTransportDAO.update(facilityTransport);
		}
		
		@Transactional
		public ArrayList<FacilityTransport> getFacilityTransportList(){
			return (ArrayList<FacilityTransport>)facilityTransportDAO.getList();
		}
		
		@Transactional
		public FacilityTransport getFacilityTransportById(int facilityTransportId){
			return facilityTransportDAO.getFacilityTransportById(facilityTransportId);
		}
		
	
}
