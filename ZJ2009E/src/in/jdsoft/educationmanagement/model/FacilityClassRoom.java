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
@Table(name = "tbl_facility_class_room")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacilityClassRoom implements java.io.Serializable {

	public FacilityClassRoom(String facilityName, String facilityNo, String facilityDescription, Integer noOfSeats,
			String facilityLocation, String facilityStatus, String facilityPersonResponsible, String referenceOne,
			String referenceTwo, FacilityType facilityType) {
		this.facilityName = facilityName;
		this.facilityNo = facilityNo;
		this.facilityDescription = facilityDescription;
		this.noOfSeats = noOfSeats;
		this.facilityLocation = facilityLocation;
		this.facilityStatus = facilityStatus;
		this.facilityPersonResponsible = facilityPersonResponsible;
		this.referenceOne = referenceOne;
		this.referenceTwo = referenceTwo;
		this.facilityType = facilityType;
	}
public FacilityClassRoom() {
		// TODO Auto-generated constructor stub
	}



private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer facilityClassRoomId;
	private String facilityName;
	private String facilityNo;
	private String facilityDescription;
	private Integer noOfSeats;
	private String facilityLocation;
	private String facilityStatus;
	private String facilityPersonResponsible;
	private String referenceOne;
	private String referenceTwo;
	//models
	
	private FacilityType facilityType;
	
	
	
	
	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facility_class_room_id", unique = true, nullable = false)
	public Integer getFacilityClassRoomId() {
		return facilityClassRoomId;
	}
	public void setFacilityClassRoomId(Integer facilityClassRoomId) {
		this.facilityClassRoomId = facilityClassRoomId;
	}
	//Single Fields


	@Column(name = "facility_name", nullable = false, length = 50)
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	@Column(name = "facility_no", nullable = false, length = 50)
	public String getFacilityNo() {
		return facilityNo;
	}
	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}
	
	@Column(name = "facility_description",nullable = false, length = 255)
	public String getFacilityDescription() {
		return facilityDescription;
	}
	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}

	@Column(name = "no_of_seats", nullable = false)
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	@Column(name = "facility_location",nullable = false, length = 150)
	public String getFacilityLocation() {
		return facilityLocation;
	}
	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}
	@Column(name = "facility_person_responsible", nullable = false, length = 100)
	public String getFacilityPersonResponsible() {
		return facilityPersonResponsible;
	}
	public void setFacilityPersonResponsible(String facilityPersonResponsible) {
		this.facilityPersonResponsible = facilityPersonResponsible;
	}
	
	@Column(name = "facility_status", nullable = false, length = 20)
	public String getFacilityStatus() {
		return facilityStatus;
	}
	public void setFacilityStatus(String facilityStatus) {
		this.facilityStatus = facilityStatus;
	}
	@Column(name = "facility_reference_one", nullable = false, length = 120)
	public String getReferenceOne() {
		return referenceOne;
	}
	public void setReferenceOne(String referenceOne) {
		this.referenceOne = referenceOne;
	}
	@Column(name = "facility_reference_two", nullable = false, length = 120)
	public String getReferenceTwo() {
		return referenceTwo;
	}
	public void setReferenceTwo(String referenceTwo) {
		this.referenceTwo = referenceTwo;
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
