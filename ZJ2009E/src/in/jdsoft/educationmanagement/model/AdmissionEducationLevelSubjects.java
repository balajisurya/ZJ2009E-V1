package in.jdsoft.educationmanagement.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.WordUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_admission_education_level_subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdmissionEducationLevelSubjects implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int admissionEducationLevelSubjectId;
	private AdmissionEducationLevelDetails admissionEducationLevelDetail;
	private Admission admission;
	private double subjectMarks;
	private String admissionEducationLevelSubjectTitle;
	
	public AdmissionEducationLevelSubjects(AdmissionEducationLevelDetails admissionEducationLevelDetail,Admission admission,double subjectMarks,String admissionEducationLevelSubjectTitle) {
		this.admissionEducationLevelDetail=admissionEducationLevelDetail;
		this.admission=admission;
		this.subjectMarks=subjectMarks;
		this.admissionEducationLevelSubjectTitle=WordUtils.capitalize(admissionEducationLevelSubjectTitle);
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admission_education_level_subject_id",nullable = false)
	public int getAdmissionEducationLevelSubjectId() {
		return admissionEducationLevelSubjectId;
	}
	public void setAdmissionEducationLevelSubjectId(int admissionEducationLevelSubjectId) {
		this.admissionEducationLevelSubjectId = admissionEducationLevelSubjectId;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "admission_education_level_id", nullable =false)
	public AdmissionEducationLevelDetails getAdmissionEducationLevelDetail() {
		return admissionEducationLevelDetail;
	}
	public void setAdmissionEducationLevelDetail(AdmissionEducationLevelDetails admissionEducationLevelDetail) {
		this.admissionEducationLevelDetail = admissionEducationLevelDetail;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "admission_id", nullable =false)
	public Admission getAdmission() {
		return admission;
	}
	
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	@Column(name = "subject_marks",nullable = false)
	public double getSubjectMarks() {
		return subjectMarks;
	}
	public void setSubjectMarks(double sujectMarks) {
		this.subjectMarks = sujectMarks;
	}
	
	@Column(name = "subject_title",nullable = false)
	public String getAdmissionEducationLevelSubjectTitle() {
		return admissionEducationLevelSubjectTitle;
	}
	public void setAdmissionEducationLevelSubjectTitle(String admissionEducationLevelSubjectTitle) {
		this.admissionEducationLevelSubjectTitle =WordUtils.capitalize(admissionEducationLevelSubjectTitle);
	}
	
}
