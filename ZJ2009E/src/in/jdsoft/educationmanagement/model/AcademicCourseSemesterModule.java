package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_academic_course_semester_module", uniqueConstraints = @UniqueConstraint(columnNames = {
		"academic_year_id", "course_sem_id","module_id" }))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicCourseSemesterModule implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public AcademicCourseSemesterModule() {}
	
   public AcademicCourseSemesterModule(AcademicYear academicYear, CourseSemesters courseSemesters,
			Module module, Staff staff) {
		this.acsmCode =Long.toString(System.currentTimeMillis());
		this.academicYear = academicYear;
		this.courseSemester = courseSemesters;
		this.module = module;
		this.staff = staff;
	}

	
	
	private Integer acsmId;
	private String acsmCode;
	private AcademicYear academicYear;
	private CourseSemesters courseSemester;
	private Module module;
	private Staff staff;
	
	

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "acsm_id", unique = true, nullable = false)
	public Integer getAcsmId() {
		return this.acsmId;
	}

	public void setAcsmId(Integer acsmId) {
		this.acsmId = acsmId;
	}

	@Column(name = "acsm_code", nullable = false, length = 50)
	public String getAcsmCode() {
		return this.acsmCode;
	}

	public void setAcsmCode(String acsmCode) {
		this.acsmCode = acsmCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = false)
	@ForeignKey(name="academicCourseSemesterModuleInAcademicYear")
	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_sem_id", nullable = false)
	@ForeignKey(name="academicCourseSemesterModuleCourseSemester")
	public CourseSemesters getCourseSemester() {
		return courseSemester;
	}

	public void setCourseSemester(CourseSemesters courseSemester) {
		this.courseSemester = courseSemester;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	@ForeignKey(name="AcademicCourseSemesterModuleInModule")
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	@ForeignKey(name="academicCourseSemesterModuleInStaff")
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
}
