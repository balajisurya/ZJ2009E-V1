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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_staff_types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffTypes implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer staffTypeId;
	private String staffTypeTitle;
	private int staffTypeVisible;
	
    private Set<Staff> staffs=new HashSet<>(0);
    private Set<StaffCategories> staffCategories=new HashSet<StaffCategories>();
	
	public StaffTypes() {
	}

	public StaffTypes(String staffTypeTitle, int staffTypeVisible) {
		this.staffTypeTitle = staffTypeTitle;
		this.staffTypeVisible = staffTypeVisible;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "staff_type_id", nullable = false)
	public Integer getStaffTypeId() {
		return this.staffTypeId;
	}

	public void setStaffTypeId(Integer staffTypeId) {
		this.staffTypeId = staffTypeId;
	}

	@Column(name = "staff_type_title", nullable = false, length = 100)
	public String getStaffTypeTitle() {
		return this.staffTypeTitle;
	}

	public void setStaffTypeTitle(String staffTypeTitle) {
		this.staffTypeTitle = staffTypeTitle;
	}

	@Column(name = "staff_type_visible", nullable = false)
	public int getStaffTypeVisible() {
		return this.staffTypeVisible;
	}

	public void setStaffTypeVisible(int staffTypeVisible) {
		this.staffTypeVisible = staffTypeVisible;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffType")
	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffType")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffType")
	public Set<StaffCategories> getStaffCategories() {
		return staffCategories;
	}

	public void setStaffCategories(Set<StaffCategories> staffCategories) {
		this.staffCategories = staffCategories;
	}

}
