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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_staff_attendance_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StaffAttendanceType implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer staffAttendanceTypeId;
	private String staffAttendanceTypeTitle;
    private int staffAttendanceTypeVisible;
	
	private Set<StaffAttendance> staffAttendances = new HashSet<StaffAttendance>(0);

	public StaffAttendanceType() {
	}

	public StaffAttendanceType(String staffAttendanceTypeTitle, int staffAttendanceTypeVisible) {
		this.staffAttendanceTypeTitle = staffAttendanceTypeTitle;
		this.staffAttendanceTypeVisible = staffAttendanceTypeVisible;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "staff_attendance_type_id", nullable = false)
	public Integer getStaffAttendanceTypeId() {
		return this.staffAttendanceTypeId;
	}

	public void setStaffAttendanceTypeId(Integer staffAttendanceTypeId) {
		this.staffAttendanceTypeId = staffAttendanceTypeId;
	}

	@Column(name = "staff_attendance_type_title", nullable = false, length = 100)
	public String getStaffAttendanceTypeTitle() {
		return this.staffAttendanceTypeTitle;
	}

	public void setStaffAttendanceTypeTitle(String staffAttendanceTypeTitle) {
		this.staffAttendanceTypeTitle = staffAttendanceTypeTitle;
	}

	

	@Column(name = "staff_attendance_type_visible", nullable = false)
	public int getStaffAttendanceTypeVisible() {
		return this.staffAttendanceTypeVisible;
	}

	public void setStaffAttendanceTypeVisible(int staffAttendanceTypeVisible) {
		this.staffAttendanceTypeVisible = staffAttendanceTypeVisible;
	}

	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffAttendanceType")
	public Set<StaffAttendance> getTblStaffAttendances() {
		return this.staffAttendances;
	}

	public void setTblStaffAttendances(Set<StaffAttendance> staffAttendances) {
		this.staffAttendances = staffAttendances;
	}

}
