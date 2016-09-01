package in.jdsoft.educationmanagement.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "tbl_semester_system")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SemesterSystem implements java.io.Serializable {

	
	public SemesterSystem() {}

	public SemesterSystem(String semSystemTitle, Integer semestersPerYear,Integer semesterSystemStatus) {
		this.semSystemTitle = semSystemTitle;
		this.semestersPerYear=semestersPerYear;
		this.semesterSystemStatus=semesterSystemStatus;
	}

	private static final long serialVersionUID = 1L;
	
	private Integer semSystemId;
	private String semSystemTitle;
	private Integer semestersPerYear;
	private Integer semesterSystemStatus;
	
	private Set<Courses> courses=new HashSet<Courses>(0);
	private Set<SemesterSystemSubset> semesterSystemSubsets=new HashSet<SemesterSystemSubset>(0);
	private Set<AcademicSemesterSystem> academicSemesterSystems=new HashSet<AcademicSemesterSystem>(0);

	

	
	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "semester_system_id", nullable = false)
	public Integer getSemSystemId() {
		return this.semSystemId;
	}

	public void setSemSystemId(Integer semSystemId) {
		this.semSystemId = semSystemId;
	}

	@Column(name = "semester_system_title", nullable = false, length = 50)
	public String getSemSystemTitle() {
		return this.semSystemTitle;
	}

	public void setSemSystemTitle(String semSystemTitle) {
		this.semSystemTitle = semSystemTitle;
	}
   
	@Column(name = "semester_per_year", nullable = false)
	public Integer getSemestersPerYear() {
		return semestersPerYear;
	}

    public void setSemestersPerYear(Integer semestersPerYear) {
		this.semestersPerYear = semestersPerYear;
	}


    @Column(name = "semester_system_status", nullable = false)
	public Integer getSemesterSystemStatus() {
		return semesterSystemStatus;
	}
    public void setSemesterSystemStatus(Integer semesterSystemStatus) {
		this.semesterSystemStatus = semesterSystemStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "semesterSystem",cascade=CascadeType.PERSIST)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@semesterSystem")
	public Set<SemesterSystemSubset> getSemesterSystemSubsets() {
		return semesterSystemSubsets;
	}

	public void setSemesterSystemSubsets(Set<SemesterSystemSubset> semesterSystemSubsets) {
		this.semesterSystemSubsets = semesterSystemSubsets;
	}
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "semesterSystem")
	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "semesterSystem")
	public Set<AcademicSemesterSystem> getAcademicSemesterSystems() {
		return academicSemesterSystems;
	}

	public void setAcademicSemesterSystems(Set<AcademicSemesterSystem> academicSemesterSystems) {
		this.academicSemesterSystems = academicSemesterSystems;
	}

}
