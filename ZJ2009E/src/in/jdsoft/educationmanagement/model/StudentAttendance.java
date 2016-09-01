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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_student_attendance",uniqueConstraints = {@UniqueConstraint(columnNames ={"student_id","student_attendance_date"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentAttendance implements Serializable {

	public StudentAttendance() {}
	
	public StudentAttendance(Student student, StudentAttendanceType studentAttendanceType,
			String studentAttendanceRemarks,Integer semester,Date studentAttendanceDate,String studentAttendanceCreatedBy, String studentAttendanceLastModifiedBy) {
		this.student = student;
		this.studentAttendanceType = studentAttendanceType;
		this.studentAttendanceRemarks = studentAttendanceRemarks;
		this.studentAttendanceCreatedDate =new Timestamp(Calendar.getInstance().getTime().getTime());
		this.studentAttendanceCreatedBy = studentAttendanceCreatedBy;
		this.studentAttendanceLastModifiedBy = studentAttendanceLastModifiedBy;
		this.studentAttendanceDate=studentAttendanceDate;
		this.semester=semester;
	}
   
   private static final long serialVersionUID = 1L;
	
	
	private Integer studentAttendanceId;
	private Student student;
	private StudentAttendanceType studentAttendanceType;
	private Integer semester;
	private String studentAttendanceRemarks;
	private Date studentAttendanceDate;
	private Date studentAttendanceCreatedDate;
	private Date studentAttendanceModifiedDate;
	private String studentAttendanceCreatedBy;
	private String studentAttendanceLastModifiedBy;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "student_attendance_id",nullable = false)
	public Integer getStudentAttendanceId() {
		return studentAttendanceId;
	}
	public void setStudentAttendanceId(Integer studentAttendanceId) {
		this.studentAttendanceId = studentAttendanceId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_attendance_type_id", nullable = false)
	public StudentAttendanceType getStudentAttendanceType() {
		return studentAttendanceType;
	}
	public void setStudentAttendanceType(StudentAttendanceType studentAttendanceType) {
		this.studentAttendanceType = studentAttendanceType;
	}
	
	@Column(name = "student_attendance_remarks",nullable = false,length=255)
	public String getStudentAttendanceRemarks() {
		return studentAttendanceRemarks;
	}
	public void setStudentAttendanceRemarks(String studentAttendanceRemarks) {
		this.studentAttendanceRemarks = studentAttendanceRemarks;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "student_attendance_date", nullable = false)
	public Date getStudentAttendanceDate() {
		return studentAttendanceDate;
	}

	public void setStudentAttendanceDate(Date studentAttendanceDate) {
		this.studentAttendanceDate = studentAttendanceDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "student_attendance_created_date", nullable = false)
	public Date getStudentAttendanceCreatedDate() {
		return studentAttendanceCreatedDate;
	}
	public void setStudentAttendanceCreatedDate(Date studentAttendanceCreatedDate) {
		this.studentAttendanceCreatedDate = studentAttendanceCreatedDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "student_attendance_modified_date", nullable = false,columnDefinition="timestamp")
	public Date getStudentAttendanceModifiedDate() {
		return studentAttendanceModifiedDate;
	}
	public void setStudentAttendanceModifiedDate(Date studentAttendanceModifiedDate) {
		this.studentAttendanceModifiedDate = studentAttendanceModifiedDate;
	}
	
	@Column(name = "student_attendance_created_by",nullable = false,length=50)
	public String getStudentAttendanceCreatedBy() {
		return studentAttendanceCreatedBy;
	}
	public void setStudentAttendanceCreatedBy(String studentAttendanceCreatedBy) {
		this.studentAttendanceCreatedBy = studentAttendanceCreatedBy;
	}
	
	@Column(name = "student_attendance_modified_by",nullable = false,length=50)
	public String getStudentAttendanceLastModifiedBy() {
		return studentAttendanceLastModifiedBy;
	}
	public void setStudentAttendanceLastModifiedBy(String studentAttendanceLastModifiedBy) {
		this.studentAttendanceLastModifiedBy = studentAttendanceLastModifiedBy;
	}

	@Column(name = "student_attendance_semester",nullable = false)
	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

}
