package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_facility_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacilityType implements java.io.Serializable {

	private Set<FacilityClassRoom> facilityClassRoom=new HashSet<FacilityClassRoom>(0);
	private Set<FacilityLaboratory> facilityLaboratory=new HashSet<FacilityLaboratory>(0);
	private Set<FacilityEquipment> facilityEquipment=new HashSet<FacilityEquipment>(0);
	private Set<FacilityTransport> facilityTransport=new HashSet<FacilityTransport>(0);
	private Set<FacilityHostel> facilityHostel=new HashSet<FacilityHostel>(0);
	
	public FacilityType(String facilityTypeName, FacilityCategory facilityCategory) {
		
		this.facilityTypeName = facilityTypeName;
		this.setFacilityCategory(facilityCategory);
	}


	public FacilityType()
	{}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facility_type_id", unique = true, nullable = false)
	public Integer getFacilitytypeId() {
		return facilitytypeId;
	}
	public void setFacilitytypeId(Integer facilitytypeId) {
		this.facilitytypeId = facilitytypeId;
	}
	
	@Column(name = "facility_type_name", unique = true, nullable = false)
	public String getFacilityTypeName() {
		return facilityTypeName;
	}
	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}
	
	//Mapping
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_category_id", nullable=false)
	@JsonManagedReference
	public FacilityCategory getFacilityCategory() {
		return facilityCategory;
	}
	public void setFacilityCategory(FacilityCategory facilityCategory) {
		this.facilityCategory = facilityCategory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityType")
	public Set<FacilityClassRoom> getFacilityClassRoom() {
		return facilityClassRoom;
	}
	public void setFacilityClassRoom(Set<FacilityClassRoom> facilityClassRoom) {
		this.facilityClassRoom = facilityClassRoom;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityType")
	public Set<FacilityLaboratory> getFacilityLaboratory() {
		return facilityLaboratory;
	}	
	public void setFacilityLaboratory(Set<FacilityLaboratory> facilityLaboratory) {
		this.facilityLaboratory = facilityLaboratory;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityType")
	public Set<FacilityEquipment> getFacilityEquipment() {
		return facilityEquipment;
	}
	public void setFacilityEquipment(Set<FacilityEquipment> facilityEquipment) {
		this.facilityEquipment = facilityEquipment;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityType")
	public Set<FacilityTransport> getFacilityTransport() {
		return facilityTransport;
	}
	public void setFacilityTransport(Set<FacilityTransport> facilityTransport) {
		this.facilityTransport = facilityTransport;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityType")
	public Set<FacilityHostel> getFacilityHostel() {
		return facilityHostel;
	}
	public void setFacilityHostel(Set<FacilityHostel> facilityHostel) {
		this.facilityHostel = facilityHostel;
	}

	private static final long serialVersionUID = 1L;
	
	//PK
	private Integer facilitytypeId;
	
	//Single Fields
	private String facilityTypeName;
	private FacilityCategory facilityCategory;
	

}
