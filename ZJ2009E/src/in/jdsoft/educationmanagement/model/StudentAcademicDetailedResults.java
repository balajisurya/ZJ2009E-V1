package in.jdsoft.educationmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_student_academic_detailed_results")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentAcademicDetailedResults implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer sadrId;
	private int stdAcaId;
	private int acsmId;
	private String moduleResultStatus;
	private long moduleMarksObtained;
	private String moduleUpdatedBy;

	public StudentAcademicDetailedResults() {
	}

	public StudentAcademicDetailedResults(int stdAcaId, int acsmId, String moduleResultStatus,
			long moduleMarksObtained, String moduleUpdatedBy) {
		this.stdAcaId = stdAcaId;
		this.acsmId = acsmId;
		this.moduleResultStatus = moduleResultStatus;
		this.moduleMarksObtained = moduleMarksObtained;
		this.moduleUpdatedBy = moduleUpdatedBy;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "sadr_id", unique = true, nullable = false)
	public Integer getSadrId() {
		return this.sadrId;
	}

	public void setSadrId(Integer sadrId) {
		this.sadrId = sadrId;
	}

	@Column(name = "std_aca_id", nullable = false)
	public int getStdAcaId() {
		return this.stdAcaId;
	}

	public void setStdAcaId(int stdAcaId) {
		this.stdAcaId = stdAcaId;
	}

	@Column(name = "acsm_id", nullable = false)
	public int getAcsmId() {
		return this.acsmId;
	}

	public void setAcsmId(int acsmId) {
		this.acsmId = acsmId;
	}

	@Column(name = "module_result_status", nullable = false, length = 50)
	public String getModuleResultStatus() {
		return this.moduleResultStatus;
	}

	public void setModuleResultStatus(String moduleResultStatus) {
		this.moduleResultStatus = moduleResultStatus;
	}

	@Column(name = "module_marks_obtained", nullable = false, precision = 10, scale = 0)
	public long getModuleMarksObtained() {
		return this.moduleMarksObtained;
	}

	public void setModuleMarksObtained(long moduleMarksObtained) {
		this.moduleMarksObtained = moduleMarksObtained;
	}

	@Column(name = "module_updated_by", nullable = false, length = 100)
	public String getModuleUpdatedBy() {
		return this.moduleUpdatedBy;
	}

	public void setModuleUpdatedBy(String moduleUpdatedBy) {
		this.moduleUpdatedBy = moduleUpdatedBy;
	}

}
