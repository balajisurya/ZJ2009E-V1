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
@Table(name = "tbl_academic_year_status", uniqueConstraints = @UniqueConstraint(columnNames = {"academic_year_status_name"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcademicYearStatus implements Serializable{

	public AcademicYearStatus() {}
	
	public AcademicYearStatus(String academicYearStatusName) {
		this.academicYearStatusName = academicYearStatusName;
	}
	private static final long serialVersionUID = 1L;
	
	private Integer academicYearStatusId;
	private String academicYearStatusName;
	
	
	private Set<AcademicYear> academicYears=new HashSet<AcademicYear>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    @Column(name = "academic_year_status_id", nullable = false)
	public Integer getAcademicYearStatusId() {
		return academicYearStatusId;
	}
	public void setAcademicYearStatusId(Integer academicYearStatusId) {
		this.academicYearStatusId = academicYearStatusId;
	}
	
	@Column(name = "academic_year_status_name", nullable = false,length=50)
	public String getAcademicYearStatusName() {
		return academicYearStatusName;
	}
	public void setAcademicYearStatusName(String academicYearStatusName) {
		this.academicYearStatusName = academicYearStatusName;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicYearStatus")
	public Set<AcademicYear> getAcademicYears() {
		return academicYears;
	}
	public void setAcademicYears(Set<AcademicYear> academicYears) {
		this.academicYears = academicYears;
	}

}
