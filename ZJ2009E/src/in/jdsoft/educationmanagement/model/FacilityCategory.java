package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_facility_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacilityCategory implements java.io.Serializable {

	public FacilityCategory() {}
	
	
	
	public FacilityCategory(String facilityCategoryName) {
		this.facilityCategoryName = facilityCategoryName;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "facility_category_id", unique = true, nullable = false)
	public Integer getFacilityCategoryId() {
		return facilityCategoryId;
	}
	public void setFacilityCategoryId(Integer facilityCategoryId) {
		this.facilityCategoryId = facilityCategoryId;
	}
	@Column(name = "facility_category_name", unique = true, nullable = false)
	public String getFacilityCategoryName() {
		return facilityCategoryName;
	}
	public void setFacilityCategoryName(String facilityCategoryName) {
		this.facilityCategoryName = facilityCategoryName;
	}
	
	//Mapping
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityCategory")
	@JsonBackReference
	public Set<FacilityType> getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(Set<FacilityType> facilityType) {
		this.facilityType = facilityType;
	}

	private static final long serialVersionUID = 1L;

	
	//PK
	private Integer facilityCategoryId;
	
	//Single
	private String facilityCategoryName;
	
	private Set<FacilityType> facilityType=new HashSet<FacilityType>(0);
}
