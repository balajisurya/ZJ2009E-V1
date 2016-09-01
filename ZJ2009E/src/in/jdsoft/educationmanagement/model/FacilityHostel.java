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
@Table(name = "tbl_facility_hostel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacilityHostel implements java.io.Serializable {

	public FacilityHostel(String facilityHostelName, String facilityHostelNo, String facilityHostelRoomDescription,
			String facilityHostelRoomNumber, String tallyReference, String facilityHostelRoomStatus,
			String facilityHostelPersonResponsible, Integer noofSeats, Double chargePerDay,
			String facilityHostelReferenceOne, String facilityHostelReferenceTwo, Date occupiedTillDate,
			FacilityType facilityType) {
		this.facilityHostelName = facilityHostelName;
		this.facilityHostelNo = facilityHostelNo;
		this.facilityHostelRoomDescription = facilityHostelRoomDescription;
		this.facilityHostelRoomNumber = facilityHostelRoomNumber;
		this.tallyReference = tallyReference;
		this.facilityHostelRoomStatus = facilityHostelRoomStatus;
		this.facilityHostelPersonResponsible = facilityHostelPersonResponsible;
		this.noofSeats = noofSeats;
		this.chargePerDay = chargePerDay;
		this.facilityHostelReferenceOne = facilityHostelReferenceOne;
		this.facilityHostelReferenceTwo = facilityHostelReferenceTwo;
		this.occupiedTillDate = occupiedTillDate;
		this.facilityType = facilityType;
	}
	public FacilityHostel() {
		
	}
	
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer facilityHostelId;
	private String facilityHostelName;
	private String facilityHostelNo;
	private String facilityHostelRoomDescription;
	private String facilityHostelRoomNumber;
	private String tallyReference;
	private String facilityHostelRoomStatus;
	private String facilityHostelPersonResponsible;
	private Integer noofSeats;
	private Double chargePerDay;
	private String facilityHostelReferenceOne;
	private String facilityHostelReferenceTwo;
	private Date occupiedTillDate;
	
	//models
	
	private FacilityType facilityType;
	
	
	
	
	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facility_hostel_id", unique = true, nullable = false)
	public Integer getFacilityHostelId() {
		return facilityHostelId;
	}
	public void setFacilityHostelId(Integer facilityHostelId) {
		this.facilityHostelId = facilityHostelId;
	}
	
	//Single Fields
	
	@Column(name = "facility_hostel_name", nullable = false, length = 30)
	public String getFacilityHostelName() {
		return facilityHostelName;
	}
	public void setFacilityHostelName(String facilityHostelName) {
		this.facilityHostelName = facilityHostelName;
	}
	@Column(name = "facility_hostel_No", nullable = false, length = 30)
	public String getFacilityHostelNo() {
		return facilityHostelNo;
	}
	public void setFacilityHostelNo(String facilityHostelNo) {
		this.facilityHostelNo = facilityHostelNo;
	}
	
	@Column(name = "facility_hostel_room_description",nullable = false, length = 30)
	public String getFacilityHostelRoomDescription() {
		return facilityHostelRoomDescription;
	}
	public void setFacilityHostelRoomDescription(String facilityHostelRoomDescription) {
		this.facilityHostelRoomDescription = facilityHostelRoomDescription;
	}
	@Column(name = "hostel_room_no", nullable = false, length = 20)
	public String getFacilityHostelRoomNumber() {
		return facilityHostelRoomNumber;
	}
	public void setFacilityHostelRoomNumber(String facilityHostelRoomNumber) {
		this.facilityHostelRoomNumber = facilityHostelRoomNumber;
	}
	@Column(name = "tally_reference", nullable = false, length = 20)
	public String getTallyReference() {
		return tallyReference;
	}
	public void setTallyReference(String tallyReference) {
		this.tallyReference = tallyReference;
	}
	@Column(name = "hostel_room_status", nullable = false, length = 20)
	public String getFacilityHostelRoomStatus() {
		return facilityHostelRoomStatus;
	}
	public void setFacilityHostelRoomStatus(String facilityHostelRoomStatus) {
		this.facilityHostelRoomStatus = facilityHostelRoomStatus;
	}
	@Column(name = "reference_hostel_person_responsible", nullable = false, length = 30)
	public String getFacilityHostelPersonResponsible() {
		return facilityHostelPersonResponsible;
	}
	public void setFacilityHostelPersonResponsible(String facilityHostelPersonResponsible) {
		this.facilityHostelPersonResponsible = facilityHostelPersonResponsible;
	}
	
	@Column(name = "hostel_no_of_seats", nullable = false)
	public Integer getNoofSeats() {
		return noofSeats;
	}
	public void setNoofSeats(Integer noofSeats) {
		this.noofSeats = noofSeats;
	}
	
	@Column(name = "charge_per_day", nullable = false)
	public Double getChargePerDay() {
		return chargePerDay;
	}
	public void setChargePerDay(Double chargePerDay) {
		this.chargePerDay = chargePerDay;
	}
	
	@Column(name = "hostel_reference_one", nullable = false, length = 30)
	public String getFacilityHostelReferenceOne() {
		return facilityHostelReferenceOne;
	}
	public void setFacilityHostelReferenceOne(String facilityHostelReferenceOne) {
		this.facilityHostelReferenceOne = facilityHostelReferenceOne;
	}
	@Column(name = "hostel_reference_two", nullable = false, length = 30)
	public String getFacilityHostelReferenceTwo() {
		return facilityHostelReferenceTwo;
	}
	public void setFacilityHostelReferenceTwo(String facilityHostelReferenceTwo) {
		this.facilityHostelReferenceTwo = facilityHostelReferenceTwo;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "room_occupied_till_date", nullable = true)
	public Date getOccupiedTillDate() {
		return occupiedTillDate;
	}
	public void setOccupiedTillDate(Date occupiedTillDate) {
		this.occupiedTillDate = occupiedTillDate;
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