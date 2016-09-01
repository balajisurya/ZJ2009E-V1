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

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_status", uniqueConstraints = @UniqueConstraint(columnNames = "admission_status_title"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionStatus implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	public AdmissionStatus() {
		// TODO Auto-generated constructor stub
	}
	public AdmissionStatus(String admissionStatusTitle) {
		this.admissionStatusTitle =WordUtils.capitalize(admissionStatusTitle);
	}
	
	private int admissionStatusId;
	private String admissionStatusTitle;
	private Set<Admission> admissions = new HashSet<Admission>(0);
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_status_id", unique = true, nullable = false)
	public int getAdmissionStatusId() {
		return admissionStatusId;
	}
	public void setAdmissionStatusId(int admissionStatusId) {
		this.admissionStatusId = admissionStatusId;
	}
	
	@Column(name = "admission_status_title", unique = true, nullable = false, length = 50)
	public String getAdmissionStatusTitle() {
		return admissionStatusTitle;
	}
	public void setAdmissionStatusTitle(String admissionStatusTitle) {
		this.admissionStatusTitle =WordUtils.capitalize(admissionStatusTitle);
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admissionStatus")
	public Set<Admission> getAdmissions() {
		return admissions;
	}
	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}
	

}
