package in.jdsoft.educationmanagement.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import in.jdsoft.educationmanagement.model.FacilityClassRoom;
import in.jdsoft.educationmanagement.model.FacilityEquipment;
import in.jdsoft.educationmanagement.model.FacilityHostel;
import in.jdsoft.educationmanagement.model.FacilityLaboratory;
import in.jdsoft.educationmanagement.model.FacilityTransport;
import in.jdsoft.educationmanagement.model.FacilityType;
import in.jdsoft.educationmanagement.services.FacilityServices;

@Controller
@RequestMapping("/facilities")
public class FacilitiesController {

	@Autowired
	FacilityServices facilityServices;
	
	@RequestMapping
	public ModelAndView displayFacilityPage(HttpServletRequest request){
		try {
			ModelAndView modelandview=new ModelAndView("facilities");
			modelandview.addObject("facilityCategoryList", facilityServices.getFacilityCategoryList());
			modelandview.addObject("facilityTypeList", facilityServices.getFacilityTypeList());	
			modelandview.addObject("facilityClassRoomList", facilityServices.getFacilityClassRoomList());
			modelandview.addObject("facilityTransportList", facilityServices.getFacilityTransportList());
			modelandview.addObject("facilityLaboratoryList", facilityServices.getFacilityLaboratoryList());
			modelandview.addObject("facilityEquipmentList", facilityServices.getFacilityEquipmentList());
			modelandview.addObject("facilityHostelList", facilityServices.getFacilityHostelList());
			return modelandview;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@RequestMapping(value="facilityType",method=RequestMethod.GET)
	@ResponseBody
	public Set<FacilityType> getFacilityCategoryType(HttpServletRequest request) throws ServletException, IOException 
	{
		try {
			int facilityCategoryId =Integer.parseInt(request.getParameter("facilityCategoryId"));
			Set<FacilityType> facilityType=facilityServices.getFacilityTypesByfacilityCategoryId(facilityCategoryId);
		    return facilityType;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }

	@RequestMapping(value="addClassRoom",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addClassRoom(HttpServletRequest request) throws Exception{
		try{
			Integer facilityTypeId=Integer.parseInt(request.getParameter("facilityTypeId"));
			String classRoomName=request.getParameter("ClassRoomName");
			String classRoomDescription=request.getParameter("ClassRoomDescription");
			String classRoomLocation=request.getParameter("ClassRoomLocation");
			String personResponsible=request.getParameter("PersonResponsible");
			String status=request.getParameter("ClassRoomStatus");
			String classRoomReference1="";
			String classRoomReference2="";
			String classRoomNo=request.getParameter("ClassRoomNo");
			
			Integer noOfSeats=Integer.parseInt(request.getParameter("NoOfSeats"));
			FacilityType facilityType=facilityServices.getFacilityTypeById(facilityTypeId);
			FacilityClassRoom facilityClassRoom=new FacilityClassRoom(classRoomName, classRoomNo, classRoomDescription, noOfSeats, classRoomLocation, status, personResponsible, classRoomReference1, classRoomReference2, facilityType);
			facilityServices.addFacilityClassRoom(facilityClassRoom);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="addLaboratory",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addLaboratory(HttpServletRequest request) throws Exception{
		try{
			Integer facilityTypeId=Integer.parseInt(request.getParameter("facilityTypeId"));
			String laboratoryName=request.getParameter("LaboratoryName");
			String laboratoryNo=request.getParameter("LaboratoryNo");
			String laboratoryDescription=request.getParameter("LaboratoryDescription");
			String laboratoryLocation=request.getParameter("LaboratoryLocation");
			String laboratoryPersonResponsible=request.getParameter("LaboratoryPersonResponsible");
			String laboratorystatus=request.getParameter("LaboratoryStatus");
			String laboratoryReference1="";
			String laboratoryReference2="";
			Integer noOfSeats=Integer.parseInt(request.getParameter("NoofSeats"));
			FacilityType facilityType=facilityServices.getFacilityTypeById(facilityTypeId);
			FacilityLaboratory facilityLaboratory=new FacilityLaboratory(laboratoryName, laboratoryNo, laboratoryDescription, noOfSeats, laboratoryLocation, laboratorystatus, laboratoryPersonResponsible, laboratoryReference1, laboratoryReference2, facilityType);
			facilityServices.addFacilityLaboratory(facilityLaboratory);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="addTransport",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addTransport(HttpServletRequest request) throws Exception{
		
		
		try{
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			Integer facilityTypeId=Integer.parseInt(request.getParameter("facilityTypeId"));
			String transportName=request.getParameter("TransportName");
			String transportNo=request.getParameter("TransportNo");
			String transportRegistrationNumber=request.getParameter("TransportRegistrationNumber");
			String transportVehicleModel=request.getParameter("TransportVehicleModel");
			String transportItemGroup=request.getParameter("TransportItemGroup");
			String transportStatus=request.getParameter("transportStatus");
			String transportRouteName=request.getParameter("TransportRouteName");
			Double transportVehicleCost=Double.parseDouble(request.getParameter("TransportVehicleCost"));
			
			Date transportLicenseRenewalDate=formatter.parse(request.getParameter("TransportLicenseRenewalDate"));
			Date transportInsuranceRenewalDate=formatter.parse(request.getParameter("TransportInsuranceRenewalDate"));
			
			
			
			String transportLocation=request.getParameter("TransportLocation");
			String transportPersonResponsible=request.getParameter("TransportPersonResponsible");
			String transportTallyReference=request.getParameter("TransportTallyReference");
			Integer noOfSeats=Integer.parseInt(request.getParameter("NoOfSeats"));
			FacilityType facilityType=facilityServices.getFacilityTypeById(facilityTypeId);
			FacilityTransport facilityTransport=new FacilityTransport(transportName, transportNo, transportRegistrationNumber, transportVehicleModel, transportItemGroup, transportTallyReference, transportStatus, transportPersonResponsible, noOfSeats, transportRouteName, transportVehicleCost, transportLicenseRenewalDate, transportInsuranceRenewalDate, transportLocation, facilityType);
		facilityServices.addFacilityTransport(facilityTransport);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="addHostel",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addHostel(HttpServletRequest request) throws Exception
	{	
		
		try
		{
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			Integer facilityTypeId=Integer.parseInt(request.getParameter("facilityTypeId"));
			
			String hostelName=request.getParameter("HostelName");
			String hostelNo=request.getParameter("HostelNo");
			String hostelRoomDescription=request.getParameter("HostelRoomDescription");
			String hostelRoomNo=request.getParameter("HostelRoomNo");
			Double hostelChargePerDay=Double.parseDouble(request.getParameter("HostelChargePerDay"));
			String hostelFacilityPersonResponsible=request.getParameter("HostelFacilityPersonResponsible");
			String hostelTallyReference=request.getParameter("HostelTallyReference");
			String hostelReferenceLayout="";
			String hostelReferenceTraiff="";
			Date hostelOccupiedTillDate=formatter.parse(request.getParameter("HostelOccupiedTillDate"));
			
			String hostelStatus=request.getParameter("Hostelstatus");
			Integer noOfSeats=Integer.parseInt(request.getParameter("NoOfSeats"));
			FacilityType facilityType=facilityServices.getFacilityTypeById(facilityTypeId);
			FacilityHostel facilityHostel=new FacilityHostel(hostelName, hostelNo, hostelRoomDescription, hostelRoomNo, hostelTallyReference, hostelStatus, hostelFacilityPersonResponsible, noOfSeats, hostelChargePerDay, hostelReferenceLayout, hostelReferenceTraiff, hostelOccupiedTillDate, facilityType);
			facilityServices.addFacilityHostel(facilityHostel);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@RequestMapping(value="addEquipment",method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void addEquipment(HttpServletRequest request) throws Exception
	{	
		try
		{  
			Integer facilityTypeId=Integer.parseInt(request.getParameter("facilityTypeId"));
			String equipmentName=request.getParameter("EquipmentName");
			String equipmentNo=request.getParameter("EquipmentNo");
			String equipmentDescription=request.getParameter("EquipmentDescription");
			String equipmentPersonResponsible=request.getParameter("EquipmentPersonResponsible");
			String equipmentLocation = request.getParameter("EquipmentLocation");
			String equipmentItemGroup=request.getParameter("EquipmentItemGroup");
			String equipmentTallyReference=request.getParameter("EquipmentTallyReference");
			Double equipmentCost=Double.parseDouble(request.getParameter("EquipmentCost"));
			String equipmentMaintenanceReference="";
			String equipmentOperationReference="";
			String equipmentStatus=request.getParameter("EquipmentStatus");
			Integer equipmentQuantityAvailable=Integer.parseInt(request.getParameter("EquipmentQuantityAvailable"));
			FacilityType facilityType=facilityServices.getFacilityTypeById(facilityTypeId);
			FacilityEquipment facilityEquipment=new FacilityEquipment(equipmentName, equipmentNo, equipmentDescription, equipmentItemGroup, equipmentTallyReference, equipmentStatus, equipmentPersonResponsible, equipmentOperationReference, equipmentMaintenanceReference, equipmentCost, equipmentQuantityAvailable, equipmentLocation, facilityType);
			facilityServices.addFacilityEquipment(facilityEquipment);
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	@RequestMapping(value="deleteClassRoom",method=RequestMethod.GET)
	public String deleteClassRoom(HttpServletRequest request) throws Exception{
		try {
			Integer facilityClassRoomId=Integer.parseInt(request.getParameter("classRoomId"));
			facilityServices.deleteFacilityClassRoom(facilityClassRoomId);
			return "redirect:/facilities";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/facilities";
		}
		
	}
	@RequestMapping(value="deleteTransport",method=RequestMethod.GET)
	public String deleteTransport(HttpServletRequest request) throws Exception{
		try {
			Integer facilityTransportId=Integer.parseInt(request.getParameter("transportId"));
			facilityServices.deleteFacilityTransport(facilityTransportId);
			return "redirect:/facilities";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/facilities";
		}
		
	}
	@RequestMapping(value="deleteLaboratory",method=RequestMethod.GET)
	public String deleteLaboratory(HttpServletRequest request) throws Exception{
		try {
			Integer facilityLaboratoryId=Integer.parseInt(request.getParameter("laboratoryId"));
			facilityServices.deleteFacilityLaboratory(facilityLaboratoryId);
			return "redirect:/facilities";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/facilities";
		}
		
	}
	@RequestMapping(value="deleteHostel",method=RequestMethod.GET)
	public String deleteHostel(HttpServletRequest request) throws Exception{
		try {
			Integer facilityHostelId=Integer.parseInt(request.getParameter("hostelId"));
			facilityServices.deleteFacilityHostel(facilityHostelId);
			return "redirect:/facilities";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/facilities";
		}
		
	}
	@RequestMapping(value="deleteEquipment",method=RequestMethod.GET)
	public String deleteEquipment(HttpServletRequest request) throws Exception{
		try {
			Integer facilityEquipmentId=Integer.parseInt(request.getParameter("equipmentId"));
			facilityServices.deleteFacilityEquipment(facilityEquipmentId);
			return "redirect:/facilities";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/facilities";
		}
		
	}
	
	@RequestMapping(value="editClassRoom")
	@ResponseBody
	public FacilityClassRoom editClassRoom(HttpServletRequest request) 
	{
		try {
			Integer facilityClassRoomId=Integer.parseInt(request.getParameter("ClassRoomId"));
			FacilityClassRoom facilityClassRoom=facilityServices.getFacilityClassRoomById(facilityClassRoomId);
		    return facilityClassRoom;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
    }

	@RequestMapping(value="editTransport")
	@ResponseBody
	public FacilityTransport editTransport(HttpServletRequest request) 
	{
		try {
			Integer facilityTransportId=Integer.parseInt(request.getParameter("TransportId"));
			FacilityTransport facilityTransport=facilityServices.getFacilityTransportById(facilityTransportId);
		    return facilityTransport;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@RequestMapping(value="editLaboratory")
	@ResponseBody
	public FacilityLaboratory editLaboratory(HttpServletRequest request) 
	{
		try {
			Integer facilityLaboratoryId=Integer.parseInt(request.getParameter("laboratoryId"));
			FacilityLaboratory facilityLaboratory=facilityServices.getFacilityLaboratoryById(facilityLaboratoryId);
		    return facilityLaboratory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@RequestMapping(value="editHostel")
	@ResponseBody
	public FacilityHostel editHostel(HttpServletRequest request) 
	{
		try {
			Integer facilityHostelId=Integer.parseInt(request.getParameter("hostelId"));
			FacilityHostel facilityHostel=facilityServices.getFacilityHostelById(facilityHostelId);
		    return facilityHostel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@RequestMapping(value="editEquipment")
	@ResponseBody
	public FacilityEquipment editEquipment(HttpServletRequest request) 
	{
		try {
			Integer facilityEquipmentId=Integer.parseInt(request.getParameter("equipmentId"));
			FacilityEquipment facilityEquipment=facilityServices.getFacilityEquipmentById(facilityEquipmentId);
		    return facilityEquipment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	
	
	@RequestMapping(value="updateClassRoom",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateClassRoom(HttpServletRequest request) throws Exception
	{
		try {
			Integer facilityClassRoomId=Integer.parseInt(request.getParameter("classRoomId"));
			FacilityClassRoom facilityClassRoom=facilityServices.getFacilityClassRoomById(facilityClassRoomId);	
			String editClassRoomName=request.getParameter("EditClassRoomName");
			String editClassRoomDescription=request.getParameter("EditClassRoomDescription");
			String editClassRoomLocation=request.getParameter("EditClassRoomLocation");
			String editPersonResponsible=request.getParameter("EditPersonResponsible");
			String editClassRoomUpdateStatus=request.getParameter("EditClassRoomUpdateStatus");
			String editclassRoomReference1="";
			String editclassRoomReference2="";
			String editClassRoomNo=request.getParameter("EditClassRoomNo");
			Integer editNoOfSeats=Integer.parseInt(request.getParameter("EditNoOfSeats"));
			
			facilityClassRoom.setFacilityName(editClassRoomName);
			facilityClassRoom.setFacilityNo(editClassRoomNo);
			facilityClassRoom.setFacilityDescription(editClassRoomDescription);
			facilityClassRoom.setFacilityLocation(editClassRoomLocation);
			facilityClassRoom.setFacilityPersonResponsible(editPersonResponsible);
			facilityClassRoom.setFacilityStatus(editClassRoomUpdateStatus);
			facilityClassRoom.setReferenceOne(editclassRoomReference1);
			facilityClassRoom.setReferenceTwo(editclassRoomReference2);
			facilityClassRoom.setNoOfSeats(editNoOfSeats);
			facilityServices.updateFacilityClassRoom(facilityClassRoom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	@RequestMapping(value="updateLaboratory",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateLaboratory(HttpServletRequest request) throws Exception
	{
		try {
			Integer facilitylaboratoryId=Integer.parseInt(request.getParameter("laboratoryId"));
			FacilityLaboratory facilityLaboratory=facilityServices.getFacilityLaboratoryById(facilitylaboratoryId);
			String editLaboratoryName=request.getParameter("EditLaboratoryName");
			String editLaboratoryDescription=request.getParameter("EditLaboratoryDescription");
			String editLaboratoryLocation=request.getParameter("EditLaboratoryLocation");
			String editLaboratoryPersonResponsible=request.getParameter("EditLaboratoryPersonResponsible");
			String editLaboratoryStatus=request.getParameter("EditLaboratoryStatus");
			String editLaboratoryReference1="";
			String editLaboratoryReference2="";
			String editLaboratoryNo=request.getParameter("EditLaboratoryNo");
			Integer editNoOfSeats=Integer.parseInt(request.getParameter("EditNoofSeats"));
			
			facilityLaboratory.setFacilityName(editLaboratoryName);
			facilityLaboratory.setFacilityNo(editLaboratoryNo);
			facilityLaboratory.setFacilityDescription(editLaboratoryDescription);
			facilityLaboratory.setFacilityLocation(editLaboratoryLocation);
			facilityLaboratory.setFacilityPersonResponsible(editLaboratoryPersonResponsible);
			facilityLaboratory.setFacilityStatus(editLaboratoryStatus);
			facilityLaboratory.setReferenceOne(editLaboratoryReference1);
			facilityLaboratory.setReferenceTwo(editLaboratoryReference2);
			facilityLaboratory.setNoOfSeats(editNoOfSeats);
			facilityServices.updateFacilityLaboratory(facilityLaboratory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    }
	
	@RequestMapping(value="updateEquipment",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateEquipment(HttpServletRequest request) throws Exception
	{
		try {
			Integer facilityEquipmentId=Integer.parseInt(request.getParameter("equipmentId"));
			FacilityEquipment facilityEquipment=facilityServices.getFacilityEquipmentById(facilityEquipmentId);	
			String editEquipmentName=request.getParameter("EditEquipmentName");
			String editEquipmentDescription=request.getParameter("EditEquipmentDescription");
			String editEquipmentLocation=request.getParameter("EditEquipmentLocation");
			String editEquipmentPersonResponsible=request.getParameter("EditEquipmentPersonResponsible");
			String editEquipmentStatus=request.getParameter("EditEquipmentStatus");
			String editEquipmentMaintenanceReference="";
			String editEquipmentOperationReference="";
			String editEquipmentItemGroup=request.getParameter("EditEquipmentItemGroup");
			String editEquipmentTallyReference=request.getParameter("EditEquipmentTallyReference");
			Double editEquipmentCost=Double.parseDouble(request.getParameter("EditEquipmentCost"));
			String editEquipmentNo=request.getParameter("EditEquipmentNo");
			Integer editEquipmentQuantityAvailable=Integer.parseInt(request.getParameter("EditEquipmentQuantityAvailable"));
			
			facilityEquipment.setFacilityEquipmentName(editEquipmentName);
			facilityEquipment.setFacilityEquipmentDescription(editEquipmentDescription);
			facilityEquipment.setFacilityLocation(editEquipmentLocation);
			facilityEquipment.setFacilityEquipmentPersonResponsible(editEquipmentPersonResponsible);
			facilityEquipment.setFacilityStatus(editEquipmentStatus);
			facilityEquipment.setReferenceMaintenanceDocument(editEquipmentMaintenanceReference);
			facilityEquipment.setReferenceOperationsDocument(editEquipmentOperationReference);
			facilityEquipment.setItemGroup(editEquipmentItemGroup);
			facilityEquipment.setTallyReference(editEquipmentTallyReference);
			facilityEquipment.setTotalCost(editEquipmentCost);
			facilityEquipment.setFacilityEquipmentNo(editEquipmentNo);
			facilityEquipment.setTotalQuantityAvailable(editEquipmentQuantityAvailable);
			facilityServices.updateFacilityEquipment(facilityEquipment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    }
	@RequestMapping(value="updateHostel",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateHostel(HttpServletRequest request) throws Exception
	{
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			Integer facilityHostelId=Integer.parseInt(request.getParameter("hostelId"));
			FacilityHostel facilityHostel=facilityServices.getFacilityHostelById(facilityHostelId);
			
			String editHostelName=request.getParameter("EditHostelName");
			String editHostelRoomDescription=request.getParameter("EditHostelRoomDescription");
			String editHostelFacilityPersonResponsible=request.getParameter("EditHostelFacilityPersonResponsible");
			String editHostelStatus=request.getParameter("EditHostelStatus");
			String editHostelReferenceLayout="";
			String editHostelReferenceTraiff="";
			String editHostelRoomNo=request.getParameter("EditHostelRoomNo");
			String editHostelTallyReference=request.getParameter("EditHostelTallyReference");
			Double editHostelChargePerDay=Double.parseDouble(request.getParameter("EditHostelChargePerDay"));
			String editHostelNo=request.getParameter("EditHostelNo");
			
			Date editHostelOccupiedTillDate=formatter.parse(request.getParameter("EditHostelOccupiedTillDate"));
			
			Integer editNoOfSeats=Integer.parseInt(request.getParameter("EditNoOfSeats"));
			
			
			facilityHostel.setFacilityHostelName(editHostelName);
			facilityHostel.setFacilityHostelRoomDescription(editHostelRoomDescription);
			facilityHostel.setFacilityHostelPersonResponsible(editHostelFacilityPersonResponsible);
			facilityHostel.setFacilityHostelRoomStatus(editHostelStatus);
			facilityHostel.setFacilityHostelReferenceOne(editHostelReferenceLayout);
			facilityHostel.setFacilityHostelReferenceOne(editHostelReferenceTraiff);
			facilityHostel.setFacilityHostelRoomNumber(editHostelRoomNo);
			facilityHostel.setTallyReference(editHostelTallyReference);
			facilityHostel.setChargePerDay(editHostelChargePerDay);
			facilityHostel.setFacilityHostelNo(editHostelNo);
			facilityHostel.setOccupiedTillDate(editHostelOccupiedTillDate);
			facilityHostel.setNoofSeats(editNoOfSeats);
			
			facilityServices.updateFacilityHostel(facilityHostel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
	@RequestMapping(value="updateTransport",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateTransport(HttpServletRequest request) throws Exception
	{
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			Integer facilityTransportId=Integer.parseInt(request.getParameter("transportId"));
			FacilityTransport facilityTransport=facilityServices.getFacilityTransportById(facilityTransportId);
			
			String editTransportName=request.getParameter("EditTransportName");
			String editTransportNo=request.getParameter("EditTransportNo");
			String editTransportRegistrationNumber=request.getParameter("EditTransportRegistrationNumber");
			String editTransportVehicleModel=request.getParameter("EditTransportVehicleModel");
			String editTransportItemGroup=request.getParameter("EditTransportItemGroup");
			String editTransportRouteName=request.getParameter("EditTransportRouteName");
			String editTransportLocation=request.getParameter("EditTransportLocation");
			String editTransportPersonResponsible=request.getParameter("EditTransportPersonResponsible");
			String editTransportTallyReference=request.getParameter("EditTransportTallyReference");
			String editTransportStatus=request.getParameter("EditTransportStatus");
			Double editTransportVehicleCost=Double.parseDouble(request.getParameter("EditTransportVehicleCost"));
			Integer editNoOfSeats=Integer.parseInt(request.getParameter("EditNoOfSeats"));
			Date editTransportLicenseRenewalDate=formatter.parse(request.getParameter("EditTransportLicenseRenewalDate"));
			Date editTransportInsuranceRenewalDate=formatter.parse(request.getParameter("EditTransportInsuranceRenewalDate"));
				
			facilityTransport.setFacilityName(editTransportName);
			facilityTransport.setFacilityNo(editTransportNo);
			facilityTransport.setFacilityTransportRegistrationNumber(editTransportRegistrationNumber);
			facilityTransport.setFacilityTransportVehicleModelDescription(editTransportVehicleModel);
			facilityTransport.setItemGroup(editTransportItemGroup);
			facilityTransport.setRouteName(editTransportRouteName);
			facilityTransport.setFacilityLocation(editTransportLocation);
			facilityTransport.setFacilityTransportPersonResponsible(editTransportPersonResponsible);
			facilityTransport.setTallyReference(editTransportTallyReference);
			facilityTransport.setFacilityStatus(editTransportStatus);
			facilityTransport.setTotalCost(editTransportVehicleCost);
			facilityTransport.setNoofSeats(editNoOfSeats);
			facilityTransport.setLicenseRenewalDate(editTransportLicenseRenewalDate);
			facilityTransport.setInsuranceRenewalDate(editTransportInsuranceRenewalDate);
			facilityServices.updateFacilityTransport(facilityTransport);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    }
	
	
	
	
}
