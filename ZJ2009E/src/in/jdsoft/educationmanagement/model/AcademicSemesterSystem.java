package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "tbl_academic_semester_system")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicSemesterSystem implements Serializable{

	public AcademicSemesterSystem() {}
	
	public AcademicSemesterSystem(AcademicYear academicYear, SemesterSystem semesterSystem) {
		this.academicYear = academicYear;
		this.semesterSystem = semesterSystem;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer academicSemesterSystemId;
	private AcademicYear academicYear;
	private SemesterSystem semesterSystem;
	
	private Set<AcademicSemesterSystemSubset> academicSemesterSystemSubsets=new HashSet<AcademicSemesterSystemSubset>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_semester_system_id", nullable = false)
	public Integer getAcademicSemesterSystemId() {
		return academicSemesterSystemId;
	}
	
	public void setAcademicSemesterSystemId(Integer academicSemesterSystemId) {
		this.academicSemesterSystemId = academicSemesterSystemId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_year_id", nullable = false)
	public AcademicYear getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_system_id", nullable = false)
	public SemesterSystem getSemesterSystem() {
		return semesterSystem;
	}
	public void setSemesterSystem(SemesterSystem semesterSystem) {
		this.semesterSystem = semesterSystem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicSemesterSystem",cascade=CascadeType.PERSIST)
	public Set<AcademicSemesterSystemSubset> getAcademicSemesterSystemSubsets() {
		return academicSemesterSystemSubsets;
	}

	public void setAcademicSemesterSystemSubsets(Set<AcademicSemesterSystemSubset> academicSemesterSystemSubsets) {
		this.academicSemesterSystemSubsets = academicSemesterSystemSubsets;
	}
	
}
