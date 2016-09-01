package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_student_leave_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentLeaveType implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public StudentLeaveType(Integer studentLeaveTypeId, String studentLeaveType) {
		this.studentLeaveTypeId = studentLeaveTypeId;
		this.studentLeaveType = studentLeaveType;
	}
	
	private Integer studentLeaveTypeId;
	private String studentLeaveType;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "student_leave_type_id", unique = true, nullable = false)
	public Integer getStudentLeaveTypeId() {
		return studentLeaveTypeId;
	}
	public void setStudentLeaveTypeId(Integer studentLeaveTypeId) {
		this.studentLeaveTypeId = studentLeaveTypeId;
	}
	
	@Column(name = "student_leave_type", nullable = false, length = 25)
	public String getStudentLeaveType() {
		return studentLeaveType;
	}
	public void setStudentLeaveType(String studentLeaveType) {
		this.studentLeaveType = studentLeaveType;
	}
	
}
