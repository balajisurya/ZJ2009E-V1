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
@Table(name = "tbl_staff_attendance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffAttendance implements java.io.Serializable {

	public StaffAttendance(Staff staff, StaffAttendanceType staffAttendanceType, String staffAttendanceRemarks,
			Date staffAttendanceCreatedDate,String staffAttendanceCreatedBy,String staffAttendanceLastModifiedBy) {
		this.staff = staff;
		this.staffAttendanceType = staffAttendanceType;
		this.staffAttendanceRemarks = staffAttendanceRemarks;
		this.staffAttendanceCreatedBy = staffAttendanceCreatedBy;
		this.staffAttendanceLastModifiedBy = staffAttendanceLastModifiedBy;
		this.staffAttendanceCreatedDate=staffAttendanceCreatedDate;
	}
	
	public StaffAttendance()
	{
		
	}
	private static final long serialVersionUID = 1L;
	
	
	private Integer staffAttendanceId;
	private Staff staff;
	private StaffAttendanceType staffAttendanceType;
	private String staffAttendanceRemarks;
	private Date staffAttendanceCreatedDate;
	private Date staffAttendanceModifiedDate;
	private String staffAttendanceCreatedBy;
	private String staffAttendanceLastModifiedBy;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "staff_attendance_id",nullable = false)
	public Integer getStaffAttendanceId() {
		return staffAttendanceId;
	}
	public void setStaffAttendanceId(Integer staffAttendanceId) {
		this.staffAttendanceId = staffAttendanceId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff tblStaff) {
		this.staff = tblStaff;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_attendance_type_id", nullable = false)
	public StaffAttendanceType getStaffAttendanceType() {
		return staffAttendanceType;
	}
	public void setStaffAttendanceType(StaffAttendanceType staffAttendanceType) {
		this.staffAttendanceType = staffAttendanceType;
	}
	
	@Column(name = "staff_attendance_remarks", nullable = false, length = 100)
	public String getStaffAttendanceRemarks() {
		return staffAttendanceRemarks;
	}
	public void setStaffAttendanceRemarks(String staffAttendanceRemarks) {
		this.staffAttendanceRemarks = staffAttendanceRemarks;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "staff_attendance_created_date", nullable = false)
	public Date getStaffAttendanceCreatedDate() {
		return staffAttendanceCreatedDate;
	}
	public void setStaffAttendanceCreatedDate(Date staffAttendanceCreatedDate) {
		this.staffAttendanceCreatedDate = staffAttendanceCreatedDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "staff_attendance_modified_date", nullable = false,columnDefinition="timestamp")
	public Date getStaffAttendanceModifiedDate() {
		return staffAttendanceModifiedDate;
	}
	public void setStaffAttendanceModifiedDate(Date staffAttendanceModifiedDate) {
		this.staffAttendanceModifiedDate = staffAttendanceModifiedDate;
	}
	
	@Column(name = "staff_attendance_created_by", nullable = false, length = 100)
	public String getStaffAttendanceCreatedBy() {
		return staffAttendanceCreatedBy;
	}
	public void setStaffAttendanceCreatedBy(String staffAttendanceCreatedBy) {
		this.staffAttendanceCreatedBy = staffAttendanceCreatedBy;
	}
	
	@Column(name = "staff_attendance_modified_by", nullable = false, length = 100)
	public String getStaffAttendanceLastModifiedBy() {
		return staffAttendanceLastModifiedBy;
	}
	public void setStaffAttendanceLastModifiedBy(String staffAttendanceLastModifiedBy) {
		this.staffAttendanceLastModifiedBy = staffAttendanceLastModifiedBy;
	}

}
