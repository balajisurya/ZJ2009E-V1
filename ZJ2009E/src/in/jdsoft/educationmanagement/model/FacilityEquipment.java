package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_facility_equipment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacilityEquipment implements java.io.Serializable {

	public FacilityEquipment(String facilityEquipmentName, String facilityEquipmentNo,
			String facilityEquipmentDescription, String itemGroup, String tallyReference, String facilityStatus,
			String facilityEquipmentPersonResponsible, String referenceOperationsDocument,
			String referenceMaintenanceDocument, Double totalCost, Integer totalQuantityAvailable,
			String facilityLocation, FacilityType facilityType) {
		this.facilityEquipmentName = facilityEquipmentName;
		this.facilityEquipmentNo = facilityEquipmentNo;
		this.facilityEquipmentDescription = facilityEquipmentDescription;
		this.itemGroup = itemGroup;
		this.tallyReference = tallyReference;
		this.facilityStatus = facilityStatus;
		this.facilityEquipmentPersonResponsible = facilityEquipmentPersonResponsible;
		this.referenceOperationsDocument = referenceOperationsDocument;
		this.referenceMaintenanceDocument = referenceMaintenanceDocument;
		this.totalCost = totalCost;
		this.totalQuantityAvailable = totalQuantityAvailable;
		this.facilityLocation = facilityLocation;
		this.facilityType = facilityType;
	}
	public FacilityEquipment() {
		// TODO Auto-generated constructor stub
	}

	
	
	
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer facilityEquipmentId;
	private String facilityEquipmentName;
	private String facilityEquipmentNo;
	private String facilityEquipmentDescription;
	private String itemGroup;
	private String tallyReference;
	private String facilityStatus;
	private String facilityEquipmentPersonResponsible;
	private String referenceOperationsDocument;
	private String referenceMaintenanceDocument;
	private Double totalCost;
	private Integer totalQuantityAvailable;
	private String facilityLocation;
	
	//models
	
	private FacilityType facilityType;
	
	
	
	
	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facility_equipment_id", unique = true, nullable = false)
	public Integer getFacilityEquipmentId() {
		return facilityEquipmentId;
	}
	public void setFacilityEquipmentId(Integer facilityEquipmentId) {
		this.facilityEquipmentId = facilityEquipmentId;
	}
	
	//Single Fields


	@Column(name = "facility_equipment_name", nullable = false, length = 70)
	public String getFacilityEquipmentName() {
		return facilityEquipmentName;
	}
	public void setFacilityEquipmentName(String facilityEquipmentName) {
		this.facilityEquipmentName = facilityEquipmentName;
	}
	
	@Column(name = "facility_equipment_no", nullable = false, length = 50)
	public String getFacilityEquipmentNo() {
		return facilityEquipmentNo;
	}
	public void setFacilityEquipmentNo(String facilityEquipmentNo) {
		this.facilityEquipmentNo = facilityEquipmentNo;
	}
	
	@Column(name = "facility_equipment_description",nullable = false, length = 255)
	public String getFacilityEquipmentDescription() {
		return facilityEquipmentDescription;
	}
	public void setFacilityEquipmentDescription(String facilityEquipmentDescription) {
		this.facilityEquipmentDescription = facilityEquipmentDescription;
	}
	@Column(name = "facility_equipment_location",nullable = false, length = 150)
	public String getFacilityLocation() {
		return facilityLocation;
	}
	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}
	@Column(name = "facility_equipment_person_responsible", nullable = false, length = 100)
	public String getFacilityEquipmentPersonResponsible() {
		return facilityEquipmentPersonResponsible;
	}
	public void setFacilityEquipmentPersonResponsible(String facilityEquipmentPersonResponsible) {
		this.facilityEquipmentPersonResponsible = facilityEquipmentPersonResponsible;
	}
	
	@Column(name = "facility_status", nullable = false, length = 20)
	public String getFacilityStatus() {
		return facilityStatus;
	}
	public void setFacilityStatus(String facilityStatus) {
		this.facilityStatus = facilityStatus;
	}
	@Column(name = "item_group", nullable = false, length = 20)
	public String getItemGroup() {
		return itemGroup;
	}
	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}
	@Column(name = "tally_reference", nullable = false, length = 30)
	public String getTallyReference() {
		return tallyReference;
	}
	public void setTallyReference(String tallyReference) {
		this.tallyReference = tallyReference;
	}
	@Column(name = "reference_operation_document", nullable = false, length = 70)
	public String getReferenceOperationsDocument() {
		return referenceOperationsDocument;
	}
	public void setReferenceOperationsDocument(String referenceOperationsDocument) {
		this.referenceOperationsDocument = referenceOperationsDocument;
	}
	@Column(name = "total_cost", nullable = false)
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	@Column(name = "reference_maintenance_document", nullable = false, length = 70)
	public String getReferenceMaintenanceDocument() {
		return referenceMaintenanceDocument;
	}
	public void setReferenceMaintenanceDocument(String referenceMaintenanceDocument) {
		this.referenceMaintenanceDocument = referenceMaintenanceDocument;
	}
	@Column(name = "total_quantity_available", nullable = false)
	public Integer getTotalQuantityAvailable() {
		return totalQuantityAvailable;
	}
	public void setTotalQuantityAvailable(Integer totalQuantityAvailable) {
		this.totalQuantityAvailable = totalQuantityAvailable;
	}
	
	
	//Mappings
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_type_id", nullable=false)
	public FacilityType getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}


}