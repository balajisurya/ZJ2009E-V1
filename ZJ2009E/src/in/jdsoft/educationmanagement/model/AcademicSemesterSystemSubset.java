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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_academic_semester_system_subset")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicSemesterSystemSubset implements java.io.Serializable {

	
	public AcademicSemesterSystemSubset() {}
	
	public AcademicSemesterSystemSubset(AcademicSemesterSystem academicSemesterSystem,SemesterSystemSubset semesterSystemSubset,
			AcademicSemesterSystemSubsetStatus academicSemesterSystemSubsetStatus) {
		this.semesterSystemSubset = semesterSystemSubset;
		this.academicSemesterSystemSubsetStatus = academicSemesterSystemSubsetStatus;
		this.academicSemesterSystem=academicSemesterSystem;
	}

	
	private static final long serialVersionUID = 1L;
	
	private Integer academicSemesterSystemSubsetId;
	private SemesterSystemSubset semesterSystemSubset;
	private AcademicSemesterSystemSubsetStatus academicSemesterSystemSubsetStatus;
	private AcademicSemesterSystem academicSemesterSystem;

	
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_semester_system_subset_id", nullable = false)
	public Integer getAcademicSemesterSystemSubsetId() {
		return this.academicSemesterSystemSubsetId;
	}

	public void setAcademicSemesterSystemSubsetId(Integer academicSemesterSystemSubsetId) {
		this.academicSemesterSystemSubsetId = academicSemesterSystemSubsetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_system_subset_id", nullable = false)
	public SemesterSystemSubset getSemesterSystemSubset() {
		return semesterSystemSubset;
	}

	public void setSemesterSystemSubset(SemesterSystemSubset semesterSystemSubset) {
		this.semesterSystemSubset = semesterSystemSubset;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_semester_system_subset_status_id", nullable = false)
	public AcademicSemesterSystemSubsetStatus getAcademicSemesterSystemSubsetStatus() {
		return academicSemesterSystemSubsetStatus;
	}

	public void setAcademicSemesterSystemSubsetStatus(AcademicSemesterSystemSubsetStatus academicSemesterSystemSubsetStatus) {
		this.academicSemesterSystemSubsetStatus = academicSemesterSystemSubsetStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "academic_semester_system_id", nullable = false)
	public AcademicSemesterSystem getAcademicSemesterSystem() {
		return academicSemesterSystem;
	}

	public void setAcademicSemesterSystem(AcademicSemesterSystem academicSemesterSystem) {
		this.academicSemesterSystem = academicSemesterSystem;
	}

}
