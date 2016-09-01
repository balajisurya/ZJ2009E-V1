package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
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
@Table(name = "tbl_staff_leave_requisition")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffLeaveRequisition implements Serializable{

	public StaffLeaveRequisition(StaffLeaveType staffLeaveType, String staffLeaveReason, Staff staff,Users leaveApprover,
			String approvalStatus, Date staffLeaveStartDate, Date staffLeaveEndDate) {
		this.staffLeaveType = staffLeaveType;
		this.staffLeaveReason = staffLeaveReason;
		this.staff = staff;
		this.leaveApprover = leaveApprover;
		this.approvalStatus = approvalStatus;
		this.staffLeaveStartDate = staffLeaveStartDate;
		this.staffLeaveEndDate = staffLeaveEndDate;
		this.approvedBy ="Pending";
		this.createdDate =new Timestamp(Calendar.getInstance().getTime().getTime());
		
	}
	
	public StaffLeaveRequisition() {}
	
	private static final long serialVersionUID = 1L;
	
	private Integer staffLeaveRequisitionId;
	private StaffLeaveType staffLeaveType;
	private String staffLeaveReason;
	private Staff staff;
	private Users leaveApprover;
	private String approvalStatus;
	private Date staffLeaveStartDate;
	private Date staffLeaveEndDate;
	private String approvedBy;
	private Date createdDate;
	private Date modifiedDate;
		
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_leave_requisition_id", nullable = false)
	public Integer getStaffLeaveRequisitionId() {
		return staffLeaveRequisitionId;
	}
	public void setStaffLeaveRequisitionId(Integer staffLeaveRequisitionId) {
		this.staffLeaveRequisitionId = staffLeaveRequisitionId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_leave_type_id", nullable = false)
	public StaffLeaveType getStaffLeaveType() {
		return staffLeaveType;
	}
	
	public void setStaffLeaveType(StaffLeaveType staffLeaveType) {
		this.staffLeaveType = staffLeaveType;
	}
	
	@Column(name = "staff_leave_reason", nullable = false)
	public String getStaffLeaveReason() {
		return staffLeaveReason;
	}
	public void setStaffLeaveReason(String staffLeaveReason) {
		this.staffLeaveReason = staffLeaveReason;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
	
	@Column(name = "approval_status", nullable = false)
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "leave_start_date", nullable =false)
	public Date getStaffLeaveStartDate() {
		return staffLeaveStartDate;
	}
	public void setStaffLeaveStartDate(Date staffLeaveStartDate) {
		this.staffLeaveStartDate = staffLeaveStartDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "leave_end_date", nullable =false)
	public Date getStaffLeaveEndDate() {
		return staffLeaveEndDate;
	}
	public void setStaffLeaveEndDate(Date staffLeaveEndDate) {
		this.staffLeaveEndDate = staffLeaveEndDate;
	}
	
	@Column(name = "approval_by", nullable =false)
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable =false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable =false,columnDefinition="timestamp")
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "approver_id", nullable = false,referencedColumnName="user_id")
	public Users getLeaveApprover() {
		return leaveApprover;
	}
	public void setLeaveApprover(Users leaveApprover) {
		this.leaveApprover = leaveApprover;
	}
	
}
