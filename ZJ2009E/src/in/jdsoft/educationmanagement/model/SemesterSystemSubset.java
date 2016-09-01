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

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_semester_system_subset")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SemesterSystemSubset implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer semSystemSubsetId;
	private SemesterSystem semesterSystem;
	private String semSystemSubsetTitle;
	
	private Set<CourseSemesters> courseSemesters=new HashSet<CourseSemesters>(0);
	private Set<AcademicSemesterSystemSubset> academicSemesterSystemSubsets=new HashSet<AcademicSemesterSystemSubset>(0);
	
	public SemesterSystemSubset() {}

	public SemesterSystemSubset(SemesterSystem semesterSystem, String semSystemSubsetTitle) {
		this.semSystemSubsetTitle = semSystemSubsetTitle;
		this.semesterSystem=semesterSystem;
	}
   
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "semester_system_subset_id", nullable = false)
	public Integer getSemSystemSubsetId() {
		return this.semSystemSubsetId;
	}

	public void setSemSystemSubsetId(Integer semSystemSubsetId) {
		this.semSystemSubsetId = semSystemSubsetId;
	}


	@Column(name = "semester_system_subset_title", nullable = false, length = 50)
	public String getSemSystemSubsetTitle() {
		return this.semSystemSubsetTitle;
	}

	public void setSemSystemSubsetTitle(String semSystemSubsetTitle) {
		this.semSystemSubsetTitle = semSystemSubsetTitle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_system_id", nullable = false)
	@ForeignKey(name="semesterSystemInSemesterSystemSubset")
	public SemesterSystem getSemesterSystem() {
		return semesterSystem;
	}

	public void setSemesterSystem(SemesterSystem semesterSystem) {
		this.semesterSystem = semesterSystem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "semesterSystemSubset")
	@ForeignKey(name="courseSemestersInSemesterSystemSubset")
	public Set<CourseSemesters> getCourseSemesters() {
		return courseSemesters;
	}

	public void setCourseSemesters(Set<CourseSemesters> courseSemesters) {
		this.courseSemesters = courseSemesters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "semesterSystemSubset")
	@ForeignKey(name="academicSemesterSystemSubsetInSemesterSystemSubset")
	public Set<AcademicSemesterSystemSubset> getAcademicSemesterSystemSubsets() {
		return academicSemesterSystemSubsets;
	}

	public void setAcademicSemesterSystemSubsets(Set<AcademicSemesterSystemSubset> academicSemesterSystemSubsets) {
		this.academicSemesterSystemSubsets = academicSemesterSystemSubsets;
	}
	
	

}
