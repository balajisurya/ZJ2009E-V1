package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_facility_transport")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacilityTransport implements java.io.Serializable {

	
	public FacilityTransport(String facilityName, String facilityNo, String facilityTransportRegistrationNumber,
			String facilityTransportVehicleModelDescription, String itemGroup, String tallyReference,
			String facilityStatus, String facilityTransportPersonResponsible, Integer noofSeats, String routeName,
			Double totalCost, Date licenseRenewalDate, Date insuranceRenewalDate, String facilityLocation,
			FacilityType facilityType) {
		this.facilityName = facilityName;
		this.facilityNo = facilityNo;
		this.facilityTransportRegistrationNumber = facilityTransportRegistrationNumber;
		this.facilityTransportVehicleModelDescription = facilityTransportVehicleModelDescription;
		this.itemGroup = itemGroup;
		this.tallyReference = tallyReference;
		this.facilityStatus = facilityStatus;
		this.facilityTransportPersonResponsible = facilityTransportPersonResponsible;
		this.noofSeats = noofSeats;
		this.routeName = routeName;
		this.totalCost = totalCost;
		this.licenseRenewalDate = licenseRenewalDate;
		this.insuranceRenewalDate = insuranceRenewalDate;
		this.facilityLocation = facilityLocation;
		this.facilityType = facilityType;
	}
	public FacilityTransport() {
		// TODO Auto-generated constructor stub
	}

private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer facilityTransportId;
	private String facilityName;
	private String facilityNo;
	private String facilityTransportRegistrationNumber;
	private String facilityTransportVehicleModelDescription;
	private String itemGroup;
	private String tallyReference;
	private String facilityStatus;
	private String facilityTransportPersonResponsible;
	private Integer noofSeats;
	private String routeName;
	private Double totalCost;
	private Date licenseRenewalDate;
	private Date insuranceRenewalDate;
	private String facilityLocation;
	
	//models
	
	private FacilityType facilityType;
	
	
	
	
	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facility_transport_id", unique = true, nullable = false)
	public Integer getFacilityTransportId() {
		return facilityTransportId;
	}
	public void setFacilityTransportId(Integer facilityTransportId) {
		this.facilityTransportId = facilityTransportId;
	}
	
	//Single Fields
	@Column(name = "facility_name", nullable = false, length = 70)
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	@Column(name = "facility_no", nullable = false, length = 70)
	public String getFacilityNo() {
		return facilityNo;
	}
	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}
	@Column(name = "facility_transport_registration_no", nullable = false, length = 70)
	public String getFacilityTransportRegistrationNumber() {
		return facilityTransportRegistrationNumber;
	}
	public void setFacilityTransportRegistrationNumber(String facilityTransportRegistrationNumber) {
		this.facilityTransportRegistrationNumber = facilityTransportRegistrationNumber;
	}
	
	@Column(name = "facility_transport_vehicle_model_description",nullable = false, length = 150)
	public String getFacilityTransportVehicleModelDescription() {
		return facilityTransportVehicleModelDescription;
	}
	public void setFacilityTransportVehicleModelDescription(String facilityTransportVehicleModelDescription) {
		this.facilityTransportVehicleModelDescription = facilityTransportVehicleModelDescription;
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
	@Column(name = "reference_transport_person_responsible", nullable = false, length = 30)
	public String getFacilityTransportPersonResponsible() {
		return facilityTransportPersonResponsible;
	}
	public void setFacilityTransportPersonResponsible(String facilityTransportPersonResponsible) {
		this.facilityTransportPersonResponsible = facilityTransportPersonResponsible;
	}
	
	@Column(name = "total_cost", nullable = false)
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	@Column(name = "transport_no_of_seats", nullable = false, length = 10)
	public Integer getNoofSeats() {
		return noofSeats;
	}
	public void setNoofSeats(Integer noofSeats) {
		this.noofSeats = noofSeats;
	}
	@Column(name = "route_name", nullable = false, length = 50)
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "license_renewal_date", nullable = true)
	public Date getLicenseRenewalDate() {
		return licenseRenewalDate;
	}
	
	public void setLicenseRenewalDate(Date licenseRenewalDate) {
		this.licenseRenewalDate = licenseRenewalDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insurance_renewal_date", nullable = true)
	public Date getInsuranceRenewalDate() {
		return insuranceRenewalDate;
	}
	public void setInsuranceRenewalDate(Date insuranceRenewalDate) {
		this.insuranceRenewalDate = insuranceRenewalDate;
	}
	@Column(name = "transport_facility_location", nullable = false, length = 30)
	public String getFacilityLocation() {
		return facilityLocation;
	}
	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}
	
	
	
	//Mappings
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_type_id",nullable=false)
	public FacilityType getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}
	
	
	
}