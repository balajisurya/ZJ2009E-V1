package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_academic_module_assignment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Assignment implements java.io.Serializable {

	public Assignment(String purpose, String objectives, String assignmentStudentActivities,
			String assignmentQuestionsandText, String referenceAssignmentFramework, String referenceAssignmentMaterial,
			String referenceAssignmentHandout, Date assignmentStartdate, Date assignmentEnddate,
			String assignmentStatus, String assignmentRemarks, Integer assignmentHoursRequired,
			Set<Student> studentassignments) {
		this.purpose = purpose;
		this.objectives = objectives;
		this.assignmentStudentActivities = assignmentStudentActivities;
		this.assignmentQuestionsandText = assignmentQuestionsandText;
		this.referenceAssignmentFramework = referenceAssignmentFramework;
		this.referenceAssignmentMaterial = referenceAssignmentMaterial;
		this.referenceAssignmentHandout = referenceAssignmentHandout;
		this.assignmentStartdate = assignmentStartdate;
		this.assignmentEnddate = assignmentEnddate;
		this.assignmentStatus = assignmentStatus;
		this.assignmentRemarks = assignmentRemarks;
		this.assignmentHoursRequired = assignmentHoursRequired;
		this.studentassignments = studentassignments;
	}
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer assignmentId;
	private String purpose;
	private String objectives;
	private String assignmentStudentActivities;
	private String assignmentQuestionsandText;
	private String referenceAssignmentFramework;
	private String referenceAssignmentMaterial;
	private String referenceAssignmentHandout;
	private Date assignmentStartdate;
	private Date assignmentEnddate;
	private String assignmentStatus;
	private String assignmentRemarks;
	private Integer assignmentHoursRequired;
	
	
	//models
	
	private Set<Student> studentassignments = new HashSet<Student>(0);

	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "assignment_id", unique = true, nullable = false)
	public Integer getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}
	
	//Single Fields

	@Column(name = "assignment_purpose", nullable = false, length = 255)
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	@Column(name = "assignment_objectives",nullable = false, length = 255)
	public String getObjectives() {
		return objectives;
	}
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}
	@Column(name = "assignment_student_activities", nullable = false, length = 255)
	public String getAssignmentStudentActivities() {
		return assignmentStudentActivities;
	}
	public void setAssignmentStudentActivities(String assignmentStudentActivities) {
		this.assignmentStudentActivities = assignmentStudentActivities;
	}
	@Column(name = "assignment_questions_and_text",nullable = false, length = 255)
	public String getAssignmentQuestionsandText() {
		return assignmentQuestionsandText;
	}
	public void setAssignmentQuestionsandText(String assignmentQuestionsandText) {
		this.assignmentQuestionsandText = assignmentQuestionsandText;
	}
	@Column(name = "assignment_reference_framework", nullable = false, length = 120)
	public String getReferenceAssignmentFramework() {
		return referenceAssignmentFramework;
	}
	public void setReferenceAssignmentFramework(String referenceAssignmentFramework) {
		this.referenceAssignmentFramework = referenceAssignmentFramework;
	}
	@Column(name = "assignment_reference_material", nullable = false, length = 120)
	public String getReferenceAssignmentMaterial() {
		return referenceAssignmentMaterial;
	}
	public void setReferenceAssignmentMaterial(String referenceAssignmentMaterial) {
		this.referenceAssignmentMaterial = referenceAssignmentMaterial;
	}
	@Column(name = "assignment_reference_handout", nullable = false, length = 120)
	public String getReferenceAssignmentHandout() {
		return referenceAssignmentHandout;
	}
	public void setReferenceAssignmentHandout(String referenceAssignmentHandout) {
		this.referenceAssignmentHandout = referenceAssignmentHandout;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "assignment_start_date", nullable = false, length = 10)
	public Date getAssignmentStartdate() {
		return assignmentStartdate;
	}
	public void setAssignmentStartdate(Date assignmentStartdate) {
		this.assignmentStartdate = assignmentStartdate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "assignment_end_date", nullable = false, length = 10)
	public Date getAssignmentEnddate() {
		return assignmentEnddate;
	}
	public void setAssignmentEnddate(Date assignmentEnddate) {
		this.assignmentEnddate = assignmentEnddate;
	}
	@Column(name = "assignment_status", nullable = false, length = 30)
	public String getAssignmentStatus() {
		return assignmentStatus;
	}
	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}
	@Column(name = "assignment_remarks", nullable = false, length = 120)
	public String getAssignmentRemarks() {
		return assignmentRemarks;
	}
	public void setAssignmentRemarks(String assignmentRemarks) {
		this.assignmentRemarks = assignmentRemarks;
	}
	@Column(name = "assignment_hours_required", nullable = false)
	public Integer getAssignmentHoursRequired() {
		return assignmentHoursRequired;
	}
	public void setAssignmentHoursRequired(Integer assignmentHoursRequired) {
		this.assignmentHoursRequired = assignmentHoursRequired;
	}
	
	//Mappings
	

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "module_id", nullable=false)
	
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_student_assignment", joinColumns = @JoinColumn(name = "assignment_id", referencedColumnName = "assignment_id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
	public Set<Student> getStudentassignments() {
		return studentassignments;
	}
	public void setStudentassignments(Set<Student> studentassignments) {
		this.studentassignments = studentassignments;
	}
	
	
	
	
}
