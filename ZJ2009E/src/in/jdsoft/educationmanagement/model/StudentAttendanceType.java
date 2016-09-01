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
@Table(name = "tbl_student_attendance_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentAttendanceType implements Serializable{
   
	public StudentAttendanceType() {}
	
	public StudentAttendanceType(String studentAttendanceTypeTitle) {
		this.studentAttendanceTypeTitle = studentAttendanceTypeTitle;
	}
	
	private static final long serialVersionUID = 1L;
	private Integer studentAttendanceTypeId;
	private String studentAttendanceTypeTitle;
	
	private Set<StudentAttendance> studentAttendance= new HashSet<StudentAttendance>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "student_attendance_type_id",nullable = false)
	public Integer getStudentAttendanceTypeId() {
		return studentAttendanceTypeId;
	}
	public void setStudentAttendanceTypeId(Integer studentAttendanceTypeId) {
		this.studentAttendanceTypeId = studentAttendanceTypeId;
	}
	
	@Column(name = "student_attendance_type_title",nullable = false,length=50)
	public String getStudentAttendanceTypeTitle() {
		return studentAttendanceTypeTitle;
	}
	public void setStudentAttendanceTypeTitle(String studentAttendanceTypeTitle) {
		this.studentAttendanceTypeTitle = studentAttendanceTypeTitle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentAttendanceType")
	public Set<StudentAttendance> getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(Set<StudentAttendance> studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	
}
