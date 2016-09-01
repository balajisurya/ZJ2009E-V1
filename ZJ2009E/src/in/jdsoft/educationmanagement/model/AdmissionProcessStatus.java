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
@Table(name = "tbl_admission_process_status",  uniqueConstraints = @UniqueConstraint(columnNames = "admission_process_status_title"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionProcessStatus implements Serializable{

	private static final long serialVersionUID = 1L;

	public AdmissionProcessStatus() {
		// TODO Auto-generated constructor stub
	}
	
	private int admissionProcessStatusId;
	private String admissionProcessStatusTitle;
	
	private Set<AdmissionConfig> admissionConfigs = new HashSet<AdmissionConfig>(0);
	
	public AdmissionProcessStatus(String admissionProcessStatusTitle) {
		this.admissionProcessStatusTitle = WordUtils.capitalize(admissionProcessStatusTitle);
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_process_status_id", unique = true, nullable = false)
	public int getAdmissionProcessStatusId() {
		return admissionProcessStatusId;
	}
	
	public void setAdmissionProcessStatusId(int admissionProcessStatusId) {
		this.admissionProcessStatusId = admissionProcessStatusId;
	}
	
	@Column(name = "admission_process_status_title", unique = true, nullable = false, length = 50)
	public String getAdmissionProcessStatusTitle() {
		return admissionProcessStatusTitle;
	}
	public void setAdmissionProcessStatusTitle(String admissionProcessStatusTitle) {
		this.admissionProcessStatusTitle =WordUtils.capitalize(admissionProcessStatusTitle);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="admissionProcessStatus")
	public Set<AdmissionConfig> getAdmissionConfigs() {
		return admissionConfigs;
	}

	public void setAdmissionConfigs(Set<AdmissionConfig> admissionConfigs) {
		this.admissionConfigs = admissionConfigs;
	}
}
