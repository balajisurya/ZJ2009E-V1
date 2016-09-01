package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_lab_plan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LabPlan implements java.io.Serializable {

	public LabPlan(String purpose, String labObjectives, String labTeacherProcedure,
			String labStudentActivities, String assessment, String referenceFramework, String referenceMaterial,
			String referenceHandout, String referenceQuestions, Module module, String aboutassignments) {
		this.purpose = purpose;
		this.labObjectives = labObjectives;
		this.labTeacherProcedure = labTeacherProcedure;
		this.labStudentActivities = labStudentActivities;
		this.assessment = assessment;
		this.referenceFramework = referenceFramework;
		this.referenceMaterial = referenceMaterial;
		this.referenceHandout = referenceHandout;
		this.referenceQuestions = referenceQuestions;
		this.module = module;
		this.setAboutassignments(aboutassignments);
	}
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer LabPlanId;
	private String purpose;
	private String labObjectives;
	private String labTeacherProcedure;
	private String labStudentActivities;
	private String assessment;
	private String referenceFramework;
	private String referenceMaterial;
	private String referenceHandout;
	private String referenceQuestions;
	private String aboutassignments;
	
	//models
	
	private Module module;
	private Set<LabPlanSchedule> LabPlanSchedules=new HashSet<LabPlanSchedule>(0);

	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "lab_plan_id", unique = true, nullable = false)
	public Integer getLabPlanId() {
		return LabPlanId;
	}
	public void setLabPlanId(Integer LabPlanId) {
		this.LabPlanId = LabPlanId;
	}
	
	//Single Fields

	@Column(name = "lab_plan_purpose", nullable = false, length = 255)
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	@Column(name = "lab_plan_objectives",nullable = false, length = 255)
	public String getlabObjectives() {
		return labObjectives;
	}
	public void setlabObjectives(String labObjectives) {
		this.labObjectives = labObjectives;
	}

	@Column(name = "lab_plan_teacher_procedure", nullable = false, length = 255)
	public String getlabTeacherProcedure() {
		return labTeacherProcedure;
	}
	public void setlabTeacherProcedure(String labTeacherProcedure) {
		this.labTeacherProcedure = labTeacherProcedure;
	}
	@Column(name = "lab_plan_student_activities",nullable = false, length = 255)
	public String getlabStudentActivities() {
		return labStudentActivities;
	}
	public void setlabStudentActivities(String labStudentActivities) {
		this.labStudentActivities = labStudentActivities;
	}
	@Column(name = "lab_plan_assessment", nullable = false, length = 150)
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	@Column(name = "lab_plan_reference_framework", nullable = false, length = 120)
	public String getReferenceFramework() {
		return referenceFramework;
	}
	public void setReferenceFramework(String referenceFramework) {
		this.referenceFramework = referenceFramework;
	}
	@Column(name = "lab_plan_reference_material", nullable = false, length = 120)
	public String getReferenceMaterial() {
		return referenceMaterial;
	}
	public void setReferenceMaterial(String referenceMaterial) {
		this.referenceMaterial = referenceMaterial;
	}
	@Column(name = "lab_plan_reference_handout", nullable = false, length = 120)
	public String getReferenceHandout() {
		return referenceHandout;
	}
	public void setReferenceHandout(String referenceHandout) {
		this.referenceHandout = referenceHandout;
	}
	@Column(name = "lab_plan_reference_questions", nullable = false, length = 120)
	public String getReferenceQuestions() {
		return referenceQuestions;
	}
	public void setReferenceQuestions(String referenceQuestions) {
		this.referenceQuestions = referenceQuestions;
	}
	@Column(name = "lab_plan_about_assignments", nullable = true, length = 150)
	public String getAboutassignments() {
		return aboutassignments;
	}
	public void setAboutassignments(String aboutassignments) {
		this.aboutassignments = aboutassignments;
	}
	
	//Mappings
	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable=false)
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "labPlan")
	public Set<LabPlanSchedule> getLabPlanSchedules() {
		return LabPlanSchedules;
	}
	public void setLabPlanSchedules(Set<LabPlanSchedule> labPlanSchedules) {
		LabPlanSchedules = labPlanSchedules;
	}
	

	
	
}