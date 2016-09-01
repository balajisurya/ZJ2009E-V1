package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_config",  uniqueConstraints = @UniqueConstraint(columnNames = "admission_process_year"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionConfig implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	public AdmissionConfig() {
		// TODO Auto-generated constructor stub
	}
	private Integer admissionConfigId;
	private String admissionProcessYear;
	private Date admissionStartDate;
	private Date admissionEndDate;
	private AdmissionProcessStatus admissionProcessStatus;
	private String applicationCodeFormat;
	private Double applicationFees;
	
	

	private Set<Admission> admissions=new HashSet<Admission>(0);
	
	
	public AdmissionConfig(AdmissionProcessStatus admissionProcessStatus,String admissionProcessYear, Date admissionStartDate,
			Date admissionEndDate,String applicationCodeFormat,Double applicationFees) {
		this.admissionProcessYear = admissionProcessYear;
		this.admissionStartDate = admissionStartDate;
		this.admissionEndDate = admissionEndDate;
		this.applicationCodeFormat =WordUtils.capitalize(applicationCodeFormat);
		this.admissionProcessStatus=admissionProcessStatus;
		this.applicationFees=applicationFees;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_config_id", unique = true, nullable = false)
	public Integer getAdmissionConfigId() {
		return admissionConfigId;
	}
	public void setAdmissionConfigId(Integer admissionConfigId) {
		this.admissionConfigId = admissionConfigId;
	}
	
	@Column(name = "admission_process_year", unique = true, nullable = false, length = 10)
	public String getAdmissionProcessYear() {
		return admissionProcessYear;
	}
	public void setAdmissionProcessYear(String admissionProcessYear) {
		this.admissionProcessYear = admissionProcessYear;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "admission_start_date",nullable = false)
	public Date getAdmissionStartDate() {
		return admissionStartDate;
	}
	public void setAdmissionStartDate(Date admissionStartDate) {
		this.admissionStartDate = admissionStartDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "admission_end_date",nullable = false)
	public Date getAdmissionEndDate() {
		return admissionEndDate;
	}
	public void setAdmissionEndDate(Date admissionEndDate) {
		this.admissionEndDate = admissionEndDate;
	}
	
	@Column(name = "admission_application_code_format",nullable = false, length =10)
	public String getApplicationCodeFormat() {
		return applicationCodeFormat;
	}
	public void setApplicationCodeFormat(String applicationCodeFormat) {
		this.applicationCodeFormat =WordUtils.capitalize(applicationCodeFormat);
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "admission_process_status_id", nullable = false)
	public AdmissionProcessStatus getAdmissionProcessStatus() {
		return admissionProcessStatus;
	}

	public void setAdmissionProcessStatus(AdmissionProcessStatus admissionProcessStatus) {
		this.admissionProcessStatus = admissionProcessStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admissionConfig")
	public Set<Admission> getAdmissions() {
		return admissions;
	}


	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}

	@Column(name = "application_fees",nullable = false)
	public Double getApplicationFees() {
		return applicationFees;
	}


	public void setApplicationFees(Double applicationFees) {
		this.applicationFees = applicationFees;
	}

}
