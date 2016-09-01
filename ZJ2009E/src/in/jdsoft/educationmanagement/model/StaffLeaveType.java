package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_staff_leave_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffLeaveType implements Serializable{

	private static final long serialVersionUID = 1L;
	
  public StaffLeaveType() {}
  
	public StaffLeaveType(String staffLeaveType) {
		this.staffLeaveType = staffLeaveType;
	}
	
	private Integer staffLeaveTypeId;
	private String staffLeaveType;
	private Set<StaffLeaveRequisition> staffLeaveRequisitions=new HashSet<StaffLeaveRequisition>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_leave_type_id", nullable = false)
	public Integer getStaffLeaveTypeId() {
		return staffLeaveTypeId;
	}
	public void setStaffLeaveTypeId(Integer staffLeaveTypeId) {
		this.staffLeaveTypeId = staffLeaveTypeId;
	}
	
	@Column(name = "staff_leave_type", nullable = false, length = 25)
	public String getStaffLeaveType() {
		return staffLeaveType;
	}
	public void setStaffLeaveType(String staffLeaveType) {
		this.staffLeaveType = staffLeaveType;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffLeaveType")
	public Set<StaffLeaveRequisition> getStaffLeaveRequisitions() {
		return staffLeaveRequisitions;
	}
	public void setStaffLeaveRequisitions(Set<StaffLeaveRequisition> staffLeaveRequisitions) {
		this.staffLeaveRequisitions = staffLeaveRequisitions;
	}
}
