package in.jdsoft.educationmanagement.model;
// Generated Mar 29, 2016 1:05:30 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_module",  uniqueConstraints = @UniqueConstraint(columnNames = "module_code"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Module implements java.io.Serializable {

	public Module() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private Integer moduleId;
	private String moduleCode;
	private String moduleName;
	private int moduleCredit;
	private String moduleType;
	private Integer totalHours;
	private boolean hasExam;
	private Institution institution;

	
	
	//models
	   private Set<CourseSemesters> courseSemesters=new HashSet<CourseSemesters>(0);
	
		private Set<LessonPlan> lessonPlan=new HashSet<LessonPlan>(0);
		private Set<LabPlan> labPlan=new HashSet<LabPlan>(0);
		private Set<AcademicCourseSemesterModule> academicCourseSemesterModules=new HashSet<AcademicCourseSemesterModule>(0);
	
	
	public Module(String moduleName, int moduleCredit,String moduleType,Integer totalHours,boolean hasExam,Institution institution) {
		this.moduleCode =Long.toString(System.currentTimeMillis());
		this.moduleName =WordUtils.capitalize(moduleName);
		this.moduleCredit = moduleCredit;
		this.moduleType=moduleType;
		this.totalHours=totalHours;
		this.hasExam=hasExam;
		this.institution=institution;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "module_id",nullable = false)
	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	@Column(name = "module_code", unique = true, nullable = false, length = 20)
	public String getModuleCode() {
		return this.moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	@Column(name = "module_name", nullable = false)
	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName =WordUtils.capitalize(moduleName);
	}

	@Column(name = "module_credits", nullable = false)
	public int getModuleCredit() {
		return this.moduleCredit;
	}

	public void setModuleCredit(int moduleCredit) {
		this.moduleCredit = moduleCredit;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
	public Set<LessonPlan> getLessonPlan() {
		return lessonPlan;
	}

	public void setLessonPlan(Set<LessonPlan> lessonPlan) {
		this.lessonPlan = lessonPlan;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
	public Set<LabPlan> getLabPlan() {
		return labPlan;
	}

	public void setLabPlan(Set<LabPlan> labPlan) {
		this.labPlan = labPlan;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "modules")
    public Set<CourseSemesters> getCourseSemesters() {
		return courseSemesters;
	}

	public void setCourseSemesters(Set<CourseSemesters> courseSemesters) {
		this.courseSemesters = courseSemesters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
	public Set<AcademicCourseSemesterModule> getAcademicCourseSemesterModules() {
		return academicCourseSemesterModules;
	}

	public void setAcademicCourseSemesterModules(Set<AcademicCourseSemesterModule> academicCourseSemesterModules) {
		this.academicCourseSemesterModules = academicCourseSemesterModules;
	}
	
	@Column(name = "module_type", nullable = false)
	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
    
	@Column(name = "module_total_hours", nullable = false)
	public Integer getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	@Column(name = "has_exam", nullable = false)
	public boolean isHasExam() {
		return hasExam;
	}

	public void setHasExam(boolean hasExam) {
		this.hasExam = hasExam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institution_id", nullable = false)
	@ForeignKey(name="moduleInInstitution")
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}



}
