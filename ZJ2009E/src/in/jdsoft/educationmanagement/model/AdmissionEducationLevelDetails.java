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
@Table(name = "tbl_admission_education_level_detail",  uniqueConstraints ={@UniqueConstraint(columnNames={"admission_id","degree_name"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionEducationLevelDetails implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	public AdmissionEducationLevelDetails() {}
	
	public AdmissionEducationLevelDetails(Admission admission,EducationLevel educationLevel, String degreeName,
			String rollNo, String certificateNo, Date startedDate, Date completedDate, double marksObtained,
			double percentage, double cgpa, double boardOrUniversity, String institutionCountry,
			String institutionState, String institutionCity) {
		this.admission = admission;
		this.degreeName =WordUtils.capitalize(degreeName);
		this.rollNo = rollNo;
		this.certificateNo = certificateNo;
		this.startedDate = startedDate;
		this.completedDate = completedDate;
		this.marksObtained = marksObtained;
		this.percentage = percentage;
		this.cgpa = cgpa;
		this.boardOrUniversity = boardOrUniversity;
		this.institutionCountry =institutionCountry;
		this.institutionState = institutionState;
		this.institutionCity = institutionCity;
		this.educationLevel=educationLevel;
	}
	
	private int admissionAcademicDetailId;
	private Admission admission;
	private EducationLevel educationLevel;
	private String degreeName;
	private String rollNo;
	private String certificateNo;
	private Date startedDate;
	private Date completedDate;
	private double marksObtained;
	private double percentage;
	private double cgpa;
	private double boardOrUniversity;
	private String institutionCountry;
	private String institutionState;
	private String institutionCity;
	
	private Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects=new HashSet<AdmissionEducationLevelSubjects>(0);
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_education_level_id", unique = true, nullable = false)
	public int getAdmissionAcademicDetailId() {
		return admissionAcademicDetailId;
	}
	public void setAdmissionAcademicDetailId(int admissionAcademicDetailId) {
		this.admissionAcademicDetailId = admissionAcademicDetailId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "admission_id", nullable =false)
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	@Column(name = "degree_name",nullable = false,length=30)
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName =WordUtils.capitalize(degreeName);
	}
	
	@Column(name = "roll_no",nullable = false,length=30)
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	@Column(name = "certificate_no",nullable = false,length=30)
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "started_date",nullable = false)
	public Date getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "completed_date",nullable = false)
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	
	@Column(name = "marks_obtained",nullable = false)
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	@Column(name = "percentage",nullable =true,precision=2)
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	@Column(name = "cgpa",nullable =true,precision=2)
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	@Column(name = "board_or_university",nullable =false)
	public double getBoardOrUniversity() {
		return boardOrUniversity;
	}
	public void setBoardOrUniversity(double boardOrUniversity) {
		this.boardOrUniversity = boardOrUniversity;
	}
	
	@Column(name = "institution_country",nullable =false)
	public String getInstitutionCountry() {
		return institutionCountry;
	}
	public void setInstitutionCountry(String institutionCountry) {
		this.institutionCountry = institutionCountry;
	}
	
	@Column(name = "institution_state",nullable =false)
	public String getInstitutionState() {
		return institutionState;
	}
	public void setInstitutionState(String institutionState) {
		this.institutionState = institutionState;
	}
	
	@Column(name = "institution_city",nullable =false)
	public String getInstitutionCity() {
		return institutionCity;
	}
	public void setInstitutionCity(String institutionCity) {
		this.institutionCity = institutionCity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_level_id", nullable =true)
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admissionEducationLevelDetail")
	public Set<AdmissionEducationLevelSubjects> getAdmissionEducationLevelSubjects() {
		return admissionEducationLevelSubjects;
	}

	public void setAdmissionEducationLevelSubjects(Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects) {
		this.admissionEducationLevelSubjects = admissionEducationLevelSubjects;
	}
	
}
