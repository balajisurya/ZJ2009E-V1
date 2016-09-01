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
@Table(name = "tbl_lesson_plan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LessonPlan implements java.io.Serializable {

	public LessonPlan(String purpose, String lessonObjectives, String lessonTeacherProcedure,
			String lessonStudentActivities, String assessment, String referenceFramework, String referenceMaterial,
			String referenceHandout, String referenceQuestions, String aboutassignments, Module module) {
		this.purpose = purpose;
		this.lessonObjectives = lessonObjectives;
		this.lessonTeacherProcedure = lessonTeacherProcedure;
		this.lessonStudentActivities = lessonStudentActivities;
		this.assessment = assessment;
		this.referenceFramework = referenceFramework;
		this.referenceMaterial = referenceMaterial;
		this.referenceHandout = referenceHandout;
		this.referenceQuestions = referenceQuestions;
		this.setAboutassignments(aboutassignments);
		this.module = module;
	}
private static final long serialVersionUID = 1L;
	
	//single fields
	
	private Integer lessonPlanId;
	private String purpose;
	private String lessonObjectives;
	private String lessonTeacherProcedure;
	private String lessonStudentActivities;
	private String assessment;
	private String referenceFramework;
	private String referenceMaterial;
	private String referenceHandout;
	private String referenceQuestions;
	private String aboutassignments;
	
	
	//models
	
	private Module module;
	private Set<LessonPlanSchedule> lessonPlanSchedules=new HashSet<LessonPlanSchedule>(0);
	
	//PK
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "lesson_plan_id", unique = true, nullable = false)
	public Integer getLessonPlanId() {
		return lessonPlanId;
	}
	public void setLessonPlanId(Integer lessonPlanId) {
		this.lessonPlanId = lessonPlanId;
	}
	
	//Single Fields

	@Column(name = "lesson_plan_purpose", nullable = false, length = 255)
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	@Column(name = "lesson_plan_objectives",nullable = false, length = 255)
	public String getLessonObjectives() {
		return lessonObjectives;
	}
	public void setLessonObjectives(String lessonObjectives) {
		this.lessonObjectives = lessonObjectives;
	}

	@Column(name = "lesson_plan_teacher_procedure", nullable = false, length = 255)
	public String getLessonTeacherProcedure() {
		return lessonTeacherProcedure;
	}
	public void setLessonTeacherProcedure(String lessonTeacherProcedure) {
		this.lessonTeacherProcedure = lessonTeacherProcedure;
	}
	@Column(name = "lesson_plan_student_activities",nullable = false, length = 255)
	public String getLessonStudentActivities() {
		return lessonStudentActivities;
	}
	public void setLessonStudentActivities(String lessonStudentActivities) {
		this.lessonStudentActivities = lessonStudentActivities;
	}
	@Column(name = "lesson_plan_assessment", nullable = false, length = 150)
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	@Column(name = "lesson_plan_reference_framework", nullable = false, length = 120)
	public String getReferenceFramework() {
		return referenceFramework;
	}
	public void setReferenceFramework(String referenceFramework) {
		this.referenceFramework = referenceFramework;
	}
	@Column(name = "lesson_plan_reference_material", nullable = false, length = 120)
	public String getReferenceMaterial() {
		return referenceMaterial;
	}
	public void setReferenceMaterial(String referenceMaterial) {
		this.referenceMaterial = referenceMaterial;
	}
	@Column(name = "lesson_plan_reference_handout", nullable = false, length = 120)
	public String getReferenceHandout() {
		return referenceHandout;
	}
	public void setReferenceHandout(String referenceHandout) {
		this.referenceHandout = referenceHandout;
	}
	@Column(name = "lesson_plan_reference_questions", nullable = false, length = 120)
	public String getReferenceQuestions() {
		return referenceQuestions;
	}
	public void setReferenceQuestions(String referenceQuestions) {
		this.referenceQuestions = referenceQuestions;
	}
	@Column(name = "lesson_plan_about_assignments", nullable = true, length = 150)
	public String getAboutassignments() {
		return aboutassignments;
	}
	public void setAboutassignments(String aboutassignments) {
		this.aboutassignments = aboutassignments;
	}
	
	
	//Mappings
	

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lessonPlan")
	public Set<LessonPlanSchedule> getLessonPlanSchedules() {
		return lessonPlanSchedules;
	}
	public void setLessonPlanSchedules(Set<LessonPlanSchedule> lessonPlanSchedules) {
		this.lessonPlanSchedules = lessonPlanSchedules;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable=false)
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}

}
