package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_staff_categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffCategories implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer staffCategoryId;
	private String staffCategoryName;
	private StaffTypes staffType;
	private int staffCategoryVisible;
	private Date staffCategoryCreatedDate;
	private String staffCategoryCreatedBy;
	private Date staffCategoryLastModified;
	private String staffCategoryLastModifiedBy;
	private MasterUserType masterUserType;
	
	private Set<Staff> staffs=new HashSet<>(0);

	public StaffCategories() {
	}

	public StaffCategories(String staffCategoryName, StaffTypes staffType, int staffCategoryVisible,
		 String staffCategoryCreatedBy,String staffCategoryLastModifiedBy,MasterUserType masterUserType) {
		this.staffCategoryName = staffCategoryName;
		this.staffType = staffType;
		this.staffCategoryVisible = staffCategoryVisible;
		this.staffCategoryCreatedDate =new Date(Calendar.getInstance().getTime().getTime());
		this.staffCategoryCreatedBy = staffCategoryCreatedBy;
		this.staffCategoryLastModifiedBy = staffCategoryLastModifiedBy;
		this.masterUserType=masterUserType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "staff_category_id", nullable = false)
	public Integer getStaffCategoryId() {
		return this.staffCategoryId;
	}

	public void setStaffCategoryId(Integer staffCategoryId) {
		this.staffCategoryId = staffCategoryId;
	}

	@Column(name = "staff_category_name", nullable = false, length = 100)
	public String getStaffCategoryName() {
		return this.staffCategoryName;
	}

	public void setStaffCategoryName(String staffCategoryName) {
		this.staffCategoryName = staffCategoryName;
	}

	

	@Column(name = "staff_category_visible", nullable = false)
	public int getStaffCategoryVisible() {
		return this.staffCategoryVisible;
	}

	public void setStaffCategoryVisible(int staffCategoryVisible) {
		this.staffCategoryVisible = staffCategoryVisible;
	}

	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "staff_category_created_date", nullable = false, length = 19)
	public Date getStaffCategoryCreatedDate() {
		return this.staffCategoryCreatedDate;
	}

	public void setStaffCategoryCreatedDate(Date staffCategoryCreatedDate) {
		this.staffCategoryCreatedDate = staffCategoryCreatedDate;
	}

	@Column(name = "staff_category_created_by", nullable = false, length = 100)
	public String getStaffCategoryCreatedBy() {
		return this.staffCategoryCreatedBy;
	}

	public void setStaffCategoryCreatedBy(String staffCategoryCreatedBy) {
		this.staffCategoryCreatedBy = staffCategoryCreatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "staff_category_last_modified", nullable = false,columnDefinition="timestamp")
	public Date getStaffCategoryLastModified() {
		return this.staffCategoryLastModified;
	}

	public void setStaffCategoryLastModified(Date staffCategoryLastModified) {
		this.staffCategoryLastModified = staffCategoryLastModified;
	}

	@Column(name = "staff_category_last_modified_by", nullable = false, length = 100)
	public String getStaffCategoryLastModifiedBy() {
		return this.staffCategoryLastModifiedBy;
	}

	public void setStaffCategoryLastModifiedBy(String staffCategoryLastModifiedBy) {
		this.staffCategoryLastModifiedBy = staffCategoryLastModifiedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffCategory")
	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_type_id", nullable = false)
	public StaffTypes getStaffType() {
		return staffType;
	}

	public void setStaffType(StaffTypes staffType) {
		this.staffType = staffType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_roles", nullable = false,referencedColumnName="type_id")
	public MasterUserType getMasterUserType() {
		return masterUserType;
	}

	public void setMasterUserType(MasterUserType masterUserType) {
		this.masterUserType = masterUserType;
	}

}
