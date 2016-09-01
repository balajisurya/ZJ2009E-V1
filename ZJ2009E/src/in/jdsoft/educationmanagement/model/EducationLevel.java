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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_education_level", uniqueConstraints = @UniqueConstraint(columnNames = "education_level_title"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EducationLevel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public EducationLevel() {}
	
	public EducationLevel(String educationLevelTitle) {
		this.educationLevelTitle =WordUtils.capitalize(educationLevelTitle);
	}
	
	public EducationLevel(String educationLevelTitle, Set<EducationLevelSubject> educationLevelSubjects) {
		this.educationLevelTitle = educationLevelTitle;
		this.educationLevelSubjects = educationLevelSubjects;
	}
	
	private int educationLevelId;
	private String educationLevelTitle;
	
	private Set<EducationLevelSubject> educationLevelSubjects=new HashSet<EducationLevelSubject>(0);
	private Set<AdmissionEducationLevelDetails> admissionEducationLevelDetails=new HashSet<AdmissionEducationLevelDetails>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "education_level_id", nullable = false)
	public int getEducationLevelId() {
		return educationLevelId;
	}
	public void setEducationLevelId(int educationLevelId) {
		this.educationLevelId = educationLevelId;
	}
	
	@Column(name = "education_level_title", nullable = false, length = 100)
	public String getEducationLevelTitle() {
		return educationLevelTitle;
	}
	public void setEducationLevelTitle(String educationLevelTitle) {
		this.educationLevelTitle =WordUtils.capitalize(educationLevelTitle);
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "educationLevel")
	@JsonManagedReference
	public Set<EducationLevelSubject> getEducationLevelSubjects() {
		return educationLevelSubjects;
	}
	public void setEducationLevelSubjects(Set<EducationLevelSubject> educationLevelSubjects) {
		this.educationLevelSubjects = educationLevelSubjects;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "educationLevel")
	public Set<AdmissionEducationLevelDetails> getAdmissionEducationLevelDetails() {
		return admissionEducationLevelDetails;
	}

	public void setAdmissionEducationLevelDetails(Set<AdmissionEducationLevelDetails> admissionEducationLevelDetails) {
		this.admissionEducationLevelDetails = admissionEducationLevelDetails;
	}
	
}
