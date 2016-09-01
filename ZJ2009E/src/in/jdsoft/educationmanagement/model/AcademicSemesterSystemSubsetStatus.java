package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_academic_semester_system_subset_status", uniqueConstraints = @UniqueConstraint(columnNames = {"academic_semester_system_subset_status_name"}) )
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicSemesterSystemSubsetStatus implements Serializable{

	public AcademicSemesterSystemSubsetStatus() {}
	
	public AcademicSemesterSystemSubsetStatus(String academicSemesterSystemStatusName) {
		this.academicSemesterSystemStatusName = academicSemesterSystemStatusName;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer academicSemesterSystemStatusId;
	private String academicSemesterSystemStatusName;
	
	private Set<AcademicSemesterSystemSubset> academicSemesterSystemSubsets=new HashSet<AcademicSemesterSystemSubset>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_semester_system_subset_status_id", nullable = false)
	public Integer getAcademicSemesterSystemStatusId() {
		return academicSemesterSystemStatusId;
	}
	public void setAcademicSemesterSystemStatusId(Integer academicSemesterSystemStatusId) {
		this.academicSemesterSystemStatusId = academicSemesterSystemStatusId;
	}
	
	@Column(name = "academic_semester_system_subset_status_name", nullable = false,length=50)
	public String getAcademicSemesterSystemStatusName() {
		return academicSemesterSystemStatusName;
	}
	public void setAcademicSemesterSystemStatusName(String academicSemesterSystemStatusName) {
		this.academicSemesterSystemStatusName = academicSemesterSystemStatusName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicSemesterSystemSubsetStatus")
	public Set<AcademicSemesterSystemSubset> getAcademicSemesterSystemSubsets() {
		return academicSemesterSystemSubsets;
	}
	public void setAcademicSemesterSystemSubsets(Set<AcademicSemesterSystemSubset> academicSemesterSystemSubsets) {
		this.academicSemesterSystemSubsets = academicSemesterSystemSubsets;
	}
}
